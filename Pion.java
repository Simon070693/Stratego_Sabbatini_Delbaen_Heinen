/**
 * Classe mère des autres pions.
 */
package stratego;

/**
 * @author Marie
 * @date 11/11/14
 */
public class Pion {

	private int x;
	private char y;
	private int grade;
	private char gradeC;
	
	/**
	 * Constructeur d'un pion de base.
	 */
	public Pion(int x, char y, int grade) {
		this.x = x;
		this.y = y;
		this.grade = grade;
	}
	
	public Pion(int x, char y, char gradeC) {
		this.x = x;
		this.y = y;
		this.gradeC = gradeC;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public char getY() {
		return y;
	}

	public void setY(char y) {
		this.y = y;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public int getGradeC() {
		return gradeC;
	}

	public void setGradeC(char gradeC) {
		this.gradeC = gradeC;
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
	public int bougerPionLaterale(char y){
		this.y = y;
		return this.y;
	}
	
	/**
	 * @param grade entre 1 et 10.
	 * @return True si l'adversaire est plus fort False s'il est plus faible.
	 */
	public boolean estPlusFort(int grade1, int grade2){
		if(grade1 > grade2){
			return true;
		}
		else{
			return false;
		}
	}

}
