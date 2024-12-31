package com.ddj.common.aspect;

import java.lang.annotation.*;

/**
 * @Author: icho
 * @Date: 2024/10/9 20:57
 * @Describe: 匿名访问不鉴权注解
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Anonymous
{
}
