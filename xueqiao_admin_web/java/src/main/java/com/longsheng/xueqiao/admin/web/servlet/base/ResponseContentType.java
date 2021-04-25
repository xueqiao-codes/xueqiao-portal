package com.longsheng.xueqiao.admin.web.servlet.base;

public enum ResponseContentType {

	TEXT_XML(1), TEXT_HTML(2), JSON(3);
	
	private int value;

    private ResponseContentType(int value) {
            this.value = value;
    }

    public int getValue(){
    	return value;
    }
    
    public String getContentType(){
    	if(value == 1)
    	{
    		return "text/xml;charset=UTF-8";
    	}
    	if(value == 2)
    	{
    		return "application/x-www-form-urlencoded; text/html; charset=utf-8";
    	}
    	if(value == 3)
    	{
    		return "application/json;charset=UTF-8";
    	}
    	return null;
    }
}
