package dz.aggoun.prayer.houres;

 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class HeurePanel extends JPanel {

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
        h = 60;
          color1 = Color.WHITE;
          color2 = new Color(64,164,154);
        
        if(this.cbr!=null)
            color2 = getCbr();
          gp = new GradientPaint(0, 0, color1, 0, h, color2);
        
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }

    public JPanel mettreEnForme(int hEcran,Color couleur,String couleurPolice,String joumoua, int deltaHijir, int changementHeure) {
       
                
            	HeurePanel panel = new HeurePanel ();
            	//panel.setLayout(new GridLayout());
            	panel.setCbr(couleur);
            	panel.setPreferredSize(new Dimension(10000,(int) Math.round(hEcran * 0.38)));
            	panel.setMaximumSize(new Dimension(100000, (int) Math.round(hEcran * 0.38)));
            	panel.setBackground(couleur);
            	panel.setBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, Color.WHITE));
            	new HeureDuJour(panel, couleurPolice,joumoua,deltaHijir,changementHeure);
               
            	return panel;
            }
        
    public  void setCbr(Color cbr){
    	this.cbr=cbr; 
    }
    public  Color  getCbr(){
    	return this.cbr ; 
    }
}