/**
 * Classe qui permet de cr�er la grille du jeu.
 */
package stratego;

import javax.swing.*;

import java.awt.GridLayout;

/**
 * @author Marie,Lionel,Simon
 * @date 12/12/14
 */

public class GrilleStratego extends JPanel {
	
	private Case[] tabBouton;			//permet de cr�er la grille de jeu
	private Principal p;
	
	

	/**
	 * Constructeur de la classe
	 */
	public GrilleStratego(Principal p) {
		tabBouton = new Case[100];
		this.p = p;
		setLayout(new GridLayout(10, 10, 0, 0));
		int numBouton = 0;

		int k=0;
		
		for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){
				tabBouton[numBouton] = new Case(j,i);
				ImageIcon fond = new ImageIcon();
				
				if(k<40 && (p.joueur.tableauPion[k].getX() == j) && (p.joueur.tableauPion[k].getY() == i)){
					fond = p.joueur.tableauPion[k].getI();
				}
				else{
					fond = new ImageIcon("image/images/StrategoBackground_"+i+j+".gif");
				}
				
				tabBouton[numBouton].setIcon(fond);
				add(tabBouton[numBouton]);
	        	numBouton = numBouton +1;
	        	k++;
			}
		}
		
	}

    /**
	 * M�thode permettant de g�rer les click du joueur.
	 */
	public void MouseClicked(java.awt.event.MouseEvent evt) {                                 
		int temp = -1;					//variable tampon pouvant occup� l'indice du pion s�lectionn�. -1 = "vide"
		int x = evt.getX();				//mets dans la variable x l'abscisse de la case sur laquelle le joueur a clicker
		int y = evt.getY();				//mets dans la variable y l'ordonn�e  de la case sur laquelle le joueur a clicker
		Case bouton = new Case(y,x);
		Icon fond = new ImageIcon ();
		
		for(int i = 0; i<100; i++){
			if(bouton.getIcon() == tabBouton[i].getIcon() && temp!= -1){	//cas ou un pion a d�j� �t� s�lectionn� et que le joueur souhaite le placer sur une case valide non occup�e
				if(estDeplacementPossible(x, y, p.joueur.tableauPion[temp]) == true && deplacementPion(p.joueur.tableauPion[temp], x, y) == true){ //si le d�placement est possible
					p.joueur.tableauPion[temp].setX(x);						//modifie la position du pion
					p.joueur.tableauPion[temp].setY(y);						//modifie la position du pion
					tabBouton[i].setIcon(p.joueur.tableauPion[temp].getI());	//change l'icon de fond par celle du pion
	    			temp = -1;												// "vide" la variable temporaire
				//connexion ac client -> client =>"message ok tour fini" a server
				}
				else{
					System.out.println("Placer le pion � un endroit autoris�!"); //si le d�placement n'est pas possible
				}
			}
			else{
				for(int j = 0; j<40; j++){		//cas ou la variable temporelle est nulle
					if(x == p.joueur.tableauPion[j].getX() && y == p.joueur.tableauPion[j].getY()){	// si on a clicker sur une case pion
						temp = j;						//on met son indice dans la variable tampon
						fond = bouton.getIcon();		//on place l'image de fond a la place du pion
						tabBouton[i].setIcon(fond);
						
					}
					else{ // si on a pas clicker sur une case pion
						if(temp == -1){ //si la variable temporelle est vide
						System.out.println("Choisissez d'abord le pion a deplacer!");
						}
						else{ // si la variable temporelle est pleine
							if(deplacementPion(p.joueur.tableauPion[temp], x, y) == true){ // si le d�placement est possible
							if(combat(temp, x, y)==0){  //s'il s'agit d'un combat => match nul
								temp = -1;				//on vide la variable tempon
								fond = new ImageIcon ("image/images/StrategoBackground_"+y+x+".gif"); //on place l'image de fond a la place du pion de l'adversaire
								tabBouton[i].setIcon(fond);
								//connexion ac client -> client =>"message ok tour fini" a server
							}
							if(combat(temp, x, y)==1){	//si le joueur gagne
								p.joueur.tableauPion[temp].setX(x);	//son pion prend les coordonn�es de l'adversaire
								p.joueur.tableauPion[temp].setY(y);
								tabBouton[i].setIcon(p.joueur.tableauPion[temp].getI());	//on mets l'image du pion du joueur � la place de celui de l'adversaire
				    			temp = -1; // on "vide" la variable temporaire
				    			//connexion ac client -> client =>"message ok tour fini" a server
							}
							if(combat(temp, x, y)==2){	//si l'adversaire gagne
				    			temp = -1; // on "vide" la variable temporaire
				    			//connexion ac client -> client =>"message ok tour fini" a server
							}
							if(combat(temp, x, y)==-1){	//si erreur
								System.out.println("ERREUR");
							}
							}
							else{
								System.out.println("Placer le pion � un endroit autoris�!"); // dernier cas
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
	public boolean estDeplacementPossible(int x, int y, Pion p1){
		if(p1.getGrade()== 0 || p1.getGrade()==11){
			return false;
		}
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
	 * Empeche le pion de se deplacer de plus d'une case sauf s'il s'agit de l'�craireur.
	 * @param p1 non null
	 * @param x = x de la case ou on veut positionner le pion.
	 * @param y = y de la case ou on veut positionner le pion.
	 * @return true si le deplacement est valide si non false.
	 */
	public boolean deplacementPion(Pion p1, int x, int y){
		if(p1.getGrade()== 0 || p1.getGrade()==11){
			return false;
		}
		if((p1.getX() == x+1) && (p1.getGrade()!=2) && (p1.getY() == y)){
			return true;
		}
		if((p1.getX() == x-1) && (p1.getGrade()!=2) && (p1.getY() == y)){
			return true;
		}
		if((p1.getY() == y+1) && (p1.getGrade()!=2) && (p1.getX() == x)){
			return true;
		}
		if((p1.getY() == y-1) && (p1.getGrade()!=2) && (p1.getX() == x)){
			return true;
		}
		else{
			return false;
		}
		
	}
	/**
	 * Trouve lequel des deux pions est le plus fort.
	 * @return 1 si le joueur est le plus fort, 2 si c'est l'adversaire et 0 s'ils sont �gaux.
	 */
	public int combat(int temp, int x, int y){
		for(int i = 0; i<40; i++){
			if((p.joueur.adversaire.tableauPion[i].getY() == y) && (p.joueur.adversaire.tableauPion[i].getX() == x)){
				if((p.joueur.adversaire.tableauPion[i].getGrade()> p.joueur.tableauPion[temp].getGrade())){
					System.out.println("Il est plus fort que vous...Son grade ="+p.joueur.adversaire.tableauPion[i].getGrade());
					return 2;
				}
				if((p.joueur.adversaire.tableauPion[i].getGrade()< p.joueur.tableauPion[temp].getGrade())){
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