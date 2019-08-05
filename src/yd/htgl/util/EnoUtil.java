package yd.htgl.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class EnoUtil {
	
	public String getEnoByTime() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		SimpleDateFormat sdf1=new SimpleDateFormat("mmss");
		String newDate=sdf.format(new Date());
		String newDate1=sdf1.format(new Date());
		String result="";
		Random random=new Random();
		for(int i=0;i<3;i++){
	        result+=random.nextInt(10);
	    }
		return newDate+result+newDate1;
		}
	
	public String getItemID(){
		
        String val = "";
        int n=6;
        Random random = new Random();
        for ( int i = 0; i < n; i++ )
        {
            String str = random.nextInt( 2 ) % 2 == 0 ? "num" : "char";
            if ( "char".equalsIgnoreCase( str ) )
            { // 产生字母
                int nextInt = random.nextInt( 2 ) % 2 == 0 ? 65 : 97;
                // System.out.println(nextInt + "!!!!"); 1,0,1,1,1,0,0
                val += (char) ( nextInt + random.nextInt( 26 ) );
            }
            else if ( "num".equalsIgnoreCase( str ) )
            { // 产生数字
                val += String.valueOf( random.nextInt( 10 ) );
            }
        }
        return val;
    }
	public String getEnoTime() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		SimpleDateFormat sdf1=new SimpleDateFormat("MMdd");
		String newDate=sdf.format(new Date());
		String newDate1=sdf1.format(new Date());
		String result="";
		Random random=new Random();
		for(int i=0;i<3;i++){
	        result+=random.nextInt(10);
	    }
		return newDate+newDate1+result;
		}
}
