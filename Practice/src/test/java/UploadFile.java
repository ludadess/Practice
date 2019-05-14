import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class UploadFile {
	
static WebDriver driver;
@Test
public void testUploadFile() {
	driver = BaseUtils.InitilizeDriver();
	driver.get("https://html.com/input-type-file/");
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	driver.findElement(By.xpath("//a[@class='pm-cta']")).click();;
	
	
	driver.findElement(By.name("fileupload")).sendKeys("C:\\Users\\Luda\\Documents\\Job Search\\Selenium\\DAY2.docx");
}
		
		
	

}
