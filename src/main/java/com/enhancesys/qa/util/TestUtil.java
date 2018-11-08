package com.enhancesys.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.enhancesys.qa.base.TestBase;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.exc.InvalidFormatException;

public class TestUtil extends TestBase 
{
	public static long PAGE_LOAD_TIMEOUT=30;
	public static long IMPLICIT_WAIT=80;


	public static String TESTDATA_SHEET_PATH = "C:\\Users\\ENH173\\Desktop\\products.xlsx";

	static Workbook book;
	static Sheet sheet;

	public static Object[][] getTestData(String sheetName) 
	{
	FileInputStream file = null;
	try{
		file = new FileInputStream(TESTDATA_SHEET_PATH);
	
	}catch(FileNotFoundException e){
		e.printStackTrace();
	}
	try{
		try {
			book = WorkbookFactory.create(file);
		} catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
			e.printStackTrace();
		}
		
	}catch(InvalidFormatException e){
		e.printStackTrace();
	}catch(IOException e){
		e.printStackTrace();
	}
	sheet = book.getSheet(sheetName);
	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	
	for(int i =0; i < sheet.getLastRowNum() ; i++)
	{
		for(int k=0; k < sheet.getRow(0).getLastCellNum(); k++)
		{
			data[i][k] = sheet.getRow(i+1).getCell(k).toString();
		}
	}
	return data;
	}
}