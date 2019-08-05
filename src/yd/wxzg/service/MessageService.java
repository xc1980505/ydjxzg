package yd.wxzg.service;

import javax.servlet.http.HttpServletRequest;

public interface MessageService {
	 /**
     * 微信公众号处理
     * @param request
     * @return
     */
    String newMessageRequest(HttpServletRequest request);
}
