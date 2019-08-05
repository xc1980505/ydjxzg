package yd.slgl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yd.slgl.entity.Target;
import yd.slgl.entity.UsersEntity;
import yd.slgl.mapper.MbtxMapper;
import yd.slgl.service.WxMbtxService;

@Service
public class WxMbtxServiceImpl  implements WxMbtxService{

	@Autowired
	private MbtxMapper mbMapper;
	
	@Override
	public Map<String, Object> xcxtargetlist(String userid, String dj) {
		Map<String, Object> map= new HashMap<String, Object>();
		List<Target> targetlist=mbMapper.xcxtargetlist(userid);
		map.put("targetlist", targetlist);
		return map;
	}

	@Override
	public Map<String, Object> xcxtargets(String user_id) {
		Map<String, Object> map= new HashMap<String, Object>();
		Target jx=mbMapper.selcjx(user_id);
		int fz=mbMapper.selcfz(user_id);
		int wc=mbMapper.selcwc(user_id);
		int sj=mbMapper.selcsj(user_id);
		List<Target> targets=mbMapper.xcxtargets(user_id);
		map.put("myjx", jx.getProgress());
		map.put("myfz", fz);
		map.put("mywc", wc);
		map.put("mysj", sj);
		map.put("myname", jx.getManager_name());
		map.put("targets", targets);
		return map;
	}

	@Override
	public Map<String, Object> mhcx(String user_id) {
		Map<String, Object> map =new HashMap<String, Object>();
		List<UsersEntity> users=mbMapper.getUserByxgs(user_id);
		map.put("users", users);
		return map;
	}

}
