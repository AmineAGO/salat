package dz.aggoun.prayer.houres;

 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class IkamaPanelPetite extends JPanel {

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
          color2 = new Color(166,164,63);
          gp = new GradientPaint(0, 0, new Color(123,53,171), 0, h, new Color(123,53,171));
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }

    public JPanel mettreEnForme(ImageIcon image,int nbmin, int hEcran, String nomSalat, int sonIkama, int changementHeure) {
       
                
    	IkamaPanelPetite panel = new IkamaPanelPetite ();
            	panel.setPreferredSize(new Dimension(100,  (int) Math.round(hEcran * 0.75)));
            	panel.setMaximumSize(new Dimension(100,  (int) Math.round(hEcran * 0.75)));
            	panel.setBackground(new Color(250,204,0));
            	panel.setBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, Color.WHITE));
            	new CompteARPetiteIkama(panel,image,nbmin,nomSalat,sonIkama,changementHeure);
               
            	return panel;
            }
        
     
}