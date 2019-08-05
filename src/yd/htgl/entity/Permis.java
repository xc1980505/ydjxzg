package yd.htgl.entity;

import java.util.List;

public class Permis {
	
	private Integer permis_id;//权限id
	private String permis_name;//权限名
	private String permis_icon;//菜单
	private String permis_code;
	private String remark;
	private Integer permis_order;
	private Integer parent_permis;
	private List<Permis> permis;
	public List<Permis> getPermis() {
		return permis;
	}
	public void setPermis(List<Permis> permis) {
		this.permis = permis;
	}
	public Integer getPermis_id() {
		return permis_id;
	}
	public void setPermis_id(Integer permis_id) {
		this.permis_id = permis_id;
	}
	public String getPermis_name() {
		return permis_name;
	}
	public void setPermis_name(String permis_name) {
		this.permis_name = permis_name;
	}
	
	
	public String getPermis_icon() {
		return permis_icon;
	}
	public void setPermis_icon(String permis_icon) {
		this.permis_icon = permis_icon;
	}
	public String getPermis_code() {
		return permis_code;
	}
	public void setPermis_code(String permis_code) {
		this.permis_code = permis_code;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getPermis_order() {
		return permis_order;
	}
	public void setPermis_order(Integer permis_order) {
		this.permis_order = permis_order;
	}
	public Integer getParent_permis() {
		return parent_permis;
	}
	public void setParent_permis(Integer parent_permis) {
		this.parent_permis = parent_permis;
	}
	

}
