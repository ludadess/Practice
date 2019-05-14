import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class GoogleSearch {

static WebDriver driver;
	
	
@Test
public void testGoogleSearch() throws InterruptedException {
	driver = BaseUtils.InitilizeDriver();
	driver.get("https://www.google.com/");
	BaseUtils.getWhenVisible(By.name("q"), 10).sendKeys("java");
	
	BaseUtils.getWhenVisible(By.xpath("//ul[@role='listbox']"), 10);
	
	List<WebElement> suggestions = driver.findElements(By.xpath("//li[@class ='sbct']/div/div/div/span/b"));
	
	for (int i=1; i<suggestions.size(); i++) {
		if (suggestions.get(i).getText().equalsIgnoreCase("tutorial")) {
			suggestions.get(i).click();
			break;
		}
		
	}
	
	
}

}
