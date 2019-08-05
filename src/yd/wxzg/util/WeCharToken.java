package yd.wxzg.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
//申请token权限
public class WeCharToken {
	public static void tokenSign(Model model, HttpServletRequest request,HttpServletResponse response) throws IOException {
	    boolean isGet = request.getMethod().toLowerCase().equals("get");
	    PrintWriter print;
	    if (isGet) {
	        // 微信加密签名
	        String signature = request.getParameter("signature");
	        // 时间戳
	        String timestamp = request.getParameter("timestamp");
	        // 随机数
	        String nonce = request.getParameter("nonce");
	        // 随机字符串
	        String echostr = request.getParameter("echostr");
	        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
	        if (signature != null && CheckoutUtil.checkSignature(signature, timestamp, nonce)) {
	            try {
	                print = response.getWriter();
	                print.write(echostr);
	                print.flush();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	   }
	    	
	 }
}
