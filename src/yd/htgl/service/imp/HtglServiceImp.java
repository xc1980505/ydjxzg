package yd.htgl.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oracle.net.aso.h;
import yd.htgl.entity.Organiza;
import yd.htgl.entity.Permis;
import yd.htgl.entity.Role;
import yd.htgl.entity.Teacher;
import yd.htgl.entity.UsersEntity;
import yd.htgl.mapper.HtglMapper;
import yd.htgl.service.HtglService;
import yd.htgl.util.EnoUtil;

@Service
public class HtglServiceImp implements HtglService {

	@Autowired
	private HtglMapper htMapper;
	@Override
	public Map<String, Object> addzzbm(Organiza organiza) {
		Map<String,Object> map = new HashMap<String,Object>();
		int count=htMapper.addzzbm(organiza);
		if(count>0){
			map.put("mess", true);
		}else{
			map.put("mess", false);
		}
		return map;
	}
	
	@Override
	public Map<String, Object> editOrganiza(String id, String dept_name) {
		Map<String,Object> map = new HashMap<String,Object>();
		int count=htMapper.editOrganiza(id,dept_name);
		if(count>0){
			map.put("mess", true);
		}else{
			map.put("mess", false);
		}
		return map;
	}
	@Override
	public Map<String, Object> getUserlist() {
		Map<String,Object> map = new HashMap<String,Object>();
		List<UsersEntity> uList=htMapper.getuserlist();
		map.put("userlist", uList);
		return map;
	}
	@Override
	public Map<String, Object> organizalist() {
		Map<String,Object> map = new HashMap<String,Object>();
		List<Organiza> organizalist=htMapper.organizalist();
		if(!organizalist.isEmpty()){
				for(Organiza s:organizalist){
					Set<Organiza> children = htMapper.getChildrenOrganiza(s.getId());
					if(children.isEmpty()){
						continue;
					}else{
						for(Organiza s1:children){
							Set<Organiza> children1 = htMapper.getChildrenOrganiza(s1.getId());
							if(children1.isEmpty()){
								continue;
							}else{
								for(Organiza s2:children1){
									Set<Organiza> children2 = htMapper.getChildrenOrganiza(s2.getId());
									if(children2.isEmpty()){
										continue;
									}else{
										for(Organiza s3:children2){
											Set<Organiza> children3 = htMapper.getChildrenOrganiza(s3.getId());
											if(children3.isEmpty()){
												continue;
											}else{
												//继续
											}
											
											s3.setChildren(children3);
										}
									}
									
									s2.setChildren(children2);
								}
							}
							
							s1.setChildren(children1);
						}
						
					}
					
					s.setChildren(children);
				}
						
		}
		//Integer minid=mbMapper.minstandid();
		
		//List<Standard> standlist=mbMapper.standlist(String.valueOf(minid),null);
		map.put("standardlist", organizalist);
		//map.put("standlist", standlist);
		return map;
	}
	@Override
	public Map<String, Object> deleteOrganiza(String id) {
		Map<String,Object> map = new HashMap<String,Object>();
		Set<Organiza> organiza=htMapper.getChildrenOrganiza(id);
		if(organiza.isEmpty()){
			int count=htMapper.deleteOrganiza(id);
			if(count>0){
				map.put("mess",true);
			}else{
				map.put("mess", false);
			}
			}
		else{
			map.put("mess","有下属部门不能删除");
		}
		return map;
	}
	@Override
	public Map<String, Object> getbumenry(String id) {
		Map<String,Object> map = new HashMap<String,Object>();
		List<UsersEntity> bmry =htMapper.getbumenry(id);
		if(!bmry.isEmpty()){
		map.put("bmry", bmry);
		}else{
		map.put("bmry", "无人员");	
		}
		return map;
	}
	@Override
	public Map<String, Object> deleteUser(String user_id) {
		Map<String,Object> map = new HashMap<String,Object>();
		int count =htMapper.deleteUser(user_id);
		if(count>0){
			map.put("mess", true);
		}else{
			map.put("mess", false);
		}
		return map;
	}
	@Override
	public Map<String, Object> updateUser(UsersEntity usersEntity) {
		Map<String,Object> map = new HashMap<String,Object>();
		//List<UsersEntity> entity=htMapper.selstatus(usersEntity.getDept_id());
		if(usersEntity.getStatus().equals("1")){
			UsersEntity entity=htMapper.selstatus(usersEntity.getDept_id());
//			System.out.println("11111111111"+entity.getUser_id());
//			System.out.println("11111111111"+usersEntity.getUser_id());
			if(entity==null){
				Organiza organiza= htMapper.selectorg(usersEntity.getDept_id());
				usersEntity.setDept_name(organiza.getDept_name());
				int count =htMapper.updateUser(usersEntity);
				if(count>0){
					map.put("mess", true);
				}else{
					map.put("mess", false);
				}
			}else if (entity.getUser_id().equals(usersEntity.getUser_id())) {
				Organiza organiza= htMapper.selectorg(usersEntity.getDept_id());
				usersEntity.setDept_name(organiza.getDept_name());
				int count =htMapper.updateUser(usersEntity);
				if(count>0){
					map.put("mess", true);
				}else{
					map.put("mess", false);
				}
			}
			else{
				map.put("mess", "已存在主管");
			}
		}else{
			Organiza organiza= htMapper.selectorg(usersEntity.getDept_id());
			usersEntity.setDept_name(organiza.getDept_name());
			int count =htMapper.updateUser(usersEntity);
			if(count>0){
				map.put("mess", true);
			}else{
				map.put("mess", false);
			}
		}
		return map;
	}
	@Override
	public Map<String, Object> bumenlist() {
		Map<String,Object> map = new HashMap<String,Object>();
		List<Organiza> organizalist=htMapper.bumenlist();
		map.put("bumen", organizalist);
		return map;
	}

