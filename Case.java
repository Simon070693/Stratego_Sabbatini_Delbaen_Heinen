/**
 * Classe Case red�finit un Jbutton.
 */

package stratego;

import javax.swing.JButton;

/**
 * @author Marie,Lionel,Simon
 * @date 12/12/14
 */

public class Case extends JButton {
	   
	private int ligne;
	private int colonne;
	     
	/**
	 * Constructeur de la classe Case.
	 * @param numL num�ro de la ligne != null
	 * @param numC num�ro de la colonne != null
	 */
	public Case(int numL, int numC){
		this.ligne = numL;
		this.colonne = numC;
	}
	public int getLigne(){
		return ligne;
	}
	     
	public int getColonne(){
		return colonne;
	}
}

