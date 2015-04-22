package com.piggsoft.commons.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public abstract class ElementTag extends SimpleTagSupport {

	protected String quote = "\'";

	protected String doubleQuote = "\"";

	protected String equals = "=";

	protected String whiteSpace = " ";

	public abstract String getElementStart();

	public abstract String getElementEnd();

	@Override
	public void doTag() throws JspException, IOException {
		StringBuilder element = new StringBuilder(getElementStart());

		element.append(getInitAttribute());

		element.append(processAttribute());

		element.append(getElementEnd());

		getJspContext().getOut().write(element.toString());

		super.doTag();
	}

	protected abstract String getInitAttribute();

	protected String getAttribute(String attrName, String attrValue) {
		if (attrValue != null && !"".equals(attrValue)) {
			return whiteSpace + attrName + equals + doubleQuote + attrValue
					+ doubleQuote + whiteSpace;
		}
		return "";
	}

	public abstract String processAttribute();

	protected PageContext getPageContext() {
		return (PageContext) this.getJspContext();
	}
	
	protected HttpServletRequest getRequest() {
		return (HttpServletRequest) getPageContext().getRequest();
	}
	
	protected HttpServletResponse getResponse() {
		return (HttpServletResponse) getPageContext().getResponse();
	}
}
