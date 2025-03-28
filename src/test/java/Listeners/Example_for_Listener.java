package Listeners;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Example_for_Listener {
	WebDriver driver;
	@Test
	public void HYR()
	{
	System.setProperty("webdriver,edge.driver", "C:\\Users\\pench\\Downloads\\edgedriver_win64\\msedgedriver.exe");
	driver=new EdgeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.manage().window().maximize();
	driver.navigate().to("https://www.hyrtutorials.com/#");
	System.out.println(driver.getTitle());
	Assert.assertTrue(driver.getTitle().equals("H Y R Tutorials - H Y R Tutorials1"));
	
	}
@Test
public void Google()
{
	System.setProperty("webdriver,edge.driver", "C:\\Users\\pench\\Downloads\\edgedriver_win64\\msedgedriver.exe");
	driver=new EdgeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.manage().window().maximize();
	driver.navigate().to("https://www.google.com/");
	System.out.println(driver.getTitle());
	Assert.assertTrue(driver.getTitle().equals("Google"));
}
@Test(dependsOnMethods ="HYR")
public void ORANGEHRM()
{
	System.setProperty("webdriver,edge.driver", "C:\\Users\\pench\\Downloads\\edgedriver_win64\\msedgedriver.exe");
	driver=new EdgeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.manage().window().maximize();
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");	
	Assert.assertEquals(driver.getTitle(),"ORANGEHRM");
}

}

