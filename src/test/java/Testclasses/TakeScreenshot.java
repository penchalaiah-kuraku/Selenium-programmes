package Testclasses;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenshot {
WebDriver dr;
@SuppressWarnings("deprecation")
@Test
public void screenshot() throws IOException
{
	WebDriverManager.chromedriver().setup();
	dr=new ChromeDriver();
	dr.manage().timeouts().pageLoadTimeout(300,TimeUnit.SECONDS);
	//dr.manage().window().getPosition(new se
	dr.get("https://www.google.com/");
	WebDriverWait wait=new WebDriverWait(dr,Duration.ofSeconds(300));
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@aria-label='Sign in']")));
	dr.findElement(By.xpath("//a[@aria-label='Sign in']")).click();
	dr.findElement(By.id("identifierId")).sendKeys("jaslkfhs");
	
	//gettext() gives what is text in text box
	
	String value2=dr.findElement(By.id("identifierId")).getText();
	System.out.println("value2"+"="+value2);
	//get Attribut gives what is locator value
	String value1=dr.findElement(By.id("identifierId")).getAttribute("id");
	System.out.println("value2"+"="+value1);
	

//	TakesScreenshot ts=(TakesScreenshot)dr;
//File file=ts.getScreenshotAs(OutputType.FILE);
//FileUtils.copyFile(file, new File("C:\\Users\\pench\\OneDrive\\Desktop.png"));



}
}
