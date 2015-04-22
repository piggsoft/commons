/**
 * 
 */
package com.piggsoft.commons;

import java.lang.reflect.Field;

/**
 * @author piggsoft@gmail.com
 *
 */
public class Test1 {
	public static void main(String[] args) throws Exception {
		Integer a1 = Integer.parseInt("2");
		Integer b1 = Integer.parseInt("2");
		System.out.println(a1 == b1);
		Integer a = new Integer(2);
		Integer b = new Integer(2);
		System.out.println(a == b);
        Class<?> cache = Integer.class.getDeclaredClasses()[0];
        Field c = cache.getDeclaredField("cache");
        c.setAccessible(true);
        Integer[] array = (Integer[]) c.get(cache);
        System.out.println(array[132]);
        System.out.println(array[133]);
        array[132] = array[133];

        System.out.printf("%d",2 + 2);
    }
}
