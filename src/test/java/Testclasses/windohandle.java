package Testclasses;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windohandle {
WebDriver dr;
@Test
public void windohandlestest()
{
	//System.setProperty("webdriver,dr.edge", "");
	
	WebDriverManager.chromedriver().setup();
	
	dr=new ChromeDriver();
	dr.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	dr.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");
	dr.manage().window().maximize();
	
	String parent=dr.getWindowHandle();
	
	System.out.println(parent);
	
	String url=dr.getCurrentUrl();
	System.out.println(url);
	JavascriptExecutor jsp=(JavascriptExecutor)dr;
	jsp.executeScript("window.scrollTo(100,500)");
	
	dr.findElement(By.id("newWindowBtn")).click();
	
	Set<String> parentchild=dr.getWindowHandles();
	
	System.out.println(parentchild);
	
	for(String window:parentchild)
	{
	dr.switchTo().window(window);	
	String url1=dr.getCurrentUrl();
	System.out.println(url1);
	
	if(!url.equals(url1))
	{
		dr.findElement(By.id("firstName")).sendKeys("kabali");
	}
}
}
}
