package com.longsheng.xueqiao.admin.web.controller;

import org.soldier.platform.oa.user.ao.client.OaUserAoStub;
import org.soldier.platform.web_framework.CController;

/**
 *  主要用于外部鉴权，可以用于nginx的auth_request等
 * @author Xairy
 */
public class Auth extends CController {
	
	@Override
	protected void process() throws Exception {
		int userId = getUserId();
		String userName = getUserName();
		String secretKey = getSecretKey();
		if (userId <= 0 || userName.isEmpty() || secretKey.isEmpty()) {
			super.getServletResponse().sendError(401);
			return;
		}
		
		
		if (!new OaUserAoStub().checkSession(userId, 2000, userId, userName,
				secretKey)) {
			super.getServletResponse().sendError(401);
			return;
		}
		
		getServletResponse().setHeader("X-WEBAUTH-USER", userName);
		getServletResponse().setStatus(200);
		
	}
	
	protected int getUserId() {
		try {
			return Integer.parseInt(getCookie("oa_user_id", "0"));
		} catch (NumberFormatException e) {
			return 0;
		}
	}
	
	protected String getUserName() {
		return getCookie("oa_user_name", "");
	}
	
	protected String getSecretKey() {
		return getCookie("oa_user_secret", "");
	}
}
