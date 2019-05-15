import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HandleDropDown {
static WebDriver driver;	
@Test
public void testDropDown() {
	
	driver = BaseUtils.InitilizeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://www.facebook.com/");
	
	// date - Dec-15-1982
	
	//Select monthDD = new Select(driver.findElement(By.id("month")));
	//monthDD.selectByVisibleText("Dec");
	BaseUtils.selectDropDownValue(By.id("month"), "Dec");
	BaseUtils.selectDropDownValue(By.id("day"), "20");
	BaseUtils.selectDropDownValue(By.id("year"), "1982");
	
	Select dayDD = new Select(driver.findElement(By.id("day")));
	List<WebElement> days = dayDD.getOptions();
	for(int i=0; i<days.size(); i++) {
		if (days.get(i).getText().equalsIgnoreCase("15")) {
			days.get(i).click();
		}
	}
	
	List<WebElement> years = driver.findElements(By.xpath("//select[@id ='year']/option"));
	for(int y=0; y<years.size(); y++) {
		if (years.get(y).getText().equalsIgnoreCase("1985")) {
			years.get(y).click();
			break;
		}
	}
}
	

}


