package yd.wxzg.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;
import yd.slgl.util.PnoUtil;

public class WxcxUtil {
	
	
	 //从微信后台拿到APPID和APPSECRET 并封装为常量
    public static final String APPID = "wx8fe91936c1133556";
    //private static final String APPID = "wx7b3a02797589949b";
    public static final String APPSECRET = "3613d8d8a7e7ea1f2371e87e1189e7bb";
    //private static final String APPSECRET = "2b5fb92a5f8b21aade261a80a8705308";
	
	
	public static Map<String,Object> sendGetReq(String url) {
//        String result = "";
//        BufferedReader in = null;
//        try {
//            String urlNameString = url;
//            URL realUrl = new URL(urlNameString);
//            // 打开和URL之间的连接
//            URLConnection connection = realUrl.openConnection();
//            // 设置通用的请求属性
//            connection.setRequestProperty("accept", "*/*");
//            connection.setRequestProperty("connection", "Keep-Alive");
//            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//            // 建立实际的连接
//            connection.connect();
//            // 获取所有响应头字段
//            java.util.Map<String, List<String>> map = connection.getHeaderFields();
//            // 遍历所有的响应头字段
//            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
//            }
//            // 定义 BufferedReader输入流来读取URL的响应
//            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            String line;
//            while ((line = in.readLine()) != null) {
//                result += line;
//            }
//        } catch (Exception e) {
//            System.out.println("发送GET请求出现异常！" + e);
//            e.printStackTrace();
//        } // 使用finally块来关闭输入流
//        finally {
//            try {
//                if (in != null) {
//                    in.close();
//                }
//            } catch (Exception e2) {
//                e2.printStackTrace();
//            }
//        }
////        String result = EntityUtils.toString(entity,"UTF-8");//HttpEntity转为字符串类型
//        JSONObject jsonObject = JSONObject.fromObject(result);//字符串类型转为JSON类型
//        return jsonObject;
//    }
		        String requestUrl = url;
		         HttpClient client = null;  
		         Map<String,Object> result =new HashMap<String,Object>();  
		         try {     
		             client = new DefaultHttpClient();  
		             HttpGet httpget = new HttpGet(requestUrl);  
		             ResponseHandler<String> responseHandler = new BasicResponseHandler();  
		             String response = client.execute(httpget, responseHandler);  
		             JSONObject OpenidJSONO=JSONObject.fromObject(response);
		             String openid =String.valueOf(OpenidJSONO.get("openid"));
		             String session_key=String.valueOf(OpenidJSONO.get("session_key"));
		             String unionid=String.valueOf(OpenidJSONO.get("unionid"));
		             String errcode=String.valueOf(OpenidJSONO.get("errcode"));
		             String errmsg=String.valueOf(OpenidJSONO.get("errmsg"));
		             String sessionid= new PnoUtil().getEno();
		             result.put("openid", openid);
		             result.put("sessionKey", session_key);
		             result.put("unionid", unionid);
		             result.put("errcode", errcode);
		             result.put("errmsg", errmsg);
		             result.put("sessionid", sessionid);
		         } catch (Exception e) {
		             e.printStackTrace();   
		         } finally {  
		             client.getConnectionManager().shutdown();  
		         }  
		         return result;  
	}
}
