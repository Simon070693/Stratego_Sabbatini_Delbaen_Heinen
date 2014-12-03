/**
 * Classe contenant les differentes methodes relatives au deroulement du jeu.
 */
package stratego;

/**
 * @author marie
 * @date 21/11/14
 */
public class GerePartie {

	
	/**
	 * Trouve lequel des deux pions est le plus fort.
	 * @param p1 != null
	 * @param p2 != null
	 * @return 1 si le pion 1 est le plus fort, 2 si c'est le pion 2 et 0 s'ils sont pareil.
	 */
	public int quiGagne(Pion p1, Pion p2){
		if(p1.getGrade() == p2.getGrade()){
			return 0;
		}
		if(p1.getGrade() > p2.getGrade()){
			return 1;
		}
		else{
			return 2;
		}
	}
	
	/**
	 * Empeche le pion d'aller dans les 8 cases non valides
	 * @param p1 != null
	 * @return false s'il s'agit d'une case non valides si non true;
	 */
	public boolean estDeplacementPossible(int x, int y){
		if(x == 3 && y == 'E'){
			return false;
		}
		if(x == 4 && y == 'E'){
			return false;
		}
		if(x == 3 && y == 'F'){
			return false;
		}
		if(x == 4 && y == 'F'){
			return false;
		}
		if(x == 7 && y == 'E'){
			return false;
		}
		if(x == 8 && y == 'E'){
			return false;
		}
		if(x == 7 && y == 'F'){
			return false;
		}
		if(x == 8 && y == 'F'){
			return false;
		}
		else{
			return true;
		}
	}
	
	/**
	 * Empeche le pion de se deplacer de plus d'une case sauf s'il s'agit de l'écraireur.
	 * @param p1 non null
	 * @param x = x de la case ou on veut positionner le pion.
	 * @param y = y de la case ou on veut positionner le pion.
	 * @return true si le deplacement est valide si non false.
	 */
	public boolean deplacementPion(Pion p1, int x, int y){
		if((p1.getX() > x+1) && p1.getGrade()!=2){
			return false;
		}
		if((p1.getX() < x-1) && p1.getGrade()!=2){
			return false;
		}
		if((p1.getY() > y+1) && p1.getGrade()!=2){
			return false;
		}
		if((p1.getY() < y-1) && p1.getGrade()!=2){
			return false;
		}
		else{
			return true;
		}
		
	}

}
