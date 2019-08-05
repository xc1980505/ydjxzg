package yd.wxzg.service.impl;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import yd.wxzg.entity.AccessToken;
import yd.wxzg.entity.TextMessage;
import yd.wxzg.service.MessageService;
import yd.wxzg.util.MessageUtil;
import yd.wxzg.util.UserMessage;
import yd.wxzg.util.WeiXinUtil;
@Service
public class MessageServiceImpl implements MessageService{
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceImpl.class);
	
	//微信消息自动回复
    @Override
    public String newMessageRequest(HttpServletRequest request) {
        String respMessage = null;
        try {
            // xml请求解析
            Map<String, String> requestMap = MessageUtil.xmlToMap(request);
            System.out.println(requestMap);
            // 发送方帐号（open_id）
            String fromUserName = requestMap.get("FromUserName");
            AccessToken accessToken = WeiXinUtil.getAccessToken();
            JSONObject userInfo = UserMessage.getWechatUserInfo(fromUserName, accessToken.getToken());
            String userNickName = userInfo.getString("nickname");
            // 公众帐号
            String toUserName = requestMap.get("ToUserName");
            // 消息类型
            String msgType = requestMap.get("MsgType");
            // 消息内容
            String content = requestMap.get("Content");
            LOGGER.info("FromUserName is:" + fromUserName + ", ToUserName is:" + toUserName + ", MsgType is:" + msgType);
            String respContent=null;
            // 文本消息
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
                //自动回复
                TextMessage text = new TextMessage();
                if("我".equals(content)){
                	text.setContent("你是"+userNickName+"！小子，你骗不了我的！！");
                }else{
                	text.setContent(content+"是谁?我不认识，我就认识你！");
                }
                if("看看".equals(content)){
                	text.setContent("你是"+content+"！小子，你骗不了我的！！");
                }else if("1".equals(content)){
                	text.setContent(fromUserName+"是谁?我不认识，我就认识你！");
                }
                text.setToUserName(fromUserName);
                text.setFromUserName(toUserName);
                text.setCreateTime(new Date().getTime());
                text.setMsgType(msgType);
                respMessage = MessageUtil.textMessageToXml(text);
            }
            // 事件推送
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                String eventType = requestMap.get("Event");// 事件类型
                // 订阅
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                    //文本消息
                    TextMessage text = new TextMessage();
                    text.setContent(userNickName+"欢迎您！");
                    text.setToUserName(fromUserName);
                    text.setFromUserName(toUserName);
                    text.setCreateTime(new Date().getTime());
                    text.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
                    respMessage = MessageUtil.textMessageToXml(text);
                }
                
                // 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {// 取消订阅

                }
            }
        }
        catch (Exception e) {
            LOGGER.error("error......");
        }
        return respMessage;
    }
}
