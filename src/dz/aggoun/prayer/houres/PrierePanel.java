package dz.aggoun.prayer.houres;

 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.MatteBorder;

public class PrierePanel extends JPanel {
	 
	Color cbr =null;
	private Color color1 = Color.WHITE;
    private Color color2 = new Color(64,164,154);
    private int w ;
    private int h ;
    private GradientPaint gp;
    private Graphics2D g2d;
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
          g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
          w = getWidth();
          h = getHeight();
          color1 = Color.WHITE;
          color2 = new Color(7,24,36);
        
        if(this.cbr!=null)
         color2 = getCbr();
          gp = new GradientPaint(0, 0, color1, 0, h, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }

    public JPanel mettreEnForme(MatteBorder mb,Color cbr,ImageIcon image,String priereName,String Heure,String color,String heureChourouk, int changementHeure) {
       
     
    	PrierePanel panel = new PrierePanel ();
    	 
    	panel.setCbr(cbr);  
    	panel.setBorder(mb);
    	panel.setLayout(new BorderLayout());
    	
    	JLabel label_minaret_p = new JLabel("", image, JLabel.CENTER);
    	panel.add(label_minaret_p , BorderLayout.NORTH);
    	
    	JLabel priereNom = new JLabel("<html><div align='center' style=' font-family: Tahoma ; color:"+color+"; font-size: 80px;font-weight: bold;'>"+Heure+"</div> </html>", JLabel.CENTER);
		String spriereHeure ;
		if(changementHeure==0)//affichage uniquement en arabe avec une grande police
		{
			spriereHeure =  "<html><div align='center'  style=' font-family: Tahoma ; color:"+color+"; font-size: 40px;font-weight: bold;'>"+priereName+"</div> ";
		}else{//affichage français arabe petite police
			spriereHeure =  "<html><div align='center'  style=' font-family: Tahoma ; color:"+color+"; font-size: 25px;font-weight: bold;'>"+priereName+"</div> ";
			
		}
		if(heureChourouk!=null){		
			if(changementHeure==0){
			spriereHeure+=	  "<div align='center' style=' font-family: Tahoma ; font-size: 25px;color: "+color+"'>(الشروق "+heureChourouk+")</div>";
			}else {
				spriereHeure+=	  "<div align='center' style=' font-family: Tahoma ; font-size: 15px;color: "+color+"'>(Chorouk|الشروق|"+heureChourouk+")</div>";
				}
		}
		else {		spriereHeure+=	  "<div align='center' style=' font-family: Tahoma ; font-size: 7px;color: black'>---</div>";}
		spriereHeure+= "</html>" ;
		
		JLabel priereHeure = new JLabel(spriereHeure, JLabel.CENTER);
		
		panel.add(priereNom,  BorderLayout.CENTER);
		panel.add(priereHeure,  BorderLayout.SOUTH);
               
            	return panel;
            }
        
    public  void setCbr(Color cbr){
    	this.cbr=cbr; 
    }
    public  Color  getCbr(){
    	return this.cbr ; 
    }
     
}