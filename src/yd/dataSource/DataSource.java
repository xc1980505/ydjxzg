package yd.dataSource;

import java.lang.annotation.ElementType; 
import java.lang.annotation.Retention; 
import java.lang.annotation.RetentionPolicy; 
import java.lang.annotation.Target; 
import org.springframework.stereotype.Component; 
/**
 * ����Դ
 *
 */ @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME) 
    @Component 
    public @interface DataSource { 
	 String value() default ""; 
	}
