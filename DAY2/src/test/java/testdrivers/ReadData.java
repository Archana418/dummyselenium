package testdrivers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadData {
	@Test
	public void ReadExcelSetofData() throws IOException 
	{
		File src= new File("C:\\Users\\ARCHANA DAS\\Desktop\\Login.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet1=wb.getSheetAt(0);	
		
		int rowcount=sheet1.getLastRowNum();
		System.out.println("Total no of row is: "+rowcount);
		
		for(int i=0;i<=rowcount;i++)
		{
			String Data=sheet1.getRow(i).getCell(0).getStringCellValue();
			System.out.println("Test data from excel sheet is:" +Data);
			String Data1=sheet1.getRow(i).getCell(1).getStringCellValue();
			System.out.println("Test data from excel sheet is:" +Data1);
		}
		wb.close();
		
				
	}

}
