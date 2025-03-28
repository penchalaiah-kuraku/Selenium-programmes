package Testclasses;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Alertsboxes {
	
	static WebDriver driver;
	
	@Test
	public void Alertsbox() {
	//public static void main(String[] args) {

		System.setProperty("webdriver,edge.driver", "C:\\Users\\pench\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.navigate().to("https://www.hyrtutorials.com/#");
		
		
		
		
		WebElement  click1=driver.findElement(By.xpath("//a[text()='Selenium Practice']"));
		Actions action=new Actions(driver);
		
		action.moveToElement(click1).build().perform();
		
		
		
						driver.findElement(By.xpath("//a[text()='Alerts']")).click();
//						driver.findElement(By.id("alertBox")).click();
//						System.out.println(driver.switchTo().alert().getText());
//						driver.switchTo().alert().accept();
//						System.out.println(driver.findElement(By.id("output")).getText());

				//Confirm Box
//						System.out.println(driver.findElement(By.id("output")).getText());
//						driver.findElement(By.id("confirmBox")).click();
//						System.out.println(driver.switchTo().alert().getText());
//						driver.switchTo().alert().accept();
//						System.out.println(driver.findElement(By.id("output")).getText());
//						driver.findElement(By.id("confirmBox")).click();
//						System.out.println(driver.switchTo().alert().getText());
//						driver.switchTo().alert().dismiss();
//						System.out.println(driver.findElement(By.id("output")).getText());

				//Prompt Box
						JavascriptExecutor jsp= (JavascriptExecutor)driver;
						
						
						jsp.executeScript("window.scrollBy(0,500)");
						
						System.out.println(driver.findElement(By.id("output")).getText());
						
						
						WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
						
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("promptBox")));
						
						jsp.executeScript("window.scrollTo(200,700)");
						driver.findElement(By.id("promptBox")).click();
						System.out.println(driver.switchTo().alert().getText());
						driver.switchTo().alert().sendKeys("HYR Tutorials");
						driver.switchTo().alert().accept();
						System.out.println(driver.findElement(By.id("output")).getText());
						driver.findElement(By.id("promptBox")).click();
						System.out.println(driver.switchTo().alert().getText());
						driver.switchTo().alert().dismiss();
						System.out.println(driver.findElement(By.id("output")).getText());
						
			}
		}