	@Override
	public Map<String, Object> insertUser(UsersEntity usersEntity) {
		Map<String,Object> map = new HashMap<String,Object>();
		if(usersEntity.getStatus().equals("1")){
			UsersEntity entity=htMapper.selstatus(usersEntity.getDept_id());
			if(entity==null){
				String ldid=htMapper.selectldid(usersEntity.getDept_id());
				if(ldid.isEmpty()){
					ldid="0";
				}
				usersEntity.setSjldid(ldid);
				Organiza organiza= htMapper.selectorg(usersEntity.getDept_id());
				usersEntity.setDept_name(organiza.getDept_name());
				String user_id= new EnoUtil().getEnoByTime();
				usersEntity.setUser_id(user_id);
				int count =htMapper.insertUser(usersEntity);
				if(count>0){
					map.put("mess", true);
				}else{
					map.put("mess", false);
				}
			}
			else{
				map.put("mess", "已存在主管");
			}
		}
		return map;
	}

	//后台权限添加组
	@Override
	public Map<String, Object> insertZu(String role_name, String role_code,String permis_id) {
		Map<String,Object> map = new HashMap<String,Object>();
		Role role=htMapper.selectrole(role_name);
		if(role==null){
		int num=htMapper.insertZu(role_name, role_code);
		if(num==1){
			Role role2=htMapper.selectrole(role_name);
			String[] part =permis_id.split(",");
			int num2=0;
			for(String x : part){
				Integer permis = Integer.valueOf(x); 
				num2=htMapper.isertpermis(role2.getRole_id(), permis);
		      }
			
			//int num2=htMapper.isertpermis(role2.getRole_id(), permis_id);
			if(num2==1){
			map.put("mess","添加成功");
			}
		}
		else{
			map.put("mess","添加失败");
		}
		}
		else{
			map.put("mess","组名称已存在");
		}
		return map;
	}

	//后台权限组修改
	@Override
	public Map<String, Object> updatezu(String role_id,String role_name,String role_code,String permis_id) {
		Map<String,Object> map = new HashMap<String,Object>();
		System.out.println("11111"+role_id+"2222"+role_name+"33333"+role_code+"44444"+permis_id);
		Integer role= Integer.valueOf(role_id);
			Role role1=htMapper.selectrole(role_name);
			
			if(role1==null||role1.getRole_id()==role){
				int num1=htMapper.updaterole(role, role_name, role_code);
				if(num1==1){
					int num=htMapper.deleterop(role);
					String[] part =permis_id.split(",");
					for(String x : part){
						Integer permis = Integer.valueOf(x); 
						System.out.println("5555555555555");
						int num2=htMapper.isertpermis(role, permis);
						if(num2==1){
							map.put("mess","修改成功");
						}
						else{
							map.put("mess","修改失败");
						}
				      }
				}
				else{
					map.put("mess","修改失败");
				}
			}
			else{
				map.put("mess","组名称已存在");
			}
		
		return map;
	}

