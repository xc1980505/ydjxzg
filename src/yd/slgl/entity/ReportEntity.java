package yd.slgl.entity;

import java.util.Set;

public class ReportEntity {
private String id;
private String report_name;
private String importancedj;
private String actual_funds;
private String report_desc;
private String target_id;
private String manager_id;
private String report_time;
private String progress;
private Set<Attachment> attachment;


public String getProgress() {
	return progress;
}
public void setProgress(String progress) {
	this.progress = progress;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public Set<Attachment> getAttachment() {
	return attachment;
}
public void setAttachment(Set<Attachment> attachment) {
	this.attachment = attachment;
}
public String getReport_name() {
	return report_name;
}
public void setReport_name(String report_name) {
	this.report_name = report_name;
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
public String getTarget_id() {
	return target_id;
}
public void setTarget_id(String target_id) {
	this.target_id = target_id;
}
public String getManager_id() {
	return manager_id;
}
public void setManager_id(String manager_id) {
	this.manager_id = manager_id;
}
public String getReport_time() {
	return report_time;
}
public void setReport_time(String report_time) {
	this.report_time = report_time;
}


}
