package com.uit.common.dto;

import java.io.Serializable;

public class UserDetailDto implements Serializable {

	private static final long serialVersionUID = -82078927692570621L;

	private String fullName;
	private String imgPath;

	public UserDetailDto(String fullName, String imgPath) {
		super();
		this.fullName = fullName;
		this.imgPath = imgPath;
	}

	public UserDetailDto() {
		super();
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

}
