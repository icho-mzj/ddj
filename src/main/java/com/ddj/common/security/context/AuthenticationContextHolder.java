package com.ddj.common.security.context;

import org.springframework.security.core.Authentication;

/**
 * @Author: icho
 * @Date: 2024/10/9 17:04
 * @Describe:
 */
public class AuthenticationContextHolder {
    private static final ThreadLocal<Authentication> contextHolder = new ThreadLocal<>();

    public static Authentication getContext()
    {
        return contextHolder.get();
    }

    public static void setContext(Authentication context)
    {
        contextHolder.set(context);
    }

    public static void clearContext()
    {
        contextHolder.remove();
    }
}
