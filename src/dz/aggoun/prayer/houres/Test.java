package dz.aggoun.prayer.houres;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Test {

	 public static  void main(String[] filename){
		 Date now = new Date();
			Calendar calendar= Calendar.getInstance();
			calendar.setTime(now);
		 
		 System.out.println( getLastSundayOfMonth (calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)+1).get(Calendar.DAY_OF_MONTH));
	 }
	 
	

	    public static GregorianCalendar getLastSundayOfMonth (int year, int month) {
	    	GregorianCalendar c = new GregorianCalendar();
	        for(int i=31; i>22; i--) //a partir du 22 pour ne pas rater un dimanche
	        {
	            c.set(year, month-1, i);
	            if (c.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.SUNDAY){
	 
	            	return c;
	            }
	        }
	 
	    	return null;
	    }
	    
}