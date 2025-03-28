package Testclasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelSheet {
	
	
	static WebDriver dr;
	String title;
	@BeforeClass
	public void test() throws IOException, InterruptedException
	{
		System.setProperty("webdriver,edge.driver", "C:\\Users\\pench\\Downloads\\edgedriver_win64\\msedgedriver.exe");
	//WebDriverManager.edgedriver().setup();
	
		dr=new EdgeDriver();
		dr.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		dr.manage().window().maximize();
		dr.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 title=dr.getTitle();
		 System.out.println(title);
	}
		//@Test
		public void Example(String username,String password) throws InterruptedException, Exception
		{
		String path="C:\\Users\\pench\\OneDrive\\Desktop\\Book1.xlsx";
		
		FileInputStream file=new FileInputStream(path);
	    XSSFWorkbook book=new XSSFWorkbook(file);
	  
		XSSFSheet sheet=book.getSheet("Sheet1");
		
		int row=sheet.getLastRowNum();
		
		for (int i = 1; i <=row; i++) {
			Thread.sleep(3000);
			String username2=sheet.getRow(i).getCell(0).getStringCellValue();
			Thread.sleep(3000);
			String password2=sheet.getRow(i).getCell(1).getRawValue();
			
			Thread.sleep(3000);
			dr.findElement(By.name("username")).sendKeys(username2);
			Thread.sleep(3000);
			dr.findElement(By.name("password")).sendKeys(password2);
			
		}	
		}
		
		@Test(dataProvider="logindetails",dataProviderClass=Excel_Integration_dataprovider.class)
		public void TestLogin(String scenario,String username1,String password1) throws Exception
		{
		Thread.sleep(3000);
		dr.findElement(By.name("username")).sendKeys(username1);
		Thread.sleep(3000);
		dr.findElement(By.name("password")).sendKeys(password1);
		Thread.sleep(2000);
		dr.findElement(By.xpath("//button[@type='submit']")).click();
	
		if(scenario.equals("Bothcorrect"))
		{
			System.out.println("loginSuccsfull");
		Assert.assertTrue(dr.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).isDisplayed());
		WebElement drop= dr.findElement(By.xpath("//p[@class='oxd-userdropdown-name']"));
		  drop.click();
		  Thread.sleep(2000);
		  dr.findElement(By.xpath("//a[text()='Logout']")).click();
		}
		else if(scenario.equals("BothWrong"))
		{
			Assert.assertEquals(dr.findElement(By.xpath("//p[text()='Invalid credentials']")).getText(),"Invalid credentials");
		}
		else if(scenario.equals("Usernamecorrect"))
		{
			Assert.assertEquals(dr.findElement(By.xpath("//p[text()='Invalid credentials']")).getText(),"Invalid credentials");
		}
		else
		{
			Assert.assertEquals(dr.findElement(By.xpath("//p[text()='Invalid credentials']")).getText(),"Invalid credentials");
		}
		
		}
}


