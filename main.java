/**
 * Classe main.
 */
package stratego;

/**
 * @author Marie
 * @date 12/11/14
 */
public class main {

	Pion[] joueur1;
	Pion[] joueur2;
	/**
	 * deux tableau de pions.
	 */
	public main(Pion[] joueur1, Pion[] joueur2) {
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
	}
	
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
	
	public void main(String[]args){
		System.out.println("Prêt à jouer?");
		
		System.out.println("C'est partis!");
		
		System.out.println("Joueur 1 place tes pions");
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		//this.joueur1[0] = Drapeau;
		
		System.out.println("Joueur 2 place tes pions");
		//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
				//this.joueur1[0] = Drapeau;
		
		System.out.println();
		System.out.println();
		System.out.println();
	}

}
