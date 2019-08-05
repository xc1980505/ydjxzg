package yd.wxzg.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpUtils;

import org.dom4j.DocumentException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.JsonNode;

import net.sf.json.JSONObject;
import yd.slgl.entity.Target;
import yd.slgl.entity.UsersEntity;
import yd.wxzg.service.MessageService;
import yd.wxzg.service.WxService;
import yd.wxzg.util.MessageUtil;
import yd.wxzg.util.WeCharToken;
import yd.wxzg.util.WeiXinUtil;
import yd.wxzg.util.WxcxUtil;

@Controller
@CrossOrigin
public class WxController{
@Resource
private MessageService messageService;
@Resource
private WxService wxservice;
/**
 * 微信消息接收和token验证
 * @param model
 * @param request
 * @param response
 * @throws Exception 
 */
	@RequestMapping("/hello.action")
	public void hello(Model model, HttpServletRequest request,HttpServletResponse response) throws Exception {
		//token验证
		WeCharToken.tokenSign(model, request, response);
	    post(request,response);
	 }
    //消息自动回复接口
    @RequestMapping(value="handle.action",method=RequestMethod.POST) 
    public void post(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=UTF-8");

        // 调用核心业务类接收消息、处理消息
        String respMessage = messageService.newMessageRequest(request);

        // 响应消息
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print(respMessage);
        } catch (IOException e){
            e.printStackTrace();           
        } finally {
            out.close();
            out = null;
        }
    }
    @RequestMapping("test.action")
    public void test(){
    	wxservice.addMessage();
    }
    
    @RequestMapping("myoauth2.action")
    public void ceshi(HttpServletRequest request, HttpServletResponse respons) throws IOException, DocumentException{
    	String code = request.getParameter("code");
		System.out.println("code:" + code);  
	    //获取code后，请求以下链接获取access_token
	    String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + WeiXinUtil.APPID
	        + "&secret=" + WeiXinUtil.APPSECRET
	        + "&code=" + code
	        + "&grant_type=authorization_code";
	     
	    //通过网络请求方法来请求上面这个接口
	    JSONObject jsonObject = WeiXinUtil.doGetStr(url);
	    //从返回的JSON数据中取出access_token和openid，拉取用户信息时用
	    String token = jsonObject.getString("access_token");
	    String openid = jsonObject.getString("openid");
	     
	    System.out.println("打印openid"+openid);
	   List<UsersEntity> user= wxservice.selectopenid(openid);
	   if(user.isEmpty()){
		   System.out.println("没有绑定openid");
		   respons.sendRedirect("http://5k9ryc.natappfree.cc/ydjxzg/wxshuanglian/#/login?openid="+openid);
	   }else{
		   System.out.println(user);
		   List<UsersEntity> userlist=wxservice.selectopenid(openid);
		   respons.sendRedirect("http://zg.demo.xqit.net/ydjxzg/wxzhengai?userlist="+userlist); 
	   }
    }
    
    
    
    
  //添加openid
  	@RequestMapping(value="addopenid.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
  	@ResponseBody
  	public String addopenid(HttpServletRequest request,HttpServletResponse res){
  		/*target_name,manager_id,funds,importancedj,start_time,end_time,cyr,
  		target_stand,target_stand_contion,target_stand_info,target_info*/
  		String openid = request.getParameter("openid");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
  		Map<String,Object> map=new HashMap<String,Object>();
  		//List<UsersEntity> userlist=wxservice.insertOpenid(openid, pass,name);
  		//map.put("user", userlist);
  		String json = JSON.toJSONString(map);
  		return json;
  	}
}