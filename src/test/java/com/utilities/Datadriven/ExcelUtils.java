package com.utilities.Datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;
import org.testng.Assert;

public class ExcelUtils {

	//==================================== FIELDS & CONSTRUCTOR ====================================
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFRow rows;
	private XSSFCell cells;
	private File file;
	
	public ExcelUtils(String excelpath) {
		file = new File(excelpath);
		this.workbook = initXSSFWorkbook(file);	
	}	
	
	
	//=========================================== METHODS ===========================================
	
	//Total rows available in the sheet
	public int getRowLength(String sheetname) {
		int sheetIndex = workbook.getSheetIndex(sheetname);
		sheet = workbook.getSheetAt(sheetIndex);
		return sheet.getLastRowNum();
	}
	
	//Total Cell columns available in the row
	public short getCellLength(String sheetname, int rowcount) {
		if( rowcount < 0) {
			return 0;
		}
		
		int sheetIndex = workbook.getSheetIndex(sheetname);
		sheet = workbook.getSheetAt(sheetIndex);
		rows = sheet.getRow(rowcount);
		return rows.getLastCellNum();
	}
	
	//Get each Cell data and returns all with String type
	public String getCellData(String sheetname, int rowcount, int cellcount) {
		if(((rowcount < 0) && (cellcount < 0))) {
			return "";
		}
		
		int sheetIndex = workbook.getSheetIndex(sheetname);
		sheet = workbook.getSheetAt(sheetIndex);
		rows = sheet.getRow(rowcount);
		cells = rows.getCell(cellcount);
	
		if(cells == null)
			return "";
		
		switch(cells.getCellType())
		{
		case STRING : 
			return cells.getStringCellValue();	
		case NUMERIC : 
			return String.valueOf(cells.getNumericCellValue());
		case BOOLEAN : 
			return String.valueOf(cells.getBooleanCellValue());
		case FORMULA : 
			return cells.getCellFormula();	
		default : 
			return "";	
		
		}
	}
	
	//Load the Workbooks of the current path excel file.
	public XSSFWorkbook initXSSFWorkbook(File excelfile) {
		
		if(!excelfile.exists()) {
			Assert.fail("Unable to locate the dataprovider Excel file with path : " + excelfile.getPath());
		}
		
		try {
			FileInputStream input = new FileInputStream(excelfile);
			workbook = new XSSFWorkbook(input);
		} catch (FileNotFoundException fnfe) {
			System.out.println("Unable to Open the Excel file : " + file.getPath() + fnfe.getMessage());
			Assert.fail();
		} catch (IOException io) {
			System.out.println("I/O error occured! Excel file : " + file.getPath() + io.getMessage());
			Assert.fail();
		}
		
		return workbook;
	}


}
