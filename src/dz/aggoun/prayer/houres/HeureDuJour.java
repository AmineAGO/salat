package dz.aggoun.prayer.houres;

import java.awt.BorderLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.HijrahChronology;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dz.aggoun.prayer.houres.data.MoisArabe;
import dz.aggoun.prayer.houres.tools.Tools;
 

public class HeureDuJour implements Runnable {

	protected JTextField dateText;
	private String horloge, date;
	Thread tr;
	private JPanel hpanel;
	private JLabel labelHorloge;
	private String dateAafficher,moisA;
	private Calendar calendar = Calendar.getInstance();
	private Calendar calendarH = Calendar.getInstance();
	private Date date1,date2;
	private LocalDate localDate;
	private Instant instant;
	private String hDate;
	private String couleur,joumoua;
	private MoisArabe moisAra;
	private DateFormat formatdate, formatdate2;
	private boolean premiereFois=true;
	private int deltaHijir;
	private Tools tools=new Tools();
	private int changementHeure;
	
	public HeureDuJour(JPanel p,String couleur,String joumoua, int deltaHijir, int changementHeure) {
		hpanel = p;
		this.joumoua=joumoua;
		this.couleur=couleur;
		this.deltaHijir=deltaHijir;
		this.changementHeure=changementHeure;
		labelHorloge = new JLabel();
		if (tr == null) {
			tr = new Thread(this);
			tr.start();
		}
	}

	public void run() {
		
		formatdate = new SimpleDateFormat("dd MM yyyy");
		formatdate2 = new SimpleDateFormat("HH':'mm");
		
		while (true) {

			date1 = new Date();
			calendar.setTime(date1);
			 
			
			date2 = new Date();
			calendarH.setTime(date2);
			calendarH.add(Calendar.DAY_OF_YEAR, deltaHijir);
			date2 = calendarH.getTime();
			
			horloge = (formatdate2.format(date1));
			date = (formatdate.format(date1));

			if(changementHeure==1)//heure en français
			{
				dateAafficher = "<span style=' color: "+couleur+";font-family: Tahoma ; font-size: 35px;font-weight: bold;'>"
			 
					        +tools.getJourFrancais(calendar.get(Calendar.DAY_OF_WEEK))+" "	+ getHijirDateFrancais(date2) + "</span><br><br><br><br><br><br></div><html> ";
			}else{
				dateAafficher = "<span style=' color: "+couleur+";font-family: Tahoma ; font-size: 35px;font-weight: bold;'>"
						 
					        +tools.getJourArabe(calendar.get(Calendar.DAY_OF_WEEK))+" "	+ getHijirDate(date2) + "</span><br><br><br><br><br><br></div><html> ";
			
			}
			if (calendar.get(Calendar.SECOND) <= 10 ||
			   (calendar.get(Calendar.SECOND) <= 30 && calendar.get(Calendar.SECOND) > 20) || 
			   (calendar.get(Calendar.SECOND) <= 50 && calendar.get(Calendar.SECOND) > 40) || 
			   (calendar.get(Calendar.SECOND) <= 70 && calendar.get(Calendar.SECOND) > 60) || 
			   (calendar.get(Calendar.SECOND) <= 90 && calendar.get(Calendar.SECOND) > 80)) 
			{
				if(changementHeure==1)//heure en français
				{dateAafficher = " <span  style=' color: "+couleur+";font-family: Tahoma ; font-size: 35px;font-weight: bold;'>"
						         +tools.getJourFrancais(calendar.get(Calendar.DAY_OF_WEEK))+" " +calendar.get(Calendar.DAY_OF_MONTH)+ " "
						         +tools.getMoisFrancais(calendar.get(Calendar.MONTH)) +" "+calendar.get(Calendar.YEAR)+"</span><br><br><br><br><br><br></div><html>";
				}else{
					dateAafficher = " <span style=' color: "+couleur+";font-family: Tahoma ; font-size: 35px;font-weight: bold;'>"
					         +tools.getJourArabe(calendar.get(Calendar.DAY_OF_WEEK))+" " +calendar.get(Calendar.DAY_OF_MONTH)+ " "
					         +tools.getMoisArabe(calendar.get(Calendar.MONTH)) +" "+calendar.get(Calendar.YEAR)+ "</span><br><br><br><br><br><br></div><html>";
				}
			}

			hpanel.remove(labelHorloge);

			labelHorloge = new JLabel(
					"<html><div align='center'  style='padding-top:0; margin:0' width='900 px'> <span  style='padding-top:0; margin:0; color: black;font-family: Tahoma ; font-size: 20px;'>"+this.joumoua+"</span><br>"
					+ "<span style=' padding-top:0; margin:0; font-family: Tahoma ;  color: "+couleur+"; font-size: 165px;font-weight: bold;'>"
							+ horloge + "</span> "
					+ "<br>"

							+ dateAafficher);

			if(calendar.get(Calendar.SECOND)%10==0 || premiereFois)
			{
				hpanel.add(labelHorloge);
			    hpanel.revalidate();
			    premiereFois=false;
			}

			try {
				calendar.setTime(new Date());
				Thread.sleep(1000-calendar.get(Calendar.MILLISECOND));
			} catch (InterruptedException e) {
			}
		}
	}

	 
	String getHijirDate(Date date ) {
		 
		instant = Instant.ofEpochMilli(date.getTime());
		localDate = instant.atZone(ZoneId.of("UTC")).toLocalDate();
		hDate = HijrahChronology.INSTANCE.date(localDate).toString().substring(19);

		hDate = hDate.substring(hDate.lastIndexOf("-") + 1)	+ hDate.substring(hDate.indexOf("-"),hDate.lastIndexOf("-") + 1) + hDate.substring(0, 4);
		hDate = hDate.replace("-01-", "  محرّم ")
				.replace("-02-", " صفر ")
				.replace("-03-", " ربيع الأول ")
				.replace("-04-", " ربيع الآخر ")
				.replace("-05-", " جمادى الأولى ")
				.replace("-06-", " جمادى الآخرة ")
				.replace("-07-", " رجب ")
				.replace("-08-", " شعبان")
				.replace("-09-", " رمضان ")
				.replace("-10-", " شوال ")
				.replace("-11-", " ذو القعدة ")
				.replace("-12-", " ذو الحجة ");

		return hDate;
	}
	
	String getHijirDateFrancais(Date date ) {
		 
		instant = Instant.ofEpochMilli(date.getTime());
		localDate = instant.atZone(ZoneId.of("UTC")).toLocalDate();
		hDate = HijrahChronology.INSTANCE.date(localDate).toString().substring(19);

		hDate = hDate.substring(hDate.lastIndexOf("-") + 1)	+ hDate.substring(hDate.indexOf("-"),hDate.lastIndexOf("-") + 1) + hDate.substring(0, 4);
		hDate = hDate.replace("-01-", "  Moharam ")
				.replace("-02-", " Safar ")
				.replace("-03-", " Rabia Alawal ")
				.replace("-04-", " Rabia Alakhir ")
				.replace("-05-", " Jumada Aloula ")
				.replace("-06-", " Jumada Alakhira ")
				.replace("-07-", " Rajab ")
				.replace("-08-", " Chaabane")
				.replace("-09-", " Ramadan ")
				.replace("-10-", " Chawal ")
				.replace("-11-", " Dhou al qi`da ")
				.replace("-12-", " Dhou al-hijja ");

		return hDate;
	}

}