package yd.slgl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yd.htgl.entity.Permis;
import yd.slgl.entity.UsersEntity;
import yd.slgl.mapper.LoginMapper;
import yd.slgl.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	private LoginMapper loginMapper;
	
	@Override
	public Map<String, Object> getLogin(String username, String password) {
		Map<String,Object> map = new HashMap<String, Object>();
		UsersEntity user=loginMapper.getLogin(username,password);
//		List<Permis> permis=loginMapper.getPerm(user.getUser_id());
//		System.out.println("+++++++++++++"+permis);
		if(user==null){
			map.put("mess", false);
		}else{
			if(!"1".equals(user.getUser_status())){
				map.put("mess", false);
			}else{
				List<Permis> permis=loginMapper.getPerm(user.getUser_id());
				map.put("login", user);
				map.put("permis", permis);
				map.put("mess", true);
			}	
		}		
		return map;
	}

	@Override
	public Map<String, Object> getpermis(String user_id) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<Permis> permis=loginMapper.getPermis(user_id);
		for (Permis permis2 : permis) {
			List<Permis> list=loginMapper.getPer(user_id, permis2.getPermis_id());
			permis2.setPermis(list);
		}
		map.put("permis", permis);
		return map;
	}

	@Override
	public Map<String, Object> getdenglu(String username, String mobile) {
		Map<String, Object> map= new HashMap<String, Object>();
		Integer num=loginMapper.getdenglu(username, mobile);
		if(num==1){
			map.put("mess",true);
		}
		else if (num==0) {
			map.put("mess",false);
		}
		return map;
	}

	@Override
	public Map<String, Object> getxhpass(String username, String password) {
		Map<String, Object> map= new HashMap<String, Object>();
		UsersEntity entity =loginMapper.getpassword(username);
		if(entity.getPassword().equals(password)){
			map.put("mess","不能修改为旧密码");
		}
		else{
			Integer num=loginMapper.upPassword(username, password);
			if(num==1){
				map.put("mess",true);
			}else{
				map.put("mess",false);
			}
		}
		return map;
	}	
}
