package Excelutils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Execl_TestNG {
	
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
	public Execl_TestNG(String xlpath, String Sheetname) throws Exception {
		 workbook=new XSSFWorkbook(xlpath);
		
		sheet=workbook.getSheet(Sheetname);
		
		
	}
	public  void readexcel(int rowNum,int cellNum) throws Exception {
		
			int count=sheet.getPhysicalNumberOfRows();
		
		//String  data=sheet.getRow(0).getCell(2).getStringCellValue();
		
		DataFormatter formater= new DataFormatter();
		
      Object data=	formater.formatCellValue(sheet.getRow(rowNum).getCell(cellNum));
		
      System.out.println(data);
		
	}
	
	
}
