package dz.aggoun.prayer.houres;

import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dz.aggoun.prayer.houres.tools.Tools;

public class CompteARIkama implements Runnable {

	protected JTextField dateText;
	private String mins,secs, dakika="دقائق";
	private ImageIcon image ;
	Thread tr;
	JPanel hpanel;
	JLabel labelHorloge;
	int sec=59; 
	int min;
	private Calendar calendar = Calendar.getInstance();
	private Calendar calendar1 = Calendar.getInstance();
	private Tools tools=new Tools();
	private DateFormat formatdate2 = new SimpleDateFormat("HH':'mm");
	private PlayerSound t= new PlayerSound();
	  

	public CompteARIkama(JPanel p, ImageIcon image, int min  ) {
		hpanel = p;
		this.min=min;
        this.image =image ;
		labelHorloge = new JLabel();
		if (tr == null) {
			tr = new Thread(this);
			tr.start();
		}
	}

	public void run() {
		while (min>=0) {
            
			sec--;
			calendar1.setTime(new Date());
           
			if(sec==-1){
            	min--;
            	
            	if(min==-1){
            		sec=0;
            	}
            	else{
            	sec=59;
            	} 
            }
             
            if(min>9){mins = ""+ min;}else{mins = "0"+ min;}
        	if(sec>9){secs=""+sec;}else{secs="0"+sec;}
        	
        	if(min==-1){mins = "00";}
        	if(min<2 || min>10){dakika=	"دقيقة";}else{
        		dakika="دقائق";
        	}
		 
			hpanel.remove(labelHorloge);

			labelHorloge = new JLabel(
					"<html><br><br><br><br>"
					+ "<div align='center'>"
					+ "<span style=' font-family: Tahoma ;margin-left: 20px ; color:white; font-size: 50px;font-weight: bold;'>تُقامُ الصَّلاةُ خِلال</span>"
					+ "<br>	"
					+ "<span style=' font-family: Tahoma ;margin-left: 20px ; color: #DE2B0F; font-size: 80px;font-weight: bold;'>"	+ secs + ": </span> "
					+ "<span style=' font-family: Tahoma ;margin-left: 20px ; color:white; font-size: 250px;font-weight: bold;'>"+ mins + "</span>  "
					+ "<span style=' font-family: Tahoma ;margin-left: 20px ; color:white; font-size: 40px;font-weight: bold;'>"+ dakika + "</span>  "
					+ "<br>	<span style=' font-family: Tahoma ;margin-left: 20px ; color:white; font-size: 40px;font-weight: bold;'>"+calendar1.get(Calendar.DAY_OF_MONTH)+ " "+tools.getMoisArabe(calendar1.get(Calendar.MONTH)) +" "+calendar1.get(Calendar.YEAR)+" <br/>"+ formatdate2.format(new Date()) +"</span> <br><br><br><br><br> " 
					+ "</div><html>");

			hpanel.add(labelHorloge);

			hpanel.revalidate();
			calendar.setTime(new Date());

			try {
				Thread.sleep(1000-calendar.get(Calendar.MILLISECOND));
			} catch (InterruptedException e) {
			}
		} 
		 
		hpanel.remove(labelHorloge);
		
		t.playSound("Files/beep.wav");
		
		labelHorloge= new JLabel(  image  );
		hpanel.add(labelHorloge);
		hpanel.repaint();
		hpanel.revalidate();
		 
		tr.interrupt();
		
		
	}

	 
}