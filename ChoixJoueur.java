/**
 * Classe ChoixJoueur permet de déterminer en fonction du choix du joueur sa couleur.
 */
package stratego;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ChoixJoueur extends JPanel {

	private Joueur joueur;

	/**
	 * Constructeur de la classe.
	 */
	public ChoixJoueur(Joueur joueur) {
		this.joueur = joueur;
		setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton couleurRouge = new JButton("Joueur Rouge");
		add(couleurRouge);
		
		JButton couleurBleu = new JButton("Joueur Bleu");
		add(couleurBleu);
		
		couleurRouge.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {			//Si le bouton rouge est choisie, attribuer la couleur rouge au joueur.
		    	if (couleurRouge.isEnabled()) {
		            joueur.color = 'r';		            
		        }
		    }
		});
		couleurBleu.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {			//Si la couleur bleu est choisie, attribuer la couleur bleu au joueur.
		    	if (couleurBleu.isEnabled()) {
		    		joueur.color = 'b';		    		
		        }
		    }
		});
	}
}
