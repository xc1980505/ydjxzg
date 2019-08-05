package yd.slgl.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import yd.slgl.entity.DeclareEntity;
import yd.slgl.entity.Khzb;
import yd.slgl.entity.ReportEntity;
import yd.slgl.entity.Standard;
import yd.slgl.entity.StandardType;
import yd.slgl.entity.Target;
import yd.slgl.entity.UsersEntity;
import yd.slgl.service.MbtxService;
import yd.slgl.util.UpLoadStandard;

@Controller
@RequestMapping("mb")
@CrossOrigin
public class MbtxController {
	@Autowired
	private MbtxService mbService;
	
	//诊改目标列表
	@RequestMapping(value="ndgh.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
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
		map=mbService.targetlist(userid,dj);
		System.out.println("PPPPPPPPPPPPPP"+map);
		String result = JSON.toJSONString(map);
		System.out.println("PPPPPPPPPPPPPP"+result);
		return result;
	}
	@RequestMapping(value="ndgh1.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String ndghlist1(HttpServletRequest request,HttpServletResponse res,HttpSession session){
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
		map=mbService.targetlist(userid,dj);
		String result = JSON.toJSONString(map);
		return result;
	}
	//微信诊改目标列表
		@RequestMapping(value="wxndgh.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String wxndghlist(HttpServletRequest request,HttpServletResponse res,HttpSession session){
			String userid = request.getParameter("userid");
			String dj = request.getParameter("dj");
			System.out.println("111111111111111111"+userid);
			System.out.println("222222222222222222"+dj);
//			UsersEntity user=(UsersEntity) session.getAttribute("user");
//			System.out.println("eeeeeeee"+user.getUsername());
		if(null==userid||"".equals(userid)){
					return null;
					
				}
			Map<String,Object> map=new HashMap<String,Object>();	
			map=mbService.wxtargetlist(userid,dj);
			String result = JSON.toJSONString(map);
			return result;
		}
	//到添加指标
	@RequestMapping(value="totargetadd.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String gotargetadd(HttpServletRequest request,HttpServletResponse res){
		Map<String,Object> map=new HashMap<String,Object>();
		List<Khzb> khzb=mbService.getkhzb();
		List<UsersEntity> userlist=mbService.userlist();
		map.put("userlist", userlist);
		map.put("khzb", khzb);
		String json = JSON.toJSONString(map);
		return json;
	}
	//添加指标
	@RequestMapping(value="addtarget.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String addtarget(HttpServletRequest request,HttpServletResponse res,Target target,String [] cyr){
		/*target_name,manager_id,funds,importancedj,start_time,end_time,cyr,
		target_stand,target_stand_contion,target_stand_info,target_info*/
		System.out.println(cyr);
		Map<String,Object> map=new HashMap<String,Object>();
		map=mbService.addtarget(target,cyr);
		String json = JSON.toJSONString(map);
		return json;
	}
	/**
	 * 项目详情
	 * @param request
	 * @param res
	 * @return json
	 */
	@RequestMapping(value="targetDetails.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String targetDetails(HttpServletRequest request,HttpServletResponse res){
		String targetid = request.getParameter("targetid");
		String user_id = request.getParameter("user_id");
		Map<String,Object> map=new HashMap<String,Object>();
		map=mbService.targetDetails(targetid,user_id);
		String json = JSON.toJSONString(map);
		return json;
	}
	/**
	 * 工作进度汇报
	 * @param request
	 * @param res
	 * @param report
	 * @return json
	 */
	@RequestMapping(value="report.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String progressReport(HttpServletRequest request,HttpServletResponse res,ReportEntity report){
		Map<String,Object> map=new HashMap<String,Object>();
		map=mbService.addReport(report);
		String json = JSON.toJSONString(map);
		return json;
	}
	//  关注/取消关注
	@RequestMapping(value="targetFollow.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String targetFollow(HttpServletRequest request,HttpServletResponse res){
		String follow = request.getParameter("follow");
		String follow_id = request.getParameter("follow_id");
		String targetid = request.getParameter("targetid");
		Map<String,Object> map=new HashMap<String,Object>();
		map=mbService.targetFollow(follow,targetid,follow_id);
		String json = JSON.toJSONString(map);
		return json;
	}
	//提交审核
	@RequestMapping(value="commitDeclare.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String commitDeclare(HttpServletRequest request,HttpServletResponse res){
		Map<String,Object> map=new HashMap<String,Object>();
		String targetid = request.getParameter("targetid");
		String report_desc = request.getParameter("report_desc");
		map=mbService.commitDeclare(targetid,report_desc);
		String json = JSON.toJSONString(map);
		return json;
	}	
	/**
	 * 审核
	 * @param request
	 * @param res
	 * @param declare
	 * @return
	 */
	@RequestMapping(value="checktarget.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String checktarget(HttpServletRequest request,HttpServletResponse res,DeclareEntity declare){
		Map<String,Object> map=new HashMap<String,Object>();
		String progress = request.getParameter("progress");
		map=mbService.checktarget(declare,progress);
		String json = JSON.toJSONString(map);	
		return json;
	}
	//去回退
	@RequestMapping(value="goRegression.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String goRegression(HttpServletRequest request,HttpServletResponse res){
		Map<String,Object> map=new HashMap<String,Object>();
		String targetid = request.getParameter("targetid");
		String declareid = request.getParameter("declareid");
		map=mbService.goRegression(targetid,declareid);
		String json = JSON.toJSONString(map);	
		return json;
	}
	//回退
	@RequestMapping(value="checkRegression.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String checkRegression(HttpServletRequest request,HttpServletResponse res,@RequestBody(required=false) List<DeclareEntity> declareEntity){
		Map<String,Object> map=new HashMap<String,Object>();
		map=mbService.checkRegression(declareEntity);
		String json = JSON.toJSONString(map);
		return json;
	}
	// 项目树
	@RequestMapping(value="projectTree.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String projectTree(HttpServletRequest request,HttpServletResponse res,HttpSession session) throws JsonParseException, JsonMappingException, IOException{
		String targetid = request.getParameter("targetid");
//		UsersEntity userzz = (UsersEntity) session.getAttribute("u");
//		//UsersEntity user1 = (UsersEntity)request.getSession().getAttribute("user");
//		System.out.println("--------------------------"+userzz.getUsername());
		Map<String,Object> map=new HashMap<String,Object>();
		map=mbService.projectTree(targetid);
		SerializerFeature feature = SerializerFeature.DisableCircularReferenceDetect; 
		String json = JSON.toJSONString(map,feature);
		return json;
	}
	//去编辑项目信息
	@RequestMapping(value="goEditTarget.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String goeditTarget(HttpServletRequest request,HttpServletResponse res) {
		
		Map<String,Object> map=new HashMap<String,Object>();
		String targetid = request.getParameter("targetid");
		System.out.println("----------"+targetid);
		map=mbService.goeditTarget(targetid);
		String json = JSON.toJSONString(map);	
		return json;
	}
	//提交编辑项目信息
	@RequestMapping(value="editTarget.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String editTarget(HttpServletRequest request,HttpServletResponse res,Target target) {
		Map<String,Object> map=new HashMap<String,Object>();
		String[] userlist = request.getParameterValues("userlist");
		System.out.println("++++++++++++++++++++"+userlist);
		System.out.println("++++++++++++++++++++"+target.getTarget_stand_contion());
		map=mbService.editTarget(target,userlist);
		String json = JSON.toJSONString(map);	
		return json;
	}
	//分解节点
	@RequestMapping(value="goDecompose.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String decomposeTarget(HttpServletRequest request,HttpServletResponse res) {
		String targetid = request.getParameter("targetid");
		Map<String,Object> map=new HashMap<String,Object>();
		map=mbService.goeditTarget(targetid);
		String json = JSON.toJSONString(map);	
		return json;
	}
	//提交分解节点
	@RequestMapping(value="decompose.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String decompose(HttpServletRequest request,HttpServletResponse res,Target target) {
		String[] userlist = request.getParameterValues("userlist");
		Map<String,Object> map=new HashMap<String,Object>();
		map=mbService.decomposeTarget(target,userlist);
		String json = JSON.toJSONString(map);
		return json;
	}
	//删除节点
	@RequestMapping(value="deleteTarger.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String deleteTarger(HttpServletRequest request,HttpServletResponse res,Target target) {
		String targetid = request.getParameter("targetid");
		String targetdj = request.getParameter("targetdj");
		Map<String,Object> map=new HashMap<String,Object>();
		map=mbService.deleteTarget(targetid,targetdj);
		String json = JSON.toJSONString(map);	
		return json;
	}
	//诊改标准体系
	@RequestMapping(value="standard.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String standard(HttpServletRequest request,HttpServletResponse res) {
		Map<String,Object> map=new HashMap<String,Object>();
		map=mbService.standardlist();
		String json = JSON.toJSONString(map);
		return json;
	}
	//添加标准类型
	@RequestMapping(value="addStandardType.action",produces = "application/json;charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String addStandardType(HttpServletRequest request,HttpServletResponse res,StandardType standardtype) {		
		Map<String,Object> map=new HashMap<String,Object>();
		System.out.println(standardtype.getName());
		map=mbService.addStandardType(standardtype);
		String json = JSON.toJSONString(map);	
		return json;
	}
	//编辑标准类型
	@RequestMapping(value="editStandardType.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String editStandardType(HttpServletRequest request,HttpServletResponse res,StandardType standardtype) {
//		String id = request.getParameter("id");
//		String name = request.getParameter("name");
//		String level = request.getParameter("level");
//		System.out.println("-----------"+name);
		Map<String,Object> map=new HashMap<String,Object>();
		map=mbService.editStandardType(standardtype);
		String json = JSON.toJSONString(map);	
		return json;
	}
	   //删除标准类型
		@RequestMapping(value="deleteStandardType.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String deleteStandardType(HttpServletRequest request,HttpServletResponse res) {
			String id = request.getParameter("id");
			Map<String,Object> map=new HashMap<String,Object>();
			map=mbService.deleteStandardType(id);
			String json = JSON.toJSONString(map);
			return json;
		}
		//查看标准信息列表
		@RequestMapping(value="standardList.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String standardList(HttpServletRequest request,HttpServletResponse res) {
		    String id = request.getParameter("id");
		    String name = request.getParameter("name");
			Map<String,Object> map=new HashMap<String,Object>();
			map=mbService.standardByType(id,name);
			String json = JSON.toJSONString(map);	
			return json;
	}
	    //删除标准信息
		@RequestMapping(value="deleteStand.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String deleteStand(HttpServletRequest request,HttpServletResponse res) {
		    String id = request.getParameter("id");
			Map<String,Object> map=new HashMap<String,Object>();
			map=mbService.deleteStand(id);
			String json = JSON.toJSONString(map);	
			return json;
	}
		 //去编辑标准
		@RequestMapping(value="goeditStand.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String goeditStand(HttpServletRequest request,HttpServletResponse res) throws IllegalStateException, IOException {
		String id = request.getParameter("id");
			Map<String,Object> map=new HashMap<String,Object>();
			map=mbService.goeditStand(id);
			String json = JSON.toJSONString(map);	
			return json;
		}
		//文件上传
		/*@RequestMapping(value="addfile.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String addfile(HttpServletRequest request,HttpServletResponse res,@RequestParam MultipartFile file) throws IllegalStateException, IOException {
		    System.out.println("999999999"+request);
			String fileName = UpLoadStandard.getFileName(request, file);
			System.out.println("!!!!!!!!!!!!!!!!"+fileName);
			String json = JSON.toJSONString("D:ceshi/"+fileName);	
			return json;
	}*/
		//文件上传
				@RequestMapping(value="addfile.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
				@ResponseBody
				public String addfile(HttpServletRequest request,HttpServletResponse res,@RequestParam MultipartFile file) throws IllegalStateException, IOException {
				    String fileName = UpLoadStandard.getFileName(request, file);
				    Map<String,Object> map=new HashMap<String,Object>();
				    map.put("filepath", "/home/www/cdn.xqit.net/zg/file/"+fileName);
				    //map.put("filepath", "D:/ceshi/"+fileName);
					map.put("fileName", fileName);
					String json = JSON.toJSONString(map);	
					return json;
			}
	   //修改文件
				@RequestMapping(value="updafile.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
				@ResponseBody
				public String updafile(HttpServletRequest request,HttpServletResponse res,@RequestParam MultipartFile file) throws IllegalStateException, IOException {
					String filepath = request.getParameter("filepath");
					/*System.out.println("jjjjjj"+file);
					System.out.println("--------"+filepath);*/
					UpLoadStandard.deleteFile(filepath);
					String fileName = UpLoadStandard.getFileName(request, file);
				    Map<String,Object> map=new HashMap<String,Object>();
				    map.put("filepath", "/home/www/cdn.xqit.net/zg/file/"+fileName);
				    //map.put("filepath", "D:/ceshi/"+fileName);
					map.put("fileName", fileName);
					String json = JSON.toJSONString(map);	
					return json;
			}
				
		//删除文件
				@RequestMapping(value="delfile.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
				@ResponseBody
				public String delfile(HttpServletRequest request,HttpServletResponse res) throws IllegalStateException, IOException {
					String filepath = request.getParameter("filepath");
					UpLoadStandard.deleteFile(filepath);
//					String fileName = UpLoadStandard.getFileName(request, file);
				    Map<String,Object> map=new HashMap<String,Object>();
//				    map.put("filepath", "/home/www/cdn.xqit.net/zg/file/"+fileName);
				    //map.put("filepath", "D:/ceshi/"+fileName);
					map.put("mess", true);
					String json = JSON.toJSONString(map);	
					return json;
			}
	     //编辑标准
		@RequestMapping(value="editStand.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String editStand(HttpServletRequest request,HttpServletResponse res,Standard stand) throws IllegalStateException, IOException {
			Map<String,Object> map=new HashMap<String,Object>();
			map=mbService.editStand(stand);
			String json = JSON.toJSONString(map);	
			return json;
	}
		//添加标准
		@RequestMapping(value="addStand.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String addStand(HttpServletRequest request,HttpServletResponse res,Standard stand) throws IllegalStateException, IOException {
		   System.out.println("++++++"+stand.getFileurl());
			Map<String,Object> map=new HashMap<String,Object>();
			map=mbService.addStand(stand);
			String json = JSON.toJSONString(map);
			return json;
	} 
		//添加标准
				@RequestMapping(value="sucha.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
				@ResponseBody
				public String sucha(HttpServletRequest request,HttpServletResponse res,Standard stand) throws IllegalStateException, IOException {
					String name = request.getParameter("name");
					System.out.println(name);
					Map<String,Object> map=new HashMap<String,Object>();
					map=mbService.sucha(name);
					String json = JSON.toJSONString(map);
					return json;
			} 
	
	/*
	 诊改绩效考核
	 */
		@RequestMapping(value="jxscore.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String jxscore(HttpServletRequest request,HttpServletResponse res) {
			String manager_id = request.getParameter("manager_id");
			String target_name = request.getParameter("target_name");
			String dj = request.getParameter("dj");
			System.out.println("!!!!!!!!!!!!!!!!!!!"+dj);
			
			Map<String,Object> map=new HashMap<String,Object>();
			
			//map=mbService.getMyscore(manager_id, target_name);
			List<Target> target=mbService.getfuzexm(manager_id);
			List<UsersEntity> xsjxf=mbService.getxsjxf(manager_id);
			List<UsersEntity> bmjxf=mbService.getbmjxf(manager_id);
			List<UsersEntity> qxjxf=mbService.getqxjxf();
			List<UsersEntity> bmbyts=mbService.getbmbyts(manager_id);
			List<UsersEntity> xsmd=mbService.getxsmd(manager_id);
			List<UsersEntity> jkmd=mbService.getjkmd(dj,manager_id);
			List<UsersEntity> user=mbService.getjkryxx(manager_id);
			//map.put("myscore", myscore);
			map=mbService.getMyscore(manager_id, target_name);
			map.put("target", target);
			map.put("xsjxf", xsjxf);
			map.put("bmjxf", bmjxf);
			map.put("qxjxf", qxjxf);
			map.put("bmbyts", bmbyts);
			map.put("xsmd", xsmd);
			map.put("jkmd", jkmd);  
			map.put("jkryxx",user);
			SerializerFeature feature = SerializerFeature.DisableCircularReferenceDetect; 
			String json = JSON.toJSONString(map,feature);
			return json;
		}
		
		
		/*具体绩效信息*/
		@RequestMapping(value="getjtjx.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String getjtjx(HttpServletRequest request,HttpServletResponse res,HttpSession session) throws JsonParseException, JsonMappingException, IOException{
			String targetid = request.getParameter("targetid");
			Map<String,Object> map=new HashMap<String,Object>();
			map=mbService.getjtjx(targetid);	
			SerializerFeature feature = SerializerFeature.DisableCircularReferenceDetect; 
			String json = JSON.toJSONString(map,feature);	
			return json;
		}
		/*添加监控人*/
		@RequestMapping(value="gettjjk.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String gettjjk(HttpServletRequest request,HttpServletResponse res,HttpSession session) throws JsonParseException, JsonMappingException, IOException{
			String user_id = request.getParameter("user_id");
			String mon_id = request.getParameter("mon_id");
			Map<String,Object> map=new HashMap<String,Object>();
			map =mbService.getcunfang(user_id,mon_id);	 
			String json = JSON.toJSONString(map);
			return json;
		}
		/*删除监控人*/
		@RequestMapping(value="getscjk.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String getscjk(HttpServletRequest request,HttpServletResponse res,HttpSession session) throws JsonParseException, JsonMappingException, IOException{
			String user_id = request.getParameter("user_id");
			String mon_id = request.getParameter("mon_id");
			Map<String,Object> map=new HashMap<String,Object>();
			map =mbService.getshanchu(user_id,mon_id);	 
			String json = JSON.toJSONString(map);
			return json;
		}
		
		
//		@RequestMapping(value="getjkryxx.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
//		@ResponseBody
//		public String getjkryxx(HttpServletRequest request,HttpServletResponse res,HttpSession session) throws JsonParseException, JsonMappingException, IOException{
//			String user_id = request.getParameter("user_id");
//			Map<String,Object> map=new HashMap<String,Object>();
//			map=mbService.getjkryxx(user_id);	 	
//			String json = JSON.toJSONString(map);
//			return json;
//		}
		//头部搜索
		@RequestMapping(value="getxsmdsc.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String xsmdsc(HttpServletRequest request,HttpServletResponse res,HttpSession session) throws JsonParseException, JsonMappingException, IOException{
			String user_id = request.getParameter("user_id");
			String name = request.getParameter("name");
			Map<String,Object> map=new HashMap<String,Object>();
			map=mbService.getxsmdsc(user_id,name);	
			String json = JSON.toJSONString(map);
			return json;
		}
		@RequestMapping(value="getxsscore.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String xsscore(HttpServletRequest request,HttpServletResponse res,HttpSession session) throws JsonParseException, JsonMappingException, IOException{
			String manager_id = request.getParameter("manager_id");
			String target_name = request.getParameter("target_name");
			Map<String,Object> map=new HashMap<String,Object>();
			map=mbService.getMyscore(manager_id, target_name);
			SerializerFeature feature = SerializerFeature.DisableCircularReferenceDetect; 
			String json = JSON.toJSONString(map,feature);
			return json;
		}
		
	  /*
	   * 微信
	   * */
		
		//微信下属绩效
		@RequestMapping(value="getwxxsjx.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
		@ResponseBody
		public String wxxsscore(HttpServletRequest request,HttpServletResponse res,HttpSession session) throws JsonParseException, JsonMappingException, IOException{
			String user_id = request.getParameter("user_id");
			Map<String,Object> map=new HashMap<String,Object>();
			List<UsersEntity> xsjxf=mbService.getxsjxf(user_id);
			map.put("xsjxf", xsjxf);
			SerializerFeature feature = SerializerFeature.DisableCircularReferenceDetect; 
			String json = JSON.toJSONString(map,feature);
			return json;
		}
		//微信部门绩效
			@RequestMapping(value="getwxbmjx.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
			@ResponseBody
			public String wxbmscore(HttpServletRequest request,HttpServletResponse res,HttpSession session) throws JsonParseException, JsonMappingException, IOException{
				String user_id = request.getParameter("user_id");
				Map<String,Object> map=new HashMap<String,Object>();
				List<UsersEntity> bmjxf=mbService.getbmjxf(user_id);
				map.put("bmjxf", bmjxf);
				SerializerFeature feature = SerializerFeature.DisableCircularReferenceDetect; 
				String json = JSON.toJSONString(map,feature);
				return json;
				}
		//微信全校绩效
		    @RequestMapping(value="getwxqxjx.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
			@ResponseBody
			public String wxqxscore(HttpServletRequest request,HttpServletResponse res,HttpSession session) throws JsonParseException, JsonMappingException, IOException{
				Map<String,Object> map=new HashMap<String,Object>();
				List<UsersEntity> qxjxf=mbService.getqxjxf();
				map.put("qxjxf", qxjxf);
				SerializerFeature feature = SerializerFeature.DisableCircularReferenceDetect; 
				String json = JSON.toJSONString(map,feature);
				return json;
				}
		//微信部门提升绩效
			@RequestMapping(value="getwxbmtsjx.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
			@ResponseBody
			public String wxbmtsscore(HttpServletRequest request,HttpServletResponse res,HttpSession session) throws JsonParseException, JsonMappingException, IOException{
				String user_id = request.getParameter("user_id");
				Map<String,Object> map=new HashMap<String,Object>();
				List<UsersEntity> bmbyts=mbService.getbmbyts(user_id);
				map.put("bmbyts", bmbyts);
				SerializerFeature feature = SerializerFeature.DisableCircularReferenceDetect; 
				String json = JSON.toJSONString(map,feature);
				return json;
				}
			//微信监控
			@RequestMapping(value="getwxjk.action",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
			@ResponseBody
			public String wxjk(HttpServletRequest request,HttpServletResponse res,HttpSession session) throws JsonParseException, JsonMappingException, IOException{
				String user_id = request.getParameter("user_id");
				String dj = request.getParameter("dj");
				Map<String,Object> map=new HashMap<String,Object>();
				List<UsersEntity> jkmd=mbService.getjkmd(dj,user_id);
				List<UsersEntity> user=mbService.getjkryxx(user_id);
				map.put("jkmd", jkmd);  
				map.put("jkryxx",user);
				SerializerFeature feature = SerializerFeature.DisableCircularReferenceDetect; 
				String json = JSON.toJSONString(map,feature);
				return json;
				}
			/*微信项目树*/
			@RequestMapping(value="wxprojectTree.action",produces = "application/json;charset=utf-8",method=RequestMethod.POST)
			@ResponseBody
			public String wxprojectTree(HttpServletRequest request,HttpServletResponse res){
				String targetid = request.getParameter("targetid");
				System.out.println("-------------------"+targetid);
				Map<String,Object> map=new HashMap<String,Object>();
				map=mbService.wxprojectTree(targetid);
				String json = JSON.toJSONString(map);
				return json;
			}
			/*微信我的关注*/
			@RequestMapping(value="wxguanzhu.action",produces = "application/json;charset=utf-8",method=RequestMethod.POST)
			@ResponseBody
			public String wxguanzhu(HttpServletRequest request,HttpServletResponse res){
				String user_id = request.getParameter("user_id");
				
				Map<String,Object> map=new HashMap<String,Object>();
				map=mbService.wxgzxm(user_id);
				String json = JSON.toJSONString(map);
				return json;
			}
			/*微信我的绩效*/
			@RequestMapping(value="wxwdjx.action",produces = "application/json;charset=utf-8",method=RequestMethod.POST)
			@ResponseBody
			public String wxwdjx(HttpServletRequest request,HttpServletResponse res){
				String user_id = request.getParameter("user_id");
				
				Map<String,Object> map=new HashMap<String,Object>();
				map=mbService.getwxMyscore(user_id, null);
				String json = JSON.toJSONString(map);
				return json;
			}
			
			/*
			 * 站内信
			 * */
			//查询
			@RequestMapping(value="getmess.action",produces = "application/json;charset=utf-8",method=RequestMethod.POST)
			@ResponseBody
			public String getmess(HttpServletRequest request,HttpServletResponse res){
				String user_id = request.getParameter("user_id");
				
				Map<String,Object> map=new HashMap<String,Object>();
				map=mbService.getmess(user_id);
				String json = JSON.toJSONString(map);
				return json;
			}
			//更改
			@RequestMapping(value="upmess.action",produces = "application/json;charset=utf-8",method=RequestMethod.POST)
			@ResponseBody
			public String upmess(HttpServletRequest request,HttpServletResponse res){
				String mess_id = request.getParameter("mess_id");
				
				Map<String,Object> map=new HashMap<String,Object>();
				map=mbService.upmess(mess_id);
				String json = JSON.toJSONString(map);
				return json;
			}
			//删除
			@RequestMapping(value="demess.action",produces = "application/json;charset=utf-8",method=RequestMethod.POST)
			@ResponseBody
			public String demess(HttpServletRequest request,HttpServletResponse res){
				String mess_id = request.getParameter("mess_id");
				
				Map<String,Object> map=new HashMap<String,Object>();
				map=mbService.demess(mess_id);
				String json = JSON.toJSONString(map);
				return json;
			}
}
