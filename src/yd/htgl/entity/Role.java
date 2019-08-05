package yd.htgl.entity;

import java.util.List;
import java.util.Set;

public class Role {
	
	private Integer role_id;//组织id
	private String role_code;
	private String role_name;//组织名
	private String remark;
	private Integer type;
	private List<Permis> permis;
	private Set<Role> roles;
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public List<Permis> getPermis() {
		return permis;
	}
	public void setPermis(List<Permis> permis) {
		this.permis = permis;
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getRole_code() {
		return role_code;
	}
	public void setRole_code(String role_code) {
		this.role_code = role_code;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	

}
