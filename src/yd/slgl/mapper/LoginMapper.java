package yd.slgl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import yd.htgl.entity.Permis;
import yd.slgl.entity.UsersEntity;

@Repository
public interface LoginMapper {
	UsersEntity getLogin(@Param("username")String username,@Param("password") String password);
	Integer getdenglu(@Param("username")String username,@Param("mobile") String mobile);
	UsersEntity getpassword(@Param("username")String username);
	Integer upPassword(@Param("username")String username,@Param("password") String password);
	//查询用户权限
	List<Permis> getPermis(@Param("user_id")String user_id); 
	List<Permis> getPerm(@Param("user_id")String user_id); 
	List<Permis> getPer(@Param("user_id")String user_id,@Param("parent_permis")Integer parent_permis); 

}
