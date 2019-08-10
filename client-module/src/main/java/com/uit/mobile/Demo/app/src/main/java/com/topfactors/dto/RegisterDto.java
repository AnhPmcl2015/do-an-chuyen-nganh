package com.topfactors.dto;

public class RegisterDto {
    private boolean success;
    private String message;

    public RegisterDto(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public RegisterDto() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "RegisterDto{" +
                "success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}
