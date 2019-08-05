package yd.slgl.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	
	public String getEnoByTime() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date =new Date();
		Date newDate=new Date(date.getTime()+60000);
		
		
		String newDate1=sdf.format(newDate);
		
		return newDate1;
		}
	public String getStringByTime() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
		Date date =new Date();
		String newDate1=sdf.format(date);
		System.out.println(newDate1);
		return newDate1;
	}
}
