package Testclasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Google {
WebDriver dr;



@Test
public void setup() throws InterruptedException
{
	System.setProperty("webdriver,edge.driver", "C:\\Users\\pench\\Downloads\\edgedriver_win64\\msedgedriver.exe");
	dr=new EdgeDriver();
	dr.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	dr.get("https://www.hyrtutorials.com/");
	dr.manage().window().maximize();
	
	dr.findElement(By.linkText("Selenium Practice")).click();
	Thread.sleep(1000);
	dr.findElement(By.linkText("CSS Selectors Practice")).click();
}
}
