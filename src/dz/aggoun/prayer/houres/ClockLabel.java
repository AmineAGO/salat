package dz.aggoun.prayer.houres;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.HijrahChronology;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import dz.aggoun.prayer.houres.data.MoisArabe;

public class ClockLabel extends JLabel implements ActionListener {

    /**
     * 
     */

	protected JTextField dateText;
	private String horloge, date;
	Thread tr;
	private JPanel hpanel;
	private JLabel labelHorloge;
	private String dateAafficher,moisA;
	private Calendar calendar = Calendar.getInstance();
	private Date date1;
	private LocalDate localDate;
	private Instant instant;
	private String hDate;
	private String couleur,joumoua;
	private MoisArabe moisAra;
	private DateFormat formatdate, formatdate2;
	private boolean premiereFois=true;
    private static final long serialVersionUID = 1L;
    String type;
    SimpleDateFormat sdf;

    public ClockLabel(String type) {
        this.type = type;
       // setForeground(Color.green);

        switch (type) {
        case "date":
            sdf = new SimpleDateFormat("  MMMM dd yyyy");
            setFont(new Font("sans-serif", Font.PLAIN, 12));
            setHorizontalAlignment(SwingConstants.LEFT);
            break;
        case "time":
            sdf = new SimpleDateFormat("HH:mm:ss");
           // setFont(new Font("sans-serif", Font.PLAIN, 40));
            setHorizontalAlignment(SwingConstants.CENTER);
            break;
        case "day":
            sdf = new SimpleDateFormat("EEEE  ");
            setFont(new Font("sans-serif", Font.PLAIN, 16));
            setHorizontalAlignment(SwingConstants.RIGHT);
            break;
        default:
            sdf = new SimpleDateFormat();
            break;
        }

        Timer t = new Timer(1000, this);
        t.start();
    }

    public void actionPerformed(ActionEvent ae) {
    	 
        Date d = new Date();
        setText(run());
    }
    
    public String run() {
	 

			date1 = new Date();
			calendar.setTime(date1);
			formatdate = new SimpleDateFormat("dd MM yyyy");
			formatdate2 = new SimpleDateFormat("HH':'mm");

			horloge = (formatdate2.format(date1));
			date = (formatdate.format(date1));

			dateAafficher = "<span style=' color: "+couleur+";font-family: Tahoma ; font-size: 35px;font-weight: bold;'>"
					+ getHijirDate(date1) + "</span><br><br><br><br><br><br></div><html> ";

			if (calendar.get(Calendar.SECOND) <= 10					|| (calendar.get(Calendar.SECOND) <= 30 && calendar							.get(Calendar.SECOND) > 20)					|| (calendar.get(Calendar.SECOND) <= 50 && calendar							.get(Calendar.SECOND) > 40)					|| (calendar.get(Calendar.SECOND) <= 70 && calendar							.get(Calendar.SECOND) > 60)										|| (calendar.get(Calendar.SECOND) <= 90 && calendar							.get(Calendar.SECOND) > 80)) 
			{
				dateAafficher = " <span style=' color: "+couleur+";font-family: Tahoma ; font-size: 35px;font-weight: bold;'>"
						+calendar.get(Calendar.DAY_OF_MONTH)+ " "+getMoisArabe(calendar.get(Calendar.MONTH)) +" "+calendar.get(Calendar.YEAR)+ "</span><br><br><br><br><br><br></div><html>";
			}

			//hpanel.remove(labelHorloge);
			this.joumoua = this.joumoua!= null ?this.joumoua: "";
		return	  
					"<html><div align='center'><span style=' color: black;font-family: Tahoma ; font-size: 20px;'>"+this.joumoua+"</span><br>"
					+ "<span style='  font-family: Tahoma ;  color: white; font-size: 165px;font-weight: bold;'>"
							+ horloge + "</span>"
					+ "<br>"

							+ dateAafficher;

 
	}

	String getMoisArabe(int mois) {
		
		switch (mois+1) {
        case 1:  moisA = moisAra.janvier.toMoisA();
                 break;
        case 2:  moisA = moisAra.fevrier.toMoisA();;
                 break;
        case 3:  moisA = moisAra.mars.toMoisA();;
                 break;
        case 4:  moisA = moisAra.avril.toMoisA();;
                 break;
        case 5:  moisA = moisAra.mai.toMoisA();;
                 break;
        case 6:  moisA = moisAra.juin.toMoisA();;
                 break;
        case 7:  moisA = moisAra.juillet.toMoisA();;
                 break;
        case 8:  moisA = moisAra.aout.toMoisA();;
                 break;
        case 9:  moisA = moisAra.septembre.toMoisA();;
                 break;
        case 10: moisA = moisAra.octobre.toMoisA();;
                 break;
        case 11: moisA = moisAra.novembre.toMoisA();;
                 break;
        case 12: moisA = moisAra.decembre.toMoisA();;
                 break;
        default: moisA = String.valueOf(mois);
                 break;
    }
		return moisA;
 
	}

	String getHijirDate(Date date) {
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

}