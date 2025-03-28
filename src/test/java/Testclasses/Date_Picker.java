package Testclasses;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Date_Picker {
	static  WebDriver dr;
	@Test
	public void setup()
	{
	System.setProperty("webdriver,edge.driver","C:\\Users\\pench\\Downloads\\edgedriver_win64\\msedgedriver.exe");
	dr=new EdgeDriver();
	dr.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
	dr.get("https://jqueryui.com/datepicker/");
	dr.manage().window().maximize();
	
	selectdate("15","March","2024");
}
public static void selectdate(String targetdate,String targetmonth,String targetyear)
{
	WebElement iframe=dr.findElement(By.tagName("iframe"));
	
	dr.switchTo().frame(iframe);
	dr.findElement(By.id("datepicker")).click();
	
	
//if date is current date for below condition
	while(true)
	{
		
		String dispmonth=dr.findElement(By.cssSelector(".ui-datepicker-month")).getText();
		String dispyear=dr.findElement(By.cssSelector(".ui-datepicker-year")).getText();
		if(targetmonth.equalsIgnoreCase(dispmonth)&&targetyear.equals(dispyear))
		{
			break;
	  }
	if(isMonthYearLater(targetmonth, targetyear, dispmonth, dispyear))
	{
		WebElement next=dr.findElement(By.xpath("//span[text()='Next']"));
		next.click();
	}
	else
	{
		
		WebElement previous=dr.findElement(By.xpath("//span[text()='Prev']"));
		previous.click();
	}
}
	
	WebElement date=dr.findElement(By.xpath("//table//tbody//tr//td//a[text()='"+targetdate+"']"));
	date.click();
	
}

public static boolean isMonthYearLater(String targetmonth,String targetyear,String dispmonth,String dispyear)
{
	int targetyearInt=Integer.parseInt(targetyear);
	int targetdispyearInt=Integer.parseInt(dispyear);
	
	if(targetyearInt>targetdispyearInt)
	{
		return true;
	}
	
	else if(targetyearInt<targetdispyearInt)
	{
		return false;
		
	}
	
	Map<String,Integer> months = new HashMap<>();

    // Use the put method to add months
    months.put("January",1);
    months.put("February",2);
    months.put("March",3);
    months.put( "April",4);
    months.put("May",5);
    months.put("June",6);
    months.put("July",7);
    months.put("August",8);
    months.put("September",9);
    months.put("October",10);
    months.put("November",11);
    months.put("December",12);

    int targetmonthindex=months.get(targetmonth);
    
    int dispmonthindex=months.get(dispmonth);
    
    return targetmonthindex>dispmonthindex;
}
}
