import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatePractice {

	public static void main(String[] args) {
	
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY MM dd ");
		System.out.println(sdf.format(new Date()));
		
		

	}

}
