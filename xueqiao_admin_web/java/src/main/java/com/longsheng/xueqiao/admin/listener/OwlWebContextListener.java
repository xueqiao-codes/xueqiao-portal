package com.longsheng.xueqiao.admin.listener;

import javax.servlet.ServletContextEvent;

import org.soldier.platform.web_framework.WebContextListener;

public class OwlWebContextListener extends WebContextListener {
	@Override
	public String getLoggerName() {
		return "xueqiao_admin_web";
	}

	@Override
	public void contextInitialized(ServletContextEvent context) {
		super.contextInitialized(context);
	}

	@Override
	public void contextDestroyed(ServletContextEvent context) {
		super.contextDestroyed(context);
	}
}
