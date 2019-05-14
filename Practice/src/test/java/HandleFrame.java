import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HandleFrame {
	
static WebDriver driver;

@Test
public void testFrame() {
	
driver = BaseUtils.InitilizeDriver();
driver.get("http://jqueryui.com/droppable/");

//System.out.println("Before switching to frame, element is displayed?");
//System.out.println(driver.findElement(By.id("draggable")).isDisplayed());

// switch to frame by index
int frames = driver.findElements(By.tagName("iframe")).size();
for (int i=0;i<frames;i++) {
	driver.switchTo().frame(i);
		if (driver.findElements(By.id("draggable")).size()>0) {
			System.out.println("current frame index is: " + i);
			System.out.println("After switching to frame, element is displayed?");
			System.out.println(driver.findElement(By.id("draggable")).isDisplayed());
			break;						
		}
		
}
//switch back to original window
driver.switchTo().defaultContent();

	
}

}
