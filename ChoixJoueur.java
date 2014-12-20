/**
 * Classe ChoixJoueur permet de déterminer en fonction du choix du joueur sa couleur.
 */
package stratego;

import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class ChoixJoueur extends JPanel{

	/**
	 * Constructeur de la classe.
	 */
	public ChoixJoueur() {
		setLayout(new GridLayout(1, 0, 0, 0));
				
	}
}