	@Override
	public Map<String, Object> deletezu(String role_id) {
		Map<String,Object> map = new HashMap<String,Object>();
		System.out.println("+++++++++++++++"+role_id);
		Integer role= Integer.valueOf(role_id);
		int num=htMapper.deleterole(role);
		int num1=htMapper.deleterop(role);
		int num2=htMapper.deleteuserrop(role);
		if(num==1||num1==1){
			map.put("mess","删除成功");
		}
		else {
			map.put("mess","删除失败");
		}
		return map;
	}

	@Override
	public Map<String, Object> selectpermis() {
		Map<String,Object> map = new HashMap<String,Object>();
		List<Permis> permi=htMapper.selectpermis();
		for(Permis x : permi){
			List<Permis> permis=htMapper.sepermi(x.getPermis_id());
			x.setPermis(permis);
		}
		map.put("permis", permi);
		return map;
	}
	//查看所有组
	@Override
	public Map<String, Object> sleroles(String role_name) {
		Map<String,Object> map = new HashMap<String,Object>();
		if(role_name==null){
		List<Role> roles=htMapper.slerole();
		for(Role x : roles){
			List<Permis> permis=htMapper.selectpermi(x.getRole_id());
			x.setPermis(permis);
		}
		map.put("role", roles);
		}
		else{
			List<Role> roles=htMapper.srolebyname(role_name);
			for(Role x : roles){
				List<Permis> permis=htMapper.selectpermi(x.getRole_id());
				x.setPermis(permis);
			}
			map.put("role", roles);
		}
		return map;
	}
	//查询人员以及分组
	@Override
	public Map<String, Object> getUsers(String name) {
		Map<String,Object> map = new HashMap<String,Object>();
		System.out.println("-------------------"+name);
		if(name==null){
			List<UsersEntity> usersEntities=htMapper.getuserlist();
			for(UsersEntity x : usersEntities){
				Set<Role> roles=htMapper.seleuserRoles(x.getUser_id());
				x.setRoles(roles);
			}
			map.put("users", usersEntities);
		}
		else{
			List<UsersEntity> entities= htMapper.getrybyname(name);
			for(UsersEntity x : entities){
				Set<Role> roles=htMapper.seleuserRoles(x.getUser_id());
				x.setRoles(roles);
			}
			map.put("users", entities);
		}
		
		return map;
	}

	//人员分组
	@Override
	public Map<String, Object> ryfenzu(String user_id, String role_id) {
		Map<String,Object> map = new HashMap<String,Object>();
		String[] part =role_id.split(",");
		for(String x : part){
			Integer role = Integer.valueOf(x); 
		    int num=htMapper.insertuserRole(role, user_id);
		    if(num==1){
		    	map.put("mess","成功");
		    }
		    else {
		    	map.put("mess","失败");
			}
		}
		return map;
	}
	//通过id获取组
	@Override
	public Map<String, Object> getzu(String role_id) {
		Map<String,Object> map = new HashMap<String,Object>();
		Integer role = Integer.valueOf(role_id);
		Role role1=htMapper.getzu(role);
		List<Permis> permis=htMapper.selectpermi(role1.getRole_id());
		role1.setPermis(permis);
		map.put("role", role1);
		return map;
	}
	//去修改
	@Override
	public Map<String, Object> getUrole(String user_id) {
		Map<String,Object> map = new HashMap<String,Object>();
		UsersEntity entity=htMapper.getrybyid(user_id);
		Set<Role> roles=htMapper.seleuserRoles(entity.getUser_id());
		List<Role> list=htMapper.slerole();
		entity.setRoles(roles);
		map.put("user", entity);
		map.put("roles",list);
		return map;
	}

