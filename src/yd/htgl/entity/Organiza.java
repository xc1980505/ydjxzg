package yd.htgl.entity;

import java.util.Set;



public class Organiza {
	
	private String id;//部门ID
	private String dept_name;//部门名称
	private String parent_id;//父部门ID
	private String level_num;
	private String head;//部门负责人
	private Set<Organiza> children;
	private Set<UsersEntity> bumency;
	
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public Set<UsersEntity> getBumency() {
		return bumency;
	}
	public void setBumency(Set<UsersEntity> bumency) {
		this.bumency = bumency;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	public String getLevel_num() {
		return level_num;
	}
	public void setLevel_num(String level_num) {
		this.level_num = level_num;
	}
	public Set<Organiza> getChildren() {
		return children;
	}
	public void setChildren(Set<Organiza> children) {
		this.children = children;
	}

}
