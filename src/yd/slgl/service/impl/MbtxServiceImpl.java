package yd.slgl.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yd.htgl.entity.Organiza;
import yd.slgl.entity.DeclareEntity;
import yd.slgl.entity.Khzb;
import yd.slgl.entity.Mess;
import yd.slgl.entity.ReportEntity;
import yd.slgl.entity.Standard;
import yd.slgl.entity.StandardType;
import yd.slgl.entity.Target;
import yd.slgl.entity.UsersEntity;
import yd.slgl.mapper.MbtxMapper;
import yd.slgl.service.MbtxService;
import yd.slgl.util.TimeUtil;
@Service
public class MbtxServiceImpl implements MbtxService{
	//String templateid="yuEHzn0cYYk-yLTvXnsee-Nzqm0Bw1D35ygn8eJz6lE";
	 private String templateid="l5oBvpMaQWSe8u-zgrj9m7qHBRh8WI-DOr57AGJunx8";
	@Autowired
	private MbtxMapper mbMapper;
	@Override
	public Map<String, Object> targetlist(String userid,String dj) {
		List<String> li = new ArrayList<String>();
		System.out.printf(userid,dj);
		String target_extends=new TimeUtil().getStringByTime();
		System.out.println("++++++++"+target_extends);
		Map<String,Object> map = new HashMap<String,Object>();
		List<List<Target>> list1 = new ArrayList<List<Target>>();
		List<List<Target>> list2 = new ArrayList<List<Target>>();
		List<List<Target>> list3 = new ArrayList<List<Target>>();
		//学校层面
		List<Target> targetlist1 = mbMapper.targetlist1(userid,"0");
		System.out.println(targetlist1);
//		if(targetlist1.isEmpty()){
//			return null;
//		}
		for(Target ta:targetlist1){
			ta.setUserEntity(mbMapper.getparticipant(ta.getId()));
			ta.setList(li);
		}
		List<Target> targetlist12 = mbMapper.targetlist12(userid,"0");
		System.out.println(targetlist1);
//		if(targetlist1.isEmpty()){
//			return null;
//		}
		for(Target ta:targetlist12){
			ta.setUserEntity(mbMapper.getparticipant(ta.getId()));
			ta.setList(li);
		}
		List<Target> targetlist13 = mbMapper.targetlist13(userid,"0");
		System.out.println(targetlist1);
//		if(targetlist1.isEmpty()){
//			return null;
//		}
		for(Target ta:targetlist13){
			ta.setUserEntity(mbMapper.getparticipant(ta.getId()));
			ta.setList(li);
		}
		list1.add(targetlist1);
		list1.add(targetlist12);
		list1.add(targetlist13);
//		list.add(targetlist4);
		map.put("xuexiao", list1);
//		//第二级
//		List<Target> targetlist2=mbMapper.targetlist2(userid);
		List<Target> targetlist2 = mbMapper.targetlist1(userid,"1");
		for(Target ta:targetlist2){
			ta.setUserEntity(mbMapper.getparticipant(ta.getId()));
			ta.setList(li);
		}
		List<Target> targetlist22 = mbMapper.targetlist12(userid,"1");
		System.out.println(targetlist1);
//		if(targetlist1.isEmpty()){
//			return null;
//		}
		for(Target ta:targetlist22){
			ta.setUserEntity(mbMapper.getparticipant(ta.getId()));
			ta.setList(li);
		}
		List<Target> targetlist23 = mbMapper.targetlist13(userid,"1");
		System.out.println(targetlist1);
//		if(targetlist1.isEmpty()){
//			return null;
//		}
		for(Target ta:targetlist23){
			ta.setUserEntity(mbMapper.getparticipant(ta.getId()));
			ta.setList(li);
		}
		list2.add(targetlist2);
		list2.add(targetlist22);
		list2.add(targetlist23);
//		list.add(targetlist4);
		map.put("zhuanye", list2);
		//第三级
//		List<Target> targetlist3=mbMapper.targetlist3(userid);
		List<Target> targetlist3 = mbMapper.targetlist1(userid,"2");
		for(Target ta:targetlist3){
			ta.setUserEntity(mbMapper.getparticipant(ta.getId()));
			ta.setList(li);
		}
		List<Target> targetlist32 = mbMapper.targetlist12(userid,"2");
		System.out.println(targetlist1);
//		if(targetlist1.isEmpty()){
//			return null;
//		}
		for(Target ta:targetlist32){
			ta.setUserEntity(mbMapper.getparticipant(ta.getId()));
			ta.setList(li);
		}
		List<Target> targetlist33 = mbMapper.targetlist13(userid,"2");
		System.out.println(targetlist1);
//		if(targetlist1.isEmpty()){
//			return null;
//		}
		for(Target ta:targetlist33){
			ta.setUserEntity(mbMapper.getparticipant(ta.getId()));
			ta.setList(li);
		}
		list3.add(targetlist3);
		list3.add(targetlist32);
		list3.add(targetlist33);
//		list.add(targetlist4);
		map.put("kecheng", list3);
//		//第四级
//		List<Target> targetlist4=mbMapper.targetlist4(userid);
//		for(Target ta:targetlist4){
//			ta.setUserEntity(mbMapper.getparticipant(ta.getId()));
//		}
//		list.add(targetlist1);
//		list.add(targetlist12);
//		list.add(targetlist13);
////		list.add(targetlist4);
//		map.put("list", list);
		return map;
//		System.out.printf(userid,dj);
//		List<String> li = new ArrayList<String>();
//		String target_extends=new TimeUtil().getStringByTime();
//		System.out.println("++++++++"+target_extends);
//		Map<String,Object> map = new HashMap<String,Object>();
//		List<List<Target>> list = new ArrayList<List<Target>>();
//		//第一级
//		List<Target> targetlist1 = mbMapper.targetlist(userid,"0");
//		System.out.println(targetlist1);
////		if(targetlist1.isEmpty()){
////			return null;
////		}
//		for(Target ta:targetlist1){
//			ta.setUserEntity(mbMapper.getparticipant(ta.getId()));
//			ta.setList(li);
//		}
//		//第二级
//		List<Target> targetlist2=mbMapper.targetlist(userid,"1");
//		for(Target ta:targetlist2){
//			ta.setUserEntity(mbMapper.getparticipant(ta.getId()));
//			ta.setList(li);
//		}
//		//第三级
//		List<Target> targetlist3=mbMapper.targetlist(userid,"2");
//		for(Target ta:targetlist3){
//			ta.setUserEntity(mbMapper.getparticipant(ta.getId()));
//			ta.setList(li);
//		}
//		//第四级
////		List<Target> targetlist4=mbMapper.targetlist(userid);
////		for(Target ta:targetlist4){
////			ta.setUserEntity(mbMapper.getparticipant(ta.getId()));
////			ta.setList(li);
////		}
//		list.add(targetlist1);
//		list.add(targetlist2);
//		list.add(targetlist3);
////		list.add(targetlist4);
//		map.put("list", list);
//		return map;
	}

