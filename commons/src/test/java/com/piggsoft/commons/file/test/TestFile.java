/**
 * 
 */
package com.piggsoft.commons.file.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import com.piggsoft.commons.utils.FileCopyUtils;
import com.piggsoft.commons.utils.ResourceUtils;

/**
 * @author piggsoft@gmail.com
 *
 */
public class TestFile {
	@Test
	public void test1() throws FileNotFoundException, IOException {
		String s = "";
		s = FileCopyUtils.copyToString(new FileReader(ResourceUtils.getFile("classpath:logback.xml")));
		System.out.println(s);
	}
}
