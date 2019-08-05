package yd.wxzg.templateMessage.util;

import java.util.Map;

import net.sf.json.JSONObject;
public class WxTemplate {
	private String template_id;//模板ID
    private String touser;//目标客户
    private String url;//用户点击模板信息的跳转页面
    private String topcolor;//字体颜色
    private Map<String,TemplateData> data;//模板里的数据
	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTopcolor() {
		return topcolor;
	}
	public void setTopcolor(String topcolor) {
		this.topcolor = "blue";
	}
	public Map<String, TemplateData> getData() {
		return data;
	}
	public void setData(Map<String, TemplateData> data) {
		this.data = data;
	}
	public WxTemplate(String template_id, String touser, String url,
			String topcolor, Map<String, TemplateData> data) {
		super();
		this.template_id = template_id;
		this.touser = touser;
		this.url = url;
		this.topcolor = topcolor;
		this.data = data;
	}
	public WxTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}

}
