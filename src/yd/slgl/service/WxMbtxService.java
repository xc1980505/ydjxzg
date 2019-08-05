package yd.slgl.service;

import java.util.Map;

public interface WxMbtxService {
	
	Map<String, Object> xcxtargetlist(String userid, String dj);
	Map<String, Object> xcxtargets(String user_id);
	Map<String,Object> mhcx(String user_id);

}
