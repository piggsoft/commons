/**
 * 
 */
package com.piggsoft.commons.tag;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.piggsoft.commons.web.WebUtils;

/**
 * @author piggsoft@gmail.com
 *
 */
public class ScriptTag extends ElementTag{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ScriptTag.class);
	
	private static final String ELEMENT_START = "<script ";
	
	private static final String ELEMENT_END = " ></script>";
	
	private static final String SRC_NAME = "src";
	
	private String src;

	/* (non-Javadoc)
	 * @see com.piggsoft.commons.tag.ElementTag#getElementHead()
	 */
	@Override
	public String getElementStart() {
		return ELEMENT_START;
	}

	/* (non-Javadoc)
	 * @see com.piggsoft.commons.tag.ElementTag#getElementEnd()
	 */
	@Override
	public String getElementEnd() {
		return ELEMENT_END;
	}

	/* (non-Javadoc)
	 * @see com.piggsoft.commons.tag.ElementTag#getInitAttribute()
	 */
	@Override
	protected String getInitAttribute() {
		return getAttribute("type", "text/javascript");
	}

	/* (non-Javadoc)
	 * @see com.piggsoft.commons.tag.ElementTag#processAttribute()
	 */
	@Override
	public String processAttribute() {
		if (StringUtils.isEmpty(src)) {
			LOGGER.error("src can not be empty");
		}
		return getAttribute(SRC_NAME, WebUtils.getScirptPath(getRequest(), src));
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

}
