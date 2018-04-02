package dz.aggoun.prayer.houres.data;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

import dz.aggoun.prayer.houres.tools.ChangementHoraire;

public class Jour {
	private Integer jour;
	private List<Horaire> horaires;
	private static Calendar calendar = Calendar.getInstance();
	
	public Integer getJour() {
		return jour;
	}

	public void setJour(Integer jour) {
		this.jour = jour;
	}

	public List<Horaire> getHoraires() {
		return horaires;
	}

	public void setHoraires(List<Horaire> horaires) {
		this.horaires = horaires;
	}
 
 
	  public static  Jour mapToJour(Map<String, String> map, ImageIcon image_off, String fond_off, MatteBorder white, Color priereCouleur, int changementHeure) {
	        final Jour jour = new Jour();
	        final List<Horaire> horaires = new ArrayList<Horaire>();
	        Horaire h=new Horaire();
	    	calendar.setTime(new Date());
	    	int heureSupp=0;
	        int dernierDimanche = ChangementHoraire.getLastSundayOfMonth (calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)+1).get(Calendar.DAY_OF_MONTH);
	       
	       if( changementHeure==1)
	       { if(calendar.get(Calendar.MONTH)+1==3 && calendar.get(Calendar.DAY_OF_MONTH)>=dernierDimanche){
	        	heureSupp = 1;
	        }
	        if(calendar.get(Calendar.MONTH)+1==10 && calendar.get(Calendar.DAY_OF_MONTH)>=dernierDimanche){
	        	heureSupp = -1;
	        }
	       }
	        final String j = map.get("jour");
	       
	        final String h_sobh = map.get("h_sobh");
	        final String min_sobh = map.get("min_sobh");
	        final String att_sobh = map.get("att_sobh");
	        h.setHeure_p(Integer.parseInt(h_sobh)+heureSupp);
	        h.setMin_p(Integer.parseInt(min_sobh));
	        h.setAttente_p(Integer.parseInt(att_sobh));
	        h.setColeur(image_off);
	        h.setFond(fond_off);
	        h.setMb(white);
	        h.setPriereCouleur(priereCouleur);
	        h.setTempsEnMin(h.getHeure_p()*60+h.getMin_p());
	        if(changementHeure==1)
	        	{
	        	h.setNom("Sobh|الصبح");
	        	}else
	        	{
	        		h.setNom("الصبح");
	        	}
	        h.setFileDouaa("Fadl_1");
	        h.setCouleurDouaa(new Color(96,73,8));
	        h.setCompteur(1);
	        horaires.add(h);
	        
	        final String h_dohr = map.get("h_dohr");
	        final String min_dohr= map.get("min_dohr");
	        final String att_dohr = map.get("att_dohr");
	        h=new Horaire();
	        h.setHeure_p(Integer.parseInt(h_dohr)+heureSupp);
	        h.setMin_p(Integer.parseInt(min_dohr));
	        h.setAttente_p(Integer.parseInt(att_dohr));
	        h.setColeur(image_off);
	        h.setFond(fond_off);
	        h.setMb(white);
	        h.setPriereCouleur(priereCouleur);
	        h.setTempsEnMin(h.getHeure_p()*60+h.getMin_p());
	        if(changementHeure==1)
        	{
	        h.setNom("Dohr|الظهر");
        	}else{
        		 h.setNom("الظهر");
        	}
	        
	        h.setFileDouaa("Fadl_2");
	        h.setCouleurDouaa(new Color(11,64,38));
	        h.setCompteur(1);
	        horaires.add(h);
	        
	        final String h_asr = map.get("h_asr");
	        final String min_asr = map.get("min_asr");
	        final String att_asr = map.get("att_asr");
	        h=new Horaire();
	        h.setHeure_p(Integer.parseInt(h_asr)+heureSupp);
	        h.setMin_p(Integer.parseInt(min_asr));
	        h.setAttente_p(Integer.parseInt(att_asr));
	        h.setColeur(image_off);
	        h.setFond(fond_off);
	        h.setMb(white);
	        h.setPriereCouleur(priereCouleur);
	        h.setTempsEnMin(h.getHeure_p()*60+h.getMin_p());
	        if(changementHeure==1)
        	{
	        h.setNom("Asr|العصر");
        	}else{
        		h.setNom("العصر");
        	}
	        h.setFileDouaa("Fadl_3");
	        h.setCouleurDouaa(new Color(116,74,189));
	        h.setCompteur(1);
	        horaires.add(h);
	        
	        final String h_maghreb = map.get("h_maghreb");
	        final String min_maghreb = map.get("min_maghreb");
	        final String att_maghreb = map.get("att_maghreb");
	        h=new Horaire();
	        h.setHeure_p(Integer.parseInt(h_maghreb)+heureSupp);
	        h.setMin_p(Integer.parseInt(min_maghreb));
	        h.setAttente_p(Integer.parseInt(att_maghreb));
	        h.setColeur(image_off);
	        h.setFond(fond_off);
	        h.setMb(white);
	        h.setPriereCouleur(priereCouleur);
	        h.setTempsEnMin(h.getHeure_p()*60+h.getMin_p());
	        if(changementHeure==1)
        	{
	        h.setNom("Maghrib|المغرب");
        	}else{
        		  h.setNom("المغرب");	
        	}
	        h.setFileDouaa("Fadl_4");
	        h.setCouleurDouaa(new Color(207,67,55));
	        h.setCompteur(1);
	        horaires.add(h);
	        
	        final String h_icha = map.get("h_icha");
	        final String min_icha = map.get("min_icha");
	        final String att_icha = map.get("att_icha");
	        h=new Horaire();
	        h.setHeure_p(Integer.parseInt(h_icha)+heureSupp);
	        h.setMin_p(Integer.parseInt(min_icha));
	        h.setAttente_p(Integer.parseInt(att_icha));
	        h.setColeur(image_off);
	        h.setFond(fond_off);
	        h.setMb(white);
	        h.setPriereCouleur(priereCouleur);
	        h.setTempsEnMin(h.getHeure_p()*60+h.getMin_p());
	        if(changementHeure==1)
        	{
	        h.setNom("Icha|العشاء");
        	}else{
        		 h.setNom("العشاء");	
        	}
	        h.setFileDouaa("Fadl_5");
	        h.setCouleurDouaa(new Color(77,140,246));
	        h.setCompteur(1);
	        horaires.add(h);

	        final String h_chourouk = map.get("h_chourouk");
	        final String min_chourouk = map.get("min_chourouk");
	        h=new Horaire();
	        h.setHeure_p(Integer.parseInt(h_chourouk)+heureSupp);
	        h.setMin_p(Integer.parseInt(min_chourouk));
	        h.setAttente_p(0);
	        h.setColeur(image_off);
	        h.setFond(fond_off);
	        h.setMb(white);
	        h.setPriereCouleur(priereCouleur);
	        h.setTempsEnMin(h.getHeure_p()*60+h.getMin_p());
	        horaires.add(h);
	        
	        jour.setJour(Integer.parseInt(j));
	        jour.setHoraires(horaires);

	        return jour;
	    }
	
}
