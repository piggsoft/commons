package com.piggsoft.commons.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.piggsoft.commons.web.helper.RequestHelper;
import com.piggsoft.commons.web.helper.ResponseHelper;

/**
 * 
 * @author piggsoft@163.com
 * @version 1.0.0
 * @since 2014/2/13
 */
public abstract class AbstractServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 280595192152192132L;
	
	protected ResponseHelper responseHelper;;
	
	protected RequestHelper requestHelper;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.requestHelper = new RequestHelper(request);
		this.responseHelper = new ResponseHelper(response);
		super.service(request, response);
	}

}
