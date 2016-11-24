package com.edexsoft.framework.security;

public enum EnumUserProfileType {
	USER("USER"), MEMBER("MEMBER"), ADMIN("ADMIN");

	String userProfileType;

	private EnumUserProfileType(String userProfileType) {
		this.userProfileType = userProfileType;
	}

	public String getUserProfileType() {
		return userProfileType;
	}
}
