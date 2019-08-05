package yd.slgl.entity;

public class Mess {

	private String recId;//接收者id
	private String mess_id;//信id
	private String message;//站内信内容
	private String create_date;//发送日期
	private String status;//状态
	public String getRecId() {
		return recId;
	}
	public void setRecId(String recId) {
		this.recId = recId;
	}
	public String getMess_id() {
		return mess_id;
	}
	public void setMess_id(String mess_id) {
		this.mess_id = mess_id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
