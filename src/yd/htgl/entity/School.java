package yd.htgl.entity;

import java.util.List;

public class School {
	
	private String school_name;
	private List<Major> majors;
	public List<Major> getMajors() {
		return majors;
	}

	public void setMajors(List<Major> majors) {
		this.majors = majors;
	}

	public String getSchool_name() {
		return school_name;
	}

	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}
	

}
