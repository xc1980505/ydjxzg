package yd.wxzg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import yd.slgl.entity.UsersEntity;
import yd.wxzg.entity.TemplateMessageEntity;

@Repository
public interface WxMapper {


	int addWxMessage(@Param("openid")String openid,@Param("templateid") String templateid,@Param("content") String content);

	Integer selectFrequency(@Param("openid")String openid,@Param("templateid") String templateid,@Param("content") String content);

	int updateRrequency(@Param("openid")String openid,@Param("templateid") String templateid,@Param("content") String content);

	int MessageCount(@Param("openid")String openid,@Param("templateid") String templateid,@Param("content") String content);

	int addErrmsg(@Param("openid")String openid,@Param("templateid") String templateid,@Param("content") String content,@Param("nowTime") String nowTime,@Param("error_reason") String error_reason);

	void deleteFreqy(@Param("id")int id);

	int errorMessage(@Param("openid")String openid,@Param("templateid") String templateid,@Param("content") String content);

	List<TemplateMessageEntity> findMessage();

	void insertMessageDate(@Param("id")int id,@Param("nowTime") String nowTime);
	
	int insertOpenid(@Param("openid")String openid,@Param("session_key")String session_key,@Param("sessionid")String sessionid,@Param("pass") String pass,@Param("name") String name);
	List<UsersEntity> getwxuser(@Param("wx_id")String openid);
	
	UsersEntity getwxsession(@Param("sessionid")String sessionid);
	
	int updateSession(@Param("sessionid")String sessionid,@Param("openid")String openid,@Param("session_key")String session_key);
	
	UsersEntity selectuser(@Param("username") String username,@Param("password") String password);
}
