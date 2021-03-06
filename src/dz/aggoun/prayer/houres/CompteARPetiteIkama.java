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

public class CompteARPetiteIkama implements Runnable {

	protected JTextField dateText;
	private String mins,secs, dakika="دقائق",nomSalat;
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
	private int sonIkama;
	private int changementHeure;
	  

	public CompteARPetiteIkama(JPanel p, ImageIcon image, int min, String nomSalat, int sonIkama, int changementHeure  ) {
		hpanel = p;
		this.min=min;
        this.image =image ;
        this.nomSalat=nomSalat;
        this.sonIkama=sonIkama;
        this.changementHeure=changementHeure;
		labelHorloge = new JLabel();
		if (tr == null) {
			tr = new Thread(this);
			tr.start();
		}
	}

	public void run() {
		calendar1.setTime(new Date());
		sec=60-calendar.get(Calendar.SECOND);
		
		while (min>0) {
            
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

			if(sec%2==0)
				
			{ 
			
				labelHorloge = new JLabel(
					"<html><div align='center'><span style=' font-family: Tahoma ;margin-left: 10px ; color:white; font-size: 32px;font-weight: bold;'>"+ (this.changementHeure==0 ? "صلاةُ " : "") +nomSalat+"   </span>"
					+ "<br><br>"
					+ " "
					+ "<span style=' font-family: Tahoma ;margin-left: 10px ; color: #545651; font-size: 30px;font-weight: bold;'>تُقامُ الصَّلاةُ خِلال</span>"
					+ "<br>"
					//+ "<span style=' font-family: Tahoma ;margin-left: 10px ; color: #DE2B0F; font-size: 10px;font-weight: bold;'>"	+ secs + ": </span> "
					+ "<span style=' font-family: Tahoma ;margin-left: 10px ; color: #7B35AB; font-size: 95px;font-weight: bold;'>"+ mins + "</span>  "
					+ "<br><span style=' font-family: Tahoma ;margin-left: 10px ; color: #545651; font-size: 30px;font-weight: bold;'>"+ (this.changementHeure==1 ? "min | " : "")+dakika + "</span>  "
					+ "<br><<br><br><br><br><br><br>	 " 
					+ "</div><html>");
			}else{ 
				
				labelHorloge = new JLabel(	"<html><div  style='width:500px;' align='center'>"
						+ "<span style=' font-family: Tahoma ;margin-left: 10px ; color:white; font-size: 32px;font-weight: bold;'>"+ (this.changementHeure==0 ? "صلاةُ " : "")+nomSalat+"   </span>"
						+ "<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>  "
						+ "<br>	 " 
						+ "</div><html>");
				
			 
				
			}
			hpanel.add(labelHorloge);
			hpanel.revalidate();
			 
			calendar.setTime(new Date());

			try {
				Thread.sleep(1000-calendar.get(Calendar.MILLISECOND));
			} catch (InterruptedException e) {
			}
		} 
		 
		hpanel.remove(labelHorloge);
		
		if(this.sonIkama==1)
		{
			t.playSound("Files/beep.wav");
		}
		
		//labelHorloge= new JLabel(  image  );
		labelHorloge = new JLabel(	"<html><div  style='width:500px;' align='center'>"
				+ "<span style=' font-family: Tahoma ;margin-left: 10px ; color:white; font-size: 32px;font-weight: bold;'>"+ (this.changementHeure==1 ? "IQUAMA | " : "")+"الإِقامة  </span>"
			 
				//+ "<br>	 " 
				+ "</div><html>");
		
		hpanel.add(labelHorloge);
		hpanel.add( new JLabel(  image  ));
		hpanel.repaint();
		hpanel.revalidate();
		 
		tr.interrupt();
		
		
	}

	 
}