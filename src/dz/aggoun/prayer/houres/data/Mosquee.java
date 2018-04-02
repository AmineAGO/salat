package dz.aggoun.prayer.houres.data;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

public class Mosquee {
	private String nom;
	private String adresse;
	private String cp;
	private String ville;
	private String tel;
	private String h_joumoua;
	private String info1;
	private String info2;
	private String info3;
	private String couleur;
	 

 
 
	  public static  Mosquee mapToMosque(Map<String, String> map ) {
	        final Mosquee m = new Mosquee();
	        
	        
	        final String nom = map.get("nom");
	        final String adresse = map.get("adresse");
	        final String cp = map.get("cp");
	        final String ville = map.get("ville");
	        final String tel = map.get("telephone");
	        final String h_joumoua= map.get("heure_joumoua");
	        final String info1 = map.get("info1");
	        final String info2 = map.get("info2");
	        final String info3 = map.get("info3");
	       System.out.println(nom);
	        m.setNom(nom);
	        m.setAdresse(adresse);
	        m.setCp(cp);
	        m.setVille(ville);
	        m.setTel(tel);
	        m.setH_joumoua(h_joumoua);
	        m.setInfo1(info1);
	        m.setInfo2(info2);
	        m.setInfo3(info3);

	        return m;
	    }




	public String getNom() {
		return nom;
	}




	public void setNom(String nom) {
		this.nom = nom;
	}




	public String getAdresse() {
		return adresse;
	}




	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}




	public String getCp() {
		return cp;
	}




	public void setCp(String cp) {
		this.cp = cp;
	}




	public String getVille() {
		return ville;
	}




	public void setVille(String ville) {
		this.ville = ville;
	}




	public String getTel() {
		return tel;
	}




	public void setTel(String tel) {
		this.tel = tel;
	}




	public String getH_joumoua() {
		return h_joumoua;
	}




	public void setH_joumoua(String h_joumoua) {
		this.h_joumoua = h_joumoua;
	}




	public String getInfo1() {
		return info1;
	}




	public void setInfo1(String info1) {
		this.info1 = info1;
	}




	public String getInfo2() {
		return info2;
	}




	public void setInfo2(String info2) {
		this.info2 = info2;
	}




	public String getInfo3() {
		return info3;
	}




	public void setInfo3(String info3) {
		this.info3 = info3;
	}




	public String getCouleur() {
		return couleur;
	}




	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
}
