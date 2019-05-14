import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CalendarDemo3 {
	static WebDriver driver;
	
	String date = "13 July 2019";

	@Test
	public void selectdate() throws InterruptedException {
	
	driver = BaseUtils.InitilizeDriver();
	driver.get("https://m.spicejet.com");	
	
	BaseUtils.getWhenReady(By.xpath("//div[@data-testid='search-renderDatesText' and @dir='auto']"),10).click();
	
	Thread.sleep(1000);
	
	List<WebElement> weeks = driver.findElements(By.xpath("//div[contains(@data-testid,'"+date.split(" ")[1]+"')]/div[3]/div"));
	System.out.println("weeks = "+weeks.size());
	System.out.println("day = "+ date.split(" ")[0]);
	String xpathBefore = "//div[contains(@data-testid,'"+date.split(" ")[1]+"')]/div[3]/div[";
	boolean flag = false;
	
	for (int i=1; i<=weeks.size(); i++) {
		for (int y=1; y<=7; y++) {
			
			System.out.println(driver.findElement(By.xpath(xpathBefore+i+"]/div["+y+"]")).getText());
				
			if (driver.findElement(By.xpath(xpathBefore+i+"]/div["+y+"]")).getText().equalsIgnoreCase(date.split(" ")[0]))
			{
				driver.findElement(By.xpath(xpathBefore+i+"]/div["+y+"]")).click();		
				flag = true;
				break;
			}
		}
		if (flag == true) {
			break;
		}
	}
	}		
	}
