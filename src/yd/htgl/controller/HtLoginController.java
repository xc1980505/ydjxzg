package yd.htgl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



import com.alibaba.fastjson.JSON;

import yd.htgl.service.HtLoginService;


@Controller
@RequestMapping("htlog")
@CrossOrigin
public class HtLoginController {
	@Autowired
	private HtLoginService htloginService;
	//登陆
	@RequestMapping(value="htlogin.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String htlogin(HttpServletRequest request,HttpServletResponse res,HttpSession session){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("username"+username);
		System.out.println("password"+username);
		
		Map<String,Object> map=htloginService.getLogin(username,password);
		String jsonString = JSON.toJSONString(map);
//		if(null!=map.get("login")){
//			
//			session.setAttribute("admin", map.get("login"));
//		}
//		UsersEntity user=(UsersEntity) session.getAttribute("admin");
//		System.out.println("yyyyyy"+user.getUsername());
		return jsonString;
	}
	//退出登陆
	@RequestMapping(value="logout.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String logout(HttpServletRequest request,HttpServletResponse res){
		Map<String,Object> map = new HashMap<String,Object>();
		request.getSession().invalidate();//销毁本次连接的Session
		map.put("mess", "已退出");
		String jsonString = JSON.toJSONString(map);
		return jsonString;
	}
}
