package yd.htgl.entity;

import java.util.List;

public class Major {
	
	private String major_name;
	private String major_code;
	private List<TheClass> classes;
	public List<TheClass> getClasses() {
		return classes;
	}
	public void setClasses(List<TheClass> classes) {
		this.classes = classes;
	}
	public String getMajor_name() {
		return major_name;
	}
	public void setMajor_name(String major_name) {
		this.major_name = major_name;
	}
	public String getMajor_code() {
		return major_code;
	}
	public void setMajor_code(String major_code) {
		this.major_code = major_code;
	}
	
	

}
