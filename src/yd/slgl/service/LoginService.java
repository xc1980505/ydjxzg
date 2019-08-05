package yd.slgl.service;

import java.util.Map;

import yd.slgl.entity.UsersEntity;

public interface LoginService {

	Map<String, Object> getLogin(String username, String password);

	Map<String, Object> getpermis(String user_id);
	Map<String, Object> getdenglu(String username,String mobile);
	Map<String, Object> getxhpass(String username,String password);
}
