/**
 * Classe mère des autres pions.
 */
package stratego;

import javax.swing.Icon;

/**
 * @author Marie
 * @date 11/11/14
 */
public class Pion {

	private int x;
	private int y;
	private int grade;
	private Icon i;


	/**
	 * Constructeur d'un pion de base.
	 */
	public Pion(int x, int y, int grade, Icon i) {
		this.x = x;
		this.y = y;
		this.grade = grade;
		this.i = i;
	}
	
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Icon getI() {
		return i;
	}


	public void setI(Icon i) {
		this.i = i;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	

	/**
	 * @param X valide requis.
	 * @return Nouveau X une fois le pion déplacé.
	 */
	public int bougerPionVerticale(int x){
		this.x = x;
		return this.x;
	}
	
	/**
	 * @param Y valide requis.
	 * @return Nouveau Y une fois le pion déplacé.
	 */
	public int bougerPionLaterale(int y){
		this.y = y;
		return this.y;
	}
}
