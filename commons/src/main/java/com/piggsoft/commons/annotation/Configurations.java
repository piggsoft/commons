/**
 * 
 */
package com.piggsoft.commons.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author piggsoft@gmail.com
 *
 */
@Retention(RUNTIME)
/**@Retention 定义了该Annotation被保留的时间长短：某些Annotation仅出现在源代码中，
 * 而被编译器丢弃；而另一些却被编译在class文件中；
 * 编译在class文件中的Annotation可能会被虚拟机忽略，
 * 而另一些在class被装载时将被读取（请注意并不影响class的执行，因为Annotation与class在使用上是被分离的）。
 * 使用这个meta-Annotation可以对 Annotation的“生命周期”限制。**/
@Target({TYPE})
/**@Target 说明了Annotation所修饰的对象范围：
 * Annotation可被用于 packages、types（类、接口、枚举、Annotation类型）、
 * 类型成员（方法、构造方法、成员变量、枚举值）、方法参数和本地变量（如循环变量、catch参数）。
 * 在Annotation类型的声明中使用了target可更加明晰其修饰的目标。**/
@Documented
/**@Documented 用于描述其它类型的annotation应该被作为被标注的程序成员的公共API，
 * 因此可以被例如javadoc此类的工具文档化。Documented是一个标记注解，没有成员。**/

/**@Inherited 元注解是一个标记注解，@Inherited阐述了某个被标注的类型是被继承的。
 * 如果一个使用了@Inherited修饰的annotation类型被用于一个class，
 * 则这个annotation将被用于该class的子类。**/
public @interface Configurations {
	public String file();
	public int id() default -1; 
}
