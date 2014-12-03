package stratego;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

	public class JoueurServeur extends Joueur implements Runnable  {
		private ServeurStratego serveur;

		public JoueurServeur(Socket socket, int numero, ServeurStratego serveur) {
			super(socket, numero);
			this.serveur = serveur;
		}

		//public void envoyerNumero() {
		//	out.println(Constantes.NUM + " " + numero);
		//}
		void traiterMessage(String message) {
			int type;
			Scanner scan = new Scanner(message);

			type =scan.nextInt();

			//switch (type) {
			//case Constantes.CHOIX : choix = Choix.valueOf(scan.next());
			//serveur.prevenirAdversaire(numero);
			//serveur.examinerChoix();
			//break;
			//}
		}

		//public void aGagne() {
		//	super.partieGagne(Drapeau d);
		//	out.println("");
		//	if (partieGagne(Drapeau d)) out.println(""); 
		//}

		//public void aPerdu() {
		//	super.aPerdu();
		//	out.println(Constantes.PERDU);
		//	if (adversaire.partieGagnee()) out.println(Constantes.PARTIE_PERDUE);
		//}


		public void run() {
			String message;

			try {
				message = in.readLine();
				while (!jeuFini) {
					traiterMessage(message);
					message = in.readLine();
				}
			}
			catch(IOException exc) {

			}
		}
}
