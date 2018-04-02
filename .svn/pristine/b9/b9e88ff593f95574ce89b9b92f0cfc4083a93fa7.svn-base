package dz.aggoun.prayer.houres.tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;

public class  EcritureFichier {

	 
	public static void ecrire(String texte, String fich) {
		 
	 
		try {
			 
			
			Writer out = new BufferedWriter(new OutputStreamWriter(	new FileOutputStream(new File(fich)), "UTF-8"));

			out.append(texte).append("\r\n");
			
			 out.flush();
			 out.close();
			
			 out=null;

		} catch (IOException ioe) {
			System.out.println("erreur : " + ioe);
		}
		 
	}
//	File MyFile = new File("C:\\data\\work\\UPSA\\DATA_OUT\\interfaces_upsa\\out_cft" + "\\" + nomFich);
//    MyFile.delete();// cas de reponse vide
}
