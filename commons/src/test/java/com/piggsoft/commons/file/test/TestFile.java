/**
 * 
 */
package com.piggsoft.commons.file.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.piggsoft.commons.utils.FileCopyUtils;
import com.piggsoft.commons.utils.ResourceUtils;

/**
 * @author piggsoft@gmail.com
 *
 */
public class TestFile {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestFile.class);
	
	@Test
	public void test1() throws FileNotFoundException, IOException {
		String s = "";
		s = FileCopyUtils.copyToString(new FileReader(ResourceUtils.getFile("classpath:logback.xml")));
		LOGGER.info(s);
		LOGGER.info("中文测试");
	}
}
