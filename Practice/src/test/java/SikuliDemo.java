import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class SikuliDemo {

static WebDriver driver;

@Test
public void testSikuli() throws FindFailed, InterruptedException {

driver = BaseUtils.InitilizeDriver();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.manage().window().maximize();
driver.manage().deleteAllCookies();

driver.get("https://www.google.com/");
BaseUtils.getWhenVisible(By.name("q"), 10).sendKeys("java");

Screen s = new Screen();

Pattern GoogleSearchImg = new Pattern("GoogleSearch.png");

System.out.println("started");
s.wait(GoogleSearchImg,60000);
s.click();
s.click();

;


	
	
}

}