	@Override
	public Map<String, Object> targetlist1(String userid,String dj) {
		System.out.printf(userid,dj);
		String target_extends=new TimeUtil().getStringByTime();
		System.out.println("++++++++"+target_extends);
		Map<String,Object> map = new HashMap<String,Object>();
		List<List<Target>> list = new ArrayList<List<Target>>();
		//第一级
		List<Target> targetlist1 = mbMapper.targetlist(userid,"1");
		System.out.println(targetlist1);
//		if(targetlist1.isEmpty()){
//			return null;
//		}
		for(Target ta:targetlist1){
			ta.setUserEntity(mbMapper.getparticipant(ta.getId()));
			ta.setList(null);
		}
		//第二级
		List<Target> targetlist2=mbMapper.targetlist2(userid);
		for(Target ta:targetlist2){
			ta.setUserEntity(mbMapper.getparticipant(ta.getId()));
		}
		//第三级
		List<Target> targetlist3=mbMapper.targetlist3(userid);
		for(Target ta:targetlist3){
			ta.setUserEntity(mbMapper.getparticipant(ta.getId()));
		}
		//第四级
		List<Target> targetlist4=mbMapper.targetlist4(userid);
		for(Target ta:targetlist4){
			ta.setUserEntity(mbMapper.getparticipant(ta.getId()));
		}
		list.add(targetlist1);
		list.add(targetlist2);
		list.add(targetlist3);
		list.add(targetlist4);
		map.put("list", list);
		return map;
	}
	@Override
	public List<Khzb> getkhzb() {
		List<Khzb> khzb=mbMapper.getkhzb();
		return khzb;
	}

	@Override
	public List<UsersEntity> userlist() {
		List<UsersEntity> userlist=mbMapper.userlist();
		return userlist;
	}

	@Override
	public Map<String, Object> addtarget(Target target, String[] cyr) {
		System.out.println(target.getManager_id());
		System.out.println(cyr);
		String target_extends=new TimeUtil().getStringByTime();
		target.setTarget_extends(target_extends);
		
		Map<String,Object> map = new HashMap<String,Object>();
		Integer tp=mbMapper.addtarget(target);
		if(tp>0){
			UsersEntity wxlist=mbMapper.getwxOpenid(target.getManager_id());
			UsersEntity user=mbMapper.getxinxi(target.getManager_id());
			System.out.println("---------"+wxlist);
			if(wxlist.getWx_id()==null){
				UsersEntity wx=mbMapper.getwxOpenid(target.getCreator_id());
				String content=wxlist.getName()+"老师未在微信上绑定诊改系统，微信消息提醒失败，目前仅用站内消息进行提醒通知。";
					String url="http://zg.demo.xqit.net/ydjxzg/wxshuanglian";
					System.out.println("0000000000000"+target.getTarget_name()+"88888888888888"+wxlist.getWx_id()+"9999999999"+target.getId());
					//mbMapper.insertmess(wx.getWx_id(), templateid, content, new TimeUtil().getEnoByTime(),url);
					mbMapper.insertinform(target.getCreator_id(), content);
					String content2=user.getName()+"老师分配了一个项目:"+target.getTarget_name()+"，您被设置为负责人";
					mbMapper.insertinform(target.getManager_id(), content2);
			}
			else{
					String content=user.getName()+"老师分配了一个项目:"+target.getTarget_name()+"，您被设置为负责人";
					String url="http://zg.demo.xqit.net/ydjxzg/wxshuanglian";
					//System.out.println("0000000000000"+target.getTarget_name()+"88888888888888"+wxlist.getWx_id()+"9999999999"+target.getId());
					//mbMapper.insertmess(wxlist.getWx_id(), templateid, content, new TimeUtil().getEnoByTime(),url);
					mbMapper.insertinform(target.getManager_id(), content);
				}
			for (String string : cyr) {
				System.out.println("++++++++++++++"+string);
			}
			
			if(cyr.length>0&&!cyr.equals("undefined")&&!cyr[0].equals("")){
				
				for(int i=0;i<cyr.length;i++){
					Integer cyrs=mbMapper.addxjcyr(cyr[i]);
					UsersEntity wxlist1=mbMapper.getwxOpenid(cyr[i]);
					if(wxlist1.getWx_id()==null){
						UsersEntity wx=mbMapper.getwxOpenid(target.getCreator_id());
						String content=wxlist1.getName()+"老师未在微信上绑定诊改系统，微信消息提醒失败，目前仅用站内消息进行提醒通知。";
							String url="http://zg.demo.xqit.net/ydjxzg/wxshuanglian";
							System.out.println("0000000000000"+target.getTarget_name()+"88888888888888"+wxlist.getWx_id()+"9999999999"+target.getId());
							//mbMapper.insertmess(wx.getWx_id(), templateid, content, new TimeUtil().getEnoByTime(),url);
							mbMapper.insertinform(target.getCreator_id(), content);
							String content2=user.getName()+"老师分配了一个项目:"+target.getTarget_name()+"，您被设置为参与";
							mbMapper.insertinform(cyr[i], content2);
					}
					else {
							String content=user.getName()+"老师分配了一个项目:"+target.getTarget_name()+"，您被设置为参与";
							String url="http://zg.demo.xqit.net/ydjxzg/wxshuanglian";
							//mbMapper.insertmess(wxlist1.getWx_id(), templateid, content, new TimeUtil().getEnoByTime(),url);
							mbMapper.insertinform(cyr[i], content);
						}
					}
				}
			map.put("mess", true);
		}else{
			map.put("mess", false);
		}
		return map;
	}

	@Override
	public Map<String, Object> targetDetails(String targetid, String user_id) {
		Map<String,Object> map = new HashMap<String,Object>();
		if(null!=targetid){
			Target target=mbMapper.targetDetails(targetid);//项目详情			
			target.setUserEntity(mbMapper.getparticipant(targetid));
			map.put("targetDetails", target); 
			if(null!=target){
				List<Target> subprojects=mbMapper.subprojects(targetid);//子项目列表
				map.put("subprojects", subprojects);
				if(!"1".equals(target.getTarget_dj())){
					//申报记录
					List<DeclareEntity> declareList=mbMapper.declareList(targetid,user_id);
					map.put("declareList", declareList);
				}
				if(!subprojects.isEmpty()){
					map.put("subprojects", subprojects);
				}else{
					map.put("mess", "0");
				}
			}
			if("4".equals(target.getTarget_dj())){
				List<ReportEntity> reportlist=mbMapper.getreportlist(targetid);
				if(!reportlist.isEmpty()){
					for(ReportEntity re:reportlist){
						re.setAttachment(mbMapper.getAttachment(re.getId()));
					}
					map.put("reportlist", reportlist);
				}
			}
		}			
		return map;
	}

	@Override
	public Map<String, Object> addReport(ReportEntity report) {
		Map<String,Object> map = new HashMap<String,Object>();
		System.out.println("111"+report.getReport_name()+"22222"+report.getImportancedj()+"3333"+report.getActual_funds()+"44444"+report.getProgress()+
				"555"+report.getReport_desc()+"666"+report.getTarget_id()+"777"+report.getManager_id());
		int ad=mbMapper.addReport(report);
		if(ad>0){
			int updateTar=mbMapper.updateTar(report);//更新进度到tr_target
			String progress=mbMapper.getprogress(report.getTarget_id());//查询进度
			if("100".equals(progress)){
				int g=mbMapper.updateCheck(report.getTarget_id());//进度为100时状态改为能提交审核
			}
			String parentid=mbMapper.getparentid(report.getTarget_id());//查询父id
			if(!parentid.isEmpty()){
				int parentprogress=mbMapper.parentProgress(parentid);//上级项目进度	
				int c=mbMapper.updateProgress1(parentid,parentprogress);//更新上级项目进度
				String parentid2=mbMapper.getparentid2(report.getTarget_id());
				if(!parentid2.isEmpty()){
					Integer parentprogress2=mbMapper.parentProgress(parentid2);
				    Integer d=mbMapper.updateProgress1(parentid2,parentprogress2);
					String parentid3=mbMapper.getparentid3(report.getTarget_id());
					if(!parentid3.isEmpty()){
						Integer parentprogress3=mbMapper.parentProgress(parentid3);
						Integer e=mbMapper.updateProgress1(parentid3,parentprogress3);	
					}
				}
				
			}
			if(updateTar>0){
				map.put("mess", true);
			}else{
				map.put("mess", false);
			}
			
		}else{
			map.put("mess", false);
		}
		return map;
	}

