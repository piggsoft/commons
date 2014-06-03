package com.piggsoft.commons.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.LocaleUtils;
import org.apache.commons.lang.StringUtils;

import com.piggsoft.commons.web.helper.RequestHelper;
import com.piggsoft.commons.web.helper.ResponseHelper;


public class WebUtils {
	
	/**
	 * 默认皮肤
	 * {@value}
	 */
	public static final String DEFAULT_SKIN = "default";
	/**
	 * 皮肤session key
	 * {@value}
	 */
	public static final String WEB_SKIN_SESSION_KEY = "default";
	/**
	 * session中存放locale的key
	 * {@value}
	 */
	public static final String SESSION_STRUTS_LOCALE_KEY = "WW_TRANS_I18N_LOCALE";
	/**
	 * cookie中存放locale的key
	 * {@value}
	 */
	public static final String COOKIE_LOCALE_KEY = "cookie_locale";
	/**
	 * 默认locale的字符串
	 * {@value}
	 */
	public static final String DEFAULT_LOCALE = "zh_CN";
	/**
	 * 默认资源文件的目录
	 * {@value}
	 */
	public static final String DEFAULT_RESOURCE_HOME = "resource";
	/**
	 * 默认theme文件的目录
	 * {@value}
	 */
	public static final String DEFAULT_THEME_HOME = "theme";
	/**
	 * 默认theme文件的目录
	 * {@value}
	 */
	public static final String DEFAULT_THEME_IMG_HOME = "images";
	/**
	 * 默认CSS文件的目录
	 * {@value}
	 */
	public static final String DEFAULT_CSS_HOME = "css";
	/**
	 * 默认SCRIPT文件的目录
	 * {@value}
	 */
	public static final String DEFAULT_SCRIPT_HOME = "script";
	
	/**
	 * 返回当前网站皮肤
	 */
	public static String getSkin(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			String skin = (String) session.getAttribute(WEB_SKIN_SESSION_KEY);
			if (skin != null) {
				return skin;
			}
		}
		return DEFAULT_SKIN;
	}
	
	public static String getCurrentLocale(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (null != session.getAttribute(SESSION_STRUTS_LOCALE_KEY)) {
			return session.getAttribute(SESSION_STRUTS_LOCALE_KEY).toString();
		}
		
		String cookieLocale = getCurrentLocaleByCookie(request, session);
		if (StringUtils.isNotEmpty(cookieLocale)) {
			return cookieLocale;
		}
			
		
		session.setAttribute(SESSION_STRUTS_LOCALE_KEY, LocaleUtils.toLocale(DEFAULT_LOCALE));
		return DEFAULT_LOCALE;
	}

	public static String getCurrentLocaleByCookie(HttpServletRequest request,
			HttpSession session) {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if (null != name && COOKIE_LOCALE_KEY.equals(name)) {
				String locale = cookie.getValue();
				session.setAttribute(SESSION_STRUTS_LOCALE_KEY, LocaleUtils.toLocale(locale));
				return cookie.getValue();
			}
		}
		return null;
	}
	
	public static void addLocaleCookie(HttpServletResponse response) {
		ResponseHelper responseHelper = new ResponseHelper(response);
		responseHelper.addCookie(COOKIE_LOCALE_KEY, DEFAULT_LOCALE);
	}
	
	/**
	 * 返回上下文路径
	 */
	public static String getWebContextRelativePath(HttpServletRequest request,
			String relativePath) {
		RequestHelper requestHelper = new RequestHelper(request);
		return requestHelper.getWebContextRelativePath(relativePath);
	}
	
	public static String getCssPath(HttpServletRequest request) {
		return getWebContextRelativePath(request, 
				DEFAULT_RESOURCE_HOME + "/" + DEFAULT_THEME_HOME + "/" + DEFAULT_SKIN + "/" 
					+ getCurrentLocale(request) + "/" + DEFAULT_CSS_HOME);
	}
	
	public static String getThemeImgPath(HttpServletRequest request, String relativePath) {
		return getWebContextRelativePath(request, 
				DEFAULT_RESOURCE_HOME + "/" + DEFAULT_THEME_HOME + "/" + DEFAULT_SKIN + "/" 
					+ getCurrentLocale(request) + "/" + DEFAULT_THEME_IMG_HOME);
	}
	
	public static String getScirptPath(HttpServletRequest request, String relativePath) {
		return getWebContextRelativePath(request, 
				DEFAULT_RESOURCE_HOME + "/" + DEFAULT_SCRIPT_HOME);
	}
	
	public static String getPath(String parent, String path) {
		if (StringUtils.isEmpty(parent)) {
			return path;
		}
		if (parent.matches(".*\\/$") || parent.matches(".*\\\\$")) {
			return parent + path;
		}
		return parent + "/" + path;
	}
	
}
