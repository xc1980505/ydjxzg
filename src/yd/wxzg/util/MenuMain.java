package yd.wxzg.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.http.client.ClientProtocolException;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import yd.wxzg.button.ClickButton;
import yd.wxzg.button.ViewButton;
import yd.wxzg.entity.AccessToken;
//微信菜单按钮封装
public class MenuMain<E> implements ServletContextListener {

@Override
public void contextDestroyed(ServletContextEvent arg0) {
	
}

@Override
public void contextInitialized(ServletContextEvent arg0) {
	

    ViewButton viewButton = new ViewButton();
    viewButton.setName("双链管理");
    viewButton.setUrl("http://zg.demo.xqit.net/ydjxzg/wxshuanglian");
    
    viewButton.setType("view");
    
    ViewButton viewButton1 = new ViewButton();
    viewButton1.setName("数据画像");
    viewButton1.setUrl("http://zg.demo.xqit.net/ydjxzg/wxzhengai");
    viewButton1.setType("view");
    List<ViewButton> buttonlist = new ArrayList<ViewButton>();
    buttonlist.add(viewButton);
    buttonlist.add(viewButton1);
    viewButton1.setButtonlist(buttonlist);
    
    ViewButton viewButton2=new ViewButton();
    //viewButton2.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxbc2d0fdbdb071cf3&redirect_uri=http://aqw9kp.natappfree.cc/ydjxzg/myoauth2.action&response_type=code&scope=snsapi_base&state=123#wechat_redirect");
    viewButton2.setUrl("http://5k9ryc.natappfree.cc/ydjxzg/wxlog/login.action");
    viewButton2.setName("关于我们");
    viewButton2.setType("view");
    
    JSONArray sub_button = new JSONArray();
    sub_button.add(viewButton2);
    
    JSONObject buttonOne=new JSONObject();
    buttonOne.put("name", "关于我们");
    buttonOne.put("sub_button", sub_button);
    
    JSONArray button=new JSONArray();
    button.add(viewButton);
    button.add(viewButton1);
    button.add(viewButton2);
    JSONObject menujson=new JSONObject();
    menujson.put("button", button);
    
    AccessToken accessToken;
    String token="";
	try {
		accessToken = WeiXinUtil.getAccessToken();
		token = accessToken.getToken();
	} catch (ClientProtocolException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    
    //微信菜单接口
    String url="https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+token;
    
    try{
    	//调用微信菜单接口
        String rs=HttpUtil.postMethod(url, menujson.toString());
        System.out.println("成功");
        System.out.println(rs);
    }catch(Exception e){
        System.out.println("请求错误！");
    }
}
}
