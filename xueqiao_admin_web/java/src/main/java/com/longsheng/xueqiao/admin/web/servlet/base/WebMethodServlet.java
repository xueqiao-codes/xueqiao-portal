package com.longsheng.xueqiao.admin.web.servlet.base;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.web_framework.util.GsonFactory;

public abstract class WebMethodServlet extends  HttpServlet {


	private WebMethod method;

	/**
	 * 
	 */
	private static final long serialVersionUID = 926417165392092709L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		entryProcess(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		entryProcess(request, response);
	}

	private void entryProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		long startTimestamp = System.currentTimeMillis();
		
		AppLog.i("WebMethodServlet ---- entryProcess ---- request : " + request.getParameterMap());
		
		Object result = null;
		
		try {
			result = method.runMethod(fillWebRequest(request));
		} catch (Exception e) {
			AppLog.e(e.getMessage(), e);
			throw new ServletException(e.getMessage(), e);
		}
		
		try {
			StringBuffer logBuffer = null;
			if (AppLog.infoEnabled()) {
				logBuffer = new StringBuffer(512);
				logBuffer.append("[timeEscape=");
				logBuffer.append((System.currentTimeMillis() - startTimestamp));
				logBuffer.append("ms]{");
				Enumeration<String> en = request.getParameterNames();
				while (en.hasMoreElements()) {
					String paramName = en.nextElement();
					logBuffer.append(paramName);
					logBuffer.append("=");
					String paramValue = request.getParameter(paramName);
					if (paramValue.length() > 512) {
						logBuffer.append(paramValue.substring(0, 64));
						logBuffer.append("......");
						logBuffer.append(paramValue.substring(paramValue
								.length() - 64));
					} else {
						logBuffer.append(paramValue);
					}
					logBuffer.append(" ");
				}
				logBuffer.append("} return ");
			}

			boolean isJsonHeader = true;
			if (method != null) {
				if (method.getContentType() == ResponseContentType.TEXT_XML) {
					response.setHeader("Content-Type", "text/xml;charset=UTF-8");
					isJsonHeader = false;
				} else if (method.getContentType() == ResponseContentType.TEXT_HTML) {
					response.setHeader("Content-Type",
							"text/html; charset=utf-8");
					isJsonHeader = false;
				} else {
					response.setHeader("Content-Type",
							"application/json;charset=UTF-8");
				}
			}

			if (AppLog.infoEnabled()) {
				StringBuffer jsonBuffer = new StringBuffer(512);
				GsonFactory.getGson().toJson(result, jsonBuffer);
				if (jsonBuffer.length() < 512) {
					logBuffer.append(jsonBuffer);
				} else {
					logBuffer.append(jsonBuffer.subSequence(0, 64));
					logBuffer.append("......");
					logBuffer
							.append(jsonBuffer.substring(jsonBuffer.length() - 64));
				}
				AppLog.i(logBuffer.toString());
			}

			if (isJsonHeader) {
				GsonFactory.getGson().toJson(result, response.getWriter());
			} else {
				if (result instanceof BaseResult) {
					GsonFactory.getGson().toJson(result, response.getWriter());
				} else {
					AppLog.d("not json:" + result.toString());
					response.getWriter().write(result.toString());
				}
			}

		} catch (Exception e) {
			AppLog.e(e.getMessage(), e);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	private WebRequest fillWebRequest(HttpServletRequest request)
			throws Exception {

		WebRequest webRequest = new WebRequest();
		webRequest.setMultiParameters(request.getParameterMap());
		
		AppLog.i("WebMethodServlet ---- fillWebRequest ---- request.getParameterMap() : " + request.getParameterMap().toString());
		
		String realIP = request.getHeader("X-Forwarded-For");
		realIP = realIP != null ? realIP : request.getHeader("X-Real-IP");

		int index = realIP.indexOf(',');
		if (index != -1) {
			realIP = realIP.substring(0, index);
		}
		webRequest.setIpAddress(realIP != null ? realIP : request
				.getRemoteAddr());

		if (request.getMethod().equalsIgnoreCase("POST")) {
			if (request.getContentType() != null) {
				
				AppLog.d("request.getContentType(): "+request.getContentType());
				
				
				if (request.getContentType().startsWith("application/json")) {
					webRequest.setContent(IOUtils.toByteArray(request
							.getInputStream()));
				} else if (request.getContentType().startsWith(
						"multipart/form-data")) {
					if (ServletFileUpload.isMultipartContent(request)) {
						FileItemFactory factory = new DiskFileItemFactory();
						ServletFileUpload upload = new ServletFileUpload(
								factory);
						Iterator<FileItem> items = upload.parseRequest(request)
								.iterator();// 将表单数据全部赋值给items
						while (items.hasNext()) {// while循环迭代items，得到所有的表单数据
							FileItem item = items.next();

							if (item.getFieldName().equals("token")) {
								webRequest.setParameter("token",
										item.getString("UTF-8"));
							} else {
								webRequest.addFileItem(item);
							}
						}
					}
				} else if (request.getContentType().startsWith("text/xml")) {
					webRequest.setContent(IOUtils.toByteArray(request
							.getInputStream()));
				}

			}
		}

		return webRequest;
	}

	public WebMethod getMethod() {
		return method;
	}

	public void setMethod(WebMethod method) {
		this.method = method;
	}

}