	@Override
	public Map<String, Object> checktarget(DeclareEntity declare,String progress) {
		Map<String,Object> map = new HashMap<String,Object>();
		String maxid=mbMapper.getmaxdeclareid(declare.getTarget_id());
		Target target=mbMapper.targetDetails(declare.getTarget_id());
		declare.setId(maxid);
		if("1".equals(declare.getResult())){
			Integer num = mbMapper.updateDeclare(declare);
			Integer num2=mbMapper.updateTargetCheck(declare.getTarget_id());
			String parentid=mbMapper.getparentid(declare.getTarget_id());
			int childrenCount=mbMapper.childrenCount(parentid);
			int childrenCountSuccess=mbMapper.childrenCountSuccess(parentid);
			if(childrenCount<=childrenCountSuccess){
				int parentcheck=mbMapper.updateCheck(parentid);
				
			}
			if(num2>0){
				UsersEntity wxlist=mbMapper.getwxOpenid(target.getManager_id());
				System.out.println("---------"+wxlist);
				String content="您的项目:"+target.getTarget_name()+"审核已通过";
				String url="http://zg.demo.xqit.net/ydjxzg/wxshuanglian/#/xiangqing?targetid="+target.getId();
				System.out.println("0000000000000"+target.getTarget_name()+"88888888888888"+wxlist.getWx_id());
				//mbMapper.insertmess(wxlist.getWx_id(), templateid, content, new TimeUtil().getEnoByTime(),url);
				mbMapper.insertinform(target.getManager_id(), content);
				map.put("mess", true);
			}else{
				map.put("mess", false);
			}
			
		}if("0".equals(declare.getResult())){
			Integer num = mbMapper.Declarefalse(declare,progress);
			Integer num2=mbMapper.TargetCheckfalse(declare.getTarget_id(),progress);
			if(num2>0){
				UsersEntity wxlist=mbMapper.getwxOpenid(target.getManager_id());
				System.out.println("---------"+wxlist);
					String content="您的项目:"+target.getTarget_name()+"审核未通过";
					String url="http://zg.demo.xqit.net/ydjxzg/wxshuanglian/#/xiangqing?targetid="+target.getId();
					System.out.println("0000000000000"+target.getTarget_name()+"88888888888888"+wxlist.getWx_id());
//					mbMapper.insertmess(wxlist.getWx_id(), templateid, content, new TimeUtil().getEnoByTime(),url);
					mbMapper.insertinform(target.getManager_id(), content);
				map.put("mess", true);
			}else{
				map.put("mess", false);
			}
			
		}
		
		return map;
	}

	@Override
	public Map<String, Object> targetFollow(String follow, String targetid ,String follow_id) {
		Map<String,Object> map = new HashMap<String,Object>();
		Integer num=mbMapper.targetFollow(follow,targetid);
		System.out.println("____________"+follow);
		if(num>0){
			if(follow.equals("1")){
				mbMapper.insertfollow(follow_id, targetid);
			}else if(follow.equals("0")){
				mbMapper.deletfollow(follow_id, targetid);
			}
			map.put("mess", true);
		}else{
			map.put("mess", false);
		}
		return map;
	}

	@Override
	public Map<String, Object> commitDeclare(String targetid, String report_desc) {
		Map<String,Object> map = new HashMap<String,Object>();
		Target target=mbMapper.targetDetails(targetid);
		int num2=mbMapper.updateTargetCh(target.getId());
		int num=mbMapper.addDeclare(target,report_desc);
		if(num>0){
			UsersEntity wxlist=mbMapper.getwxOpenid(target.getUpManager_id());
			System.out.println("---------"+wxlist);
			
				String content="项目:"+target.getTarget_name()+"提交了审核,请尽快处理,提交人"+target.getName();
				String url="http://zg.demo.xqit.net/ydjxzg/wxshuanglian/#/xiangqing?targetid="+target.getId();
				System.out.println("0000000000000"+target.getTarget_name()+"88888888888888"+wxlist.getWx_id());
//				mbMapper.insertmess(wxlist.getWx_id(), templateid, content, new TimeUtil().getEnoByTime(),url);
				mbMapper.insertinform(target.getUpManager_id(), content);
			map.put("mess", true);
		}else{
			map.put("mess", false);
		} 
		return map;
	}

	@Override
	public Map<String, Object> goRegression(String targetid,String declareid) {
		List<Target> targetlist=mbMapper.targetResult(targetid);
		String did=mbMapper.getmaxdeclareid(targetid);
		String comment = mbMapper.declareComment(did);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("targetlist", targetlist);
		map.put("comment", comment);
		return map;
	}

	@Override
	public Map<String, Object> checkRegression(List<DeclareEntity> declareEntity) {
		Map<String,Object> map = new HashMap<String,Object>();
		String parentid=mbMapper.getparentid(declareEntity.get(0).getTarget_id());
		int cou=mbMapper.updateTargetcheck2(parentid);
		for(DeclareEntity declare:declareEntity){			
			if(null!=declare.getComment()&&!"".equals(declare.getComment())){
				String maxid=mbMapper.getmaxdeclareid(declare.getTarget_id());
				declare.setId(maxid);
				int num=mbMapper.updateTargetcheck1(declare.getPropress(),declare.getTarget_id());
				int num2 = mbMapper.insertcheckRegression(declare);
				if(num>0&&num2>0){
					map.put("mess", true);
				}else{
					map.put("mess", false);
				}
			}
		}
		return map;
	}

