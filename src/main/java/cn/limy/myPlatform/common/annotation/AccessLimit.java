package cn.limy.myPlatform.common.annotation;

import java.lang.annotation.*;

/**
 * @author mijiupro
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Inherited
@Documented
public @interface AccessLimit {
    int limit() default 10; // 限流阈值
    int seconds() default 60; // 时间窗口
}
