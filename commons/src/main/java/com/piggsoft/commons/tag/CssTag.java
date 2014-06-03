package com.piggsoft.commons.tag;



import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.piggsoft.commons.web.WebUtils;


public class CssTag extends ElementTag{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CssTag.class);
	
	private String href;
	
	private static final String ELEMENT_HEAD = "<link ";
	
	private static final String ELEMENT_END = " ></link>";
	
	private static final String HREF_NAME = "href";
	
	@Override
	public String processAttribute() {
		if (StringUtils.isEmpty(href)) {
			LOGGER.error("href can not be empty");
		}
		return getAttribute(HREF_NAME, WebUtils.getPath(WebUtils.getCssPath(getRequest()), href));
	}
	
	@Override
	protected String getInitAttribute() {
		return getAttribute("rel", "stylesheet") + getAttribute("type", "text/css");
	}
	
	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	@Override
	public String getElementHead() {
		return ELEMENT_HEAD;
	}

	@Override
	public String getElementEnd() {
		return ELEMENT_END;
	}

}
