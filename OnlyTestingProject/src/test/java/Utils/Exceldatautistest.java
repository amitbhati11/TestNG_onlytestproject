package Utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldatautistest {
	XSSFWorkbook  workbook;
	XSSFSheet sheet;
	
	public Exceldatautistest(String xlpath, String Sheetname) throws Exception {
		
		workbook=new XSSFWorkbook(xlpath);
		sheet=workbook.getSheet(Sheetname);
	}
	
	public int getRowcount(int rownum) {
		int Rownum=sheet.getPhysicalNumberOfRows();
		
		return Rownum;
		
	}
	
	public int  getColmcount(int colnum) {
		int Colnum=sheet.getRow(0).getPhysicalNumberOfCells();
		
		return Colnum;
		
		
	}
	
	public  String getexceldata(int rownum,int colnum) {
		
		DataFormatter formater=new DataFormatter();
		
	String data= formater.formatCellValue(sheet.getRow(rownum).getCell(colnum));
	
	return data;
	}
			

}
