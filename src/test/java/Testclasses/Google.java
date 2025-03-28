package Testclasses;


import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Google {
WebDriver dr;



@Test
public void setup() throws InterruptedException
{
	System.setProperty("webdriver,edge.driver", "C:\\Users\\pench\\Downloads\\edgedriver_win64\\msedgedriver.exe");
	
	
	
	EdgeOptions options=new EdgeOptions();
	options.addArguments("--headless");
	
	dr=new EdgeDriver(options);
	dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	dr.get("https://www.hyrtutorials.com/");
	dr.manage().window().maximize();
	//dr.findElement(By.linkText("Selenium Practice")).click();
	Thread.sleep(1000);
	//dr.findElement(By.linkText("CSS Selectors Practice")).click();
	
	//hard Assertion
	String home=dr.findElement(By.xpath("//a[text()='Home'  and @itemprop='url']")).getText();
	
	Assert.assertEquals(home, "Home");
	
	//soft Assertion
	
//	SoftAssert softassert=new SoftAssert();
//   String home1=dr.findElement(By.xpath("//a[text()='Home'  and @itemprop='url']")).getText();
//	
//   softassert.assertEquals(home1, "Home1");
	
	
	//no of links
	int a=dr.findElements(By.tagName("a")).size();
	
	System.out.println("no of links"+"="+a);
	
	//no windows
	
	int noofwindows=dr.getWindowHandles().size();
	
	System.out.println("no of windows"+"="+noofwindows);
	
	System.out.println(dr.getPageSource());
	Assert.assertEquals(dr.getPageSource().contains("404") || dr.getTitle().contains("404"),true);
	
	//no options of drop down
//	WebElement drop=dr.findElement(By.linkText("Selenium Practice"));
//	
//	Select s=new Select(drop);
//	List<WebElement> list=s.getOptions();
//	
//	int size=list.size();
//	for (int i = 0; i <size; i++) {
//		
//		String option=list.get(i).getText();
//		System.out.println(option);
//	}	
}
}
