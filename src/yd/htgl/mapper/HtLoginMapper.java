package yd.htgl.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import yd.htgl.entity.Admin;

@Repository
public interface HtLoginMapper {

	Admin getLogin(@Param("username")String username,@Param("password") String password);
}