	@Override
	public Map<String, Object> projectTree(String targetid) {
		Map<String,Object> map = new HashMap<String,Object>();
		Target targetOne=mbMapper.targetDetails(targetid);
		map.put("targetOne", targetOne);
		if("1".equals(targetOne.getTarget_dj())){
			targetOne.setClassName("firstLevel");
			//查找第二级
			Set<Target> targetTwo=mbMapper.targetTwo(targetid);
			targetOne.setChildren(targetTwo);
			if(!targetTwo.isEmpty()){	
				for(Target ta:targetTwo){
					ta.setClassName("secondLevel");
					//查找第三级
					Set<Target> targetThree = mbMapper.targetTwo(ta.getId());
					if(!targetThree.isEmpty()){
						ta.setChildren(targetThree);
						for(Target three:targetThree){
							three.setClassName("thirdLevel");
							//查找第四级
							Set<Target> targetFour = mbMapper.targetTwo(three.getId());
							if(!targetFour.isEmpty()){
								three.setChildren(targetFour);
								for(Target four:targetFour){
									four.setClassName("fourthLevel");
								}
							}
						}
						
					}
				}
				
			}
			map.put("projectTree", targetOne);
		}
		if(!"1".equals(targetOne.getTarget_dj())){
			System.out.println(targetOne.getParent_id()+"-----------"+targetOne.getTarget_dj());
			Target targetOne1=mbMapper.targetparentid1(targetOne.getParent_id(),targetOne.getTarget_dj());
			System.out.println("55555555"+targetOne1);
			targetOne1.setClassName("firstLevel");
			//查找第二级
			Set<Target> targetTwo=mbMapper.targetTwo1(targetOne.getId(),targetOne.getTarget_dj());
			targetOne1.setChildren(targetTwo);
			if(!targetTwo.isEmpty()){	
				for(Target ta:targetTwo){
					ta.setClassName("secondLevel");
					Set<Target> targetThree = new HashSet<Target>();
					//查找第三级
					if(targetOne.getTarget_dj().equals("2")){
					targetThree = mbMapper.targetTwo(ta.getId());
					}else{
						targetThree = mbMapper.targetTwo2(targetOne.getId(),targetOne.getTarget_dj());	
					}
					if(!targetThree.isEmpty()){
						ta.setChildren(targetThree);
						for(Target three:targetThree){
							three.setClassName("thirdLevel");
							Set<Target> targetFour= new HashSet<Target>();
							//查找第四级
							if(targetOne.getTarget_dj().equals("2") || targetOne.getTarget_dj().equals("3")){
								targetFour=mbMapper.targetTwo(three.getId());
							}else{
								targetFour=mbMapper.targetTwo3(targetOne.getId(),targetOne.getTarget_dj());
							}
							if(!targetFour.isEmpty()){
								three.setChildren(targetFour);
								for(Target four:targetFour){
									String brtitle="";
									int b=0;
									for(int lg=0, len=four.getTitle().length();lg<len;lg++){
										b++;
										brtitle+=four.getTitle().charAt(lg);
										if(b%8==0){
											brtitle+="<br>";
										}										
									}
									four.setTitle(brtitle);
									four.setClassName("fourthLevel");
								}
							}
						}
						
					}
				}
				
			}
			map.put("projectTree", targetOne1);
		}
		
		return map;
	}

	@Override
	public Map<String, Object> goeditTarget(String targetid) {
		Map<String,Object> map = new HashMap<String,Object>();
		Target target=mbMapper.targetDetails(targetid);
		target.setUserEntity(mbMapper.getparticipant(targetid));
		List<Khzb> khzb=mbMapper.getkhzb();
		List<UsersEntity> userlist=mbMapper.userlist();
		map.put("target", target);
		map.put("khzb", khzb);
		map.put("userlist", userlist);
		return map;
	}

	@Override
	public Map<String, Object> editTarget(Target target, String[] userlist) {
		Map<String,Object> map = new HashMap<String,Object>();
		int num=mbMapper.editTarget(target);
		Target target2=mbMapper.targetDetails(target.getId());
		if(userlist.length>0&&!userlist.equals("")&&!userlist.equals("undefined")){
			int num1=mbMapper.deleteParticipant(target.getId());
			for(int i=0;i<userlist.length;i++){
				System.out.println(userlist[i]);
				Integer cyrs=mbMapper.addxjcyr(userlist[i]);
			}
		}
		if(num>0){
			UsersEntity wxlist=mbMapper.getwxOpenid(target.getManager_id());
			
				String content="您负责的项目:"+target.getTarget_name()+"已被"+target2.getUpManager()+"老师修改";
				String url="http://yfakzt.natappfree.cc/ydjxzg/wxshuanglian/#/xiangqing?targetid="+target.getId();
				System.out.println("0000000000000"+target.getTarget_name()+"88888888888888"+wxlist.getWx_id());
//				mbMapper.insertmess(wxlist.getWx_id(), templateid, content, new TimeUtil().getEnoByTime(),url);
				mbMapper.insertinform(target.getManager_id(), content);
				
			UsersEntity wxlist2=mbMapper.getwxOpenid(target2.getCreator_id());
				String content2="您分配的项目:"+target.getTarget_name()+"修改成功";
				String url2="http://yfakzt.natappfree.cc/ydjxzg/wxshuanglian/#/xiangqing?targetid="+target.getId();
				System.out.println("0000000000000"+target.getTarget_name()+"88888888888888"+wxlist2.getWx_id());
//				mbMapper.insertmess(wxlist2.getWx_id(), templateid, content2, new TimeUtil().getEnoByTime(),url2);
				mbMapper.insertinform(target2.getUpManager_id(), content2);
				if(userlist.length>0&&!userlist[0].equals("")&&!userlist.equals("undefined")){
			    for(String user_id:userlist){
				String[] strarr =user_id.split(",");
			    for(String str: strarr){
			    	mbMapper.addParticipant(target.getId(),str);
					UsersEntity wx=mbMapper.getwxOpenid(str);
						String content3="您参与的项目:"+target.getTarget_name()+"已被"+target2.getManager_name()+"修改";
						String url3="http://zg.demo.xqit.net/ydjxzg/wxshuanglian/#/xiangqing?targetid="+target.getId();
//						mbMapper.insertmess(wx.getWx_id(), templateid, content, new TimeUtil().getEnoByTime(),url3);
						mbMapper.insertinform(str, content3);
						
					}
			    }
				}
			mbMapper.upparname(target.getId(), target.getTarget_name());
			map.put("mess", true);
		}else{
			map.put("mess",false);
		}
		return map;
	}

