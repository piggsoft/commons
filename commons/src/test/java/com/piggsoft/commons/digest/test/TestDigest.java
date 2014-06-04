/**
 * 
 */
package com.piggsoft.commons.digest.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.piggsoft.commons.encrypt.Md5Encrypt;
import com.piggsoft.commons.utils.DigestUtils;

/**
 * @author piggsoft@gmail.com
 *
 */
public class TestDigest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TestDigest.class);
	
	@Test
	public void test() {
		String s = "123456q";
		long t1 = System.currentTimeMillis();
		String s1 = Md5Encrypt.encrypt(s);
		long t2 = System.currentTimeMillis();
		String s2 = DigestUtils.md5DigestAsHex(s.getBytes());
		long t3 = System.currentTimeMillis();
		LOGGER.info(""+((t2-t1) - (t3-t2)));
		LOGGER.info(s1);
		LOGGER.info(s2);
	}
	
	@Test
	public void test2() {
		int count = 100;
		for (int i=0; i < count; i++) {
			test();
		}
	}
}
