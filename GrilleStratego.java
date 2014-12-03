package stratego;

import javax.swing.*;
import  java.awt.event.*;
import java.awt.GridLayout;


public class GrilleStratego extends JPanel {
	
	Case[] tabBouton = new Case[100];
	JButton[] tabBout = new JButton[40];
	Joueur j1;
	int [] nbPions= new int [12];
	

	/**
	 * Create the panel.
	 */
	public GrilleStratego() {
		nbPions[0]=5;
		nbPions[1]=1;
		nbPions[2]=1;
		nbPions[3]=2;
		nbPions[4]=3;
		nbPions[5]=4;
		nbPions[6]=4;
		nbPions[7]=4;
		nbPions[8]=5;
		nbPions[9]=8;
		nbPions[10]=1;
		nbPions[11]=1;
		
		
		setLayout(new GridLayout(14, 10, 0, 0));
		int  numBouton = 0;
    	for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){        		
				tabBouton[numBouton] = new Case(j,i);
				ImageIcon fond = new ImageIcon ("image/images/StrategoBackground_"+i+j+".gif");
				tabBouton[numBouton].setIcon(fond);
				add(tabBouton[numBouton]);
	        	numBouton = numBouton +1;
	     
			}
		}
    	int numBout = 0;
    	for(int i=0; i<10; i++){ 
    		for(int j=0; j<4; j++){ 
    			tabBout[numBout] = new JButton();
    			//if (j1.color == 'B'){
    				int k=0;
    				int compteur= nbPions[k];
    				while (compteur>0){
    					ImageIcon fond = new ImageIcon ("image/images/PionsBleus/"+k+".gif");
    					tabBout[numBout].setIcon(fond);
    					add(tabBout[numBout]);
    	    			numBout = numBout +1; 
    					compteur--; 
    					}
    				k++; 
    				} 
    			/*else{
    				int k=0;
    				int compteur= nbPions[k];
    				while (compteur>0){
    					ImageIcon fond = new ImageIcon ("image/images/PionsBleus/"+k+".gif");
    					tabBout[numBout].setIcon(fond);
    					add(tabBout[numBout]);
    	    			numBout = numBout +1;
    					compteur--; 
    					}
    				k++; 
    				} 
    			
    			
    			}*/
    		}
    	}
    			
	
	
	public void MouseClicked(java.awt.event.MouseEvent evt) {                                 
		
		int temp = -1;
		int b;
		int x = evt.getX();
		int y = evt.getY();
		Case bouton = new Case(x,y);
		Icon fond = new ImageIcon ();
		
		for(int i = 0; i<100; i++){
			if(bouton.getIcon() == tabBouton[i].getIcon()){
				j1.tableauPion[temp].setX(x);
				j1.tableauPion[temp].setY(y);
				j1.tableauPion[temp].setI(fond);
    			temp = -1; // "vide" la variable temporaire
			}
			else{
				for(int j = 0; j<40; j++){
					if(x == j1.tableauPion[j].getX() && y == j1.tableauPion[j].getY()){
						temp = j;
						fond = j1.tableauPion[j].getI();
					}
					else{
						System.out.println("Choisissez d'abord le pion a deplacer!");
					}
				}
				
			}
		}
	}
}