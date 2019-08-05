package yd.htgl.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import yd.htgl.entity.*;

import java.util.List;
import java.util.Set;


@Repository
public interface HtglMapper {
	
	//查看部门机构列表
	List<Organiza> organizalist();
	//查询部门人员
	List<UsersEntity> getbumenry(@Param("id")String id);
	//查询下属部门
	Set<Organiza> getChildrenOrganiza(@Param("id")String id);
	
	//添加部门机构
	Integer addzzbm(@Param("organiza")Organiza organiza);
	//编辑部门机构
	int editOrganiza(@Param("id")String id,@Param("dept_name") String dept_name);
	//删除部门机构
	int deleteOrganiza(@Param("id")String id);
	//机构
	List<Organiza> bumenlist();
	//人员
	List<UsersEntity> getuserlist();
	//人员删除
	int deleteUser(@Param("user_id")String user_id);
	//人员编辑
	int updateUser(@Param("UsersEntity") UsersEntity usersEntity);
	Organiza selectorg(@Param("id")String id);
	UsersEntity selstatus(@Param("dept_id")String dept_id);
	//人员添加
	int insertUser(@Param("UsersEntity")UsersEntity usersEntity);
	//上级领导
	String selectldid(@Param("dept_id")String dept_id);
	
	/*
	 * 权限
	 * */
	//添加组
	int insertZu(@Param("role_name")String role_name,@Param("role_code")String role_code);
	//查询权限
	List<Permis> selectpermis();
	List<Permis> sepermi(Integer permis_id);
	List<Permis> selectpermi(Integer role_id);
	//查询组
	Role selectrole(@Param("role_name")String role_name);
	List<Role> srolebyname(@Param("role_name")String role_name);
	//查看所有组
	List<Role> slerole();
	//去修改
	Role getzu(@Param("role_id")Integer role_id);
	//修改组
	int updaterole(@Param("role_id")Integer role_id,@Param("role_name")String role_name,@Param("role_code")String role_code);
	//删除组
	int deleterole(@Param("role_id")Integer role_id);
	//组的权限
	int isertpermis(@Param("role_id")Integer role_id,@Param("permis_id")Integer permis_id);
	//删除组权限
	int deleterop(@Param("role_id")Integer role_id);
	//删除用户分组
	int deleteuserrop(@Param("role_id")Integer role_id);
	//查看所有用户分组
	Set<Role> seleuserRoles(@Param("user_id")String user_id);
	//用户分组
	int insertuserRole(@Param("role_id")Integer role_id,@Param("user_id")String user_id);
	//删除用户分组
	int deleteuserRole(@Param("user_id")String user_id); 
	//通过人员id查询组
	//Set<Role> srolebyid(String user_id);
	//通过id获取人员信息
	UsersEntity getrybyid(@Param("user_id")String user_id);
	//通过姓名获取人员信息
	List<UsersEntity> getrybyname(@Param("name")String name);
	//后台管理新SQL
	//查看所有教师
	List<Teacher> getTeacher();
//	//查询部门
//	List<Organiza> getOrgan();
	//密码重置
	int ResetPass(@Param("number")String number,@Param("password")String password);
	Teacher getPass(@Param("number")String number);
	//删除教师
	int delTeacher(@Param("number")String number);
	//修改教师
	int upTeacher(@Param("teacher")Teacher teacher);
	//添加教师
	int inTeacher(@Param("teacher")Teacher teacher);
	//所属部门
	int instOrgan(@Param("teacher_id")String teacher_id,@Param("dept_id")String dept_id);
	//添加部门负责人
	int updateOrgan(@Param("id")String id,@Param("head")String head);
	//查询上级部门的主管
	Teacher sjzg(@Param("department_id")String department_id);
	//查看部门主管
	Organiza majorzg(@Param("dept_id")String dept_id);
	//更新部门成员上级id
	int upLeader(@Param("department_id")String department_id,@Param("teacher_id")String teacher_id);
	//查重
	int checkTeacher(@Param("number")String number);
	//搜索教师、部门等
	List<Teacher> search(@Param("name")String name,@Param("department_name")String department_name);
	//
	
}
