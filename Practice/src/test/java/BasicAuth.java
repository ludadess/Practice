import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class BasicAuth {
	
static WebDriver driver;
@Test
public void testPopUpAuth() {
	driver = BaseUtils.InitilizeDriver();
	driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
	
	
	
	
	
}

}
