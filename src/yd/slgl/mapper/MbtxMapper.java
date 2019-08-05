package yd.slgl.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import yd.slgl.entity.Attachment;
import yd.slgl.entity.DeclareEntity;
import yd.slgl.entity.Khzb;
import yd.slgl.entity.Mess;
import yd.slgl.entity.Monitor;
import yd.slgl.entity.ReportEntity;
import yd.slgl.entity.Standard;
import yd.slgl.entity.StandardType;
import yd.slgl.entity.Target;
import yd.slgl.entity.UsersEntity;

@Repository
public interface MbtxMapper {

	List<Target> targetlist(@Param("user_id")String userid,@Param("target_category")String target_category);
	List<Target> targetlist1(@Param("user_id")String userid,@Param("target_category")String target_category);
	List<Target> targetlist12(@Param("user_id")String userid,@Param("target_category")String target_category);
	List<Target> targetlist13(@Param("user_id")String userid,@Param("target_category")String target_category);

	Set<UsersEntity> getparticipant(@Param("targetid")String id);

	List<Target> targetlist2(@Param("user_id")String userid);

	List<Target> targetlist3(@Param("user_id")String userid);

	List<Target> targetlist4(@Param("user_id")String userid);

	List<Khzb> getkhzb();

	List<UsersEntity> userlist();

	Integer addtarget(@Param("target")Target target);

	Integer addcyr(@Param("user_id")String user_id,@Param("target_id")String target_id);
	Integer addxjcyr(@Param("user_id")String user_id);
	
	Target targetDetails(@Param("target_id")String targetid);

	List<Target> subprojects(@Param("target_id")String targetid);

	List<ReportEntity> getreportlist(@Param("target_id")String id);

	Set<Attachment> getAttachment(@Param("id")String id);

	int addReport(@Param("report")ReportEntity report);

	List<DeclareEntity> declareList(@Param("targetid")String targetid, @Param("user_id")String user_id);

	Integer updateDeclare(@Param("declare")DeclareEntity declare);

	Integer updateTargetCheck(@Param("target_id")String target_id);

	Integer Declarefalse(@Param("declare")DeclareEntity declare,@Param("progress") String progress);

	Integer TargetCheckfalse(@Param("target_id")String target_id,@Param("progress") String progress);

	Integer targetFollow(@Param("follow")String follow,@Param("target_id")String targetid);
	
	int insertfollow(@Param("follow_id")String follow,@Param("target_id")String targetid);
	int deletfollow(@Param("follow_id")String follow,@Param("target_id")String targetid);

	int addDeclare(@Param("target")Target target,@Param("report_desc") String report_desc);

	List<Target> targetResult(@Param("target_id")String targetid);

	String declareComment(@Param("declareid")String declareid);

	int updateTargetcheck(@Param("progress")String propress, @Param("target_id")String id);

	int insertcheckRegression(@Param("declare") DeclareEntity declare);

	Set<Target> targetTwo(@Param("target_id")String targetid);
	
	Set<Target> targetTwo1(@Param("target_id")String targetid,@Param("target_dj") String target_dj);
	
	Set<Target> targetTwo2(@Param("target_id")String targetid,@Param("target_dj") String target_dj);
	
	Set<Target> targetTwo3(@Param("target_id")String targetid,@Param("target_dj") String target_dj);
	
	
	Target targetThree(@Param("target_id")String id);

	Target targetparentid1(@Param("parent_id")String parent_id,@Param("target_dj") String target_dj);
	
    List<Target> wxtargetparentid1(@Param("parent_id")String parent_id,@Param("target_dj") String target_dj);

	int editTarget(@Param("target")Target target);

	int deleteParticipant(@Param("target_id")String id);

	void addParticipant(@Param("target_id")String id,@Param("user_id") String user_id);

	int decomposeTarget(@Param("target")Target target);

	int brotherCount(@Param("parent_id")String parent_id);

	int deleteTarget(@Param("target_id")String targetid);

	int deletecyr(@Param("target_id")String targetid);

	int deleteChildren(@Param("target_id")String targetid);

	int deleteChildrenCyr(@Param("target_id")String targetid);

	int deleteChildrenCyr2(@Param("target_id")String targetid);

	int deleteChildren2(@Param("target_id")String targetid);

	int deleteChildrenCyr3(@Param("target_id")String targetid);

	int deleteChildren3(@Param("target_id")String targetid);

	Target targetDetails1(@Param("target_id")String targetid);

	String[] getids(@Param("target_id")String targetid);

	List<StandardType> standardlist();
	
	Integer typename(@Param("name")String name,@Param("parent_id")String parent_id);

	List<StandardType> getChildrenStandard(@Param("standard_id")String id);

	int addStandardType(@Param("standardtype")StandardType standardtype);

	int editStandardType(@Param("id")String id,@Param("name") String name);

