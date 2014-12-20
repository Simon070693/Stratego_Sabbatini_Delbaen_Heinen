/**
 * Classe Pions, sert à créer un Pion.
 */
package stratego;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * @author Marie,Lionel,Simon
 * @date 12/12/14
 */
public class Pion {

	private int x;
	private int y;
	private int grade;
	private ImageIcon i;
	
	


	/**
	 * Constructeur d'un pion.
	 */
	public Pion(int y, int x, int grade, ImageIcon i) {
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
	public ImageIcon getI() {
		return i;
	}
	public void setI(ImageIcon i) {
		this.i = i;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
}
