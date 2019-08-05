package yd.htgl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import yd.htgl.entity.Organiza;
import yd.htgl.entity.Teacher;
import yd.htgl.entity.UsersEntity;
import yd.htgl.service.HtglService;



@Controller
@RequestMapping("ht")
@CrossOrigin
public class HtController {

	@Autowired
	private HtglService htglService;
	
	
	//添加部门
	@RequestMapping(value="gotargetadd.action",produces = "application/json;charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String gotargetadd(HttpServletRequest request,HttpServletResponse res,Organiza organiza){
		Map<String,Object> map=new HashMap<String,Object>();
		map=htglService.addzzbm(organiza);
		String json = JSON.toJSONString(map);
		return json;
	}
	//编辑部门
		@RequestMapping(value="editorganiza.action",produces = "application/json;charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String editorganiza(HttpServletRequest request,HttpServletResponse res) {
			String id = request.getParameter("id");
			String name = request.getParameter("dept_name");
			
			Map<String,Object> map=new HashMap<String,Object>();
			map=htglService.editOrganiza(id, name);
			String json = JSON.toJSONString(map);	
			return json;
		}
		//删除部门
	    @RequestMapping(value="deleteOrganiza.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String deleteOrganiza(HttpServletRequest request,HttpServletResponse res) {
			String id = request.getParameter("id");
			Map<String,Object> map=new HashMap<String,Object>();
			map=htglService.deleteOrganiza(id);
			String json = JSON.toJSONString(map);
			return json;
			}
	    
	  //人员信息获取
		@RequestMapping(value="getbumenry.action",produces = "application/json;charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String getbumenry(HttpServletRequest request,HttpServletResponse res){
			String id = request.getParameter("id");
			Map<String,Object> map=new HashMap<String,Object>();
			map=htglService.getbumenry(id);
			String json = JSON.toJSONString(map);
			return json;
		}
	//人员信息显示
	@RequestMapping(value="getuserlist.action",produces = "application/json;charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String getUserlist(HttpServletRequest request,HttpServletResponse res){
		
		Map<String,Object> map=new HashMap<String,Object>();
		map=htglService.getUserlist();
		String json = JSON.toJSONString(map);
		return json;
	}
	//部门显示
	@RequestMapping(value="organizalist.action",produces = "application/json;charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String organizalist(HttpServletRequest request,HttpServletResponse res){
		
		Map<String,Object> map=new HashMap<String,Object>();
		map=htglService.organizalist();
		System.out.println("________________"+map);
		String json = JSON.toJSONString(map);
		return json;
	}
	//部门名称数据
	@RequestMapping(value="bumenlist.action",produces = "application/json;charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String bumenlist(HttpServletRequest request,HttpServletResponse res){
		
		Map<String,Object> map=new HashMap<String,Object>();
		map=htglService.bumenlist();
		String json = JSON.toJSONString(map);
		return json;
	}
	//人员信息删除
	@RequestMapping(value="deleteUser.action",produces = "application/json;charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String deleteUser(HttpServletRequest request,HttpServletResponse res){
		String id = request.getParameter("id");
		Map<String,Object> map=new HashMap<String,Object>();
		map=htglService.deleteUser(id);
		String json = JSON.toJSONString(map);
		return json;
	}
	//人员信息编辑
	@RequestMapping(value="updateUser.action",produces = "application/json;charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String updateUser(HttpServletRequest request,HttpServletResponse res,UsersEntity usersEntity){
		Map<String,Object> map=new HashMap<String,Object>();
		map=htglService.updateUser(usersEntity);
		String json = JSON.toJSONString(map);
		return json;
	}
	//人员信息编辑
		@RequestMapping(value="insertUser.action",produces = "application/json;charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String insertUser(HttpServletRequest request,HttpServletResponse res,UsersEntity usersEntity){
			Map<String,Object> map=new HashMap<String,Object>();
			map=htglService.insertUser(usersEntity);
			String json = JSON.toJSONString(map);
			return json;
		}
		//权限管理
		//查询权限
		@RequestMapping(value="selectpermis.action",produces = "application/json;charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String selectpermis(HttpServletRequest request,HttpServletResponse res)throws Exception{
			Map<String,Object> map=new HashMap<String,Object>();
			
			map=htglService.selectpermis();
			String json = JSON.toJSONString(map);
			return json;
		}
		//查看所有组
		@RequestMapping(value="sleroles.action",produces = "application/json;charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String sleroles(HttpServletRequest request,HttpServletResponse res)throws Exception{
			Map<String,Object> map=new HashMap<String,Object>();
			String role_name = request.getParameter("role_name");
			request.getServerName();
			System.out.println("----------------");
			System.out.println("测试访问的url"+request.getServerName());
			request.getRequestURL();
			System.out.println("测试访问的url"+request.getRequestURL());
			map=htglService.sleroles(role_name);
			String json = JSON.toJSONString(map);
			return json;
		}
		//创建组
		@RequestMapping(value="insertzu.action",produces = "application/json;charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String insertzu(HttpServletRequest request,HttpServletResponse res)throws Exception{
			Map<String,Object> map=new HashMap<String,Object>();
			String role_name = request.getParameter("role_name");
			String role_code = request.getParameter("role_code");
			String permis_id =request.getParameter("permis_id");
			System.out.println(role_name);
			map=htglService.insertZu(role_name, role_code,permis_id);
			String json = JSON.toJSONString(map);
			return json;
		}
		//去修改
		@RequestMapping(value="getzu.action",produces ="application/json;charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String getzu(HttpServletRequest request,HttpServletResponse res)throws Exception{
			Map<String,Object> map=new HashMap<String,Object>();
			String role_id = request.getParameter("role_id");
			map=htglService.getzu(role_id);
			String json = JSON.toJSONString(map);
			return json;
		}
		
