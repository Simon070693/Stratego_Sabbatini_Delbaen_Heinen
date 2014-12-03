package stratego;

import javax.swing.*;

import java.awt.GridLayout;


public class GrilleStratego extends JPanel {
	
	JButton[] tabBouton = new JButton[100];

	/**
	 * Create the panel.
	 */
	public GrilleStratego() {
		setLayout(new GridLayout(10, 10, 0, 0));
		int  numBouton = 0;
    	for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){        		
				tabBouton[numBouton] = new JButton();
				ImageIcon fond = new ImageIcon ("image/images/StrategoBackground_"+i+j+".gif");
				tabBouton[numBouton].setIcon(fond);
				add(tabBouton[numBouton]);
	        	numBouton = numBouton +1;
			}
		}
	}
}
