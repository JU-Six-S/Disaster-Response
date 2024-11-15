package com.jusixs.ndrs.util;

/**
 * A utility class representing the result of an operation, encapsulating success or failure states.
 * This class is used throughout the National Disaster Response System (NDRS) project to standardize
 * the handling of operation outcomes.
 *
 * @param <T> the type of data contained in the result if the operation is successful
 *
 * <p>Author: Sadman</p>
 */
public class Result<T> {

    private T data;
    private String errorMessage;
    private boolean isSuccess;

    /**
     * Private constructor for creating a result instance.
     *
     * @param data the data associated with a successful operation
     * @param errorMessage the error message associated with a failed operation
     * @param isSuccess a boolean indicating whether the operation was successful
     */
    private Result(T data, String errorMessage, boolean isSuccess) {
        this.data = data;
        this.errorMessage = errorMessage;
        this.isSuccess = isSuccess;
    }

    /**
     * Creates a successful result containing the provided data.
     *
     * @param data the data associated with the successful operation
     * @param <T> the type of the data
     * @return a {@link Result} object representing a successful operation
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(data, null, true);
    }

    /**
     * Creates a failed result containing the provided error message.
     *
     * @param errorMessage the error message associated with the failed operation
     * @param <T> the type of the data (typically null in case of failure)
     * @return a {@link Result} object representing a failed operation
     */
    public static <T> Result<T> failure(String errorMessage) {
        return new Result<>(null, errorMessage, false);
    }

    /**
     * Retrieves the data from a successful result.
     *
     * @return the data of type {@code T}, or {@code null} if the operation failed
     */
    public T getData() {
        return data;
    }

    /**
     * Retrieves the error message from a failed result.
     *
     * @return the error message, or {@code null} if the operation was successful
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Indicates whether the operation was successful.
     *
     * @return {@code true} if the operation was successful, {@code false} otherwise
     */
    public boolean isSuccess() {
        return isSuccess;
    }
}