	@Override
	public Map<String, Object> decomposeTarget(Target target, String[] userlist) {
		Map<String,Object> map = new HashMap<String,Object>();
		int count=mbMapper.brotherCount(target.getParent_id());
		Target target2=mbMapper.targetDetails(target.getParent_id());
		target.setBrother(String.valueOf(count+1));
		int num=mbMapper.decomposeTarget(target);
		if(userlist.length>0&&!userlist.equals("undefined")&&!userlist.equals("")){
			for(String user_id:userlist){
				String[] strarr =user_id.split(",");
			    for(String str: strarr){
				System.out.println(str);
				System.out.println("################"+str);
				mbMapper.addxjcyr(str);
			}
		}
		}
		if(num>0){
			UsersEntity wxlist=mbMapper.getwxOpenid(target.getManager_id());
			UsersEntity wx=mbMapper.getwxOpenid(target.getCreator_id());
			if(wxlist.getWx_id()==null){
				String content=wxlist.getName()+"老师未在微信上绑定诊改系统，微信消息提醒失败，目前仅用站内消息进行提醒通知。";
					String url="http://zg.demo.xqit.net/ydjxzg/wxshuanglian";
					System.out.println("0000000000000"+target.getTarget_name()+"88888888888888"+wxlist.getWx_id()+"9999999999"+target.getId());
					//mbMapper.insertmess(wx.getWx_id(), templateid, content, new TimeUtil().getEnoByTime(),url);
					mbMapper.insertinform(target.getCreator_id(), content);
					String content2=wx.getName()+"老师分配了一个项目:"+target.getTarget_name()+"，您被设置为负责人";
					mbMapper.insertinform(target.getManager_id(), content2);
			}
			else{
				String content=wx.getName()+"老师分配了一个项目"+target.getTarget_name()+",您被设置为负责人";
				String templateid="yuEHzn0cYYk-yLTvXnsee-Nzqm0Bw1D35ygn8eJz6lE";
				System.out.println("0000000000000"+target.getTarget_name()+"88888888888888"+wxlist.getWx_id());
				String url="http://zg.demo.xqit.net/ydjxzg/wxshuanglian/#/xiangqing?targetid="+target.getId();
				//mbMapper.insertmess(wxlist.getWx_id(), templateid, content, new TimeUtil().getEnoByTime(),url);
				mbMapper.insertinform(target.getManager_id(), content);
			}
			for(String user_id:userlist){
				String[] strarr =user_id.split(",");
			    for(String str: strarr){
				System.out.println(str);
			    UsersEntity wx1=mbMapper.getwxOpenid(str);
				    if(wx1.getWx_id()==null)
				    {
						String content=wx1.getName()+"老师未在微信上绑定诊改系统，微信消息提醒失败，目前仅用站内消息进行提醒通知。";
							String url="http://zg.demo.xqit.net/ydjxzg/wxshuanglian";
							System.out.println("0000000000000"+target.getTarget_name()+"88888888888888"+wxlist.getWx_id()+"9999999999"+target.getId());
							//mbMapper.insertmess(wx.getWx_id(), templateid, content, new TimeUtil().getEnoByTime(),url);
							mbMapper.insertinform(target.getCreator_id(), content);
							String content2=wx.getName()+"老师分配了一个项目:"+target.getTarget_name()+"，您被设置为参与人";
							mbMapper.insertinform(str, content2);
				    }
				    else {
				    	String content=wx.getName()+"老师分配了一个项目:"+target.getTarget_name()+",您被设置为参与人";
						String url="http://zg.demo.xqit.net/ydjxzg/wxshuanglian/#/xiangqing?targetid="+target.getId();
						//mbMapper.insertmess(wx1.getWx_id(), templateid, content, new TimeUtil().getEnoByTime(),url);
						mbMapper.insertinform(str, content);
					}

			
			}
		}
			map.put("mess", true);
		}else{
			map.put("mess", false);
		}
		return map;
	}

	@Override
	public Map<String, Object> deleteTarget(String targetid,String targetdj) {
		Map<String,Object> map = new HashMap<String,Object>();		
		Target target=mbMapper.targetDetails(targetid);
		List<UsersEntity> canyu=mbMapper.getcanyuren(targetid);
		if("4".equals(targetdj)){
			//删除指标及其参与人
			int count=mbMapper.deleteTarget(targetid);
			mbMapper.deletecyr(targetid);
			if(count>0){
				UsersEntity wxlist=mbMapper.getwxOpenid(target.getManager_id());
				
					String content="您负责的项目:"+target.getTarget_name()+"已被取消";
					String url="http://zg.demo.xqit.net/ydjxzg/wxshuanglian";
					System.out.println("0000000000000"+target.getTarget_name()+"88888888888888"+wxlist.getWx_id());
					//mbMapper.insertmess(wxlist.getWx_id(), templateid, content, new TimeUtil().getEnoByTime(),url);
					mbMapper.insertinform(target.getManager_id(), content);
				if(!canyu.isEmpty()){
					for(UsersEntity can:canyu){
						UsersEntity wx=mbMapper.getwxOpenid(can.getUser_id());
						String content2="您参与的项目:"+target.getTarget_name()+"已被取消";
						String url2="http://zg.demo.xqit.net/ydjxzg/wxshuanglian";
						//mbMapper.insertmess(wx.getWx_id(), templateid, content2, new TimeUtil().getEnoByTime(),url);
						mbMapper.insertinform(can.getUser_id(), content2);
					}
				}
				map.put("mess", true);
			}else{
				map.put("mess", false);
			}
		}if("3".equals(targetdj)){
			mbMapper.deleteChildren(targetid);
			/*mbMapper.deleteChildrenCyr(targetid);*/
			int count=mbMapper.deleteTarget(targetid);
			mbMapper.deletecyr(targetid);
			if(count>0){
				UsersEntity wxlist=mbMapper.getwxOpenid(target.getManager_id());
				
					String content="您的项目:"+target.getTarget_name()+"已被取消";
					String url="http://zg.demo.xqit.net/ydjxzg/wxshuanglian";
					System.out.println("0000000000000"+target.getTarget_name()+"88888888888888"+wxlist.getWx_id());
					//mbMapper.insertmess(wxlist.getWx_id(), templateid, content, new TimeUtil().getEnoByTime(),url);
					mbMapper.insertinform(target.getManager_id(), content);
				
				if(!canyu.isEmpty()){
					for(UsersEntity can:canyu){
						
						UsersEntity wx=mbMapper.getwxOpenid(can.getUser_id());
						
							String content2="您参与的项目:"+target.getTarget_name()+"已被取消";
							String url1="http://zg.demo.xqit.net/ydjxzg/wxshuanglian";
						//	mbMapper.insertmess(wx.getWx_id(), templateid, content2, new TimeUtil().getEnoByTime(),url);
							mbMapper.insertinform(can.getUser_id(), content2);
					}
				}
				map.put("mess", true);
			}else{
				map.put("mess", false);
			}
		}if("2".equals(targetdj)){
			String[] ids=mbMapper.getids(targetid);
			if(ids.length>0){
				for(String id:ids){
					int count=mbMapper.deleteTarget(id);
					mbMapper.deletecyr(id);
				}
			}
			mbMapper.deleteChildren(targetid);
			/*mbMapper.deleteChildrenCyr(targetid);*/
			int count=mbMapper.deleteTarget(targetid);
			mbMapper.deletecyr(targetid);
			if(count>0){
				UsersEntity wxlist=mbMapper.getwxOpenid(target.getManager_id());
					String content="您的项目:"+target.getTarget_name()+"已被取消";
					String url="http://zg.demo.xqit.net/ydjxzg/wxshuanglian";
					System.out.println("0000000000000"+target.getTarget_name()+"88888888888888"+wxlist.getWx_id());
				//	mbMapper.insertmess(wxlist.getWx_id(), templateid, content, new TimeUtil().getEnoByTime(),url);
					mbMapper.insertinform(target.getManager_id(), content);
				
				if(!canyu.isEmpty()){
					for(UsersEntity can:canyu){
						
						UsersEntity wx=mbMapper.getwxOpenid(can.getUser_id());
						
							String content2="您参与的项目:"+target.getTarget_name()+"已被取消";
							String url1="http://zg.demo.xqit.net/ydjxzg/wxshuanglian";
						//	mbMapper.insertmess(wx.getWx_id(), templateid, content2, new TimeUtil().getEnoByTime(),url);
							mbMapper.insertinform(can.getUser_id(), content2);
					}
				}
				map.put("mess", "删除节点成功!");
			}else{
				map.put("mess", "删除节点失败!");
			}
		}if("1".equals(targetdj)){
			String[] ids=mbMapper.getids(targetid);
			if(ids.length>0){
				for(String id:ids){
					mbMapper.deleteChildren(id);
					/*mbMapper.deleteChildrenCyr(id);*/
				}
				for(String id:ids){
					int count=mbMapper.deleteTarget(id);
					mbMapper.deletecyr(id);
				}
			}
			
			/*mbMapper.deleteChildrenCyr3(targetid);*/
			/*mbMapper.deleteChildren3(targetid);*/
			/*mbMapper.deleteChildrenCyr2(targetid);*/
			/*mbMapper.deleteChildren2(targetid);*/
			mbMapper.deleteChildren(targetid);
			/*mbMapper.deleteChildrenCyr(targetid);*/
			int count=mbMapper.deleteTarget(targetid);
			mbMapper.deletecyr(targetid);
			if(count>0){
				UsersEntity wxlist=mbMapper.getwxOpenid(target.getManager_id());
				
					String content="您的项目:"+target.getTarget_name()+"已被取消";
					String url="http://zg.demo.xqit.net/ydjxzg/wxshuanglian";
					System.out.println("0000000000000"+target.getTarget_name()+"88888888888888"+wxlist.getWx_id());
				//	mbMapper.insertmess(wxlist.getWx_id(), templateid, content, new TimeUtil().getEnoByTime(),url);
					mbMapper.insertinform(target.getManager_id(), content);
				
				if(!canyu.isEmpty()){
					for(UsersEntity can:canyu){
						UsersEntity wx=mbMapper.getwxOpenid(can.getUser_id());
							String content2="您参与的项目:"+target.getTarget_name()+"已被取消";
							String url1="http://zg.demo.xqit.net/ydjxzg/wxshuanglian";
					//		mbMapper.insertmess(wx.getWx_id(), templateid, content2, new TimeUtil().getEnoByTime(),url1);
							mbMapper.insertinform(can.getUser_id(), content);
					}
				}
				map.put("mess", true);
			}else{
				map.put("mess", false);
			}
		}
		
			
		return map;
	}

