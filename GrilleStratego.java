/**
 * Classe qui permet de créer la grille du jeu.
 */
package stratego;

import javax.swing.*;

import java.awt.GridLayout;

/**
 * @author Marie,Lionel,Simon
 * @date 12/12/14
 */

public class GrilleStratego extends JPanel {
	
	Case[] tabBouton = new Case[100];			//permet de créer la grille de jeu
	Pion[] tableauPion = new Pion[40];			//tableau contenant les pions du joueur avec leur coordonnées choisies
	Joueur joueur;
	
	

	/**
	 * Constructeur de la classe
	 */
	public GrilleStratego(Joueur joueur) {
		this.joueur = joueur;
		this.tableauPion = joueur.tableauPion;
		setLayout(new GridLayout(10, 10, 0, 0));
		int  numBouton = 0;
    	for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){        		
				tabBouton[numBouton] = new Case(j,i);
				for(int k=0; k<40; k++){
					if(tableauPion[k].getX()==j && tableauPion[k].getY()== i){				//place les pions dans la grille si non, mets l'image de fond
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
    /**
	 * Méthode permettant de gérer les click du joueur.
	 */
	public void MouseClicked(java.awt.event.MouseEvent evt) {                                 
		int temp = -1;					//variable tampon pouvant occupé l'indice du pion sélectionné. -1 = "vide"
		int x = evt.getX();				//mets dans la variable x l'abscisse de la case sur laquelle le joueur a clicker
		int y = evt.getY();				//mets dans la variable y l'ordonnée  de la case sur laquelle le joueur a clicker
		Case bouton = new Case(x,y);
		Icon fond = new ImageIcon ();
		
		for(int i = 0; i<100; i++){
			if(bouton.getIcon() == tabBouton[i].getIcon() && temp!= -1){	//cas ou un pion a déjà été sélectionné et que le joueur souhaite le placer sur une case valide non occupée
				if(estDeplacementPossible(x, y) == true && deplacementPion(joueur.tableauPion[temp], x, y) == true){ //si le déplacement est possible
					joueur.tableauPion[temp].setX(x);						//modifie la position du pion
					joueur.tableauPion[temp].setY(y);						//modifie la position du pion
					tabBouton[i].setIcon(joueur.tableauPion[temp].getI());	//change l'icon de fond par celle du pion
	    			temp = -1;												// "vide" la variable temporaire
				}
				else{
					System.out.println("Placer le pion à un endroit autorisé!"); //si le déplacement n'est pas possible
				}
			}
			else{
				for(int j = 0; j<40; j++){		//cas ou la variable temporelle est nulle
					if(x == joueur.tableauPion[j].getX() && y == joueur.tableauPion[j].getY()){	// si on a clicker sur une case pion
						temp = j;						//on met son indice dans la variable tampon
						fond = bouton.getIcon();		//on place l'image de fond a la place du pion
						tabBouton[i].setIcon(fond);
						
					}
					else{ // si on a pas clicker sur une case pion
						if(temp == -1){ //si la variable temporelle est vide
						System.out.println("Choisissez d'abord le pion a deplacer!");
						}
						else{ // si la variable temporelle est pleine
							if(deplacementPion(joueur.tableauPion[temp], x, y) == true){ // si le déplacement est possible
							if(combat(temp, x, y)==0){  //s'il s'agit d'un combat => match nul
								temp = -1;				//on vide la variable tempon
								fond = new ImageIcon ("image/images/StrategoBackground_"+y+x+".gif"); //on place l'image de fond a la place du pion de l'adversaire
								tabBouton[i].setIcon(fond);
							}
							if(combat(temp, x, y)==1){	//si le joueur gagne
								joueur.tableauPion[temp].setX(x);	//son pion prend les coordonnées de l'adversaire
								joueur.tableauPion[temp].setY(y);
								tabBouton[i].setIcon(joueur.tableauPion[temp].getI());	//on mets l'image du pion du joueur à la place de celui de l'adversaire
				    			temp = -1; // on "vide" la variable temporaire
							}
							if(combat(temp, x, y)==2){	//si l'adversaire gagne
				    			temp = -1; // on "vide" la variable temporaire
							}
							if(combat(temp, x, y)==-1){	//si erreur
								System.out.println("ERREUR");
							}
							}
							else{
								System.out.println("Placer le pion à un endroit autorisé!"); // dernier cas
							}
						}
					}
				}
				
			}
		}
	}
	/**
	 * Empeche le pion d'aller dans les 8 cases non valides
	 * @param x <=0 et x>=10 et y <=0 et y>=10
	 * @return false s'il s'agit d'une case non valides si non true
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