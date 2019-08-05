package yd.wxzg.entity;

public class MessageResult {
private Integer errcode;
private String errmsg;
private String msgid;
public int getErrcode() {
	return errcode;
}
public void setErrcode(Integer errcode) {
	this.errcode = errcode;
}
public String getErrmsg() {
	return errmsg;
}
public void setErrmsg(String errmsg) {
	this.errmsg = errmsg;
}
public String getMsgid() {
	return msgid;
}
public void setMsgid(String msgid) {
	this.msgid = msgid;
}
@Override
public String toString() {
	return "MessageResult [errcode=" + errcode + ", errmsg=" + errmsg
			+ ", msgid=" + msgid + "]";
}

}
