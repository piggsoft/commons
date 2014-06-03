package com.piggsoft.commons.annotation;

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Target({ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD })
public @interface Test {
	String name();
	int id() default 0;
	Class<Long> gid();
}
