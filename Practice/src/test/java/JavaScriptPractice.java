import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class JavaScriptPractice {

static WebDriver driver;

@Test
public void testJavaScript() throws IOException, InterruptedException {
	driver = BaseUtils.InitilizeDriver();
	driver.get("https://ui.freecrm.com/");
	// Login
	
	BaseUtils.getWhenVisible(By.name("email"), 10);
	// flash email text box
	BaseUtils.flashElement(driver.findElement(By.name("email")), driver);
	// enter data in email text box
	driver.findElement(By.name("email")).sendKeys("ludadess@yahoo.ca");
	// flash password text box
	BaseUtils.flashElement(driver.findElement(By.name("password")), driver);
	// enter data in email text box
	driver.findElement(By.name("password")).sendKeys("Fantasy_1");
	
	
	// draw border around login button
	BaseUtils.drawBorder(driver.findElement(By.cssSelector(".ui.fluid.large.blue.submit.button")), driver);
	Thread.sleep(1000);
	// take screenshot
	BaseUtils.getScreenShot(driver, "freecrm");
	Thread.sleep(1000);
	// generate Alert
	BaseUtils.generateAlert(driver, "There is issue with Login button");
	driver.switchTo().alert().dismiss();
	
	//click on Login button using JS
	BaseUtils.clickElementByJS(driver.findElement(By.cssSelector(".ui.fluid.large.blue.submit.button")), driver);
	
	Thread.sleep(3000);
	BaseUtils.scrollPageDownByJS(driver);
	Thread.sleep(3000);
	
	Actions a = new Actions(driver);	
	a.sendKeys(Keys.PAGE_UP).build().perform();
	Thread.sleep(3000);
	
	
	WebElement el = driver.findElement(By.xpath("//span[contains(text(),'Twitter not set up')]"));
	BaseUtils.scrollIntoViewByJS(el, driver);
	
	
	Thread.sleep(2000);
	// refresh browser using JS
	BaseUtils.refreshBrowserByJS(driver);
	
	// get title of the page using JS
	System.out.println(BaseUtils.getTitleByJS(driver));
	
	// get inner text  of the page using JS
	System.out.println(BaseUtils.getPageinnerTextByJS(driver));
	
}

}
