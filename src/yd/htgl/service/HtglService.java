package yd.htgl.service;


import java.util.Map;

import yd.htgl.entity.Organiza;
import yd.htgl.entity.Teacher;
import yd.htgl.entity.UsersEntity;


public interface HtglService {
      
	Map<String, Object> organizalist();
	Map<String, Object> addzzbm(Organiza organiza);
	
	Map<String, Object> getbumenry(String id);
	Map<String, Object> updateUser(UsersEntity usersEntity);
	Map<String, Object> editOrganiza(String id,String dept_name);
	Map<String, Object> deleteOrganiza(String id);
	Map<String, Object> deleteUser(String user_id);
	Map<String, Object> getUserlist();
	Map<String, Object> bumenlist();
	Map<String, Object> insertUser(UsersEntity usersEntity);
	//后台权限组添加
	Map<String, Object> insertZu(String role_name,String role_code,String permis_id);
	//后台权限组去修改
	Map<String, Object> getzu(String role_id);
	//后台权限组修改
	Map<String, Object> updatezu(String role_id,String role_name,String role_code,String permis_id);
	//后台权限组删除
	Map<String, Object> deletezu(String role_id);
	//后台权限查看
	Map<String, Object> selectpermis();
	//后台所有组查看
	Map<String, Object> sleroles(String role_name);
	//人员查询
	Map<String, Object> getUsers(String name);
	//用户分组
	Map<String, Object> ryfenzu(String user_id,String role_id);
	//去修改用户分组
	Map<String, Object> getUrole(String user_id);
	//修改用户分组
	Map<String, Object> updatefz(String user_id,String role_id);
	//教师列表
	Map<String, Object> getTeacher();
	//密码重置
	Map<String, Object> ResetPass(String number);
	//添加教师
	Map<String, Object> inTeacher(Teacher teacher);
	//搜索教师（教师姓名、部门）
	Map<String, Object> search(String name,String department_name);
	//删除教师
	Map<String, Object> delTeacher(String number);
}
