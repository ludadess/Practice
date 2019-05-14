import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HandlePopUp {
	static WebDriver driver;
	@Test
	public void testpopUp() {
		
		driver = BaseUtils.InitilizeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("proceed")).click();
		Alert alert = driver.switchTo().alert();
		String text =  alert.getText();
		alert.accept();
		if (text.equalsIgnoreCase("Please enter a valid user name") ) {
			System.out.println("Allert message is correct");
		}
		else {
			System.out.println("Allert message is not correct");
		}
			
		
		
	}
	
	

}
