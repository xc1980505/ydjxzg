package yd.wxzg.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//时间封装
public class DataUtils {
	
  public static String detaileds(){
	return new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date());
  }
  public static String detaileds2(){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	  }
  //日期转字符串
  public static String dateToStriong(Date time){	  
	    SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String afterTime = sDateFormat.format(time);
		return afterTime;
  }
  //字符串转日期
  public static Date stringToDate(String time){	  
	    SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date afterTime=null;
		try {
			afterTime = sDateFormat.parse(time);
		} catch (ParseException e) {
			System.err.println("日期格式转换失败！请联系管理员");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return afterTime;
  }
  
}
