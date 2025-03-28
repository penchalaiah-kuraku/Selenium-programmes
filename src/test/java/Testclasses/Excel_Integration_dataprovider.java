package Testclasses;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Excel_Integration_dataprovider {
	
@DataProvider(name="logindetails")	
 public String[][] gatData() throws Exception{
	
	 File file= new File("./src/test/resources/Book2.xlsx");
	 System.out.println(file.exists());
	 
	 FileInputStream fin=new FileInputStream(file);
	 XSSFWorkbook book=new XSSFWorkbook(fin);
	 XSSFSheet sheet=book.getSheetAt(0);
	 
	 System.out.println("No of Rows With out Index"+sheet.getPhysicalNumberOfRows());
	 System.out.println("No of Rows With  Index"+sheet.getLastRowNum());
	int row= sheet.getPhysicalNumberOfRows();
	int col=sheet.getRow(0).getLastCellNum();
	
	System.out.println("No of cols"+sheet.getRow(0).getLastCellNum());
	String[][] data=new String[row-1][col];
	 
	 for (int i = 1; i<row; i++) {
		
		 for (int j = 0; j <col ; j++) {
			 
			 DataFormatter format=new DataFormatter();
			 data[i-1][j]=format.formatCellValue(sheet.getRow(i).getCell(j));
//	
			 //.;
			System.out.print("Excel Data  "+sheet.getRow(i).getCell(j).getStringCellValue());
			//data[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
		}
		 
		 System.out.println();
		 
	}
	//book.close();
	 fin.close();
	 return data;
}
 
}
