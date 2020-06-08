package testdrivers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteExcel {
	@Test
	public void WriteExcelData() throws IOException
	{
		File src= new File("C:\\Users\\ARCHANA DAS\\Desktop\\Login.xlsx");
		FileInputStream fis= new FileInputStream(src);
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sheet1=wb.getSheetAt(0);
		
		int rowcount =sheet1.getLastRowNum();
		System.out.println("Total no of row: "+rowcount);
		for(int i=0;i<=rowcount;i++)
		{
			String Data=sheet1.getRow(i).getCell(0).getStringCellValue();
			System.out.println("Test Data from excel is:" +Data);
			String Data1=sheet1.getRow(i).getCell(1).getStringCellValue();
			System.out.println("Test Data from excel is:" +Data1);
		}
		
		sheet1.getRow(0).createCell(2).setCellValue("Valid user");
		sheet1.getRow(1).createCell(2).setCellValue("Valid user");
		sheet1.getRow(2).createCell(2).setCellValue("Valid user");
		
		File srcout = new File("C:\\Users\\ARCHANA DAS\\Desktop\\Login.xlsx");
		FileOutputStream fout=new FileOutputStream(srcout);
		wb.write(fout);
		fout.close();
		
				
		
		
	}

}