	@Override
	public Map<String, Object> standardlist() {
		Map<String,Object> map = new HashMap<String,Object>();
		List<StandardType> standardlist=mbMapper.standardlist();
		if(!standardlist.isEmpty()){
				for(StandardType s:standardlist){
					List<StandardType> children = mbMapper.getChildrenStandard(s.getId());
					List<Standard> childrenstand= mbMapper.standlist(s.getId(), null);
					if(children.isEmpty()){
						continue;
					}else{
						for(StandardType s1:children){
							List<StandardType> children1 = mbMapper.getChildrenStandard(s1.getId());
							List<Standard> childrenstand1= mbMapper.standlist(s1.getId(), null);
							if(children1.isEmpty()){
								if(childrenstand1.isEmpty()){
									continue;
								}else{
									s1.setChildrenstand(childrenstand1);
								}
							}else{
								for(StandardType s2:children1){
									List<StandardType> children2 = mbMapper.getChildrenStandard(s2.getId());
									List<Standard> childrenstand2= mbMapper.standlist(s2.getId(), null);
									if(children2.isEmpty()){
										if(childrenstand2.isEmpty()){
											continue;
										}else{
											s2.setChildrenstand(childrenstand2);
										}
									}else{
										for(StandardType s3:children2){
											List<StandardType> children3 = mbMapper.getChildrenStandard(s3.getId());
											List<Standard> childrenstand3= mbMapper.standlist(s3.getId(), null);
											if(children3.isEmpty()){
												if(childrenstand3.isEmpty()){
													continue;
												}else{
													s3.setChildrenstand(childrenstand2);
												}
												
											}else{
												//继续
											}
											
											s3.setChildren(children3);
											
										}
									}
									
									s2.setChildren(children2);
									
								}
							}
							
							s1.setChildren(children1);
							
						}
						
					}
					
					s.setChildren(children);
					s.setChildrenstand(childrenstand);
				}
						
		}
		Integer minid=mbMapper.minstandid();
		int scount=mbMapper.StandCount();
		Standard stan=mbMapper.seluptime();
		List<Standard> standlist=mbMapper.standlist(String.valueOf(minid),null);
		map.put("standardlist", standardlist);
		map.put("standlist", standlist);
		map.put("scount", scount);
		map.put("update_time",stan.getUpdate_time() );
		return map;
	}

	@Override
	public Map<String, Object> addStandardType(StandardType standardtype) {
		Map<String,Object> map = new HashMap<String,Object>();
		
		System.out.println("++++++++++++"+standardtype.getName());
		Integer num=mbMapper.typename(standardtype.getName(),standardtype.getParent_id());
		System.out.println("+{+++++"+num);
		if(num==0){
		int count=mbMapper.addStandardType(standardtype);
		if(count>0){
			map.put("mess", true);
		}else{
			map.put("mess", false);
		}
		}
		else{
			map.put("mess", "名称已存在");
		}
		return map;
	}

	@Override
	public Map<String, Object> editStandardType(StandardType standardtype) {
		Map<String,Object> map = new HashMap<String,Object>();
		
		Integer num=mbMapper.typename(standardtype.getName(),standardtype.getParent_id());
		if(num==0){
		int count=mbMapper.editStandardType(standardtype.getId(),standardtype.getName());
		if(count>0){
			map.put("mess", true);
		}else{
			map.put("mess", false);
		}
		}else{
			map.put("mess", "名称已存在");
		}
		return map;
	}

	@Override
	public Map<String, Object> deleteStandardType(String id) {
		Map<String,Object> map = new HashMap<String,Object>();
		if("0".equals(id)){
			map.put("mess", "此节点不可删除");
		}else{
		int count1=mbMapper.deleteStand(id);
		int count2=mbMapper.deleteStandType(id);
		if(count2>0){
			map.put("mess", true);
		}else{
			map.put("mess", false);
		}
		}
		return map;
	}

	@Override
	public Map<String, Object> standardByType(String id,String name) {
		Map<String,Object> map = new HashMap<String,Object>();
		List<Standard> standlist=mbMapper.standlist(id,name);
		int i = 0;
        for (Standard s : standlist){
        s.setName((++i) + ". " +s.getName());
    }
		if(!standlist.isEmpty()){
			map.put("standlist", standlist);
		}
		else{
			map.put("mess", false);
		}
		return map;
	}

	@Override
	public Map<String, Object> deleteStand(String id) {
		Map<String,Object> map = new HashMap<String,Object>();
		int count=mbMapper.deleteStandard(id);
		if(count>0){
			map.put("mess", true);
		}else{
			map.put("mess", false);
		}
		return map;
	}

	@Override
	public Map<String, Object> editStand(Standard stand) {
		Map<String,Object> map = new HashMap<String,Object>();
        int count = mbMapper.editStand(stand);
        if(count>0){
			map.put("mess", true);
		}else{
			map.put("mess", false);
		}
		return map;
	}

	@Override
	public Map<String, Object> addStand(Standard stand) {
		Map<String,Object> map = new HashMap<String,Object>();
		
        int count = mbMapper.addStand(stand);
        if(count>0){
			map.put("mess", true);
		}else{
			map.put("mess", false);
		}
		return map;
	}

	@Override
	public Map<String, Object> goeditStand(String id) {
		Map<String,Object> map = new HashMap<String,Object>();
		Standard standard=mbMapper.goeditStand(id);
		if(null!=standard){
			map.put("standard", standard);
		}
		return map;
	}

