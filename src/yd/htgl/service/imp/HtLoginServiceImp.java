package yd.htgl.service.imp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yd.htgl.entity.Admin;
import yd.htgl.mapper.HtLoginMapper;
import yd.htgl.service.HtLoginService;
import yd.slgl.entity.UsersEntity;

@Service
public class HtLoginServiceImp implements HtLoginService{
	
	@Autowired
	private HtLoginMapper htloginMapper;

	@Override
	public Map<String, Object> getLogin(String username, String password) {
		Map<String,Object> map = new HashMap<String, Object>();
		Admin admin=htloginMapper.getLogin(username,password);
		System.out.println(admin+"-------------");
		if(null==admin){
			map.put("mess", false);
		}else{
			System.out.println("+++++++++++++"+admin.getUser_status());
			if(!"1".equals(admin.getUser_status())){
				map.put("mess", false);
			}else{
				map.put("login", admin);
				map.put("mess", true);
				
			}	
		}		
		return map;
	}

}
