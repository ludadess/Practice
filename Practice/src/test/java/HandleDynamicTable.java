import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HandleDynamicTable {
static WebDriver driver;

@Test
public void testTable1() throws InterruptedException {
	
	driver = BaseUtils.InitilizeDriver();
	driver.get("https://ui.freecrm.com/");
	// Login
	
	BaseUtils.getWhenVisible(By.name("email"), 10);
	// flash email text box
	BaseUtils.flashElement(driver.findElement(By.name("email")), driver);
	// enter data in email text box
	driver.findElement(By.name("email")).sendKeys("ludadess@yahoo.ca");
	// flash password text box
	BaseUtils.flashElement(driver.findElement(By.name("password")), driver);
	// enter data in email text box
	driver.findElement(By.name("password")).sendKeys("Fantasy_1");
	BaseUtils.drawBorder(driver.findElement(By.cssSelector(".ui.fluid.large.blue.submit.button")), driver);
	driver.findElement(By.cssSelector(".ui.fluid.large.blue.submit.button")).click();
	
	BaseUtils.getWhenReady(By.xpath("//span[contains(text(),'Contacts')]"), 10).click();
	
	// ************ 1st method ****************************************************
	Thread.sleep(3000);
	String name = "test1 test2";
	String xpath = "//td[contains(text(),'"+name+"')]/preceding-sibling::td/div";
	driver.findElement(By.xpath(xpath)).click();
	
	
	// ************** 2nd method ****************************************
	//table/tbody/tr[1]/td[2]/div
	String xpathBefore = "//table/tbody/tr[";
	String xpathAfter = "]/td[2]";
	String xpathAfter1 = "]/td[1]/div";
	
	for(int i=1; i<=3;i++) {
		name = driver.findElement(By.xpath(xpathBefore+i+xpathAfter)).getText();
		System.out.println(name);
		if (name.equalsIgnoreCase("spring winter")){
			driver.findElement(By.xpath(xpathBefore+i+xpathAfter1)).click();
			break;
	}
	}		
}
}