import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class BaseUtils {
	static WebDriver driver;
	static String projectPath = System.getProperty("user.dir");
	
	public static WebDriver  InitilizeDriver() {
		System.setProperty("webdriver.chrome.driver", projectPath+ "/drivers/chromedriver.exe");
		return driver = new ChromeDriver();
	}
	
	public static WebElement getWhenVisible(By locator, int timeout) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;								
	}
	public static WebElement getWhenReady(By locator, int timeout) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.elementToBeClickable(locator));		
		return element;
	}
	
	public static void getScreenShot (WebDriver driver, String fileName) throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM_dd_hh_mm");
		String dateStamp = sdf.format(new Date());
		fileName = fileName+"_"+dateStamp+".png";	
		File file = new File ("C:/Work/"+fileName);
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, file);
		
		
	}
	public static void flashElement (WebElement element, WebDriver driver){
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 for( int i=0; i<50; i++) {
			 js.executeScript("arguments[0].style.border='2px dashed black'", element);
			 js.executeScript("arguments[0].style.border='2px dashed white'", element);
			 }
	 }
	public static void drawBorder (WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border ='3px solid red'", element);
	}
	
	
	public static void generateAlert (WebDriver driver, String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('"+message+"')");
	}
	
	public static void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);		
	}
	public static void refreshBrowserByJS (WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0);");
	}
	public static String getTitleByJS (WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	public static String getPageinnerTextByJS (WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}
	public static void scrollPageDownByJS (WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");	
	}
	
	public static void scrollIntoViewByJS (WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);	
	}
}
