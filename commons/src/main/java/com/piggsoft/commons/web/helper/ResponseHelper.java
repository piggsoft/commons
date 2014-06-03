package com.piggsoft.commons.web.helper;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


/**
 * 
 * @author piggsoft@163.com
 * @version 1.0.0
 * @since 2014/2/13
 */
public class ResponseHelper {
	
	/**
	 * response默认字符集 :
	 * {@value}
	 */
	public static final String RESPONSE_DEFAULT_ENCODING = "UTF-8";
	
	/**
	 * response默认文件格式 :
	 * {@value}
	 */
	public static final String RESPONSE_DEFAULT_TYPE = "text/html";
	
	/**
	 * cookie默认超时时间
	 * 30天
	 */
	public static int COOKIE_DEFAULT_MAX_TIME = 30 * 24 * 60 * 60;
	
	/**
	 * response通用返回值--正常:
	 * {@value}
	 */
	public static final String RESPONSE_OK = "ok";
	/**
	 * response通用返回值--非正常:
	 * {@value}
	 */
	public static final String RESPONSE_KO = "ko";
	
	private HttpServletResponse response;
	
	public ResponseHelper(HttpServletResponse response) {
		this.response = response;
	}
	
	/**
	 * 
	 * @param response {@link HttpServletResponse}
	 * @param content 内容
	 * @param encoding 字符集
	 * @param type 写出的类型
	 * @throws IOException
	 */
	public void response(String content, String encoding, String type) throws IOException {
		response.reset();
		response.setCharacterEncoding(encoding);
		response.setContentType(type + ";charset=" + encoding);
		response.getWriter().print(content);
		response.getWriter().flush();
	}
	
	/**
	 * 
	 * @param response {@link HttpServletResponse}
	 * @param content 内容
	 * @throws IOException
	 */
	public void response(String content) throws IOException {
		response(content, RESPONSE_DEFAULT_ENCODING, RESPONSE_DEFAULT_TYPE);
	}
	
	/**
	 * 
	 * @param response {@link HttpServletResponse}
	 * @param content 内容
	 * @param type 写出的类型
	 * @throws IOException
	 */
	public void response(String content, String type) throws IOException {
		response(content, RESPONSE_DEFAULT_ENCODING, type);
	}
	
	/**
	 * 加入Cookie
	 * @param name
	 * @param value
	 * <br>see also {@link ResponseHelper#addCookie(String, String, int)}
	 */
	public void addCookie(String name, String value) {
		addCookie(name, value, COOKIE_DEFAULT_MAX_TIME);
	}
	
	/**
	 * 加入Cookie
	 * @param name
	 * @param value
	 * @param maxAge 超时时间单位：秒
	 */
	public void addCookie(String name, String value, int maxAge) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
}
