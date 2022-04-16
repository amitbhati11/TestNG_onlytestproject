package Excelutils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Ecxlutilsdemo1 {
 
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
	public Ecxlutilsdemo1(String xlpath, String Sheetname) throws Exception {
		
		workbook=new XSSFWorkbook(xlpath);
		sheet=workbook.getSheet(Sheetname);
		
		
		
	}
	
	
	public int getRowcount() {
		
		int rownum=sheet.getPhysicalNumberOfRows();
		
		return rownum;
	}
	
	public int getcellcount() {
		int colnum=sheet.getRow(0).getPhysicalNumberOfCells();
		return colnum;
	}
	
	public  String  getcelldata(int rown, int celn) {
		
		DataFormatter formater=new DataFormatter();
		
	String data=formater.formatCellValue(sheet.getRow(rown).getCell(celn));
		
		return data;
	}
}
