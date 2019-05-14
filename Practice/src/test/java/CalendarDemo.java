import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CalendarDemo {


static WebDriver driver;	


@Test
public void selectDate() throws InterruptedException {
	driver = BaseUtils.InitilizeDriver();
	driver.get("https://ui.freecrm.com/");
	
	System.out.println("Before login :"+driver.getTitle());
	// Login
	BaseUtils.getWhenVisible(By.name("email"), 10).sendKeys("ludadess@yahoo.ca");
	driver.findElement(By.name("password")).sendKeys("Fantasy_1");
	driver.findElement(By.cssSelector(".ui.fluid.large.blue.submit.button")).click();
	Thread.sleep(1000);
	System.out.println("After login :"+driver.getTitle());
	
}
}
