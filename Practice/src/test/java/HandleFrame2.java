import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HandleFrame2 {
	
static WebDriver driver;

@Test
public void testFrame() {
driver = BaseUtils.InitilizeDriver();
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

driver.get("http://jqueryui.com/droppable/");

// switch to frame by WebElement
driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class ='demo-frame']")));
WebElement el = driver.findElement(By.id("draggable"));
WebElement elTarget = driver.findElement(By.id("droppable"));
Actions a = new Actions(driver);

//a.dragAndDrop(el, elTarget).build().perform();
a.clickAndHold(el).moveToElement(elTarget).release().build().perform();


// switch back to original window

driver.switchTo().defaultContent();

	
}

}
