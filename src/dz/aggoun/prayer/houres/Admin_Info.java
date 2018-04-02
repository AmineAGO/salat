package dz.aggoun.prayer.houres;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import dz.aggoun.prayer.houres.data.DateLabelFormatter;
import dz.aggoun.prayer.houres.data.FichierPropreties;
import dz.aggoun.prayer.houres.tools.EcritureFichier;
import dz.aggoun.prayer.houres.tools.TextFileReader;

public class Admin_Info extends JFrame  {
	
	
	  private Container container ;
     
	  private JTextArea taTexteInfo = new JTextArea ("  ");
	  private JLabel labelTexteInfo = new JLabel("  النصّ المُوّحد");
	  private Color fondInfo;
	  private Color couleurInfo;
	  private JButton b6 = new JButton ("عدِّل النصّ ");
	  private JButton b7 = new JButton ("الرجوع إلى النصّ الأصلي");
	  Properties prop = new Properties();
	 
	public Admin_Info() throws IOException, AWTException {
		
	  
		Toolkit tk = Toolkit.getDefaultToolkit();  
		int xSize = ((int) tk.getScreenSize().getWidth());  
		int ySize = ((int) tk.getScreenSize().getHeight()); 
		
		  this.setTitle("تعديلات النصّ المُوّحد");
		    this.setSize(500, 500);
		   // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);
		    container=this.getContentPane();
		    
		    b6.addActionListener(new BoutonListenerValide());
		    b7.addActionListener(new BoutonListenerDefaut());
			 
		 
		    
		    init();   
		 
		 
		 
	}
	int dialogButton = JOptionPane.YES_NO_OPTION;
	Font flabel = new Font("Tahoma", Font.PLAIN, 18);
	 class BoutonListenerDefaut implements ActionListener{

	    public void actionPerformed(ActionEvent e) { 
	    	 
	   	 UIManager.put("Label.font", flabel);
	   	 
	    	  
	    	if(JOptionPane.showConfirmDialog (container, "هل أنت متأكد من الرجوع إلى النصّ الأصلي؟","!حذار",dialogButton) == JOptionPane.YES_OPTION){
	           EcritureFichier.ecrire(contenu, "Files/Info");
	    	 
	    	container.removeAll();
			container.repaint();
			container.revalidate();
			 
	    	try {
				init();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}
	     }
          }
	 class BoutonListenerValide implements ActionListener{

		    public void actionPerformed(ActionEvent e) {
		    	UIManager.put("Label.font", flabel);
		    	if(JOptionPane.showConfirmDialog (container, "هل أنت متأكد   ؟","!حذار",dialogButton) == JOptionPane.YES_OPTION){
		    	 
		    		EcritureFichier.ecrire(taTexteInfo.getText(), "Files/Info");
		    	 
				container.removeAll();
				container.repaint();
				container.revalidate();
		    	try {
					init();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
		     }

		  }
	 
	void init() throws UnsupportedEncodingException, IOException	{
		  FileInputStream input = new FileInputStream("config.properties");

			// load a properties file
			prop.load(new InputStreamReader(new FileInputStream("config.properties"), "UTF-8"));
		fondInfo=new Color(Integer.valueOf(prop.getProperty("fond_info_r").replace(" ", "")),Integer.valueOf(prop.getProperty("fond_info_g").replace(" ", "")),Integer.valueOf(prop.getProperty("fond_info_b").replace(" ", "")));
		  couleurInfo=new Color(Integer.valueOf(prop.getProperty("couleur_info_r").replace(" ", "")),Integer.valueOf(prop.getProperty("couleur_info_g").replace(" ", "")),Integer.valueOf(prop.getProperty("couleur_info_b").replace(" ", "")));

		   
		    container.setBackground(Color.white);
		    container.setLayout(new GridLayout(0,1,15,15 )); 
		   
		taTexteInfo.setPreferredSize(new Dimension(250, 300));
		taTexteInfo.setText(TextFileReader.ReadTextFile("Files/Info"));
		Font font = new Font("Tahoma", Font.PLAIN, 16);
		taTexteInfo.setFont(font);
		taTexteInfo.setForeground(couleurInfo); 
		
		b6.setFont(new Font("Tahoma", Font.BOLD, 16));
		b7.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		taTexteInfo.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		labelTexteInfo.setFont(new Font("Tahoma", Font.BOLD, 16));
		
	    JPanel infoTextePan = new JPanel();
	    JPanel validateInfoTextePan = new JPanel();
	    
	   
	    infoTextePan .setBackground(Color.WHITE);
	   
	    
	     taTexteInfo.setBackground(fondInfo); 
	     infoTextePan.add(taTexteInfo );
	     infoTextePan.add(labelTexteInfo );
	     container.add(infoTextePan);
	     
	     validateInfoTextePan.add(b6 );
	     validateInfoTextePan.add(b7);
	     container.add(validateInfoTextePan);
	      
	      
	     
	     JScrollPane jsp = new JScrollPane(container);
	    	     
	    this.setContentPane(jsp);
	    this.setVisible(true);  
	    
	    
	}

	public static void main(String[] args) throws IOException, AWTException {
		 
		new Admin_Info();
	}

	String remplirFichierTmp( ) {
		String s=FichierPropreties.contenu_tmp;
    	
     
    	return s;
    	
	}
	public static String contenu="يَاأَيُّهَا الَّذِينَ آمَنُوا اذْكُرُوا اللَّهَ ذِكْرًا كَثِيرًا  \r\n"+
	"وَسَبِّحُوهُ بُكْرَةً وَأَصِيلًا  \r\n"+
	"هُوَ الَّذِي يُصَلِّي عَلَيْكُمْ وَمَلَائِكَتُهُ  \r\n"+
	"لِيُخْرِجَكُمْ مِنْ الظُّلُمَاتِ إِلَى النُّورِ  \r\n"+
	"وَكَانَ بِالْمُؤْمِنِينَ رَحِيمًا  \r\n"+
" \r\n"+
	"سبحان الله  \r\n"+
  "\r\n"+
"الحمد لله  \r\n"+
"\r\n"+
"الله أكبر  \r\n";



}