	int deleteStand(@Param("id")String id);

	int deleteStandType(@Param("id")String id);

	Integer minstandid();
	
	Integer StandCount();
	
	Standard seluptime();

	List<Standard> standlist(@Param("id")String minid,@Param("name") String name);

	int deleteStandard(@Param("id")String id);

	int editStand(@Param("stand")Standard stand);

	int addStand(@Param("stand")Standard stand);

	Standard goeditStand(@Param("id")String id);

	int updateTar(@Param("report")ReportEntity report);

	Integer parentProgress(@Param("parent_id")String parent_id);

	String getparentid(@Param("target_id")String parentid);

	Integer updateProgress(@Param("target_id")String parentid,@Param("progress") int parentprogress);

	String getparentid2(@Param("target_id")String target_id);

	String getparentid3(@Param("target_id")String target_id);

	String getprogress(@Param("target_id")String target_id);

	int updateCheck(@Param("target_id")String target_id);

	Integer updateProgress1(@Param("target_id")String parentid,@Param("progress") int parentprogress);

	int childrenCount(@Param("parent_id")String parentid);

	int childrenCountSuccess(@Param("parent_id")String parentid);

	String getmaxdeclareid(@Param("target_id")String targetid);

	int updateTargetCh(@Param("target_id")String target);

	int updateTargetcheck1(@Param("progress")String propress,@Param("id") String id);

	int updateTargetcheck2(@Param("target_id")String parentid);
	
	/*
	 * 诊改绩效考核
	 * */
	//我的绩效分数
	Target getMyscore(@Param("manager_id")String manager_id);
	//子项绩效分数
	Set<Target> getjtjx(@Param("id")String id);
	Set<Target> getzxjtjx(@Param("parent_id")String parent_id);
	//负责项目
	List<Target> getfuzexm(@Param("manager_id")String manager_id);
	//下属绩效分数表
	List<UsersEntity> getxsjxf(@Param("user_id")String user_id);
	//部门绩效分数表
    List<UsersEntity> getbmjxf(@Param("user_id")String user_id);
    //全校绩效分数表
    List<UsersEntity> getqxjxf();
    //部门本月提升排行
    List<UsersEntity> getbmbyts(@Param("user_id")String user_id,@Param("mon")String mon);
    //下属名单
    List<UsersEntity> getxsmd(@Param("user_id")String user_id);
    List<UsersEntity> getxsmdsc(@Param("user_id")String user_id,@Param("name")String name);
    //监控人员名单
    List<UsersEntity> getjkmd(@Param("user_id")String user_id,@Param("dj")String dj);
    //监控人员信息
    List<UsersEntity> getjkryxx(@Param("user_id")String user_id);
    Integer getcxjk(@Param("user_id")String user_id,@Param("mon_id")String mon_id);
    
    UsersEntity getcxdj(@Param("user_id")String user_id);
    Integer getcunfang(@Param("user_id")String user_id,@Param("mon_id")String mon_id);
    Integer getshanchu(@Param("user_id")String user_id,@Param("mon_id")String mon_id);
    
    List<StandardType> standtypelist(@Param("name")String name);
    
    int upparname(@Param("parent_id")String parent_id,@Param("parent_name")String parent_name);
    
    //微信
    UsersEntity getwxOpenid(@Param("user_id")String user_id);
    int insertmess(@Param("openid")String openid,@Param("templateid")String templateid,@Param("content")String content,@Param("endTime")String endTime,@Param("url")String url);
    List<UsersEntity> getcanyuren(@Param("targetid")String id);
//    UsersEntity getwxuser(@Param("wx_id")String openid);
    List<Target> wxtargetlist(@Param("target_id")String target_id);
    Target wxtar(@Param("target_id")String target_id);
    //我的关注
   List<Target> guanzhuxinxi(@Param("user_id")String user_id);
   
   //站内信
   int insertinform(@Param("user_id")String user_id,@Param("content")String content);
   UsersEntity getxinxi(@Param("user_id")String user_id);
   List<Mess> getmess(@Param("user_id")String user_id);
   int upmess(@Param("mess_id")String mess_id);
   int demess(@Param("mess_id")String mess_id);
   
   //微信小程序
   
   List<Target> xcxtargetlist(@Param("user_id")String userid);
   //标准数量
   
   //查询绩效
   Target selcjx(@Param("user_id")String user_id);
   //负责的项目数
   int selcfz(@Param("user_id")String user_id);
   //完成的项目数
   int selcwc(@Param("user_id")String user_id);
   //涉及的项目数
   int selcsj(@Param("user_id")String user_id);
   //负责项目列表
   List<Target> xcxtargets(@Param("user_id")String user_id);
   //根据姓名、工号、手机号查询
   List<UsersEntity> getUserByxgs(@Param("user_id")String user_id);
   
   
   
   
   
   
}
