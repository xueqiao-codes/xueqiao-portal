package com.longsheng.xueqiao.admin.web.servlet.base;

/**
 * 值的包装数据类
 * @author wileywang
 *
 */
public class ValueResult<T> extends BaseResult {
	private T value;
	
	public ValueResult(T value){
		setValue(value);
	}
	
	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
}
