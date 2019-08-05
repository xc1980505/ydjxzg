package yd.wxzg.service.impl;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.http.client.ClientProtocolException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import yd.wxzg.entity.AccessToken;
import yd.wxzg.entity.MessageResult;
import yd.wxzg.entity.TemplateMessageEntity;
import yd.wxzg.mapper.WxMapper;
import yd.wxzg.service.QuartzService;
import yd.wxzg.templateMessage.util.TemplateData;
import yd.wxzg.templateMessage.util.WxTemplate;
import yd.wxzg.util.DataUtils;
import yd.wxzg.util.ErrorCodeUtils;
import yd.wxzg.util.HttpUtil;
import yd.wxzg.util.JacksonUtil;
import yd.wxzg.util.TemplateFailUtil;
import yd.wxzg.util.UserMessage;
import yd.wxzg.util.WeiXinUtil;

@Service
public class QuartServiceImpl implements QuartzService {
	@Resource
	private WxMapper wxmapper;
	
	  public void quartzJobTestMethod() throws Exception {
		  String nowTime=  DataUtils.detaileds2();
	        System.out.println("定时任务执行：" + nowTime);
	        List<TemplateMessageEntity> mess=wxmapper.findMessage();
	        //判断消息表中是否新增数据
	        if(mess.size()>0){
	        	for(TemplateMessageEntity m:mess){
	        		//消息发送次数
	        		int frequency = m.getFrequency();
	        		//当第一次发送消息与第二次发送时间间隔一分钟时发送第二次消息，否则返回
	        		 if(1==frequency){
	        			if(TemplateFailUtil.secondTime(m.getEndTime())){
	        				continue;
	        		  }	        				
	        		}
	        		else if(2==frequency){
	        			if(TemplateFailUtil.thirdTime(m.getEndTime())){
	        				continue;
	        		  }	        				
	        		}	        		
	        		Boolean result = registTemplate(nowTime,m.getOpenid(),m.getTemplateid(),m.getContent(),m.getId(),m.getUrl());
	        	}
	        }
	    }
	  public Boolean registTemplate(String nowTime,String openid,String templateid,String content,int id,String url) {
			/*  HttpServletRequest request=null;*/
		    int errorCode=00;
			AccessToken accessToken=null;
			try {
				accessToken = WeiXinUtil.getAccessToken();
			} catch (ClientProtocolException e1) {
				// TODO Auto-generated catch block
				errorCode=40111;
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				errorCode=40111;
				e1.printStackTrace();
			}
			String token = accessToken.getToken();
			String userNickName=null;
			try {
				JSONObject userInfo = UserMessage.getWechatUserInfo(openid, token);
				userNickName = userInfo.getString("nickname");
			} catch (Exception e) {
				errorCode=00001;
				
			}
			int cfcz=wxmapper.errorMessage(openid,templateid,content);
		    //查看是否有本条消息的错误信息有返回false
		    if(cfcz>0){
		    	wxmapper.deleteFreqy(id);
		    	return false;
		    }
		    // 发送模板消息token
		    String resultUrl2 = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+token;		   
		    // 封装基础数据
		   WxTemplate wxTemplate = new WxTemplate();
		   wxTemplate.setTemplate_id(templateid);
		   wxTemplate.setTouser(openid);
		   wxTemplate.setUrl(url);
		   wxTemplate.setTopcolor("blue");
		   Map<String, TemplateData> tempDate = new HashMap<String, TemplateData>();
		   
		  TemplateData keyword1 = new TemplateData();
		   keyword1.setValue("消息接收");
		   keyword1.setColor("red");
		   tempDate.put("keyword1", keyword1);
		   TemplateData keyword2 = new TemplateData();
		   keyword2.setValue(userNickName);
		   keyword2.setColor("blue");
		   tempDate.put("keyword2", keyword2);
		   TemplateData keyword3 = new TemplateData();
		   keyword3.setValue(nowTime);
		   keyword3.setColor("green");
		   tempDate.put("keyword3", keyword3);
		   TemplateData keyword4 = new TemplateData();
		   keyword4.setValue(content);
		   keyword4.setColor("black");
		   tempDate.put("keyword4", keyword4);
		   wxTemplate.setData(tempDate);
		   
		   
		   String jsonString=null;
		try {//将bean转换成json字符串
			jsonString = JacksonUtil.bean2Json(wxTemplate).toString();
		} catch (IOException e) {
			errorCode=1001;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   //发送post请求
		   String postMethod=null;
		try {
			postMethod = HttpUtil.postMethod(resultUrl2, jsonString);
		} catch (ClientProtocolException e) {
			errorCode=10111;
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			errorCode=10111;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   //将返回结果转换成bean
		   MessageResult jsonObject2=null;
		try {
			jsonObject2 = JacksonUtil.json2Bean(postMethod, MessageResult.class);
		} catch (JsonParseException e) {
			errorCode=1002;
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			errorCode=1002;
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			errorCode=1002;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   int result = 0;
		   //判断返回结果是否为空
		   if (null != jsonObject2) {
			   //得到模板消息返回码
			   errorCode=jsonObject2.getErrcode();
			   //判断消息是否发送成功0，成功；否则失败			   
		        if (0 != errorCode) {
		            result = jsonObject2.getErrcode();
		            System.err.println("错误 errcode:"+errorCode+",errmsg:"+jsonObject2.getErrmsg().toString());
		           //模板消息发送失败，修改发送次数+1
		        	wxmapper.updateRrequency(openid, templateid, content);
		        	//获取模板消息发送次数
		        	Integer frequency1=wxmapper.selectFrequency(openid,templateid,content);
		        	//修改消息发送时间
		        	wxmapper.insertMessageDate(id,nowTime);
		        	//查看本条消息的发送次数，次数大于三次就返回false
		        	if(3<=frequency1){
		        		wxmapper.deleteFreqy(id);
		        		wxmapper.addErrmsg(openid, templateid, content,nowTime,ErrorCodeUtils.errorMsg(errorCode));
		        	}
		        	return false;		           
		        }else{
		        	 //模板消息发送成功后删除模板消息并返回true
		        	wxmapper.deleteFreqy(id);		        	
		        	return true;
		        }
		    }else{
		    	errorCode=10002;
		    	//模板消息发送失败，修改发送次数+1
	        	wxmapper.updateRrequency(openid, templateid, content);
	        	//获取模板消息发送次数
	        	Integer frequency1=wxmapper.selectFrequency(openid,templateid,content);
	        	//修改消息发送时间
	        	wxmapper.insertMessageDate(id,nowTime);
	        	//查看本条消息的发送次数，次数大于三次就返回false
	        	if(3<=frequency1){
	        		wxmapper.deleteFreqy(id);
	        		wxmapper.addErrmsg(openid, templateid, content,nowTime,ErrorCodeUtils.errorMsg(errorCode));
	        	}
		    	return false;
		    }

		   
		}
}
