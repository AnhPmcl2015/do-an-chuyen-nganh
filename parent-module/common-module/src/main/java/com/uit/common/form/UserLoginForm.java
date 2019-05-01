package com.uit.common.form;

import java.io.Serializable;

public class UserLoginForm implements Serializable {

	private static final long serialVersionUID = 1947147147882251269L;

	private String phoneNumber;
	private String password;

	public UserLoginForm(String phoneNumber, String password) {
		super();
		this.phoneNumber = phoneNumber;
		this.password = password;
	}

	public UserLoginForm() {
		super();
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
