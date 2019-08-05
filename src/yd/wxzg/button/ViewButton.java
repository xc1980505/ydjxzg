package yd.wxzg.button;

import java.util.List;
//按钮视图
public class ViewButton {
	private String type;
	private String name;
	private String url;
	private List<ViewButton> buttonlist; 
	public String getType() {
		return type;
	}
 
	public List<ViewButton> getButtonlist() {
		return buttonlist;
	}

	public void setButtonlist(List<ViewButton> buttonlist) {
		this.buttonlist = buttonlist;
	}

	public void setType(String type) {
		this.type = type;
	}
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public String getUrl() {
		return url;
	}
 
	public void setUrl(String url) {
		this.url = url;
	}
 
}

