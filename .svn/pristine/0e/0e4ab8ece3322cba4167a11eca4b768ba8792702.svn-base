package dz.aggoun.prayer.houres;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import dz.aggoun.prayer.houres.tools.CsvFileHelper;

/**
 * JPanel avec texte defilant verticalement
 * @author laurent
 *
 */
public class JPanelTexteDefilant extends JPanel {
	
	/**
	 * Constructeur
	 * @param typeDefilement - int - type de defilement .
	 * @param cadenceEnMs - int - cadence de mise a jour en Ms .
	 * @param increment -int- increment en pixels
	 * @param espaceGauche - int - espace du bord gauche
	 * @param espaceHaut - int - espace du bord haut
	 * @param coulAvantPlan - java.awt.Color - couleur texte
	 * @param coulArrPlan - java.awt.Color - couleur fond
	 * @param conteneur - javax.awt.Component - conteneur .
	 * @param lignesDeTexte - java.util.Vector de String - les lignes de texte
	 */
	public JPanelTexteDefilant(
			int typeDefilement,
			int cadenceEnMs, int incrementEnPx,
			int espaceGauche, int espaceHaut,
			Color coulAvantPlan, Color coulArrPlan,
			Component conteneur,
			Vector<String> lignesDeTexte){
		this._lignesDeTexte = lignesDeTexte;
		this.graphicInitialization(espaceGauche, espaceHaut,
				coulAvantPlan, coulArrPlan);
		this.dataInitialization(typeDefilement, cadenceEnMs, incrementEnPx, conteneur);
	}
	
	/**
	 * Constructeur
	 * @param typeDefilement - int - type de defilement .
	 * @param cadenceEnMs - int - cadence de mise a jour en Ms .
	 * @param increment -int- increment en pixels
	 * @param espaceGauche - int - espace du bord gauche
	 * @param espaceHaut - int - espace du bord haut
	 * @param coulAvantPlan - java.awt.Color - couleur texte
	 * @param coulArrPlan - java.awt.Color - couleur fond
	 * @param conteneur - javax.awt.Component - conteneur .
	 * @param lignesDeTexte - Ellipse de String - les lignes de texte
	 */
	public JPanelTexteDefilant(
			int typeDefilement,
			int cadenceEnMs, int incrementEnPx, 
			int espaceGauche, int espaceHaut,
			Color coulAvantPlan, Color coulArrPlan,
			Component conteneur,
			String ... lignesDeTexte){
		for(String ligneCourante : lignesDeTexte)
			this._lignesDeTexte.add(ligneCourante);
		this.graphicInitialization(espaceGauche, espaceHaut,
				coulAvantPlan, coulArrPlan);
		this.dataInitialization(typeDefilement, cadenceEnMs, incrementEnPx, conteneur);
	}
	
	/**
	 * Constructeur
	 * @param typeDefilement - int - type de defilement .
	 * @param cadenceEnMs - int - cadence de mise a jour en Ms .
	 * @param increment -int- increment en pixels
	 * @param espaceGauche - int - espace du bord gauche
	 * @param espaceHaut - int - espace du bord haut
	 * @param coulAvantPlan - java.awt.Color - couleur texte
	 * @param coulArrPlan - java.awt.Color - couleur fond
	 * @param conteneur - javax.awt.Component - conteneur .
	 * @param fichierTexte - java.io.BufferedReader - une stream pointant vers
	 * un fichier texte . Attention ! Cette stream doit etre initialisee avec
	 *  le fichier texte voulu auparavant
	 * (logique) et ne sera pas fermee par cette fonction (logique par rapport a
	 * la 1ere condition) . Il sera donc recommande de refermer la stream sans plus tarder
	 * juste apres la creation du JPanelTexteDefilant, avant meme de commencer a l'utiliser .
	 * @throws IOexception - si la Stream n'a pas pu etre expploitee . 
	 */
	public JPanelTexteDefilant(
			int typeDefilement,
			int cadenceEnMs, int incrementEnPx, 
			int espaceGauche, int espaceHaut,
			Color coulAvantPlan, Color coulArrPlan,
			Component conteneur,
			BufferedReader fichierTexte)
	throws IOException {
		String ligneCourante = null;
		while(true){
			ligneCourante = fichierTexte.readLine();
			if(ligneCourante == null) break;
			this._lignesDeTexte.add(ligneCourante);
		}
		this.graphicInitialization(espaceGauche, espaceHaut,
				coulAvantPlan, coulArrPlan);
		this.dataInitialization(typeDefilement, cadenceEnMs, incrementEnPx, conteneur);
	}
	
