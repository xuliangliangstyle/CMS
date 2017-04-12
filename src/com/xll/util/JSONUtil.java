package com.xll.util;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.activiti.engine.impl.util.json.JSONArray;
import org.activiti.engine.impl.util.json.JSONObject;
import org.springframework.stereotype.Component;

/**
 * 对象转JSONArray工具
 * @author Administrator
 *
 */
@Component(value="jsonUtil")
public class JSONUtil {
	private String ENTITY_PATH="com.xll.po";
	private final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public JSONArray toJSONArray(@SuppressWarnings("rawtypes") Collection collection)
		throws Exception
	{
		JSONArray jsons = new JSONArray();
		JSONObject json;
		for (@SuppressWarnings("rawtypes")
		Iterator ite = collection.iterator(); ite.hasNext(); jsons.put(json))
		{
			Object obj = ite.next();
			json = toJSONObject(obj);
		}

		return jsons;
	}

	public JSONObject toJSONObject(Object obj)
		throws Exception
	{
		if (obj instanceof Map)
			return toJSONObject((Map)obj);
		JSONObject json = new JSONObject();
		Field fields[] = obj.getClass().getDeclaredFields();
		Field.setAccessible(fields, true);
		for (int i = 0; i < fields.length; i++)
		{
			Object result = fields[i].get(obj);
			if (result != null)
				json.put(fields[i].getName(), getResult(result));
		}

		Field.setAccessible(fields, false);
		return json;
	}

	private JSONObject toJSONObject(Map map)
		throws Exception
	{
		JSONObject json = new JSONObject();
		@SuppressWarnings("rawtypes")
		Set keys = map.keySet();
		for (@SuppressWarnings("rawtypes")
		Iterator ite = keys.iterator(); ite.hasNext();)
		{
			String key = (String)ite.next();
			Object result = map.get(key);
			if (result != null)
				json.put(key, getResult(result));
		}

		return json;
	}

	private String dateToString(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
		return sdf.format(date);
	}

	@SuppressWarnings("rawtypes")
	private Object getResult(Object result)
		throws Exception
	{
		if (result instanceof Collection)
			result = toJSONArray((Collection)result);
		else
		if (result instanceof Map)
			result = toJSONObject((Map)result);
		else
		if (result.getClass().toString().contains(ENTITY_PATH))
			result = toJSONObject(result);
		else
		if (Date.class.equals(result.getClass()))
			result = dateToString((Date)result);
		else
			result = result.toString();
		return result;
	}

}
