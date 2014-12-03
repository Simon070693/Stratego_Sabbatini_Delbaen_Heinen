/**
 * Classe Espion herite de la classe Pion.
 */
package stratego;

/**
 * @author Marie
 * @date 12/11/14
 */
public class Espion extends Pion{

	/**
	 * Constructeur d'un Espion.
	 */
	public Espion(int x, char y, int grade) {
		super(x, y, grade);
	}
	
	public boolean estMarechal(int grade){
		if(grade==10){
			return true;
		}
		else{
			return false;
		}
	}

}
