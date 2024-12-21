package com.jojo.boot.springbootmdc.config;

public class R<T> {

    private String traceKey;
    private T data;
    private String message;
    private int code;

    // 私有构造函数，确保使用工厂方法创建
    private R(T data, String traceKey, String message, int code) {
        this.data = data;
        this.traceKey = traceKey;
        this.message = message;
        this.code = code;
    }

    // 静态工厂方法，构建成功响应
    public static <T> R<T> success(T data, String traceKey) {
        return new R<>(data, traceKey, "success", 200);
    }

    // 访问器和修改器
    public String getTraceKey() {
        return traceKey;
    }

    public void setTraceKey(String traceKey) {
        this.traceKey = traceKey;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "R{" +
                "traceKey='" + traceKey + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                ", code=" + code +
                '}';
    }

}
