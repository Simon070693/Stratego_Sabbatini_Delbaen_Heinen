package stratego;

import javax.swing.*;

import java.awt.GridLayout;


public class GrilleStratego extends JPanel {
	
	private static final long serialVersionUID = 2L;
	Case[] tabBouton = new Case[100];
	Pion[] tableauPion;
	Joueur joueur;
	
	

	/**
	 * Create the panel.
	 */
	public GrilleStratego(Joueur joueur, Pion[] tableauPion) {
		this.joueur = joueur;
		this.tableauPion = tableauPion;
		
		
		setLayout(new GridLayout(10, 10, 0, 0));
		int  numBouton = 0;
    	for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){        		
				tabBouton[numBouton] = new Case(j,i);
				for(int k=0; k<40; k++){
					if(tableauPion[k].getX()==j && tableauPion[k].getY()== i){
						ImageIcon fond = (ImageIcon) tableauPion[k].getI();
						tabBouton[numBouton].setIcon(fond);
					}
					else{
						ImageIcon fond = new ImageIcon ("image/images/StrategoBackground_"+i+j+".gif");
						tabBouton[numBouton].setIcon(fond);
					}
				}
				add(tabBouton[numBouton]);
	        	numBouton = numBouton +1;
	     
			}

    	}
   }
    			
	
	
	public void MouseClicked(java.awt.event.MouseEvent evt) {                                 
		
		int temp = -1;
		int x = evt.getX();
		int y = evt.getY();
		Case bouton = new Case(x,y);
		Icon fond = new ImageIcon ();
		
		for(int i = 0; i<100; i++){
			if(bouton.getIcon() == tabBouton[i].getIcon() && temp!= -1){
				if(estDeplacementPossible(x, y) == true && deplacementPion(joueur.tableauPion[temp], x, y) == true){
					joueur.tableauPion[temp].setX(x);
					joueur.tableauPion[temp].setY(y);
					tabBouton[i].setIcon(joueur.tableauPion[temp].getI());
	    			temp = -1; // "vide" la variable temporaire
				}
				else{
					System.out.println("Placer le pion à un endroit autorisé!");
				}
			}
			else{
				for(int j = 0; j<40; j++){
					if(x == joueur.tableauPion[j].getX() && y == joueur.tableauPion[j].getY()){
						if(deplacementPion(joueur.tableauPion[temp], x, y) == true){
							temp = j;
							fond = bouton.getIcon();
							tabBouton[i].setIcon(fond);
						}
						else{
							System.out.println("Placer le pion à un endroit autorisé!");
						}
					}
					else{
						if(temp == -1){
						System.out.println("Choisissez d'abord le pion a deplacer!");
						}
						else{
							if(deplacementPion(joueur.tableauPion[temp], x, y) == true){
							if(combat(temp, x, y)==0){
								temp = -1;
								fond = new ImageIcon ("image/images/StrategoBackground_"+y+x+".gif");
								tabBouton[i].setIcon(fond);
							}
							if(combat(temp, x, y)==1){
								joueur.tableauPion[temp].setX(x);
								joueur.tableauPion[temp].setY(y);
								tabBouton[i].setIcon(joueur.tableauPion[temp].getI());
				    			temp = -1; // "vide" la variable temporaire
							}
							if(combat(temp, x, y)==2){
				    			temp = -1; // "vide" la variable temporaire
							}
							if(combat(temp, x, y)==-1){
								System.out.println("ERREUR");
							}
							}
							else{
								System.out.println("Placer le pion à un endroit autorisé!");
							}
						}
					}
				}
				
			}
		}
	}
	
	
	
	/**
	 * Empeche le pion d'aller dans les 8 cases non valides
	 * @param p1 != null
	 * @return false s'il s'agit d'une case non valides si non true;
	 */
	public boolean estDeplacementPossible(int x, int y){
		if(x == 3 && y == 5){
			return false;
		}
		if(x == 4 && y == 5){
			return false;
		}
		if(x == 3 && y == 6){
			return false;
		}
		if(x == 4 && y == 6){
			return false;
		}
		if(x == 7 && y == 5){
			return false;
		}
		if(x == 8 && y == 5){
			return false;
		}
		if(x == 7 && y == 6){
			return false;
		}
		if(x == 8 && y == 6){
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
	
	/**
	 * Trouve lequel des deux pions est le plus fort.
	 * @return 1 si le joueur est le plus fort, 2 si c'est l'adversaire et 0 s'ils sont égaux.
	 */
	public int combat(int temp, int x, int y){
		for(int i = 0; i<40; i++){
			if((joueur.adversaire.tableauPion[i].getY() == y) && (joueur.adversaire.tableauPion[i].getX() == x)){
				if((joueur.adversaire.tableauPion[i].getGrade()> joueur.tableauPion[temp].getGrade())){
					System.out.println("Il est plus fort que vous...Son grade ="+joueur.adversaire.tableauPion[i].getGrade());
					return 2;
				}
				if((joueur.adversaire.tableauPion[i].getGrade()< joueur.tableauPion[temp].getGrade())){
					System.out.println("Vous etes plus fort!");
					return 1;
				}
				else{
					System.out.println("Egalite! Les deux s'entre-tuent...");
					return 0;
				}
			}
		}
		return -1;
	}
}