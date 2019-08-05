package yd.slgl.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import net.sf.json.JSONObject;
import yd.slgl.entity.UsersEntity;
import yd.slgl.service.WxMbtxService;
import yd.slgl.util.PnoUtil;
import yd.wxzg.service.WxService;
import yd.wxzg.util.WxcxUtil;


@Controller
@RequestMapping("wxcx")
@CrossOrigin
public class WxcxController {

	@Autowired
	private WxMbtxService wxmbtxService;
	@Resource
	private WxService wxservice;
	
	//诊改目标列表
	@RequestMapping(value="xcxndgh.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String ndghlist(HttpServletRequest request,HttpServletResponse res,HttpSession session){
		String userid = request.getParameter("userid");
		String dj = request.getParameter("dj");
		System.out.println("测试访问的url"+request.getServerName());
		request.getRequestURL();
		System.out.println("测试访问的url"+request.getHeader("Origin"));
		System.out.println("测试访问的url"+request.getRequestURL());
		System.out.println("------------"+userid+"+++++++++++++++"+dj);
	if(null==userid||"".equals(userid)){
				return null;
			}
		Map<String,Object> map=new HashMap<String,Object>();
		map=wxmbtxService.xcxtargetlist(userid,dj);
		System.out.println("PPPPPPPPPPPPPP"+map);
		String result = JSON.toJSONString(map);
		System.out.println("PPPPPPPPPPPPPP"+result);
		return result;
	}
	@RequestMapping(value="xcxsession.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
    public String xcxsession(HttpServletRequest request, HttpServletResponse respons){
    	Map<String,Object> map=new HashMap<String,Object>();
    	 List<UsersEntity> userlist=null;
    	String sessionid = request.getParameter("sessionid");
    	String code = request.getParameter("code");
    	System.out.println("****************"+sessionid);
    	System.out.println("****************"+code);
    	if(sessionid==null||sessionid.isEmpty()||sessionid.equals("undefined")){
    		String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + WxcxUtil.APPID + "&secret=" + WxcxUtil.APPSECRET
    		        + "&js_code=" + code + "&grant_type=authorization_code";   //接口地址
    	    //通过网络请求方法来请求上面这个接口
    		Map<String,Object> Wx = WxcxUtil.sendGetReq(url);
    		String openid = (String) Wx.get("openid");
    		String session_key = (String) Wx.get("session_key");
    	    String session= (String) Wx.get("sessionid");
    	    System.out.println("^^^^^^^^^^^"+session);
    	    userlist=wxservice.selectopenid(openid);
    	    if(!userlist.isEmpty()){
    		wxservice.updateSession(openid, session, session_key);
    		userlist=wxservice.selectopenid(openid);
    		map.put("userlist", userlist);
    		map.put("sessionid", session);
    	    }
    	    else{
    	    	//未绑定返回400
    	    	map.put("mess", "400");
    	    }
//		System.out.println("+++++++"+sessionid);
//	    UsersEntity entity=wxservice.getsession(sessionid);
//	    String openid = entity.getWx_openid();
//	    String session_key = (String) map.get("sessionKey");
//	    System.out.println("打印openid"+openid);
//	    System.out.println("打印session_key"+session_key);
//	   userlist=wxservice.selectopenid(openid);
//	   map.put("userlist", userlist);
    	}
    	else{
    		System.out.println("+++++++"+sessionid);
    	    UsersEntity entity=wxservice.getsession(sessionid);
    	    String openid = entity.getWx_openid();
    	    String session_key = (String) map.get("sessionKey");
    	    System.out.println("打印openid"+openid);
    	    System.out.println("打印session_key"+session_key);
    	    userlist=wxservice.selectopenid(openid);
    	    map.put("userlist", userlist);
//    		String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + WxcxUtil.APPID + "&secret=" + WxcxUtil.APPSECRET
//    		        + "&js_code=" + code + "&grant_type=authorization_code";   //接口地址
//    	    //通过网络请求方法来请求上面这个接口
//    		Map<String,Object> Wx = WxcxUtil.sendGetReq(url);
//    		String openid = (String) Wx.get("openid");
//    		String session_key = (String) Wx.get("session_key");
//    	    String session= (String) Wx.get("sessionid");
//    	    System.out.println("++++++++++"+session);
//    		wxservice.updateSession(openid, session, session_key);
//    		userlist=wxservice.selectopenid(openid);
//    		map.put("userlist", userlist);
//    		map.put("sessionid", session);
    	}
	   String result = JSON.toJSONString(map);
	   return result;
    }
	@RequestMapping(value="xcxopenid.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
    public String xcxopenid(HttpServletRequest request, HttpServletResponse respons){
    	Map<String,Object> map=new HashMap<String,Object>();
    	String code = request.getParameter("code");
    	String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		System.out.println("code:" + code);  
		System.out.println("+++++++"+name);
		System.out.println("+++++++"+pass);
	    //获取code后，请求以下链接获取access_token
	    String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + WxcxUtil.APPID + "&secret=" + WxcxUtil.APPSECRET
        + "&js_code=" + code + "&grant_type=authorization_code";   //接口地址
	    //通过网络请求方法来请求上面这个接口
	    Map<String,Object> Wx  = WxcxUtil.sendGetReq(url);
	    //从返回的JSON数据中取出access_token和openid，拉取用户信息时用
//	    String token = jsonObject.getString("access_token");
	    String openid = (String) Wx.get("openid");
	    String session_key = (String) Wx.get("sessionKey");
	    String sessionid= (String) Wx.get("sessionid");
	    System.out.println("打印openid"+openid);
	    System.out.println("打印session_key"+session_key);
	    System.out.println("打印session_key"+sessionid);
	   List<UsersEntity> user= wxservice.selectopenid(openid);
	   if(user==null||user.isEmpty()){
		   System.out.println("|||||||||||||");
		  map=wxservice.insertOpenid(openid, pass, session_key, name, sessionid);
	   }else{
		   for (UsersEntity usersEntity : user) {
			   map.put("mess", "此微信已绑定账号"+usersEntity.getUsername());
		}
	   }
	   String result = JSON.toJSONString(map);
	   return result;
    }
	//绩效列表
		@RequestMapping(value="xcxjx.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String MyScore(HttpServletRequest request,HttpServletResponse res,HttpSession session){
			String user_id = request.getParameter("user_id");
			System.out.println("测试访问的url"+request.getServerName());
			request.getRequestURL();
			System.out.println("测试访问的url"+request.getHeader("Origin"));
			System.out.println("测试访问的url"+request.getRequestURL());
			System.out.println("------------"+user_id);
		if(null==user_id||"".equals(user_id)){
					return null;
				}
			Map<String,Object> map=new HashMap<String,Object>();
			map=wxmbtxService.xcxtargets(user_id);
			System.out.println("PPPPPPPPPPPPPP"+map);
			String result = JSON.toJSONString(map);
			System.out.println("PPPPPPPPPPPPPP"+result);
			return result;
		}
		//根据姓名、手机号、工号搜索
		@RequestMapping(value="getxgs.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String getXgs(HttpServletRequest request,HttpServletResponse res,HttpSession session){
			String user_id = request.getParameter("user_id");
			String search = request.getParameter("search");
			System.out.println("测试访问的url"+request.getServerName());
			request.getRequestURL();
			System.out.println("测试访问的url"+request.getHeader("Origin"));
			System.out.println("测试访问的url"+request.getRequestURL());
			System.out.println("------------"+user_id);
		if(null==user_id||"".equals(user_id)){
					return null;
				}
			Map<String,Object> map=new HashMap<String,Object>();
			map=wxmbtxService.mhcx(search);
			String result = JSON.toJSONString(map);
			return result;
		}
}
