package yd.wxzg.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import net.sf.json.JSONObject;
//根据access_token和openid获取用户信息
public class UserMessage {
	public static JSONObject getWechatUserInfo(String openId,String token){		
        String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="+token+"&openid="+openId;  
        JSONObject result=null;  
        HttpClient client = new HttpClient();  
        GetMethod get = new GetMethod(url);  
            try {  
                   client.executeMethod(get);  
                   String returnJson=get.getResponseBodyAsString();
                   returnJson = new String(returnJson.getBytes("ISO8859_1"),"UTF-8");  
                   result = JSONObject.fromObject(returnJson);  
                   if(result.containsKey("nickname")){
                        return result;  
                   }else{
                       return result;
                   }
                 }catch (Exception e) {}
            
        return result;  
        }

}
