package yd.htgl.entity;

import java.util.Set;

//用户entity
public class UsersEntity {
private String user_id;
private String username;
private String name;
private String password;
private String gender;
private String user_status;
private String mobile;
private String email;
private String wx_num;
private String qq_num;
private String dj;
private String dept_name;
private String zw;
private Integer fenshu;
private String status;
private String dept_id;
private String sjldid;
private Set<Role> roles;




public Set<Role> getRoles() {
	return roles;
}
public void setRoles(Set<Role> roles) {
	this.roles = roles;
}
public String getSjldid() {
	return sjldid;
}
public void setSjldid(String sjldid) {
	this.sjldid = sjldid;
}
public String getDept_id() {
	return dept_id;
}
public void setDept_id(String dept_id) {
	this.dept_id = dept_id;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getDept_name() {
	return dept_name;
}
public void setDept_name(String dept_name) {
	this.dept_name = dept_name;
}
public String getZw() {
	return zw;
}
public void setZw(String zw) {
	this.zw = zw;
}
public Integer getFenshu() {
	return fenshu;
}
public void setFenshu(Integer fenshu) {
	this.fenshu = fenshu;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getUser_id() {
	return user_id;
}
public void setUser_id(String user_id) {
	this.user_id = user_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getUser_status() {
	return user_status;
}
public void setUser_status(String user_status) {
	this.user_status = user_status;
}
public String getMobile() {
	return mobile;
}
public void setMoblile(String mobile) {
	this.mobile = mobile;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getWx_num() {
	return wx_num;
}
public void setWx_num(String wx_num) {
	this.wx_num = wx_num;
}
public String getDj() {
	return dj;
}
public void setDj(String dj) {
	this.dj = dj;
}
public String getQq_num() {
	return qq_num;
}
public void setQq_num(String qq_num) {
	this.qq_num = qq_num;
}

}
