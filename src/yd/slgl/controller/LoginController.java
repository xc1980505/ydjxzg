package yd.slgl.controller;

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

import yd.slgl.entity.UsersEntity;
import yd.slgl.service.LoginService;
import yd.slgl.util.PnoUtil;

import com.alibaba.fastjson.JSON;


@Controller
@RequestMapping("log")
@CrossOrigin
public class LoginController {
	@Autowired
	private LoginService loginService;
	//登陆
	@RequestMapping(value="login.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String login(HttpServletRequest request,HttpServletResponse res,HttpSession session){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("++++++++"+username+"________"+password);
		Map<String,Object> map=loginService.getLogin(username,password);
		String jsonString = JSON.toJSONString(map);
		if(null!=map.get("login")){
			session.setAttribute("user", map.get("login"));
			session.setAttribute("permis", map.get("permis"));
		}
//		UsersEntity user=(UsersEntity) session.getAttribute("user");
//		System.out.println("yyyyyy"+user.getUsername());
		return jsonString;
	}
	//获取验证码
	@RequestMapping(value="getyanzheng.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String getyanzheng(HttpServletRequest request,HttpServletResponse res,HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		String num=new PnoUtil().getEnoByTime();
		map.put("mess", num);
		session.setAttribute("num", num);
		String jsonString = JSON.toJSONString(map);
		return jsonString;
	}
	//权限
		@RequestMapping(value="getpermis.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String getpermis(HttpServletRequest request,HttpServletResponse res){
			Map<String,Object> map = new HashMap<String,Object>();
			String user_id = request.getParameter("user_id");
			map=loginService.getpermis(user_id);
			String jsonString = JSON.toJSONString(map);
			return jsonString;
		}
		
		//验证
		@RequestMapping(value="getpass.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String getpass(HttpServletRequest request,HttpServletResponse res,HttpSession session){
			Map<String,Object> map = new HashMap<String,Object>();
			String username = request.getParameter("username");
			String mobile = request.getParameter("mobile");
			map=loginService.getdenglu(username, mobile);
			String jsonString = JSON.toJSONString(map);
			return jsonString;
		}
		//修改密码
		@RequestMapping(value="getxgpass.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String getxgpass(HttpServletRequest request,HttpServletResponse res,HttpSession session){
			Map<String,Object> map = new HashMap<String,Object>();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			map=loginService.getxhpass(username, password);
			String jsonString = JSON.toJSONString(map);
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
