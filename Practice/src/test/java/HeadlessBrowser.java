import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class HeadlessBrowser {

static String projectPath = System.getProperty("user.dir");
@Test
public void testHeadlessChrome() throws InterruptedException {
	//************** chrome *************************
	System.setProperty("webdriver.chrome.driver", projectPath+ "/drivers/chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("headless");
	WebDriver driver = new ChromeDriver(options);
	// ************ firefox ******************************
		/*
		 * System.setProperty("webdriver.chrome.driver", projectPath+
		 * "/drivers/geckodriver.exe"); FirefoxBinary fireFoxBinary = new
		 * FirefoxBinary(); fireFoxBinary.addCommandLineOptions("--headless");
		 * FirefoxOptions fo = new FirefoxOptions(); fo.setBinary(fireFoxBinary);
		 * WedDriver driver = new FirefoxDriver(fo);
		 */
	// *********************************************************
	
	driver.get("https://ui.freecrm.com/");
	
	System.out.println("Before login "+driver.getTitle());
	// Login
	driver.findElement(By.name("email")).sendKeys("ludadess@yahoo.ca");
	driver.findElement(By.name("password")).sendKeys("Fantasy_1");
	driver.findElement(By.cssSelector(".ui.fluid.large.blue.submit.button")).click();
	Thread.sleep(2000);
	System.out.println("After login "+driver.getTitle());
	
}
}
