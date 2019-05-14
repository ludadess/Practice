import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TakeScreenShot {
	static WebDriver driver;
	@Test
	public void getScreenShot() throws InterruptedException, IOException {
		driver = BaseUtils.InitilizeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
		SimpleDateFormat sdf = new SimpleDateFormat("MM_dd_HH_mm");
		String timeStamp = sdf.format(new Date());
		String fPath = "C:/Work/google_"+timeStamp+".png";
		File f = new File (fPath);
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, f);		
		
	}
}
