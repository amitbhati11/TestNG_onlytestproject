package Excelutils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataexcelUtils {
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
	
	public DataexcelUtils(String path,String sheetname) throws Exception {
		workbook=new XSSFWorkbook(path);
		sheet=workbook.getSheet(sheetname);
	}
	public int getrowcount() {
		int rowcount=0;
	 rowcount=	sheet.getPhysicalNumberOfRows();	
	//System.out.println(rowcount);
	return rowcount;
		
	}
	
	public int getcellcount() {
		int cellcount=0;
	 cellcount=sheet.getRow(0).getPhysicalNumberOfCells();	
//	System.out.println(cellcount);
	
	return cellcount;
		
	}
	
	
	public String getcelldata(int rownum,int colnum) {
		
		DataFormatter formater=new DataFormatter();
		
	String Data=formater.formatCellValue(sheet.getRow(rownum).getCell(colnum));
		
		//String Data=sheet.getRow(rownum).getCell(colnum).getStringCellValue();
		//System.out.println(Data);
		
		return Data;
		
		
	}
	
	public double getcelldatanumber(int rownum,int colnum) {
		
		double celldata=sheet.getRow(rownum).getCell(colnum).getNumericCellValue();
		//System.out.println(celldata);
		return celldata;
		
	}

}
