import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

public class NoImages {
	static String projectPath = System.getProperty("user.dir");
	@Test
	public void testNoImagesChrome() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", projectPath+ "/drivers/chromedriver.exe");
		Map<String, Object> images = new HashMap<>();
		images.put("images", 2);
		Map<String, Object> prefs = new HashMap<>();
	    prefs.put("profile.default_content_setting_values", images);
	    ChromeOptions options = new ChromeOptions();
	    options.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://ui.freecrm.com/");
		System.out.println("Before login "+driver.getTitle());
		// Login
		driver.findElement(By.name("email")).sendKeys("ludadess@yahoo.ca");
		driver.findElement(By.name("password")).sendKeys("Fantasy_1");
		driver.findElement(By.cssSelector(".ui.fluid.large.blue.submit.button")).click();
		Thread.sleep(2000);
		System.out.println("After login "+driver.getTitle());
		
	}
	@Test
	public void testNoImagesFirefox() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", projectPath+ "/drivers/geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("permissions.default.image", 2);
		options.setProfile(profile);
		options.setCapability(FirefoxDriver.PROFILE, profile);
		WebDriver driver = new FirefoxDriver(options);
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
