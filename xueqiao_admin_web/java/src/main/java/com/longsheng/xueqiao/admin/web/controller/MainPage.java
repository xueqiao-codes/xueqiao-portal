package com.longsheng.xueqiao.admin.web.controller;

public class MainPage extends OaAuthController {

	public void show() throws Exception {
		put("username", getUserName());
		render("sled_page.html");
	}

}
