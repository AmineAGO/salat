package dz.aggoun.prayer.houres;

 


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class DateDuJour  implements Runnable {
 
  protected JTextField dateText;
  private String date;
  Thread tr;
  JPanel hpanel;
  JLabel labelDate,labelHorloge;
  
  public DateDuJour(JPanel p) {
	  hpanel=p;
	  
	  labelHorloge=labelDate  = new JLabel();
        if (tr == null) {
            tr = new Thread(this);
            tr.start();
        }
      }
 
      public void run(){
        while (true) {
           
            Date date1 = new Date();
            DateFormat formatdate = new SimpleDateFormat("dd MMMM yyyy");
            DateFormat formatdate2 = new SimpleDateFormat("HH':'mm':'ss");
         
            date=( formatdate.format(date1) );
           
            hpanel.remove(labelDate);
            hpanel.remove(labelHorloge);
           
            labelDate  = new JLabel("<html> <span style='  font-size: 30px;font-weight: bold;'>"+getMoisArabe(date)+"</span></html>");
         
            
             
            hpanel.add(labelDate );
            hpanel.add(labelHorloge );
           
            hpanel.revalidate() ;
          
            
            try { Thread.sleep(1000000);
          } catch(InterruptedException e){
            }
        }
      }
       
  String getMoisArabe(String date){
	  return date.replace("janvier", "جانفي").replace("février", "فيفري").replace("mars", "مارس").replace("avril", "أفريل").replace("mai", "ماي").replace("juin", "جوان").
			  replace("juillet", "جويلية").replace("août", "أوت").replace("septembre", "سبتمبر").replace("octobre", "أكتوبر").replace("novembre", "نوفمبر").replace("décembre", "ديسمبر");
  }
     
}