package com.edexsoft.framework.security;

public enum EnumUserState {
	ACTIVE("Active"), INACTIVE("Inactive"), DELETED("Deleted"), LOCKED("Locked");

	private String state;

	private EnumUserState(final String state){
        this.state = state;
    }

	public String getState() {
		return this.state;
	}

	@Override
	public String toString() {
		return this.state;
	}

	public String getName() {
		return this.name();
	}
}
