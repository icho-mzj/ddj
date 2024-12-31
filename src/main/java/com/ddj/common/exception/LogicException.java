package com.ddj.common.exception;

import lombok.Getter;

/**
 * @Author: icho
 * @Date: 2024/10/9 17:05
 * @Describe: 业务异常
 */
public class LogicException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    @Getter
    private Integer code;

    /**
     * 错误提示
     */
    private String message;

    /**
     * 错误明细，内部调试错误
     *
     * 和 {@link CommonResult#getDetailMessage()} 一致的设计
     */
    @Getter
    private String detailMessage;

    /**
     * 空构造方法，避免反序列化问题
     */
    public LogicException()
    {
    }

    public LogicException(String message)
    {
        this.message = message;
    }

    public LogicException(String message, Integer code)
    {
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage()
    {
        return message;
    }

    public LogicException setMessage(String message)
    {
        this.message = message;
        return this;
    }

    public LogicException setDetailMessage(String detailMessage)
    {
        this.detailMessage = detailMessage;
        return this;
    }
}
