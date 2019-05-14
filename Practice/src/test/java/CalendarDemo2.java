import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CalendarDemo2 {


static WebDriver driver;	


@Test
public void selectDate() throws InterruptedException, ParseException {
	driver = BaseUtils.InitilizeDriver();
	driver.get("https://ui.freecrm.com/");
	// Login
	BaseUtils.getWhenVisible(By.name("email"), 10).sendKeys("ludadess@yahoo.ca");
	driver.findElement(By.name("password")).sendKeys("Fantasy_1");
	driver.findElement(By.cssSelector(".ui.fluid.large.blue.submit.button")).click();
	// click Calendar
	BaseUtils.getWhenReady(By.xpath("//span[contains(text(),'Calendar')]"), 10).click();
	
	// Select a desired date	 ***************************************************
	String date = "29 May 2020";
	// convert String to Date
	SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
	Date d = sdf.parse(date);
	Date currentDate = sdf.parse(sdf.format(new Date()));
	
	
	String dayStr = date.split(" ")[0];
	String monthYearStr =date.split(" ")[1]+" "+date.split(" ")[2];
	String monthYearDispl = driver.findElement(By.xpath("//span[@class = 'rbc-toolbar-label']")).getText();
	
	// if a desired date == current date
	if(d.compareTo(currentDate)==0) {
		System.out.println("Current date == desired");
		driver.findElement(By.xpath("//div[@class = 'rbc-date-cell rbc-now rbc-current']//a")).click();	
	}
	// if a desired date != current date
	else {        
		if(d.compareTo(currentDate)>0) {
			System.out.println("Current date < desired");
			while ( !monthYearStr.equalsIgnoreCase(monthYearDispl)) {
				driver.findElement(By.cssSelector(".chevron.right.icon")).click();
				monthYearDispl =BaseUtils.getWhenVisible(By.xpath("//span[@class = 'rbc-toolbar-label']"), 10).getText();
			}	
		}
		else if(d.compareTo(currentDate)<0) {
			System.out.println("Current date > desired");
			while ( !monthYearStr.equalsIgnoreCase(monthYearDispl)) {
				driver.findElement(By.cssSelector(".chevron.left.icon")).click();
				monthYearDispl =BaseUtils.getWhenVisible(By.xpath("//span[@class = 'rbc-toolbar-label']"), 10).getText();
			}	
		}
		
		// Select a desired day link
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd");
		if (dayStr.equalsIgnoreCase(sdf1.format(new Date()))) {
			driver.findElement(By.xpath("//div[@class = 'rbc-date-cell rbc-current']//a")).click();	
		}
		else {
			List<WebElement> dates = driver.findElements(By.xpath("//div[@class ='rbc-date-cell']//a"));	
			for(int i=0; i<dates.size();i++ ) {		
				if( dates.get(i).getText().equalsIgnoreCase(dayStr)) {
					dates.get(i).click();
					break;
				}			
			}
		}
	}
}
}
