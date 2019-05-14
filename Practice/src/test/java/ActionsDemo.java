import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsDemo {
	
static WebDriver driver;
@Test
public void testActions() {
	driver = BaseUtils.InitilizeDriver();
	driver.get("https://www.spicejet.com/");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	
	Actions a = new Actions(driver);
	WebElement el = driver.findElement(By.xpath("//a[contains(text(),'Add-Ons')]"));
	
	a.moveToElement(el).build().perform();
	BaseUtils.getWhenReady((By.linkText("Hot Meals")), 10).click();
	
	//driver.findElement(By.linkText("Hot Meals")).click();
}


}
