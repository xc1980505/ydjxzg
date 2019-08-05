package yd.slgl.entity;

public class DeclareEntity {
private String id;
private String result;
private String comment;
private String manager_id;
private String manager_name;
private String importancedj;
private String actual_funds;
private String funds;
private String name;
private String report_desc;
private String declare_time;
private String target_id;
private String progress;


public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getTarget_id() {
	return target_id;
}
public String getProgress() {
	return progress;
}
public String getDeclare_time() {
	return declare_time;
}
public void setDeclare_time(String declare_time) {
	this.declare_time = declare_time;
}
public String getPropress() {
	return progress;
}
public void setProgress(String progress) {
	this.progress = progress;
}
public String gress() {
	return target_id;
}
public void setTarget_id(String target_id) {
	this.target_id = target_id;
}
public String getManager_name() {
	return manager_name;
}
public void setManager_name(String manager_name) {
	this.manager_name = manager_name;
}
public String getFunds() {
	return funds;
}
public void setFunds(String funds) {
	this.funds = funds;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getResult() {
	return result;
}
public void setResult(String result) {
	this.result = result;
}
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}
public String getManager_id() {
	return manager_id;
}
public void setManager_id(String manager_id) {
	this.manager_id = manager_id;
}
public String getImportancedj() {
	return importancedj;
}
public void setImportancedj(String importancedj) {
	this.importancedj = importancedj;
}
public String getActual_funds() {
	return actual_funds;
}
public void setActual_funds(String actual_funds) {
	this.actual_funds = actual_funds;
}
public String getReport_desc() {
	return report_desc;
}
public void setReport_desc(String report_desc) {
	this.report_desc = report_desc;
}
public DeclareEntity(String id, String result, String comment,
		String manager_id, String manager_name, String importancedj,
		String actual_funds, String funds, String report_desc,
		String declare_time, String target_id, String progress) {
	super();
	this.id = id;
	this.result = result;
	this.comment = comment;
	this.manager_id = manager_id;
	this.manager_name = manager_name;
	this.importancedj = importancedj;
	this.actual_funds = actual_funds;
	this.funds = funds;
	this.report_desc = report_desc;
	this.declare_time = declare_time;
	this.target_id = target_id;
	this.progress = progress;
}
public DeclareEntity() {
	super();
	// TODO Auto-generated constructor stub
}

}
