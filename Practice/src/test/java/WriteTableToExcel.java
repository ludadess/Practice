
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class WriteTableToExcel {
	
static WebDriver driver;
@Test
public void writeHTMLTableToExcel() {
	driver = BaseUtils.InitilizeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.w3schools.com/html/html_tables.asp");
	
	//*[@id="customers"]/tbody/tr[2]/td[1] - Company
	//*[@id="customers"]/tbody/tr[2]/td[2] - Contact
	//*[@id="customers"]/tbody/tr[2]/td[3] - Country
	
	
	Xls_Reader reader = new Xls_Reader("C:/Users/archi/git/Practice/Practice/DataTableDemo.xlsx");
	reader.addSheet("DataTable");
	reader.addColumn("DataTable", "Company");
	reader.addColumn("DataTable", "Contact");
	reader.addColumn("DataTable", "Country");
	
	int rows = driver.findElements(By.xpath("//*[@id='customers']/tbody/tr")).size();
	
	String xpathBefore = "//*[@id='customers']/tbody/tr[";
	for(int i=2; i<=rows; i++) {
		String company = driver.findElement(By.xpath(xpathBefore+i+"]/td[1]")).getText();
		String contact = driver.findElement(By.xpath(xpathBefore+i+"]/td[2]")).getText();
		String country = driver.findElement(By.xpath(xpathBefore+i+"]/td[3]")).getText();
		System.out.println(company+" "+contact+" "+country);
		reader.setCellData("DataTable", "Company", i, company);
		reader.setCellData("DataTable", "Contact", i, contact);
		reader.setCellData("DataTable", "Country", i, country);
		
	}
	
	reader.removeColumn("DataTable", 1);
	
	
	
}


}
