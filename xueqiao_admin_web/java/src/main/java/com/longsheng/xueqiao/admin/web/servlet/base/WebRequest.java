package com.longsheng.xueqiao.admin.web.servlet.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.fileupload.FileItem;


public class WebRequest {
	private Map<String, String[]> parametersMap;
	private byte[] content;
	private List<FileItem> fileItems;
	private String contentType;
	private String ipAddress;
	
	public WebRequest() {
		parametersMap = new HashMap<String, String[]>();
	}
	
	public Map<String, String[]> getParameters() {
		return parametersMap;
	}
	
	public void setMultiParameters(Map<String, String[]> parameters) {
		if (parameters == null) {
			return ;
		}
		for (Entry<String, String[]> parameter : parameters.entrySet()) {
			parametersMap.put(parameter.getKey(), parameter.getValue());
		}
	}
	
	public void setParameters(Map<String, String> parameters) {
		if (parameters == null) {
			return ;
		}
		for (Entry<String, String> parameter : parameters.entrySet()) {
			setParameter(parameter.getKey(), parameter.getValue());
		}
	}
	
	public void setParameter(String key, String value) {
		parametersMap.put(key, new String[]{value});
	}
	
	public void setParameter(String key, String[] values) {
		parametersMap.put(key, values);
		
	}
	
	public byte[] getContent() {
		return content;
	}
	
	public void setContent(byte[] content) {
		this.content = content;
	}
	
	public void addFileItem(FileItem item) {
		if (fileItems == null) {
			fileItems = new ArrayList<FileItem>();
		}
		fileItems.add(item);
	}
	
	public List<FileItem> getFileItems() {
		return this.fileItems;
	}
	
	public String getParameter(String key) {
		String[] listResult = parametersMap.get(key);
		if(listResult == null || listResult.length < 1){
			return null;
		}
		return listResult[0];
	}
	
	public String getParameterNotNull(String key) {
		String result = getParameter(key);
		if(result == null){
			throw new IllegalArgumentException(key + " is not exists!");
		}
		return result;
	}
	
	public String getParameter(String key, String defaultValue) {
		String value = getParameter(key);
		if (value == null) {
			return defaultValue;
		}
		return value;
	}
	
	public long getLong(String key) {
		try {
			return Long.parseLong(getParameterNotNull(key));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(key + " format error, should be long number");
		}
	}
	
	public double getDouble(String key){
			try {
				return Double.parseDouble(getParameterNotNull(key));
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException(key + " format error, should be double number");
			}
	}
	
	public double getDouble(String key, double defaultValue) {
		String value = getParameter(key);
		if (value == null) {
			return defaultValue;
		}
		
		try {
			return Double.parseDouble(getParameterNotNull(key));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(key + " format error, should be double number");
		}
	}
	
	public long getLong(String key, long defaultValue) {
		String value = getParameter(key);
		if (value == null) {
			return defaultValue;
		}
		
		try {
			return Long.parseLong(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(key + " format error, should be long number");
		}
	}
	
	public int getInt(String key) {
		try {
			return Integer.parseInt(getParameterNotNull(key));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(key + " format error, should be int number");
		}
	}
	
	public int getInt(String key, int defaultValue) {
		String value = getParameter(key);
		if (value == null) {
			return defaultValue;
		}
		
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(key + " format error, should be int number");
		}
	}
	
	public short getShort(String key) {
		try {
			return Short.parseShort(getParameterNotNull(key));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(key + " format error, should be short number");
		}
	}
	
	public short getShort(String key, short defaultValue) {
		String value = getParameter(key);
		if (value == null) {
			return defaultValue;
		}
		
		try {
			return Short.parseShort(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(key + " format error, should be short number");
		}
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
}
