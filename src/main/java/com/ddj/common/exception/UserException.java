package com.ddj.common.exception;

/**
 * @Author: icho
 * @Date: 2024/10/9 16:52
 * @Describe:
 */
public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
