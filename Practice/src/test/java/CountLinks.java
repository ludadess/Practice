import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CountLinks {
	
static WebDriver driver;
@Test
public void countAllLinks() {
driver = BaseUtils.InitilizeDriver();
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
driver.get("https://www.ebay.com/");

List<WebElement> links = driver.findElements(By.tagName("a"));
System.out.println("Number of links "+ links.size());
for (int i=0;i<links.size();i++) {
	
	System.out.println(links.get(i).getText());
	
}


	
}


}
