package com.piggsoft.commons.web.helper;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author piggsoft@163.com
 * @version 1.0.0
 * @since 2014/2/21
 */
public class RequestHelper {
	
	private HttpServletRequest request;
	
	public RequestHelper(HttpServletRequest request) {
		this.request = request;
	}
	
	public Object getHeaderParameter(String key) {
		return this.request.getHeader(key);
	}
	/*
	 * 返回上下文路径
	 */
	public String getWebContextRelativePath(String relativePath) {
		String contextPath = request.getContextPath();
		contextPath = contextPath + "/" + relativePath;
		contextPath = contextPath.replace("//", "/");
		return contextPath;
	}
}
