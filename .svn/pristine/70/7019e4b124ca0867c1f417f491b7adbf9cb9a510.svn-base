package dz.aggoun.prayer.houres;

 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import dz.aggoun.prayer.houres.data.Mosquee;

public class EntetePanel extends JPanel {

	 private Color cbr=null;
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
          h = 55;
          color1 = Color.WHITE;
          color2 = new Color(64,164,154);
        if(this.cbr!=null)
            color2 = getCbr();
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }

    public JPanel mettreEnForme(ImageIcon image, Mosquee mosquee , int hEcran,Color couleur ) {
       
                
    	        EntetePanel panel = new EntetePanel ();
    	        panel.setCbr(couleur);
            	panel.setLayout( new GridLayout());
            	panel.setPreferredSize(new Dimension(10000, (int) Math.round(hEcran * 0.233)));
            	panel.setMaximumSize(new Dimension(100000, (int) Math.round(hEcran * 0.233)));
            	panel.setBackground(Color.WHITE);
  
				JLabel logo_centre = new JLabel(image );
				JLabel logo_droit = new JLabel( "<html><div align=\"center\" style=' font-family: \"Tahoma\" ; color: "+mosquee.getCouleur()+"; font-size: 35px; '>"
				+mosquee.getNom()+"<br>"+mosquee.getVille()+"  </div> </html>", JLabel.CENTER);
				JLabel logo_gauche = new JLabel("<html><div align=\"center\" style=' font-family: Tahoma ; color: "+mosquee.getCouleur()+"; font-size: 35px; '>بسم الله الرحمن الرّحيم</div> </html>", JLabel.CENTER);
				
			 	 
				panel.add(logo_droit );
				panel.add(logo_centre );
				panel.add(logo_gauche );
				
 
				
            	 
            	
            	return panel;
            }
        
    public  void setCbr(Color cbr){
    	this.cbr=cbr; 
    }
    public  Color  getCbr(){
    	return this.cbr ; 
    }
}