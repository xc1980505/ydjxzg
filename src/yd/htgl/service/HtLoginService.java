package yd.htgl.service;

import java.util.Map;

public interface HtLoginService {

	Map<String, Object> getLogin(String username, String password);
}
