package yd.wxzg.templateMessage.util;

public class TemplateData {
private String value;//模板值
private String color;//模板颜色
public String getValue() {
	return value;
}
public void setValue(String value) {
	this.value = value;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public TemplateData(String value, String color) {
	super();
	this.value = value;
	this.color = color;
}
public TemplateData() {
	super();
	// TODO Auto-generated constructor stub
}

}
