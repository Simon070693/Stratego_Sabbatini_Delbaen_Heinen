/**
 * 
 */
package stratego;

/**
 * @author Marie
 * @date 12/11/14
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.ImageIcon;


public  class Joueur{
	
	public Joueur adversaire;
	public char color;
	public Pion[] tableauPion = new Pion[40];
	public String[] nbPions = new String [12];
	public int[] nbPion = new int [12];
	
	/**
	 * Constructeur du joueur.
	 */
	public Joueur(){
		color = 'z';
		ImageIcon i0 = new ImageIcon ("image/images/PionsRouges/0.gif");
		ImageIcon i1 = new ImageIcon ("image/images/PionsRouges/1.gif");
		ImageIcon i2 = new ImageIcon ("image/images/PionsRouges/2.gif");
		ImageIcon i3 = new ImageIcon ("image/images/PionsRouges/3.gif");
		ImageIcon i4 = new ImageIcon ("image/images/PionsRouges/4.gif");
		ImageIcon i5 = new ImageIcon ("image/images/PionsRouges/5.gif");
		ImageIcon i6 = new ImageIcon ("image/images/PionsRouges/6.gif");
		ImageIcon i7 = new ImageIcon ("image/images/PionsRouges/7.gif");
		ImageIcon i8 = new ImageIcon ("image/images/PionsRouges/8.gif");
		ImageIcon i9 = new ImageIcon ("image/images/PionsRouges/9.gif");
		ImageIcon i10 = new ImageIcon ("image/images/PionsRouges/10.gif");
		ImageIcon i11 = new ImageIcon ("image/images/PionsRouges/11.gif");
		tableauPion[0] = new Pion(0,0,0,i0);
		tableauPion[1] = new Pion(0,1,0,i0);
		tableauPion[2] = new Pion(0,2,0,i0);
		tableauPion[3] = new Pion(0,3,0,i0);
		tableauPion[4] = new Pion(0,4,0,i0);
		tableauPion[5] = new Pion(0,5,0,i0);
		tableauPion[6] = new Pion(0,6,1,i1);
		tableauPion[7] = new Pion(0,7,2,i2);
		tableauPion[8] = new Pion(0,8,2,i2);
		tableauPion[9] = new Pion(0,9,2,i2);
		tableauPion[10] = new Pion(1,0,2,i2);
		tableauPion[11] = new Pion(1,1,2,i2);
		tableauPion[12] = new Pion(1,2,2,i2);
		tableauPion[13] = new Pion(1,3,2,i2);
		tableauPion[14] = new Pion(1,4,2,i2);
		tableauPion[15] = new Pion(1,5,3,i3);
		tableauPion[16] = new Pion(1,6,3,i3);
		tableauPion[17] = new Pion(1,7,3,i3);
		tableauPion[18] = new Pion(1,8,3,i3);
		tableauPion[19] = new Pion(1,9,3,i3);
		tableauPion[20] = new Pion(2,0,4,i4);
		tableauPion[21] = new Pion(2,1,4,i4);
		tableauPion[22] = new Pion(2,2,4,i4);
		tableauPion[23] = new Pion(2,3,4,i4);
		tableauPion[24] = new Pion(2,4,5,i5);
		tableauPion[25] = new Pion(2,5,5,i5);
		tableauPion[26] = new Pion(2,6,5,i5);
		tableauPion[27] = new Pion(2,7,5,i5);
		tableauPion[28] = new Pion(2,8,6,i6);
		tableauPion[29] = new Pion(2,9,6,i6);
		tableauPion[30] = new Pion(3,0,6,i6);
		tableauPion[31] = new Pion(3,1,6,i6);
		tableauPion[32] = new Pion(3,2,7,i7);
		tableauPion[33] = new Pion(3,3,7,i7);
		tableauPion[34] = new Pion(3,4,7,i7);
		tableauPion[35] = new Pion(3,5,8,i8);
		tableauPion[36] = new Pion(3,6,8,i8);
		tableauPion[37] = new Pion(3,7,9,i9);
		tableauPion[38] = new Pion(3,8,10,i10);
		tableauPion[39] = new Pion(3,9,11,i11);
		nbPions[0] = "Bombe";
		nbPion[0] = 6;
		nbPions[1] ="Espion";
		nbPion[1] = 1;
		nbPions[2] ="Eclaireur";
		nbPion[2] = 8;
		nbPions[3] ="Demineur";
		nbPion[3] = 5;
		nbPions[4] ="Sergent";
		nbPion[4] = 4;
		nbPions[5] ="Lieutenant";
		nbPion[5] = 4;
		nbPions[6] ="Capitaine";
		nbPion[6] = 4;
		nbPions[7] ="Commendant";
		nbPion[7] = 3;
		nbPions[8] ="Colonnel";
		nbPion[8] = 2;
		nbPions[9] ="General";
		nbPion[9] = 1;
		nbPions[10] ="Marechal";
		nbPion[10] = 1;
		nbPions[11] ="Drapeau";
		nbPion[11] = 1;
	}
	
	/**
	 * Permet de savoir si un joueur capitule.
	 */
	public boolean capitule(){
		return false;
	}
	
	/**
	 * Permet de savoir si le joueur a encore des pions déplaçables.
	 */
	public boolean encorePionJouable(Pion[] tabP){
		int i;
		int j;
		for(i=0; i<40; i++){
			j = tabP[i].getGrade(); 
			if(j> 0 && j<11){
				return true;
			}
		}
		return false;
	}
}



