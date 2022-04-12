package Excelutils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DemoExcelutils {
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
	public DemoExcelutils(String xlpath,String sheetname) throws Exception {
		
		workbook=new XSSFWorkbook(xlpath);
		sheet=workbook.getSheet(sheetname);
	}
	
	
	
	public int  getrowcount() {
		
	int Rowcount=	sheet.getPhysicalNumberOfRows();
	return Rowcount;
	}
	
	public int getcellcount() {
		int Cellcount=sheet.getRow(0).getPhysicalNumberOfCells();
		return Cellcount;
		
		
	}
	
	public String getcelldata(int rownum,int colnum) {
		
		DataFormatter formater=new DataFormatter();
		  
		String data=formater.formatCellValue(sheet.getRow(rownum).getCell(colnum));
		
		return data;
		
		
	//	sheet.getRow(rownum).getCell(colnum);
		
		
	}

}
