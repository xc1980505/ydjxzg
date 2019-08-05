package yd.jxzg.common;

public class Title {
private String title;
private String param1;
private String param2;
private String type;
private Boolean table;
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getParam1() {
	return param1;
}
public void setParam1(String param1) {
	this.param1 = param1;
}
public String getParam2() {
	return param2;
}
public void setParam2(String param2) {
	this.param2 = param2;
}
public Title(String title, String param1, String param2) {
	super();
	this.title = title;
	this.param1 = param1;
	this.param2 = param2;
}
public Title() {
	super();
	// TODO Auto-generated constructor stub
}
public Title(String title, String param1) {
	super();
	this.title = title;
	this.param1 = param1;
}
public Boolean getTable() {
	return table;
}
public void setTable(Boolean table) {
	this.table = table;
}
public Title(String title, String param1, String param2, Boolean table) {
	super();
	this.title = title;
	this.param1 = param1;
	this.param2 = param2;
	this.table = table;
}

public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public Title(String title, String param1, String param2, String type) {
	super();
	this.title = title;
	this.param1 = param1;
	this.param2 = param2;
	this.type = type;
}

}
