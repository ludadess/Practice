import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PDF_Reader {

	static WebDriver driver;
	
@Test
public void readPDF() throws IOException {
	String urlPDF = "https://www.uis.edu/career/wp-content/uploads/sites/114/2013/04/thankyou_letter_samples.pdf";
	driver = BaseUtils.InitilizeDriver();
	driver.manage().window().maximize();
	driver.get(urlPDF);
	URL url = new URL(urlPDF);
	InputStream is = url.openStream();
	BufferedInputStream fileParse = new BufferedInputStream(is);
	PDDocument document = null;
	document = PDDocument.load(fileParse);
	String pdfContent = new PDFTextStripper().getText(document);
	System.out.println(pdfContent);
	Assert.assertTrue(pdfContent.contains("Sample Thank You Letters"));		
}
}
