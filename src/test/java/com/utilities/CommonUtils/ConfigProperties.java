package com.utilities.CommonUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ConfigProperities.class will load the properites file from the path
 */
public class ConfigProperties {
	
	//==================================== FIELDS & CONSTRUCTOR ====================================
	private static Properties prop = null;
	
	//=========================================== METHODS ===========================================
	
	//load properties will load the properties file and accessable their key:value
	public static Properties loadProperties(String filename) {
		try {
			
			if(prop == null) {
			prop = new Properties();
			FileInputStream stream = new FileInputStream("./src/test/resources/" +filename+ ".properties");
			prop.load(stream);
			}
		}
		catch (IOException io) {
			System.out.println("Unable to read the Properties File : " + io.getMessage());
			io.printStackTrace();
		}
		
		return prop;
	}
	



}
