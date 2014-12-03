/**
 * Classe Demineur herite de la classe Pion
 */
package stratego;

/**
 * @author marie
 *
 */
public class Demineur extends Pion{

	/**
	 * Constructeur d'un demineur.
	 */
	public Demineur(int x, char y, int grade) {
		super(x, y, grade);
	}
	
	public boolean estBombe(Pion X){
		if(X.getGrade()=='B'){
			return true;
		}
		else{
			return false;
		}
	}
}
