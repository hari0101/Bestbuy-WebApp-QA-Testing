package com.utilities.Constants;

public enum PlatformType {
	
	WINDOWS("windows"),
	LINUX("linux"),
	MACOS("macos");
	
	private final String platformType;
	
	PlatformType(String platformType) {
		this.platformType = platformType;
	}
	
	public String getPlatformName() {
		return platformType;
	}
	
}
