package com.topfactors.form;

import java.io.Serializable;

public class RegisterArgs implements Serializable {

    private String username;
    private String fullName;
    private String password;
    private String phoneNumber;

    public RegisterArgs(String username, String fullName, String password, String phoneNumber) {
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public RegisterArgs() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "RegisterArgs{" +
                "username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
