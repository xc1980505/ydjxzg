package yd.wxzg.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TemplateFailUtil {
	
 //第二次发送失败时间间隔
 public static boolean secondTime(String nowTime){
	 SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 try {
		Date parse = sDateFormat.parse(nowTime);
		Date afterDate = new Date(parse.getTime()+1*60*1000);//1分钟
		if(new Date().before(afterDate)){
			return true;
		}
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;	 
 }
//第三次发送失败时间间隔
public static boolean thirdTime(String nowTime){	 	 
	 SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 try {
		Date parse = sDateFormat.parse(nowTime);
		Date afterDate = new Date(parse.getTime()+20*60*1000);//20分钟
		if(new Date().before(afterDate)){//判断当前时间是否比第设定第三次发送时间早
			return true;
		}
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;	 
}
}
