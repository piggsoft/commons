/**
 * 
 */
package com.piggsoft.commons.annotation.test;

import org.junit.Test;

import com.piggsoft.commons.annotation.Configurations;

/**
 * @author piggsoft@gmail.com
 *
 */
public class TestAnnotation {
	@Test
	public void test1() {
		Class<Model> clazz = Model.class;
		Configurations c = clazz.getAnnotation(Configurations.class);
		if (null != c) {
			System.out.println(c.file());
		}
	}
}
