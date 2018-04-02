package dz.aggoun.prayer.houres;

import java.awt.AWTException;
import java.io.IOException;

public class Lance {

	public static void main(String[] args) throws IOException, AWTException {
		 
		if(args.length>0)
		{
			 new Principal(args[0]);
		}else{
			new Principal(null);
		}
	}
}