	//我的绩效分数
	@Override
	public Map<String, Object> getMyscore(String manager_id, String target_name) {
		Map<String,Object> map = new HashMap<String,Object>();
		Target targetOne=mbMapper.getMyscore(manager_id);
		System.out.println("+++++++++++++"+targetOne.getManager_name());
		targetOne.setName(targetOne.getManager_name());
		map.put("targetOne", targetOne);
		if(!"0".equals(targetOne.getProgress())){
			targetOne.setClassName("firstLevel");
			//查找第二级
			Set<Target> targetTwo=mbMapper.getjtjx(targetOne.getId());
			
			targetOne.setChildren(targetTwo);
			if(!targetTwo.isEmpty()){	
				for(Target ta:targetTwo){
					ta.setName(ta.getTarget_name());
					ta.setClassName("secondLevel");
					//查找第三级
					Set<Target> targetThree = mbMapper.getzxjtjx(ta.getId());
					if(!targetThree.isEmpty()){
						ta.setChildren(targetThree);
						for(Target three:targetThree){
							three.setName(three.getTarget_name());
							three.setClassName("thirdLevel");
							//查找第四级
							Set<Target> targetFour = mbMapper.getzxjtjx(three.getId());
							if(!targetFour.isEmpty()){
								three.setChildren(targetFour);
								for(Target four:targetFour){
									four.setName(four.getTarget_name());
									four.setClassName("fourthLevel");
								}
							}
						}
						
					}
				}
				
			}
			map.put("myscore", targetOne);
		}
		return map;
	}
    //我负责的项目
	@Override
	public List<Target> getfuzexm(String manager_id) {
		List<Target> target =mbMapper.getfuzexm(manager_id);
		return target;
	}
	
	//下属绩效分数表

	@Override
	public List<UsersEntity> getxsjxf(String user_id) {
		List<UsersEntity> xsjxf =mbMapper.getxsjxf(user_id);
		return xsjxf;
	}

	//部门绩效分数表
	@Override
	public List<UsersEntity> getbmjxf(String user_id) {
		List<UsersEntity> bmjxf =mbMapper.getbmjxf(user_id);
		return bmjxf;
	}
	
	//全校绩效分数表
	@Override
	public List<UsersEntity> getqxjxf() {
		List<UsersEntity> qxjxf =mbMapper.getqxjxf();
		return qxjxf;
	}
	
	//部门本月提升
	@Override
	public List<UsersEntity> getbmbyts(String user_id) {
		/*SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        String mon = format.format(m);*/
		String mon="2019-03-19";
		 List<UsersEntity> bmbyts=mbMapper.getbmbyts(user_id, mon);
		return bmbyts;
	}

//	@Override
//	public Map<String, Object> getjtjx(String manager_id) {
//		List<Target> target =mbMapper.getfuzexm(manager_id);
//		Map<String,Object> map = new HashMap<String,Object>();
//		List<Target> targe= new ArrayList<Target>();
//		for(Target target2 : target){
//			        String id = target2.getId();//直接操作Example对象
//			        System.out.println("ID"+id);
//		         //查出传过来id为targetid的项目详情
//				Target targetOne=mbMapper.getjtjx(target2.getId());
//				//Map<String,Object> map = new HashMap<String,Object>();
//				//map.put("targetOne", targetOne);
//				//根据项目等级进行判断
//					targetOne.setClassName("firstLevel");
//					//查找第二级
//					Set<Target> targetTwo=mbMapper.getzxjtjx(target2.getId());
//					targetOne.setChildren(targetTwo);
//					if(!targetTwo.isEmpty()){	
//						for(Target ta:targetTwo){
//							ta.setClassName("secondLevel");
//							//查找第三级
//							Set<Target> targetThree = mbMapper.getzxjtjx(ta.getId());
//							if(!targetThree.isEmpty()){
//								ta.setChildren(targetThree);
//								for(Target three:targetThree){
//									three.setClassName("thirdLevel");
//									//查找第四级
//									Set<Target> targetFour = mbMapper.getzxjtjx(three.getId());
//									if(!targetFour.isEmpty()){
//										three.setChildren(targetFour);
//										for(Target four:targetFour){
//											four.setClassName("fourthLevel");
//										}
//									}
//								}
//								
//							}
//						}
//						
//					}
//					targe.add(targetOne);	
//		} 
//					map.put("projectTree", targe);
//				
//		return map;
//	}

	@Override
	public List<UsersEntity> getxsmd(String user_id) {
		
		List<UsersEntity> xsmd =mbMapper.getxsmd(user_id);
		return xsmd;
	}

	@Override
	public List<UsersEntity> getjkryxx(String user_id) {
		Map<String,Object> map = new HashMap<String,Object>();
		List<UsersEntity> jkryxx= new ArrayList<UsersEntity>();
//		
//		String[] strarr = user_id.split(","); 
//		for (int i = 0; i < strarr.length; i++) {
			List<UsersEntity> user=mbMapper.getjkryxx(user_id);
//			jkryxx.add(user);
//        }
		 
		return user;
	}

	@Override
	public List<UsersEntity> getjkmd(String dj,String user_id) {
		List<UsersEntity> jkmd=mbMapper.getjkmd(dj,user_id);
		return jkmd;
	}

	@Override
	public Map<String, Object> getcunfang(String user_id,String mon_id) {
		Map<String,Object> map = new HashMap<String,Object>();
		String[] strarr = user_id.split(","); 
		for (int i = 0; i < strarr.length; i++) {
			int cxjk=mbMapper.getcxjk(strarr[i], mon_id);
			if(cxjk==0){
				int count=mbMapper.getcunfang(strarr[i],mon_id);
				if(count !=0){
					map.put("mess",true);
				}
			}
			else{
				map.put("mess", false);
			}
	
        }
		
		return map;
	}
	
	@Override
	public Map<String, Object> getshanchu(String user_id,String mon_id) {
		Map<String,Object> map = new HashMap<String,Object>();
		String[] strarr = user_id.split(","); 
		for (int i = 0; i < strarr.length; i++) {
			int cxjk=mbMapper.getcxjk(strarr[i],mon_id);
			if(cxjk==1){
				int count=mbMapper.getshanchu(strarr[i],mon_id);
				if(count !=0){
					map.put("mess",true);
				}
			}
			else{
				map.put("mess", false);
			}
	
        }
		
	return map;
	
	}

	@Override
	public Map<String, Object> sucha(String name) {
		Map<String,Object> map = new HashMap<String,Object>();
		List<StandardType> standardTypes =mbMapper.standtypelist(name);
		if(!standardTypes.isEmpty()){
			for(StandardType s:standardTypes){
				List<Standard> childrenstand= mbMapper.standlist(s.getId(), null);
				s.setChildrenstand(childrenstand);
			}
			map.put("shju", standardTypes);
	}
		return map;
	}

