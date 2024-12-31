package com.ddj.common.aspect;

import java.lang.annotation.*;

/**
 * @Author: icho
 * @Date: 2024/10/9 17:42
 * @Describe:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataScope {
    /**
     * 部门表的别名
     */
    public String deptAlias() default "";

    /**
     * 用户表的别名
     */
    public String userAlias() default "";

    /**
     * 权限字符（用于多个角色匹配符合要求的权限）默认根据权限注解@ss获取，多个权限用逗号分隔开来
     */
    public String permission() default "";
}