	@Override
	public Map<String, Object> updatefz(String user_id, String role_id) {
		Map<String,Object> map = new HashMap<String,Object>();
		int num=htMapper.deleteuserRole(user_id);
		System.out.println("+++++"+num);
			System.out.println("________"+role_id);
			System.out.println("________"+user_id);
			String[] part =role_id.split(",");
			for(String x : part){
				Integer role = Integer.valueOf(x); 
			    int num1=htMapper.insertuserRole(role, user_id);
			    if(num1==1){
			    	map.put("mess","成功");
			    }
			    else {
			    	map.put("mess","失败");
				}
			}
		
		return map;
	}
	//教师列表
	@Override
	public Map<String, Object> getTeacher() {
		Map<String, Object> map=new HashMap<String, Object>();
		List<Teacher> teachers= htMapper.getTeacher();
		map.put("teachers", teachers);
		return map;
	}
	//重置密码
	@Override
	public Map<String, Object> ResetPass(String number) {
		Map<String, Object> map=new HashMap<String, Object>();
		String password = new EnoUtil().getItemID();
		int num=htMapper.ResetPass(number, password);
		if(num==1){
			Teacher teacher=htMapper.getPass(number);
			map.put("pass", teacher.getPassword());
			map.put("mess",true);
		}
		else{
			map.put("mess", false);
		}
		return map;
	}

	//添加教师
	@Override
	public Map<String, Object> inTeacher(Teacher teacher) {
		int cout=0;
		Map<String, Object> map=new HashMap<String, Object>();
		System.out.println(teacher.getIs_pcwb()+teacher.getEducation());
		teacher.setTeacher_id(new EnoUtil().getEnoTime());
		int count=htMapper.checkTeacher(teacher.getNumber());
		//Teacher teacher2=htMapper.majorzg(teacher.getDepartment_id());
		if(count!=1){
			if(!teacher.getDirector().isEmpty()&&!teacher.getDirector().equals("")){
				String[] director =teacher.getDirector().split(",");
				for (String string : director) {
					Organiza organiza= htMapper.majorzg(string);
					if(organiza!=null){
						map.put("mess",organiza.getDept_name()+"已存在主管");
						cout=1;
						break;
					}
				}
				if(cout==0){
					for (String string : director) {
						htMapper.updateOrgan(string, teacher.getTeacher_id());
					}
					String[] dept =teacher.getDepartment_id().split(",");
					for (String dept_id : dept) {
						htMapper.instOrgan(teacher.getTeacher_id(), dept_id);
					}
					int num=htMapper.inTeacher(teacher);
					if(num==1){
						//Teacher teacher3=htMapper.majorzg(teacher.getDepartment_id());
						
						map.put("mess",true);
					}
					else{
						map.put("mess", false);
					}	
				}
				
			}else {
				String[] dept =teacher.getDepartment_id().split(",");
				for (String dept_id : dept) {
					htMapper.instOrgan(teacher.getTeacher_id(), dept_id);
				}
				int num=htMapper.inTeacher(teacher);
				if(num==1){
					//Teacher teacher3=htMapper.majorzg(teacher.getDepartment_id());
					
					map.put("mess",true);
				}
				else{
					map.put("mess", false);
				}	
			}
//			if(teacher.getDirector().length()>0){
//				map.put("mess","部门已存在主管");
//			}else if(teacher.getDirector().equals("1")){
//				Teacher teac=htMapper.sjzg(teacher.getDepartment_id());
//				if(teac==null){
//					teacher.setLeader("无");
//				}
//				else {
//					teacher.setLeader(teac.getTeacher_id());
//				}
//				teacher.setTeacher_id(new EnoUtil().getEnoTime());
//				int num=htMapper.inTeacher(teacher);
//				if(num==1){
//					//Teacher teacher3=htMapper.majorzg(teacher.getDepartment_id());
//					
//					map.put("mess",true);
//				}
//				else{
//					map.put("mess", false);
//				}	
//			}
		}
		else{
			map.put("mess", "工号已存在");
		}
		return map;
	}

	//搜索（教师、部门）
	@Override
	public Map<String, Object> search(String name, String department_name) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<Teacher>teachers=htMapper.search(name, department_name);
		map.put("teachers", teachers);
		return map;
	}
	//删除教师
	@Override
	public Map<String, Object> delTeacher(String number) {
		Map<String, Object> map =new HashMap<String, Object>();
		int num=htMapper.delTeacher(number);
		if(num==1){
			map.put("mess",true);
		}
		else{
			map.put("mess", false);
		}	
		return map;
	}
	
	
	
	
}
