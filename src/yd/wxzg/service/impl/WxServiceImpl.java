package yd.wxzg.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import yd.slgl.entity.UsersEntity;
import yd.wxzg.mapper.WxMapper;
import yd.wxzg.service.WxService;
import yd.wxzg.util.DataUtils;

@Service
public class WxServiceImpl implements WxService{
@Resource
private WxMapper wxmapper;



@Override
public void addMessage() {
	String templateid="hFqpK-zlNedwhfrfJQG2Tupuzpb-9LdRnEy78cw66RI";
	String templateid2="Q-RwDL8RpHzGMhZLDAAiNkOY4HftLqN8Ko4Uzc10Rgk";
	String openid="o-1fl1GWik_xuKQ-ol4vbRzFoR-I";
	String content=DataUtils.detaileds();
	wxmapper.addWxMessage(openid, templateid2, content);
}


@Override
public void updateOpenid( String pass,String name) {
	String openid="orDQj1WDamBQVCXIsCzrJHiBdXx8";
	//wxmapper.insertOpenid(openid,pass,name);
	
}


@Override
public List<UsersEntity> selectopenid(String openid) {
	//wxmapper.getwxuser(openid);
	
	return wxmapper.getwxuser(openid);
}


@Override
public Map<String, Object> insertOpenid(String openid, String pass,String session_key,String name,String sessionid) {
	Map<String, Object> map= new HashMap<String, Object>();
	UsersEntity user=wxmapper.selectuser(name, pass);
	if(user!=null){
		if(user.getWx_openid()==null||user.getWx_openid().isEmpty()){
		int num1=wxmapper.insertOpenid(openid, session_key, sessionid, pass, name);
		if(num1 !=0){
			List<UsersEntity> uList= wxmapper.getwxuser(openid);
			map.put("userlist", uList);
			 map.put("sessionid", sessionid);
		}
		}
		else{
		   map.put("messt", "账号已绑定");
		}
	}
	else{
		map.put("messt", "账号不存在");
	}
//	List<UsersEntity> uList=null;
//	int num=wxmapper.insertOpenid(openid,session_key, pass,name,sessionid);
//	if(num !=0){
//		uList= wxmapper.getwxuser(openid);
//	}
	return map;
}


@Override
public UsersEntity getsession(String sessionid) {
	
	return wxmapper.getwxsession(sessionid);
}


@Override
public int updateSession(String openid, String sessionid,String session_key) {
	wxmapper.updateSession(sessionid, openid, session_key);
	return wxmapper.updateSession(sessionid, openid, session_key);
}

}
