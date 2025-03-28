package Testclasses;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tables {
	
	WebDriver dr;
	@Test
	public void Test1()
	{
	WebDriverManager.chromedriver().setup();
	EdgeOptions options = new EdgeOptions();
    options.setAcceptInsecureCerts(true);
	
	//ChromeOptions  options=new ChromeOptions();
	
	//EdgeOptions options=new Edgeoptions();
	//options.addArguments("--window-size=100,700");
	//options.addArguments("--headless");
	
	dr=new EdgeDriver(options);
	dr.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	dr.manage().window().maximize();
	dr.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
	
	
	List<WebElement>list=dr.findElements(By.tagName("a"));
	int size=list.size();
	System.out.println(size);
	for (WebElement linkelements :list) {
		System.out.println(linkelements.getText());
	}
	
	
	JavascriptExecutor jsp=(JavascriptExecutor)dr;
	jsp.executeScript("window.scrollTo(0,700)");
			
	
	WebElement  table=dr.findElement(By.xpath("//*[@id=\"contactList\"]"));
	
	List<WebElement> row=table.findElements(By.tagName("tr"));
	System.out.println(row.size());
	
	for (int i = 0; i < row.size(); i++) {
		List<WebElement> col=row.get(i).findElements(By.tagName("td"));
		
		
		for (int j = 0; j <col.size() ; j++) {
			
//			if(col.get(3).getText().equals("5000"))
//			{
//				System.out.println(col.get(1).getText());
			
			
//				break;
		//}
			System.out.print(col.get(j).getText() + "  |  "); 
			
		}
	System.out.println();
	}
	}
}