	@Override
	public Map<String, Object> getjtjx(String manager_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getxsmdsc(String user_id,String name) {
		Map<String,Object> map = new HashMap<String,Object>();
		List<UsersEntity> xsmd =mbMapper.getxsmdsc(user_id,name);
		map.put("md", xsmd);
		return map;
	}

	@Override
	public Map<String, Object> wxtargetlist(String userid, String dj) {
		Map<String,Object> map = new HashMap<String,Object>();
		List<List<Target>> list = new ArrayList<List<Target>>();
		//第一级
		if(dj.equals("1")){
		List<Target> targetlist1 = mbMapper.targetlist(userid,"1");
		System.out.println(targetlist1);
		if(targetlist1.isEmpty()){
			return null;
		}
		
		for(Target ta:targetlist1){
			ta.setUserEntity(mbMapper.getparticipant(ta.getId()));
		}
		list.add(targetlist1);
		}
		//第二级
		if(dj.equals("2")){
		List<Target> targetlist2=mbMapper.targetlist2(userid);
		for(Target ta:targetlist2){
			ta.setUserEntity(mbMapper.getparticipant(ta.getId()));
		}
		list.add(targetlist2);
		}
		//第三级
		if(dj.equals("3")){
		List<Target> targetlist3=mbMapper.targetlist3(userid);
		for(Target ta:targetlist3){
			ta.setUserEntity(mbMapper.getparticipant(ta.getId()));
		}
		list.add(targetlist3);
		}
		//第四级
		if(dj.equals("4")){
		List<Target> targetlist4=mbMapper.targetlist4(userid);
		for(Target ta:targetlist4){
			ta.setUserEntity(mbMapper.getparticipant(ta.getId()));
		}
		list.add(targetlist4);
		}
//		list.add(targetlist1);
//		list.add(targetlist2);
//		list.add(targetlist3);
//		list.add(targetlist4);
		map.put("list", list);
		return map;
	}

	@Override
	public Map<String, Object> wxprojectTree(String targetid) {
		Map<String,Object> map = new HashMap<String,Object>();
		Target targetOne=mbMapper.targetDetails(targetid);
		if("1".equals(targetOne.getTarget_dj())){
		List<Target> targetlist=mbMapper.wxtargetlist(targetid);
		if(!targetlist.isEmpty()){
				for(Target s:targetlist){
					Set<Target> children = mbMapper.targetTwo(targetid);
					if(children.isEmpty()){
						continue;
					}else{
						for(Target s1:children){
							Set<Target> children1 = mbMapper.targetTwo(s1.getId());
							if(children1.isEmpty()){
								continue;
							}else{
								for(Target s2:children1){
									Set<Target> children2 = mbMapper.targetTwo(s2.getId());
									if(children2.isEmpty()){
										continue;
									}else{
										for(Target s3:children2){
											Set<Target> children3 = mbMapper.targetTwo(s3.getId());
											if(children3.isEmpty()){
												continue;
											}else{
												//继续
											}
											
											s3.setChildren(children3);
										}
									}
									
									s2.setChildren(children2);
								}
							}
							
							s1.setChildren(children1);
						}
						
					}
					
					s.setChildren(children);
				}
						
		}
		map.put("standardlist", targetlist);
		}
		if(!"1".equals(targetOne.getTarget_dj())){
			List<Target> targetlist =mbMapper.wxtargetparentid1(targetOne.getParent_id(),targetOne.getTarget_dj());
			if(!targetlist.isEmpty()){
				for(Target s:targetlist){
					Set<Target> children=mbMapper.targetTwo1(targetOne.getId(),targetOne.getTarget_dj());
					if(children.isEmpty()){
						continue;
					}else{
						for(Target s1:children){
							//Set<Target> children1 = mbMapper.targetTwo(s1.getId());
							Set<Target> children1= new HashSet<Target>();
							if(targetOne.getTarget_dj().equals("2")){
								 children1 = mbMapper.targetTwo(s1.getId());
								}else{
								 children1 = mbMapper.targetTwo2(targetOne.getId(),targetOne.getTarget_dj());	
								}
							if(children1.isEmpty()){
								continue;
							}else{
								for(Target s2:children1){
									//Set<Target> children2 = mbMapper.targetTwo(s2.getId());
									Set<Target> children2= new HashSet<Target>();
									//查找第四级
									if(targetOne.getTarget_dj().equals("2") || targetOne.getTarget_dj().equals("3")){
										children2=mbMapper.targetTwo(s2.getId());
									}else{
										children2=mbMapper.targetTwo3(targetOne.getId(),targetOne.getTarget_dj());
									}
									if(children2.isEmpty()){
										continue;
									}else{
//										for(Target s3:children2){
//											Set<Target> children3 = mbMapper.targetTwo(s3.getId());
//											if(children3.isEmpty()){
//												continue;
//											}else{
//												//继续
//											}
//											
//											s3.setChildren(children3);
//										}
									}
									
									s2.setChildren(children2);
								}
							}
							
							s1.setChildren(children1);
						}
						
					}
					
					s.setChildren(children);
				}
						
		}
		map.put("standardlist", targetlist);
		}
		//Integer minid=mbMapper.minstandid();
		
		//List<Standard> standlist=mbMapper.standlist(String.valueOf(minid),null);
		//map.put("standardlist", targetlist);
		//map.put("standlist", standlist);
		return map;
		
	}

	@Override
	public Map<String, Object> wxgzxm(String user_id) {
		Map<String,Object> map = new HashMap<String,Object>();
		List list=new ArrayList();
		List<Target> targets=mbMapper.guanzhuxinxi(user_id);
		for (Target target : targets) {
			Target target2=mbMapper.wxtar(target.getId());
			target2.setUserEntity(mbMapper.getparticipant(target.getId()));	
			list.add(target2);
		}
		map.put("target", list);
		return map;
	}
	//我的绩效分数
		@Override
		public Map<String, Object> getwxMyscore(String manager_id, String target_name) {

			Map<String,Object> map = new HashMap<String,Object>();
			List<Target> targetlist= new ArrayList<Target>();
			Target list=mbMapper.getMyscore(manager_id);
			list.setTarget_name(list.getManager_name());
			targetlist.add(list);
			if(!targetlist.isEmpty()){
					for(Target s:targetlist){
						Set<Target> children=mbMapper.getjtjx(list.getId());
						if(children.isEmpty()){
							continue;
						}else{
							for(Target s1:children){
								Set<Target> children1 = mbMapper.getzxjtjx(s1.getId());
								if(children1.isEmpty()){
									continue;
								}else{
									for(Target s2:children1){
										Set<Target> children2 = mbMapper.getzxjtjx(s2.getId());
										if(children2.isEmpty()){
											continue;
										}else{
											for(Target s3:children2){
												Set<Target> children3 = mbMapper.getzxjtjx(s3.getId());
												if(children3.isEmpty()){
													continue;
												}else{
													//继续
												}
												
												s3.setChildren(children3);
											}
										}
										
										s2.setChildren(children2);
									}
								}
								
								s1.setChildren(children1);
							}
							
						}
						
						s.setChildren(children);
					}
					
		}
			map.put("myscore", targetlist);
			return map;
		}

		//查询站内信
		@Override
		public Map<String, Object> getmess(String user_id) {
			Map<String,Object> map = new HashMap<String,Object>();
			List<Mess> messes=mbMapper.getmess(user_id);
			map.put("mess", messes);
			return map;
		}
		//更改站内信状态
		@Override
		public Map<String, Object> upmess(String mess_id) {
			Map<String, Object> map =new HashMap<String, Object>();
			System.out.println("+++++++++"+mess_id);
			String[] strarr = mess_id.split(","); 
			for (int i = 0; i < strarr.length; i++) {
			int num=mbMapper.upmess(strarr[i]);
			if(num==1){
				map.put("mess", true);
			}
			else {
				map.put("mess", false);
			}
			}
			return map;
		}

		@Override
		public Map<String, Object> demess(String mess_id) {
			Map<String, Object> map=new HashMap<String, Object>();
			String[] strarr = mess_id.split(","); 
			for (int i = 0; i < strarr.length; i++) {
			int num=mbMapper.demess(strarr[i]);
			if(num==1){
				map.put("mess", true);
			}
			else {
				map.put("mess", false);
			}
			}
			return map;
		};
}
