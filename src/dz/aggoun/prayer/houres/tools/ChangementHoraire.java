package dz.aggoun.prayer.houres.tools;

import java.util.GregorianCalendar;

public class ChangementHoraire {

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
