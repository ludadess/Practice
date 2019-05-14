import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class HandleWindow {
static WebDriver driver;
	@Test
	public void testFrame() {
		driver = BaseUtils.InitilizeDriver();
		driver.get("https://www.onland.ca/ui/");	
		driver.findElement(By.xpath("//span[contains(@id,'support-text') ]")).click();
		driver.findElement(By.id("menuitem-help")).click();
	 Set<String> ids = driver.getWindowHandles();
	Iterator<String> it = ids.iterator();	
	String parentID = it.next();
	String childID = it.next();
	driver.switchTo().window(childID);
	System.out.println(driver.getCurrentUrl());
	driver.findElement(By.linkText("News")).click();
	driver.switchTo().window("");
	driver.quit();
	
	
		
	}
	

}
