package Utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutilsdemo {
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
	public Excelutilsdemo(String exlpath,String sheetname) throws IOException {
		workbook=new XSSFWorkbook(exlpath);
		sheet=workbook.getSheet(sheetname);
		
	}
	public int  getrowcount(int rownum) {
		
		int rowcount =sheet.getPhysicalNumberOfRows();
		
		return rowcount;
		
		
	}
	
	public int getcellcount(int cellnum) {
	int cellcount=	sheet.getRow(0).getPhysicalNumberOfCells();
	
	return cellcount;
		
		
	}
	
	public String getcelldata(int rownum,int cellnum) {
		
		DataFormatter formater=new DataFormatter();
		
	String data =	formater.formatCellValue(sheet.getRow(rownum).getCell(cellnum));
		
		//System.out.println(data);
	
	return data;
	}

}
