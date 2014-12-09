package stratego;

import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ChoixJoueur extends JPanel {

	private static final long serialVersionUID = 1L;
	Joueur joueur;
	int FINI = 0;

	/**
	 * Create the panel.
	 */
	public ChoixJoueur(Joueur joueur, int FINI) {
		this.joueur = joueur;
		this.FINI = FINI;
		FINI = 0;
		setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton couleurRouge = new JButton("Joueur Rouge");
		add(couleurRouge);
		
		JButton couleurBleu = new JButton("Joueur Bleu");
		add(couleurBleu);
		
		couleurRouge.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		    	if (couleurRouge.isEnabled()) {
		            joueur.color = 'r';		            
		        }
		    }
		});
		
		couleurBleu.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		    	if (couleurBleu.isEnabled()) {
		    		joueur.color = 'b';		    		
		        }
		    }
		});
		//if(joueur.color== 'b' || joueur.color == 'r'){
			FINI = 1;
		}
	}
	

//}
