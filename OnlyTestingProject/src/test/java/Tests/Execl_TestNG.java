package Tests;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Execl_TestNG {
	
	
	public static void readexcel() throws IOException {
		
		String xlpath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\Datautils\\DataTestNG.xlsx";
		
		XSSFWorkbook workbook=new XSSFWorkbook(xlpath);
		
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int count=sheet.getPhysicalNumberOfRows();
		
		//String  data=sheet.getRow(0).getCell(2).getStringCellValue();
		
		DataFormatter formater= new DataFormatter();
		
Object data=	formater.formatCellValue(sheet.getRow(0).getCell(2));
		
		System.out.println(data);
		System.out.println(count);
	}
	
	public static void main(String [] xyz) throws Exception {
		readexcel();
	}

}