	/**
	 * Ajoute une ligne de texte
	 * @param texte - String - ligne de texte
	 */
	public void appendLine(String texte){
		this._lignesDeTexte.add(texte);
	}
	
	/**
	 * Supprime une ligne de texte
	 * @param numeroLigne - int - numero de la ligne .
	 */
	public void deleteLine(int numeroLigne){
		this._lignesDeTexte.removeElementAt(numeroLigne);
	}
	
	/**
	 * Methode heritee : methode de dessin
	 * @param g - java.awt.Graphics - le contexte de dessin
	 */
	public void paint(Graphics g){
		//final int hauteurFonte = g.getFontMetrics().getHeight();
		g.setFont(new Font("Tahoma", 10, 100));
		FontMetrics metrics = g.getFontMetrics(g.getFont());
		final int  hauteurFonte = metrics.getHeight();
		
		//On ne peut initaliser la hauteur de la fonte pour les actions tempo  qu'ici
		this._actionPourTempo_montUniq_period.setHauteurFonte(hauteurFonte);
		this._actionPourTempo_vaEtVient_period.setHauteurFonte(hauteurFonte);
		this._actionPourTempo_monteeUnique.setHauteurFonte(hauteurFonte);
		
		//Mise a jour reguliere des dimensions du conteneur : c'est pourquoi cette methode appelee ici .
		this._actionPourTempo_montUniq_period.setDimensionsConteneur(this._conteneur.getWidth(), this._conteneur.getHeight());
		this._actionPourTempo_vaEtVient_period.setDimensionsConteneur(this._conteneur.getWidth(), this._conteneur.getHeight());
		this._actionPourTempo_monteeUnique.setDimensionsConteneur(this._conteneur.getWidth(), this._conteneur.getHeight());
		
		//le fond
		g.setColor(this._coulArrPlan);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		 
	    	//le texte
		g.setColor(this._coulAvantPlan);
		 
		for(byte i = 0; i < this._lignesDeTexte.size(); i++){
			g.drawString(this._lignesDeTexte.get(i), (int) Math.round((this.getWidth()- metrics.stringWidth(this._lignesDeTexte.get(i))) * 0.50) ,	this._espaceHaut + this._yDebut + i * hauteurFonte);
			 
		}
		
		//les bordures
		g.setColor(this._coulArrPlan);
		g.fillRect(0, 0, this.getWidth(), this._espaceHaut);
		g.fillRect(0, this.getHeight()-this._espaceHaut, this.getWidth(), this.getHeight());
		g.fillRect(0, 0, this._espaceGauche, this.getHeight());
		g.fillRect(this.getWidth()-this._espaceGauche, 0, this.getWidth(), this.getHeight());
	}
	
	
	static BufferedReader stream = null;
	/**
	 * @param args
	 */
	public static void scrollingText(String nom_fichier ,JFrame fenetre,Color couleur,Color fond) {
		 {
		
			  stream = null;
			
			try {
				stream = new BufferedReader(new InputStreamReader(new FileInputStream(CsvFileHelper.getResource(nom_fichier)), "UTF-8"));
				final JPanelTexteDefilant panneauTxtDefilant = new JPanelTexteDefilant(
						2,
						20, //periode ms
						1, // deplacements en px
						20, // bord gauche
						50, // bord haut,
						couleur, //couleur texte
						fond, //couleur fond
						fenetre,
						stream
				);
				
				fenetre.setLayout(new BorderLayout(5,5));
				fenetre.add(panneauTxtDefilant);
				 
				
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null,
						"Impossible de trouver le fichier !",
						"Erreur bloquante !",
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (IOException e){
				JOptionPane.showMessageDialog(null,
						"Erreur de traitement de fichier !",
						"Erreur bloquante !",
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			finally {
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	/**
	 * Initialisation graphique
	 * @param espaceGauche - int - espace du bord gauche
	 * @param espaceHaut - int - espace du bord haut
	 * @param coulAvantPlan - java.awt.Color - couleur texte
	 * @param coulArrPlan - java.awt.Color - couleur fond
	 */
	private void graphicInitialization(int espaceGauche, int espaceHaut,
			Color coulAvantPlan, Color coulArrPlan){
		this._espaceGauche = espaceGauche;
		this._espaceHaut = espaceHaut;
		this._coulAvantPlan = coulAvantPlan;
		this._coulArrPlan = coulArrPlan;
	}
	
	/**
	 * Initialisation des donnees
	 * @param typeDefilement - int - type de defilement .
	 * Voir l'un des constructeurs .
	 * @param cadenceEnMs - int - cadence de mise a jour en Ms .
	 * @param increment -int- increment en pixels
	 * @param conteneur - javax.awt.Component - conteneur .
	 * 
	 */
	private void dataInitialization(int typeDefilement, final int cadenceEnMs, final int incrementEnPx,
			Component conteneur){
		
		this._conteneur = conteneur;
		
		this._actionPourTempo_montUniq_period = new TimerTask_Personnalise(){

			{
				this._hauteurConteneur = _conteneur.getHeight();
				this._largeurConteneur = _conteneur.getWidth();
				
				_yDebut = this._hauteurConteneur - _espaceHaut;
				
			}
			
			@Override
			public void run() {
				_yDebut -= incrementEnPx;
				if(_yDebut <= -1 * this._hauteurFonte * _lignesDeTexte.size()){
					_yDebut = this._hauteurConteneur;
				}
				repaint();
			}
			
		};
		
		this._actionPourTempo_vaEtVient_period = new TimerTask_Personnalise(){

			{
				this._hauteurConteneur = _conteneur.getHeight();
				this._largeurConteneur = _conteneur.getWidth();
				
				_yDebut = this._hauteurConteneur - _espaceHaut;
				
			}
			
			@Override
			public void run() {
				
				_yDebut -= this._sens * incrementEnPx;
				int nbrLignes = _lignesDeTexte.size();
				boolean conditionChangement = 
					this._hauteurFonte > 0 &&
					/*cette premiere condition obligatoire :
					 * au 1er lancement _hauteurFonte non initialisee !
					 * (Sinon aurait immediatement change de sens : hauteurFonte valant alors 0) .
					 */
					( ( ((this._sens > 0) && _yDebut<= -1 * this._hauteurFonte * nbrLignes)
					|| ( (this._sens < 0) && _yDebut >= this._hauteurConteneur)) );
				
				if(conditionChangement){
					this._sens *= -1;
				}
				repaint();
			}
			
		};
		
		this._actionPourTempo_monteeUnique = new TimerTask_Personnalise(){

			{
				this._hauteurConteneur = _conteneur.getHeight();
				this._largeurConteneur = _conteneur.getWidth();
				
				_yDebut = this._hauteurConteneur - _espaceHaut;
				
			}
			
			@Override
			public void run() {
				
				_yDebut -= this._sens * incrementEnPx;
				int nbrLignes = _lignesDeTexte.size();
				boolean conditionChangement = 
					_yDebut <= -1 * this._hauteurFonte * nbrLignes;
				
				if(conditionChangement){
					this._sens = 0;
				}
				repaint();
			}
			
		};
		
		switch(typeDefilement){
			case 1 :
				this._actionPourTempo = this._actionPourTempo_monteeUnique;
				break;
			case 2 :
				this._actionPourTempo = this._actionPourTempo_montUniq_period;
				break;
			case 3 :
				this._actionPourTempo = this._actionPourTempo_vaEtVient_period;
				break;
			default :
				this._actionPourTempo = this._actionPourTempo_monteeUnique;
		}
		
		this._tempo = new Timer();
		this._tempo.scheduleAtFixedRate(
				this._actionPourTempo,
				cadenceEnMs,
				cadenceEnMs
		);
	}
	
	/**
	 * couleur texte
	 */
	private Color _coulAvantPlan;
	
	/**
	 * couleur fond
	 */
	private Color _coulArrPlan;
	
	/**
	 * Ordonee de la 1ere ligne de texte 
	 */
	private int _yDebut;
	
	/**
	 * Espace du bord gauche
	 */
	private int _espaceGauche;
	
	/**
	 * Espace du bord haut
	 */
	private int _espaceHaut;
	
	/**
	 * Objet conteneur du JPanel
	 */
	private Component _conteneur;
	
	/**
	 * La temporisation associee
	 */
	private Timer _tempo;
	
	/**
	 *  Action a effectuer regulierement par la tempo .
	 */
	private TimerTask_Personnalise _actionPourTempo;
	
	/**
	 * Action a effectuer regulierement par la tempo : mode montee unique periodique.
	 */
	private TimerTask_Personnalise _actionPourTempo_montUniq_period;
	
	/**
	 * Action a effectuer regulierement par la tempo : mode va-et-vient periodique .
	 */
	private TimerTask_Personnalise _actionPourTempo_vaEtVient_period;
	
	/**
	 * Action a effectuer regulierement par la tempo : mode montee (1 seule fois) .
	 */
	private TimerTask_Personnalise _actionPourTempo_monteeUnique;
	
	
	/**
	 * Les lignes de texte a afficher .
	 */
	private Vector<String> _lignesDeTexte = new Vector<String>();
	
	/**
	 * NumÃ©ro de sÃ©rialisation (recommandÃ© par Eclipse 3.2)
	 */
	private static final long serialVersionUID = 7914429803810162343L;
	
}
