package yd.wxzg.entity;

public class TemplateMessageEntity {
private int id;
private String openid;
private String templateid;
private String content;
private String url;
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}

private int frequency;
private int status;
private String endTime;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getOpenid() {
	return openid;
}
public void setOpenid(String openid) {
	this.openid = openid;
}
public String getTemplateid() {
	return templateid;
}
public void setTemplateid(String templateid) {
	this.templateid = templateid;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public int getFrequency() {
	return frequency;
}
public void setFrequency(int frequency) {
	this.frequency = frequency;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}

public String getEndTime() {
	return endTime;
}
public void setEndTime(String endTime) {
	this.endTime = endTime;
}
public TemplateMessageEntity() {
	super();
	// TODO Auto-generated constructor stub
}
public TemplateMessageEntity(String openid, String templateid, String content) {
	super();
	this.openid = openid;
	this.templateid = templateid;
	this.content = content;
}

public TemplateMessageEntity(int id, String openid, String templateid,
		String content, int frequency, int status, String endTime) {
	super();
	this.id = id;
	this.openid = openid;
	this.templateid = templateid;
	this.content = content;
	this.frequency = frequency;
	this.status = status;
	this.endTime = endTime;
}

}
