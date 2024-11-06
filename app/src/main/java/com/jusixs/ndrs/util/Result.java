package com.jusixs.ndrs.util;

public class Result<T> {
    private T data;
    private String errorMessage;
    private boolean isSuccess;

    private Result(T data, String errorMessage, boolean isSuccess) {
        this.data = data;
        this.errorMessage = errorMessage;
        this.isSuccess = isSuccess;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(data, null, true);
    }

    public static <T> Result<T> failure(String errorMessage) {
        return new Result<>(null, errorMessage, false);
    }

    public T getData() { return data; }
    public String getErrorMessage() { return errorMessage; }
    public boolean isSuccess() { return isSuccess; }
}
