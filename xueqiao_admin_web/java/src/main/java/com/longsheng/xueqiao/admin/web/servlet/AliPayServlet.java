package com.longsheng.xueqiao.admin.web.servlet;

import com.longsheng.xueqiao.admin.web.servlet.base.WebMethodServlet;
import com.longsheng.xueqiao.admin.web.servlet.method.AlipayDone;

public class AliPayServlet extends WebMethodServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8245032442902331790L;

	public AliPayServlet() {
		super();
		setMethod(new AlipayDone());
	}

}
