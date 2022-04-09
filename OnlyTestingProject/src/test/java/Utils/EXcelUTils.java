package Utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EXcelUTils {
	//String excelpath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\Datautils\\loginDataprovider.xlsx";
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
	public EXcelUTils(String excelpath,String sheetname) throws Exception {
		workbook=new XSSFWorkbook(excelpath);
		sheet=workbook.getSheet(sheetname);
		
	}
	
	
	public int getrowcount(int rownum) throws Exception {
		
		
		int rowCount=sheet.getPhysicalNumberOfRows();
		
		return rowCount;
		
	}
	public int  getcellcount(int colnum) {
		int cellCount=sheet.getRow(0).getPhysicalNumberOfCells();
		
		return cellCount;
	}
	
	public String getcellstringdata(int rownum,int colnum) {
		
		DataFormatter formater=new DataFormatter();
		String value= formater.formatCellValue(sheet.getRow(rownum).getCell(colnum));
		
		return value;

		
	}
	
}
