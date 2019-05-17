
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class WorkWithExcel {
	private static XSSFWorkbook workbook = null;
	private static XSSFSheet sheet = null;
	private static XSSFRow row   =null;
	private static XSSFCell cell = null;


public static void main(String[] arg) throws IOException {
	FileInputStream fis = new FileInputStream("C:/Users/archi/git/Practice/Practice/DataTableDemo.xlsx");
	workbook = new XSSFWorkbook(fis);
	//sheet = workbook.getSheetAt(0);
	fis.close();
	int rowCount = getRowCount( "DataTable");
	System.out.println(rowCount);	
	
}	

	public static int getRowCount(String sheetName){
		
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1)
			return 0;
		else{
		
		sheet = workbook.getSheetAt(index);
		int number=sheet.getLastRowNum()+1;
		return number;
		}
		
	}
	
	
	
}



