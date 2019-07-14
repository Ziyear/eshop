package com.eshop.common.utils;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * json对象映射工具类之jackson封装
 * 
 */
@Slf4j
public class JsonUtils {

	private static ObjectMapper objectMapper = null;

	static {
		objectMapper = new ObjectMapper();
		// 设置默认日期格式
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		// 提供其它默认设置
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		objectMapper.setFilters(new SimpleFilterProvider()
				.setFailOnUnknownId(false));
	}

	/**
	 * 将对象转换成json字符串格式（默认将转换所有的属性）
	 * 
	 * @param value
	 * @return
	 */
	public static String toJsonStr(Object value) {
		try {
			return objectMapper.writeValueAsString(value);
		} catch (JsonProcessingException e) {
			log.error("Json转换失败", e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * 将对象转换成json字符串格式
	 * 
	 * @param value
	 *            需要转换的对象
	 * @param properties
	 *            需要转换的属性
	 */
	public static String toJsonStr(Object value, String[] properties) {
		try {
			SimpleBeanPropertyFilter sbp = SimpleBeanPropertyFilter
					.filterOutAllExcept(properties);
			FilterProvider filterProvider = new SimpleFilterProvider()
					.addFilter("propertyFilterMixIn", sbp);
			return objectMapper.writer(filterProvider)
					.writeValueAsString(value);
		} catch (Exception e) {
			log.error("Json转换失败", e);
			throw new RuntimeException(e);
		}

	}

	/**
	 * 将对象转换成json字符串格式
	 * 
	 * @param value
	 *            需要转换的对象
	 * @param properties2Exclude
	 *            需要排除的属性
	 */
	public static String toJsonStrWithExcludeProperties(Object value,
			String[] properties2Exclude) {
		try {
			SimpleBeanPropertyFilter sbp = SimpleBeanPropertyFilter
					.serializeAllExcept(properties2Exclude);
			FilterProvider filterProvider = new SimpleFilterProvider()
					.addFilter("propertyFilterMixIn", sbp);
			return objectMapper.writer(filterProvider)
					.writeValueAsString(value);
		} catch (Exception e) {
			log.error("Json转换失败", e);
			throw new RuntimeException(e);
		}

	}

	/**
	 * 将对象json格式直接写出到流对象中（默认将转换所有的属性）
	 * 
	 * @param out
	 * @return
	 */
	public static void writeJsonStr(OutputStream out, Object value) {
		try {
			objectMapper.writeValue(out, value);
		} catch (Exception e) {
			log.error("Json转换失败", e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * 将对象json格式直接写出到流对象中
	 * 
	 * @param value
	 *            需要转换的对象(注意，需要在要转换的对象中定义JsonFilter注解)
	 * @param properties
	 *            需要转换的属性
	 */
	public static void writeJsonStr(OutputStream out, Object value,
			String[] properties) {

		try {
			objectMapper.writer(
					new SimpleFilterProvider().addFilter(
							AnnotationUtils
									.getValue(
											AnnotationUtils.findAnnotation(
													value.getClass(),
													JsonFilter.class))
									.toString(), SimpleBeanPropertyFilter
									.filterOutAllExcept(properties)))
					.writeValue(out, value);
		} catch (Exception e) {
			log.error("Json转换失败", e);
			throw new RuntimeException(e);
		}

	}

	/**
	 * 将对象转换成json字符串格式
	 * 
	 * @param value
	 *            需要转换的对象
	 * @param properties2Exclude
	 *            需要排除的属性(注意，需要在要转换的对象中定义JsonFilter注解)
	 */
	public static void writeJsonStrWithExcludeProperties(OutputStream out,
			Object value, String[] properties2Exclude) {
		try {
			objectMapper.writer(
					new SimpleFilterProvider().addFilter(
							AnnotationUtils
									.getValue(
											AnnotationUtils.findAnnotation(
													value.getClass(),
													JsonFilter.class))
									.toString(), SimpleBeanPropertyFilter
									.serializeAllExcept(properties2Exclude)))
					.writeValue(out, value);
		} catch (Exception e) {
			log.error("Json转换失败", e);
			throw new RuntimeException(e);
		}

	}

	/**
	 * 反序列化POJO或简单Collection如List<String>.
	 * 
	 * 如果JSON字符串为Null或"null"字符串, 返回Null. 如果JSON字符串为"[]", 返回空集合.
	 * 
	 * 如需反序列化复杂Collection如List<MyBean>, 请使用fromJson(String, JavaType)
	 */


	@SuppressWarnings({ "unchecked", "unused" })

	
	/**
	 * 单独解析某一个json的key值
	 * @Title: getjsonvalue 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param jsonText
	 * @param @param key
	 * @param @return    设定文件 
	 * @return JsonNode    返回类型 
	 * @throws
	 */
	public static JsonNode getjsonvalue(String jsonText, String key){
		
		try {
			ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(jsonText); // 读取Json
            
            return  rootNode.path(key);
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return null;
	}
	
	
	public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
		ObjectMapper mapper = new ObjectMapper();
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);   
	}   
	
	
	/**
	 * 解析json属性，放到实体里面去
	 * @Title: readJsonList 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param jsondata
	 * @param @param collectionClass
	 * @param @return    设定文件 
	 * @return List<SpecVO>    返回类型 
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public static List<Object> readJsonList(String jsondata,Class<?> collectionClass) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			JavaType javaType = getCollectionType(ArrayList.class, collectionClass);
			List<Object> lst =  (List<Object>)mapper.readValue(jsondata, javaType);

			return lst;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * json 转map
	 * @Title: readJsonMap 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param jsondata
	 * @param @return    设定文件 
	 * @return Map<String,Map<String,Object>>    返回类型 
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> readJsonToMap(String jsondata) {
	    try {
	        Map<String, String> maps = objectMapper.readValue(jsondata, Map.class);
	        //System.out.println(maps);
	        return maps;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String, Object> readJsonToMap1(String jsondata) {
	    try {
	        Map<String, Object> maps = objectMapper.readValue(jsondata, Map.class);
	        //System.out.println(maps);
	        return maps;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	
	/**
	 * 设置过滤值为空的属性，使得生成的 json 字符串只包含非空的值
	 * 
	 * @return
	 */


}
