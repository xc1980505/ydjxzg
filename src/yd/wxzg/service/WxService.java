package yd.wxzg.service;

import java.util.List;
import java.util.Map;

import yd.slgl.entity.UsersEntity;

public interface WxService {


	void addMessage();
	Map<String, Object> insertOpenid(String openid,String session_key,String pass,String name,String sessionid);
	void updateOpenid(String pass,String name);
	List<UsersEntity>  selectopenid(String openid);
	
	UsersEntity  getsession(String sessionid);
	int updateSession(String openid,String sessionid,String session_key);
}
