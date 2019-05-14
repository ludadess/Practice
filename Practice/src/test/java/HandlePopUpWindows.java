import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HandlePopUpWindows {
	
	static WebDriver driver;
	@Test
	public void testPopUps() {
			driver = BaseUtils.InitilizeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("http://popuptest.com/");
			
			BaseUtils.getWhenReady(By.linkText("Come & Go Test"), 10).click();
			Set<String> ids = driver.getWindowHandles();
			Iterator<String> it = ids.iterator();
			while(it.hasNext()) {
				String id = it.next();
				driver.switchTo().window(id);
				System.out.println(driver.getTitle());
				//driver.close();
			}
			driver.switchTo().window("");
			driver.findElement(By.xpath("//input[contains(@value,'BACK')]")).click();
			driver.quit();
				
	}
}
