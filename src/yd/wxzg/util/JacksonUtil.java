package yd.wxzg.util;
//json与bean的转换
import java.io.IOException;
import java.io.StringWriter;
 
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
 
/**
 * bean转json格式或者json转bean格式, 项目中我们通常使用这个工具类进行json---java互相转化
 */
public class JacksonUtil {
	private static ObjectMapper mapper = new ObjectMapper();
	//bean转json
	public static String bean2Json(Object obj) throws IOException {
		StringWriter sw = new StringWriter();
		JsonGenerator gen = new JsonFactory().createJsonGenerator(sw);
		mapper.writeValue(gen, obj);
		gen.close();
		return sw.toString();
	}
	//json转bean
	public static <T> T json2Bean(String jsonStr, Class<T> objClass)
			throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(jsonStr, objClass);
	}
}

