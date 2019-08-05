package yd.slgl.util;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class PnoUtil {
	
	public String getEnoByTime() {
		String result="";
		Random random=new Random();
		for(int i=0;i<4;i++){
	        result+=random.nextInt(10);
	        
	    }
		return result;
		}
	
	public String getEno() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhh");
		SimpleDateFormat sdf1=new SimpleDateFormat("mmss");
		String newDate=sdf.format(new Date());
		String newDate1=sdf1.format(new Date());
		String result="";
		Random random=new Random();
		for(int i=0;i<4;i++){
	        result+=random.nextInt(10);
	    }
		return newDate+result+newDate1;
		}
}
