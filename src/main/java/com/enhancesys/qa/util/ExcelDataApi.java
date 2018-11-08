package com.enhancesys.qa.util;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataApi 
{
	public FileInputStream fis = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	
	public ExcelDataApi(String xlFilePath) throws Exception
	{
		fis = new FileInputStream(xlFilePath);
		workbook = new XSSFWorkbook(fis);
		fis.close();
	}
	
	public String getCellData(String sheetName,int colNum,int rowNum)
	{
		try
		{
		sheet=workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		
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
		}else if(cell.getCellType() == Cell.CELL_TYPE_BLANK)
					return "";
		else
			return String.valueOf(cell.getBooleanCellValue());
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			return "No matching Value";
		}
	}
}