		//修改组
		@RequestMapping(value="updatezu.action",produces ="application/json;charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String updatezu(HttpServletRequest request,HttpServletResponse res)throws Exception{
			Map<String,Object> map=new HashMap<String,Object>();
			String role_id = request.getParameter("role_id");
			String role_name = request.getParameter("role_name");
			String role_code = request.getParameter("role_code");
			String permis_id =request.getParameter("permis_id");
			map=htglService.updatezu(role_id, role_name, role_code, permis_id);
			String json = JSON.toJSONString(map);
			return json;
		}
		//删除组
		@RequestMapping(value="deletezu.action",produces ="application/json;charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String deletezu(HttpServletRequest request,HttpServletResponse res)throws Exception{
			Map<String,Object> map=new HashMap<String,Object>();
			String role_id = request.getParameter("role_id");
			map=htglService.deletezu(role_id);
			String json = JSON.toJSONString(map);
			return json;
		}
		//查看所有人员
		@RequestMapping(value="getUsers.action",produces = "application/json;charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String getUsers(HttpServletRequest request,HttpServletResponse res)throws Exception{
			Map<String,Object> map=new HashMap<String,Object>();
			String name = request.getParameter("name");
			System.out.println("-------------------"+name);
			map=htglService.getUsers(name);
			String json = JSON.toJSONString(map);
			return json;
		}
//		//人员分组
//		@RequestMapping(value="ryfenzu.action",produces = "application/json;charset=utf-8",method=RequestMethod.POST)
//		@ResponseBody
//		public String ryfenzu(HttpServletRequest request,HttpServletResponse res)throws Exception{
//			Map<String,Object> map=new HashMap<String,Object>();
//			String user_id = request.getParameter("user_id");
//			String role_id =request.getParameter("role_id");
//			map=htglService.ryfenzu(user_id, role_id);
//			String json = JSON.toJSONString(map);
//			return json;
//		}
		//去修改
		@RequestMapping(value="getuserzu.action",produces ="application/json;charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String getuserzu(HttpServletRequest request,HttpServletResponse res)throws Exception{
			Map<String,Object> map=new HashMap<String,Object>();
			String user_id = request.getParameter("user_id");
			map=htglService.getUrole(user_id);
			String json = JSON.toJSONString(map);
			return json;
		}
		
		//修改人员分组
		@RequestMapping(value="updatefz.action",produces ="application/json;charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String updatefz(HttpServletRequest request,HttpServletResponse res)throws Exception{
			Map<String,Object> map=new HashMap<String,Object>();
			String user_id = request.getParameter("user_id");
			String role_id =request.getParameter("role_id");
			map=htglService.updatefz(user_id, role_id);
			String json = JSON.toJSONString(map);
			return json;
		}
		/*
		 * 后台调整
		 * */
		//教师列表
		@RequestMapping(value="getTeacher.action",produces="appication/json;charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String getTeacher(HttpServletRequest request,HttpServletResponse response){
			Map<String, Object> map= new HashMap<String, Object>();
			map=htglService.getTeacher();
			String json =JSON.toJSONString(map);
			return json;
		}
		//密码重置
		@RequestMapping(value="ResetPass.action",produces="appication/json;charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String ResetPass(HttpServletRequest request,HttpServletResponse response){
			Map<String, Object> map= new HashMap<String, Object>();
			String number= request.getParameter("number");
			map=htglService.ResetPass(number);
			String json =JSON.toJSONString(map);
			return json;
		}
		//添加教师信息
		@RequestMapping(value="inTeacher.action",produces="appication/json;charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String inTeacher(HttpServletRequest request,HttpServletResponse response,Teacher teacher){
			Map<String, Object> map= new HashMap<String, Object>();
			System.out.println(teacher.getDepartment_id());
			map=htglService.inTeacher(teacher);
			String json =JSON.toJSONString(map);
			return json;
		}
		//修改教师信息
		
		
		
		//删除教师信息
		@RequestMapping(value="delTeacher.action",produces="appication/json;charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String delTeacher(HttpServletRequest request,HttpServletResponse response,Teacher teacher){
			Map<String, Object> map= new HashMap<String, Object>();
			String number=request.getParameter("number");
			map=htglService.delTeacher(number);
			String json =JSON.toJSONString(map);
			return json;
		}
		//搜索
		
		@RequestMapping(value="search.action",produces="appication/json;charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String search(HttpServletRequest request,HttpServletResponse response,Teacher teacher){
			Map<String, Object> map= new HashMap<String, Object>();
			String name=request.getParameter("name");
			String department_name=request.getParameter("department_name");
			map=htglService.search(name, department_name);
			String json =JSON.toJSONString(map);
			return json;
		}
		//班级课程管理
		
}
