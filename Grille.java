/**
 * Créé le plateau du jeu.
 */
package stratego;

import javax.swing.Icon;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Button;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;


/**
 * @date 21/11/14
 * @author marie
 */
public class Grille extends javax.swing.JFrame {

    
    public Grille() {
    	javax.swing.JButton [][] grille = new javax.swing.JButton[10][10];
    	javax.swing.JButton [][] grilleDePlacement = new javax.swing.JButton[4][10];
    	initialise(grille);
    	javax.swing.JToggleButton capituler = new javax.swing.JToggleButton(); //boutton qui permet d'abandonner la partie.
        javax.swing.JLabel label = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); // ferme la fenetre
        setTitle("Stratego");
        
        JButton btnNewButton = new JButton("New button");
        getContentPane().add(btnNewButton, BorderLayout.CENTER);
        
        
       
    }
                   
    

    	/*
    	 * Initialise la grille de boutton.
    	 */
        public static void initialise(javax.swing.JButton [][] grille){
        	
        int k = 0; //premier chiffre de l'image
    	int l = 0; //deuxieme chiffre de l'image => StrategoBackground_00.gif => StrategoBackground_kl.gif
    	int x = 0; //permet de placer les cases avec setBounds() 
    	int y = 0; //permet de placer les cases avec setBounds() => setBounds(x, y, 50, 50)
    	
        for(int i=0; i<10; i++){
        	
        	for(int j=0; j<10; j++){        		
        	    
        		grille[i][j] = new javax.swing.JButton();
        	    
        		if(l==9){ // pour placer les images.
        	    	l=0;
        	    	k++;
        	    }
        	    grille[i][j].setIcon(new javax.swing.ImageIcon("image/images/StrategoBackground_"+k+l+".gif"));
        	    l++;
        	    
        	    
        	    if (x==450){ // pour placer les cases.
        	    	x=0;
        	    	y = y+50;
        	    }
        	    grille[i][j].setBounds(x, y, 50, 50);
        	    x = x+50;
        	}
        }
        } // fin de l'initialisation de la grille.
       
        
        
        
        /*
         * Initialise la grille de boutton où les pieces sont placées en début de partie.
         */
        public void initialise2 (javax.swing.JButton [][] grilleDePlacement){
        for(int i=0; i<5; i++){
        	for(int j=0; i<11; j++){        		
        	    grilleDePlacement[i][j] = new javax.swing.JButton();
        	}
        }
        } // fin de l'initialisation de la grille.
        
             			
        public void mouseClicked(java.awt.event.MouseEvent evt, javax.swing.JButton [][] grille, Pion[] tableauPion) {
        	javax.swing.JButton b1 = new javax.swing.JButton();
        	int temp = -1;
        	int i = evt.getY();
        	int j = evt.getX();
            b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/images/StrategoBackground_"+i+j+".gif")));
            Icon s = b1.getIcon();
        	if(grille[i][j].getIcon() != b1.getIcon()){ // s'il s'agit d'un pion        					
        		for(int m=0; i<101; i++){				//trouver quel pion est-ce
        			if(tableauPion[m].getX()== j && tableauPion[m].getY()== i){
        				temp = m;
        				s = b1.getIcon();
        			}
        		}
        	}
        	else{
        		if(temp == -1){
        			System.out.println("Choisissez d'abord le pion a deplacer!");
        		}
        		else{
        			tableauPion[temp].setX(j);
        			tableauPion[temp].setY(i);
        			tableauPion[temp].setI(s);
        			temp = -1; // "vide" la variable temporaire
        		}
        	}
        }
        
                                                                           

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Grille.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Grille.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Grille.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Grille.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }

//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//            	new Grille().setVisible(true);
//                initialise(grille);
//            }
//        });
    	new Grille().setVisible(true);
    }
}
