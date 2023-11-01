package com.andrepixel.backend_blog.dtos;

import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ExceptionResponseCustomizedDTO {
    private int httpStatus;
    private String message;
    private StackTraceElement[] errors;

    public ExceptionResponseCustomizedDTO(
            int httpStatus,
            String message,
            StackTraceElement[] errors
    ) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.errors = errors;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public StackTraceElement[] getErrors() {
        return errors;
    }

    public void setErrors(StackTraceElement[] errors) {
        this.errors = errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ExceptionResponseCustomizedDTO that =
                (ExceptionResponseCustomizedDTO) o;
        return httpStatus == that.httpStatus && Objects.equals(
                message,
                that.message
        ) && Arrays.equals(
                errors,
                that.errors
        );
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(
                httpStatus,
                message
        );
        result = 31 * result + Arrays.hashCode(errors);
        return result;
    }

    @Override
    public String toString() {
        return "ExceptionResponseCustomizedDTO{" + "httpStatus=" + httpStatus +
                ", message='" + message + '\'' + ", errors=" +
                Arrays.toString(errors) + '}';
    }
}
