/**
 * Classe Drapeau etend classe Pion.
 */
package stratego;

/**
 * @author Marie
 * @date 12/11/14
 */
public class Drapeau extends Pion{

	boolean attrape;
	
	/**
	 * Constructeur d'un Drapeau
	 */
	public Drapeau(int x, char y, char gradeC, boolean attrape) {
		super(x, y, gradeC);
		this.attrape = attrape;
	}

	public boolean estAttrape(){
		if(this.attrape == true){
			return true;
		}
		else{
			return false;
		}
	}
}
