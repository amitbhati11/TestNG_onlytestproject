package Utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excedldatautils {
	
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
	public Excedldatautils(String exclpath,String Sheetname ) throws Exception {
		
		workbook=new XSSFWorkbook(exclpath);
		sheet=workbook.getSheet(Sheetname);
		
		
	}
	
	
	public int getrowcount() {
	int Rownum=	sheet.getPhysicalNumberOfRows();
		
	return Rownum;
	}
	
	
	public int  getcellcount() {
	int Cellnum=	sheet.getRow(0).getPhysicalNumberOfCells();
		return Cellnum;
	}
	
	public String getcelldata(int rownum, int cellnum) {
		
		DataFormatter formater=new DataFormatter();
		
		String celldata=formater.formatCellValue(sheet.getRow(rownum).getCell(cellnum));
		return celldata;
	}

}
