package com.lib.ioc.view.annomation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import android.view.View;

/**
 * 事件注解.
 * 被注解的方法必须具备一下形式:
 * 1. private 修饰
 * 2. 返回值类型没有要求
 * 3. 方法名以Click或Event结尾, 否则可能被混淆编译时删除. (方法签名形式为void *(android.view.View)也可以)
 * 4. 参数签名和type的接口要求的参数签名一致.(传参一样)
 * @author fatenliyer
 * @date 2016-1-2
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Event {
	 /**
     * 控件的id集合, id小于1时不执行ui事件绑定.
     * 绑定的内容
     * @return
     */
    int[] value();

    /**
     * 控件的parent控件的id集合, 组合为(value[i], parentId[i] or 0).
     *
     * @return
     */
    int[] parentId() default 0;

    /**
     * 事件的listener, 默认为点击事件.
     *
     * @return
     */
    Class<?> type() default View.OnClickListener.class;

    /**
     * 事件的setter方法名, 默认为set+type#simpleName.
     *
     * @return
     */
    String setter() default "";

    /**
     * 如果type的接口类型提供多个方法, 需要使用此参数指定方法名.
     *
     * @return
     */
    String method() default "";
}
