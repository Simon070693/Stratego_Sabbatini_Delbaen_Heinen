/**
 * Classe Principal permet d'afficher les différents panels.
 */
package stratego;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author Marie,Lionel,Simon
 * @date 12/12/14
 */

public class Principal extends JFrame {

	public ChoixJoueur panel1;
	public Initialisation panel2;
	public GrilleStratego panel3;	
	public Joueur joueur;
	public char c = 'r';
	public char c2 = 'b';
	
	
	/**
	 * Constructeur de la frame Principal 
	 */
	public Principal(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setSize(510,510);
		setResizable(false);
		setLocationRelativeTo(null);
	    setTitle("Projet Stratego");
	    setIconImage(new ImageIcon("image/images/StrategoIcon.jpg").getImage());
	}
	
	
	
	/**
	 * Méthode main.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal p = new Principal();
					p.joueur = new Joueur();
					p.setVisible(true);
					
				//	p.panel1 = new ChoixJoueur();
				//	p.panel2 = new Initialisation(p);
					p.panel3 = new GrilleStratego(p);		
					/*
					p.setContentPane(p.panel1);
					p.panel1.setVisible(true);
					
					JButton couleurRouge = new JButton("Joueur Rouge");
					p.panel1.add(couleurRouge);
					couleurRouge.addActionListener(new Click(p,p.c));
					JButton couleurBleu = new JButton("Joueur Bleu");
					p.panel1.add(couleurBleu);	
					couleurBleu.addActionListener(new Click(p,p.c2));
					*/
					p.getContentPane().add(p.panel3);
					p.panel3.setVisible(true);
					}
					
					
				
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
