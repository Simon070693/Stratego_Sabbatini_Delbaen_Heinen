/**
 * Classe Principal permet d'afficher les différents panels.
 */
package stratego;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 * @author Marie,Lionel,Simon
 * @date 12/12/14
 */

public class Principal extends JFrame {

	public static ChoixJoueur panel1;
	public static Initialisation panel2;
	public static GrilleStratego panel3;	
	public static Principal frame;
	public static Joueur joueur;
	
	
	/**
	 * Constructeur de la frame Principal 
	 */
	public Principal(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setBounds(100, 100, 450, 300);
	}
	/**
	 * Méthode main.
	 */
	public static void main(String[] args) {
		String [] nbPions = new String[12];
		int [] nbPion = new int[12];
		Pion[] tableauPion = new Pion[40];
		char c = ' ';
		joueur = new Joueur(c, tableauPion);

		/*
		 * Initialise les deux tableau nbPions et nbPion contenant respectivement le nom du pions et le nombre qu'il y en a.
		 */
		nbPions[0] = "Bombe";
		nbPion[0] = 5;
		nbPions[1] ="Espion";
		nbPion[1] = 1;
		nbPions[2] ="Eclaireur";
		nbPion[2] = 8;
		nbPions[3] ="Demineur";
		nbPion[3] = 5;
		nbPions[4] ="Sergent";
		nbPion[4] = 4;
		nbPions[5] ="Lieutenant";
		nbPion[5] = 4;
		nbPions[6] ="Capitaine";
		nbPion[6] = 4;
		nbPions[7] ="Commendant";
		nbPion[7] = 3;
		nbPions[8] ="Colonnel";
		nbPion[8] = 2;
		nbPions[9] ="General";
		nbPion[9] = 1;
		nbPions[10] ="Marechal";
		nbPion[10] = 1;
		nbPions[11] ="Drapeau";
		nbPion[11] = 1;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					panel1 = new ChoixJoueur(joueur);
					panel2 = new Initialisation(joueur, nbPions , nbPion);
					panel3 = new GrilleStratego(joueur);		
					frame = new Principal();
					frame.setVisible(true);
					panel1 = new ChoixJoueur(joueur);
					frame.getContentPane().add(panel1);
					panel1.setVisible(true);
					frame.getContentPane().add(panel2);
					panel2.setVisible(true);
					frame.getContentPane().add(panel3);
					panel3.setVisible(true);
					
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
