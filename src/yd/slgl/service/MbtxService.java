package yd.slgl.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import yd.slgl.entity.DeclareEntity;
import yd.slgl.entity.Khzb;
import yd.slgl.entity.Mess;
import yd.slgl.entity.ReportEntity;
import yd.slgl.entity.Standard;
import yd.slgl.entity.StandardType;
import yd.slgl.entity.Target;
import yd.slgl.entity.UsersEntity;


public interface MbtxService {

	Map<String, Object> targetlist(String userid, String dj);
	Map<String, Object> targetlist1(String userid, String dj);
	
	Map<String, Object> wxtargetlist(String userid, String dj);
	

	List<Khzb> getkhzb();

	List<UsersEntity> userlist();

	Map<String, Object> addtarget(Target target,String[] cyr);

	Map<String, Object> targetDetails(String targetid, String user_id);

	Map<String, Object> addReport(ReportEntity report);

	Map<String, Object> checktarget(DeclareEntity declare, String progress);

	Map<String, Object> targetFollow(String follow, String targetid,String follow_id);

	Map<String, Object> commitDeclare(String targetid, String report_desc);

	Map<String, Object> goRegression(String targetid, String declareid);

	Map<String, Object> checkRegression(List<DeclareEntity> declareEntity);

	Map<String, Object> projectTree(String targetid);

	Map<String, Object> goeditTarget(String targetid);

	Map<String, Object> editTarget(Target target, String[] userlist);

	Map<String, Object> decomposeTarget(Target target, String[] userlist);

	Map<String, Object> deleteTarget(String targetid,String targetdj);

	Map<String, Object> standardlist();

	Map<String, Object> addStandardType(StandardType standardtype);

	Map<String, Object> editStandardType(StandardType standardtype);

	Map<String, Object> deleteStandardType(String id);

	Map<String, Object> standardByType(String id, String name);

	Map<String, Object> deleteStand(String id);

	Map<String, Object> editStand(Standard stand);

	Map<String, Object> addStand(Standard stand);

	Map<String, Object> goeditStand(String id);
	
	/*
     *绩效考核模块
     */
	Map<String, Object> getMyscore(String manager_id,String target_name);
	Map<String, Object> getjtjx(String manager_id);
	List<Target> getfuzexm(String manager_id);
	List<UsersEntity> getxsjxf(String user_id);
	List<UsersEntity> getbmjxf(String user_id);
	List<UsersEntity> getqxjxf();
	List<UsersEntity> getbmbyts(String user_id);
	List<UsersEntity> getxsmd(String user_id);
	List<UsersEntity> getjkmd(String dj,String user_id);
	List<UsersEntity> getjkryxx(String user_id);
	Map<String, Object> getcunfang(String user_id,String mon_id);
	Map<String, Object> getshanchu(String user_id,String mon_id);
	Map<String, Object> getmess(String user_id);
	Map<String, Object> upmess(String mess_id);
	Map<String, Object> demess(String mess_id);
	
	Map<String, Object> sucha(String name);
	Map<String,Object> getxsmdsc(String user_id,String name);
	
	Map<String, Object> wxprojectTree(String targetid);
	
	Map<String,Object> wxgzxm(String user_id);

	Map<String, Object> getwxMyscore(String manager_id,String target_name);
	
}
