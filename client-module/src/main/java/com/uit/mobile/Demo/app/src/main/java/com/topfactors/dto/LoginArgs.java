package com.topfactors.dto;

public class LoginArgs {
    private String usernameOrPhoneNumber;
    private String password;

    public String getUsernameOrPhoneNumber() {
        return usernameOrPhoneNumber;
    }

    public void setUsernameOrPhoneNumber(String usernameOrPhoneNumber) {
        this.usernameOrPhoneNumber = usernameOrPhoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginArgs(String usernameOrPhoneNumber, String password) {
        this.usernameOrPhoneNumber = usernameOrPhoneNumber;
        this.password = password;
    }

    public LoginArgs() {

    }
}
