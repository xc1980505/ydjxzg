package yd.wxzg.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
 
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import yd.wxzg.entity.TextMessage;
 
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
//微信消息封装类
public class MessageUtil {
	
	 /** 
     * 返回消息类型：文本 
     */  
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";  
  
    /** 
     * 返回消息类型：音乐 
     */  
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";  
  
    /** 
     * 返回消息类型：图文 
     */  
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";  
  
    /** 
     * 请求消息类型：文本 
     */  
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";  
  
    /** 
     * 请求消息类型：图片 
     */  
    public static final String REQ_MESSAGE_TYPE_IMAGE = "image";  
  
    /** 
     * 请求消息类型：链接 
     */  
    public static final String REQ_MESSAGE_TYPE_LINK = "link";  
  
    /** 
     * 请求消息类型：地理位置 
     */  
    public static final String REQ_MESSAGE_TYPE_LOCATION = "location";  
  
    /** 
     * 请求消息类型：音频 
     */  
    public static final String REQ_MESSAGE_TYPE_VOICE = "voice";  
  
    /** 
     * 请求消息类型：推送 
     */  
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";  
  
    /** 
     * 事件类型：subscribe(订阅) 
     */  
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";  
  
    /** 
     * 事件类型：unsubscribe(取消订阅) 
     */  
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";  
  
    /** 
     * 事件类型：CLICK(自定义菜单点击事件) 
     */  
    public static final String EVENT_TYPE_CLICK = "CLICK";
/**
 * xml转为map集合
 * @param request
 * @return
 * @throws IOException
 * @throws DocumentException
 */
      public static Map<String,String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException{
 
      //System.out.println("进xmlToMap");
 
      Map<String,String> map=new HashMap<String, String>();
 
      //dom4j saxReader解析xml
      SAXReader reader=new SAXReader();
 
      //从request中获取输入流
      InputStream ins = request.getInputStream();
 
      //解析xml文档
      Document doc =reader.read(ins);
 
      //获得根节点
      Element root = doc.getRootElement();
 
      //List存储  遍历
      List<Element> list=  root.elements();
 
      for (Element e : list) {
  map.put(e.getName(), e.getText());
}
      ins.close();
    //  System.out.println(map.toString());
return map;  
      }
 
      /**
       * 将文本消息对象转换为xml
       * @param textMessage
       * @return
       */
 
       //xtream jar包 ->  XStrem类提供对象转xml
      public static String textMessageToXml(TextMessage textMessage){
     // System.out.println("进textMessageToXml");
      /**
       * new StaxDriver()这个很重要 没有这个就错了
       * XStream xstream=new XStream(new StaxDriver());
       */
    XStream xstream=new XStream(new StaxDriver());
    xstream.alias("xml", textMessage.getClass());
// System.out.println("textMessage");
   return xstream.toXML(textMessage);    
      }
}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
