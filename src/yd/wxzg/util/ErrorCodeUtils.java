package yd.wxzg.util;

//微信自定义错误码
public class ErrorCodeUtils {

	public static String errorMsg(int code){
		String errorMsg=null;
		
		if(-1==code){
			errorMsg="服务器繁忙，请稍等！";
		}else if(40037==code){
			errorMsg="无效的template_id！";
		}else if(40003==code){
			errorMsg="无效的openid！";
		}else if(45009==code){
			errorMsg="接口调用超过限额！";
		}else if(47001==code){
			errorMsg="数据格式错误！";
		}else if(40111==code){
			errorMsg="获取accessToken错误！";
		}else if(1001==code){
			errorMsg="Bean转JSON错误！";
		}else if(10001==code){
			errorMsg="获取用户信息失败！";
		}else if(10002==code){
			errorMsg="模板消息返回为空！";
		}else if(1002==code){
			errorMsg="JSON转Bean错误！";
		}else if(10111==code){
			errorMsg="Http请求发送错误！";
		}else{
			errorMsg="未知错误！";
		}
		
		return errorMsg;
	}
}
