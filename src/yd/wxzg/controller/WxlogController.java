package yd.wxzg.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import yd.slgl.entity.UsersEntity;
import yd.slgl.service.LoginService;
import yd.wxzg.util.WeiXinUtil;

import com.alibaba.fastjson.JSON;

import net.sf.json.JSONObject;


@Controller
@RequestMapping("/wxlog")
@CrossOrigin
public class WxlogController {
	 private static final long serialVersionUID = 1L;
	@RequestMapping(value="login.action",produces = "application/json; charset=utf-8",method=RequestMethod.GET)
	@ResponseBody
	public void login(HttpServletRequest request,HttpServletResponse res,HttpSession session)throws ServletException, IOException{
		 //第一步：引导用户进入授权页面同意授权，获取code
	     
	    //回调地址
	    String backUrl = "http://5k9ryc.natappfree.cc/ydjxzg/myoauth2.action";  //第1种情况使用
	    //String backUrl = "http://suliu.free.ngrok.cc/WxAuth/wxCallBack";//第2种情况使用，这里是web.xml中的路径
	     
	    //授权页面地址
	    String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+WeiXinUtil.APPID
	        + "&redirect_uri="+URLEncoder.encode(backUrl)
	        + "&response_type=code"
	        + "&scope=snsapi_base"
	        + "&state=STATE#wechat_redirect";
	    //重定向到授权页面
	    res.sendRedirect(url);
	}
}
