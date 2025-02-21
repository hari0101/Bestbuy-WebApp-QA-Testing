package com.utilities.Datadriven;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {

	@DataProvider(name = "swaglabs")
	public String[][] validCredentials() {
		
		String excelpath = "./src/test/resources/demodata.xlsx";
		
		ExcelUtils util = new ExcelUtils(excelpath);
		
		int totalRow = util.getRowLength("swaglabs");
		int totalCell = util.getCellLength("swaglabs", 0);
		
		String[][] data = new String[totalRow][totalCell];
	
		for(int i=1; i<=totalRow; i++){
			for(int j=0; j<totalCell; j++) {
				data[i-1][j] = util.getCellData("swaglabs", i, j);
			}
		}
		
		return data;
	}
	
	
}
