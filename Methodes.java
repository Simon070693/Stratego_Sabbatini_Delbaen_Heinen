/**
 * Liste des methodes.
 */
package stratego;

/**
 * @author Marie
 * @date 12/11/14
 */
public class Methodes {

	public static boolean partieGagne(Drapeau d){
		if(d.estAttrape()==true){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean capitule(){
		return false;
	}
	
	public boolean encorePionJouable(Pion[] tabP){
		int i;
		int j;
		for(i=0; i<40; i++){
			j = tabP[i].getGrade(); 
			if(j == (int)j){
				return true;
			}
		}
		return false;
	}
}
