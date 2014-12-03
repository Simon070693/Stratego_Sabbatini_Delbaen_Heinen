package stratego;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
	


public class ServeurStratego {
	
	private JoueurServeur[] lesJoueurs;
	private int numSuivant = 0;
	
	public ServeurStratego(JoueurServeur[] lesJoueurs) {
			this.lesJoueurs = lesJoueurs;
	}

	public void ajouterJoueur(Socket socket) {
			lesJoueurs[numSuivant] = new JoueurServeur(socket, numSuivant, this);
			numSuivant++;
			if (numSuivant == 2) donnerFeuVert();
	}

	public void traiterMessage(String message, Joueur joueur) {
			System.out.println(message);
			Scanner scan = new Scanner(message);
			int type = scan.nextInt();
	}

	/*public void chercherJoueurGagnant() {
			attendre();
			Choix choix0 = lesJoueurs[0].choix;
			Choix choix1 = lesJoueurs[1].choix;
			if (choix0.equals(choix1)) egalite();
			if (choix0 == Choix.CISEAUX) {
				if (choix1 ==  Choix.FEUILLE) validerGain(0);
				else if  (choix1 ==  Choix.CAILLOU) validerGain(1);
			}
			else if (choix0 == Choix.FEUILLE)  {
				if (choix1 ==  Choix.CAILLOU) validerGain(0); 
				else if  (choix1 ==  Choix.CISEAUX) validerGain(1); 
			}
			else if (choix0 == Choix.CAILLOU)  {
				if (choix1 ==  Choix.CISEAUX) validerGain(0);  
				else if  (choix1 ==  Choix.FEUILLE) validerGain(1); 
			}
		}*/
		
		
		//public void annulerChoix() {
		//	lesJoueurs[0].choix = null;
		//	lesJoueurs[1].choix = null;
		//}

		
		public void donnerFeuVert() {
			for (JoueurServeur j : lesJoueurs) j.envoyerNumero();
		}

		public static void main(String[] arg) throws Exception {
			int portStratego = 4567;
			ServerSocket  receptionniste =  new ServerSocket(portStratego);		
			JoueurServeur[] lesJoueurs = new JoueurServeur[2];

			ServeurStratego serveur = new ServeurStratego(lesJoueurs);
			for (int i = 0; i < 2; i++)	serveur.ajouterJoueur(receptionniste.accept());

			new ServeurStratego(lesJoueurs);
		}

}
