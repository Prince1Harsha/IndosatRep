package com.enhancesys.qa.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDateUtil 
{
	public FileInputStream fis = null;
	public FileOutputStream fos =null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	String xlFilePath;

	public ExcelDateUtil(String xlFilePath) throws Exception
	{
		this.xlFilePath = xlFilePath;
		fis = new FileInputStream(xlFilePath);
		workbook = new XSSFWorkbook(fis);
		fis.close();
	}
	
	public ExcelDateUtil() {
	}

	public String getCellData(String sheetName,int colNum,int rowNum)
	{
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		
		try
		{
			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			
			else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) 
			{
				String cellValue = String.valueOf(cell.getNumericCellValue());
				if(HSSFDateUtil.isCellDateFormatted(cell))
				{
					DateFormat df = new SimpleDateFormat("dd/MM/yy");
					Date date = cell.getDateCellValue();
					cellValue = df.format(date);
				}
				return cellValue;
			}
			else if(cell.getCellType() == Cell.CELL_TYPE_BLANK)
				return "";
			
			else 
				return String.valueOf(cell.getBooleanCellValue());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "No Matching Value";
		}
	
	}
	public boolean setCellData(String sheetName,int colNum,int rowNum,String value)
	{
		try
		{
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowNum);
			
			if(row == null)
				row = sheet.createRow(rowNum);
			cell = row.getCell(colNum);
			
			if(cell == null)
				cell = row.createCell(colNum);
			
			cell.setCellValue(value);
	
				fos = new FileOutputStream(xlFilePath);
				workbook.write(fos);
				fos.close();
			
			
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		return true;
	}

}
