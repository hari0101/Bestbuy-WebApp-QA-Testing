package com.utilities.Datadriven;

import org.testng.annotations.DataProvider;

public class JsonDataProvider {

	//==================================== FIELDS & CONSTRUCTOR ====================================
	private JsonUtils util;
	private static String jsonpath = "./src/test/resources/dataprovider.json"; 
	
	public JsonDataProvider() {
		util = new JsonUtils(jsonpath);
	}
	//=========================================== METHODS ===========================================
	
	@DataProvider(name = "logintest")
	public String[][] validLoginTestData() {
		return util.jsonArrayDataDriven("logintest", "username", "password");
	}
	

	
}
