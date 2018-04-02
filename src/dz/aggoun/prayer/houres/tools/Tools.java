package dz.aggoun.prayer.houres.tools;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dz.aggoun.prayer.houres.data.MoisArabe;

public class Tools  { 
	private String moisA,jourA;
	private MoisArabe moisAra;

	public String getMoisArabe(int mois) {
		
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
	
public String getMoisFrancais(int mois) {
		
		switch (mois+1) {
        case 1:  moisA = moisAra.janvier.toMoisF();
                 break;
        case 2:  moisA = moisAra.fevrier.toMoisF();;
                 break;
        case 3:  moisA = moisAra.mars.toMoisF();;
                 break;
        case 4:  moisA = moisAra.avril.toMoisF();;
                 break;
        case 5:  moisA = moisAra.mai.toMoisF();;
                 break;
        case 6:  moisA = moisAra.juin.toMoisF();;
                 break;
        case 7:  moisA = moisAra.juillet.toMoisF();;
                 break;
        case 8:  moisA = moisAra.aout.toMoisF();;
                 break;
        case 9:  moisA = moisAra.septembre.toMoisF();;
                 break;
        case 10: moisA = moisAra.octobre.toMoisF();;
                 break;
        case 11: moisA = moisAra.novembre.toMoisF();;
                 break;
        case 12: moisA = moisAra.decembre.toMoisF();;
                 break;
        default: moisA = String.valueOf(mois);
                 break;
    }
		return moisA;
 
	}


public String getJourArabe(int jour) {
		//System.out.println(jour);
		switch (jour) {
        case 7:  jourA = "السبت";
                 break;
        case 1:  jourA = "الأحد";
                 break;
        case 2:  jourA = "الإثنين";
                 break;
        case 3:  jourA = "الثلاثاء";
                 break;
        case 4:  jourA = "الأربعاء";
                 break;
        case 5:  jourA = "الخميس";
                 break;
        case 6:  jourA = "الجمعة";
                 break;
        
    }
		return jourA;
 
	}


public String getJourFrancais(int jour) {
	//System.out.println(jour);
	switch (jour) {
    case 7:  jourA = "Samedi";
             break;
    case 1:  jourA = "Dimanche";
             break;
    case 2:  jourA = "Lundi";
             break;
    case 3:  jourA = "Mardi";
             break;
    case 4:  jourA = "Mercredi";
             break;
    case 5:  jourA = "Jeudi";
             break;
    case 6:  jourA = "Vendredi";
             break;
    
}
	return jourA;

}
}
