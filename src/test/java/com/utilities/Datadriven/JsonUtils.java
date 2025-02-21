package com.utilities.Datadriven;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

/**
 * JsonUtils.class helps to achieve the data-driven testing from the JSON file.
 */
public class JsonUtils {
	
	//==================================== FIELDS & CONSTRUCTOR ====================================
	private ObjectMapper jsonmapper;
	private JsonNode rootnode;
	
	public JsonUtils(String pathname) {
		jsonmapper = new ObjectMapper();
		try {
			rootnode = jsonmapper.readTree(new File(pathname));
		} 
		catch (IOException io) {
			System.out.println("Unable to read the JSON file : " + pathname);
			io.printStackTrace();
		}
	}
	
	//=========================================== METHODS ===========================================
	
	public String[][] jsonArrayDataDriven(String keyArrayValue, String keyValueFirst, String keyValueSecond) {
		/**
		 * @param keyArrayValue
		 * @param keyValueFirst
		 * @param keyValueSecond
		 * 
		 * jsonDataDriven get the data from the json file and act as testdata source.
		 * 
		 * This method only allows the json file with one array with all the elements
		 * are objects with only two key-value pairs.
		 * 
		 * @return String[][] jsondata
		 */	
		JsonNode keyArray = rootnode.get(keyArrayValue);
		JsonNode firstObject = keyArray.get(0);
		
		String[][] jsondata = new String[keyArray.size()][firstObject.size()];
		
		for(int i = 0; i < keyArray.size(); i++) {
			JsonNode obj = keyArray.get(i);
			String user = obj.get(keyValueFirst).asText();
			String pwd = obj.get(keyValueSecond).asText();
			
			for(int j = 0; j < obj.size(); j++) {
				if(j == 0)
					jsondata[i][j] = user;
				
				if(j == 1)
					jsondata[i][j] = pwd;
			}
		}
		return jsondata;
	}
	
	
	public int getJsonArraySize(String arrayName) {
		return rootnode.get(arrayName).size();
	}
	
	
}
