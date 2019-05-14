import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Navigations {

static WebDriver driver;
@Test
public void testNavigation() throws InterruptedException {
	driver = BaseUtils.InitilizeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("https://www.google.com/");
	Thread.sleep(2000);
	driver.navigate().to("https://www.amazon.com/");
	Thread.sleep(2000);
	driver.navigate().back();
	Thread.sleep(2000);
	driver.navigate().forward();
	driver.navigate().refresh();
	
	
}
	

}
