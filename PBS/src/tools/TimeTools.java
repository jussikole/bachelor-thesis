package tools;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeTools {

	public static Timestamp parseTimestamp(String format, String text) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date date = dateFormat.parse(text);
		Timestamp timestamp = new Timestamp(date.getTime());
		return timestamp;
	}
	
	public static void main(String[] args) throws ParseException {
		Timestamp timestamp = TimeTools.parseTimestamp("dd/MM/yy", "10/12/01");
		System.out.println(timestamp);
	}
}
