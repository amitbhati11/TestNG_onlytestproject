package Excelutils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExlUtilsdemo {
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
	public ExlUtilsdemo(String xlpath,String Sheetname) throws IOException {
		
		workbook=new XSSFWorkbook(xlpath);
		sheet=workbook.getSheet(Sheetname);
	}
	
	
	public int  rowcount() {
		
	int Rownum=	sheet.getPhysicalNumberOfRows();
	
	return Rownum;
		
	}

	public int cellcount() {
		
	int Colnum=	sheet.getRow(0).getPhysicalNumberOfCells();
	
	return Colnum;
		
	}
	
	public String getcelldata(int rownum,int cellnum) {
		
		DataFormatter formater=new DataFormatter();
		
	   String data=formater.formatCellValue(sheet.getRow(rownum).getCell(cellnum)) ;
			
     return data;
}
	
}
