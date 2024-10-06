package com.ddj.common.constant;

import com.ddj.common.DateUtils;

import javax.xml.ws.Response;
import java.util.Date;
import java.util.Objects;

/**
 * @Author: icho
 * @Date: 2024/10/4 14:41
 * @Describe:
 */

public class ResponseEntity<T> {

    /**
     * 返回结果状态码
     */
    private Integer code;

    /**
     * 返回结果状态信息
     */
    private String message;

    /**
     * 返回主体数据
     */
    private T data;

    protected ResponseEntity() {

    }

    protected ResponseEntity(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 构造通用成功返回工厂方法
     *
     * @return
     */
    public static <T> ResponseEntity<T> ok() {
        return ResponseEntity.ok((T) DateUtils.DateToString(null));
    }

    /**
     * 构造通用成功返回{@link Response Response}工厂方法
     *
     * @return {@link Response Response}
     */
    public static <T> ResponseEntity<T> ok(T data) {
        return ResponseEntity.of(BaseResponseStatus.SUCCESS_CODE, BaseResponseStatus.SUCCESS_MESSAGE, data);
    }

    /**
     * 构造通用失败返回工厂方法
     *
     * @return
     */
    public static <T> ResponseEntity<T> error() {
        return ResponseEntity.error(null);
    }

    /**
     * 构造通用失败返回工厂方法
     *
     * @param message 返回消息
     * @return
     */
    public static <T> ResponseEntity<T> error(String message) {
        return ResponseEntity.of(BaseResponseStatus.ERROR_CODE, message);
    }

    /**
     * 构造通用失败返回工厂方法
     *
     * @param code    返回状态码
     * @param message 返回消息
     * @return
     */
    public static <T> ResponseEntity<T> error(Integer code, String message) {
        return ResponseEntity.of(code, message);
    }

    /**
     * 构造{@link Response Response}工厂方法
     *
     * @param code    自定义返回码
     * @param message 自定义返回消息
     * @return {@link Response Response}
     */
    public static <T> ResponseEntity<T> of(Integer code, String message) {
        return ResponseEntity.<T>builder()
                .code(code)
                .message(message)
                .data(null)
                .build();
    }

    /**
     * 构造{@link Response Response}工厂方法
     *
     * @param code    自定义返回码
     * @param message 自定义返回消息
     * @param data    返回数据
     * @return {@link Response Response}
     */
    public static <T> ResponseEntity<T> of(int code, String message, T data) {
        return ResponseEntity.<T>builder()
                .code(code)
                .message(message)
                .data(data)
                .build();
    }

    /**
     * 构造{@link Response Response}工厂方法
     *
     * @param status 自定义返回格式
     * @param data   返回数据
     * @return {@link Response Response}
     */
    public static <T> ResponseEntity<T> of(BaseResponseStatus status, T data) {
        return ResponseEntity.<T>builder()
                .code(status.getCode())
                .message(status.getMessage())
                .data(data)
                .build();
    }

    public ResponseEntity(Builder<T> tBuilder) {
        this.code = tBuilder.code;
        this.message = tBuilder.message;
        this.data = tBuilder.data;
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public static <T> Builder<T> builder(ResponseEntity<T> Response) {
        Builder<T> builder = new Builder<>();
        builder.code = Response.code;
        builder.message = Response.message;
        builder.data = Response.data;
        return builder;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseEntity<?> Response = (ResponseEntity<?>) o;
        return Objects.equals(getCode(), Response.getCode())
                && Objects.equals(getMessage(), Response.getMessage())
                && Objects.equals(getData(), Response.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getMessage(), getData());
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class Builder<T> {
        private Integer code;
        private String message;
        private T data;

        private Builder() {
        }

        public Builder<T> code(Integer code) {
            this.code = code;
            return this;
        }

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public ResponseEntity<T> build() {
            return new ResponseEntity<>(this);
        }

    }

    /**
     * Base响应状态接口
     */
    public interface BaseResponseStatus {

        int SUCCESS_CODE = 200;
        int ERROR_CODE = 500;

        String SUCCESS_MESSAGE = "成功";
        String ERROR_MESSAGE = "失败";

        /**
         * 获取状态码
         */
        Integer getCode();

        /**
         * 获取返回信息
         */
        String getMessage();

    }

    public enum ResponseStatus implements BaseResponseStatus {

        /**
         * 200 成功 使用约定的成功状态码
         */
        SUCCESS(BaseResponseStatus.SUCCESS_CODE, BaseResponseStatus.SUCCESS_MESSAGE),

        /**
         * 500 异常 使用约定的失败状态码
         */
        ERROR(BaseResponseStatus.ERROR_CODE, BaseResponseStatus.ERROR_MESSAGE),

        /**
         * 参数错误
         */
        ILLEGAL_ARGUMENT(400, "参数错误"),

        UNAUTHORIZED(401, "未认证"),

        FORBIDDEN(403, "未授权"),

        WRONG_PASSWORD(411, "账号或密码错误"),

        ACCOUNT_DISABLED(412, "账号已被禁用"),
        ;

        ResponseStatus(Integer code, String msg) {
            this.code = code;
            this.message = msg;
        }

        @Override
        public Integer getCode() {
            return code;
        }

        @Override
        public String getMessage() {
            return message;
        }

        /**
         * 返回状态码,{@link ResponseStatus#SUCCESS_CODE SUCCESS(200)}表示成功
         */
        private final Integer code;

        /**
         * 返回描述信息
         */
        private final String message;
    }
}

