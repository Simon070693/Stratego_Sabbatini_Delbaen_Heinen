/**
 * Classe client permet d'envoyer les nouvelle coordonnées (tableauPion) à chaques déplacement.
 * Permet d'établir connexion TCP entre deux joueurs.
 */
package stratego;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class Client extends Joueur {
	
	InetAddress adresseLocale;
	Pion[] tableauAEmettre;
	Pion[] tableauRecu;
	private Principal p;
	private Socket soc;
	private ObjectOutputStream out;
	private ObjectInputStream in ;
	
	/**
	 * Constructeur de la classe Client.
	 * @param p = Principal
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Client(Principal p) throws IOException, ClassNotFoundException{
		super();
		tableauAEmettre= new Pion[40];
		for(int i = 0 ; i<=40; i++){
			tableauAEmettre[i]=p.joueur.tableauPion[i];
		}
		this.p.joueur=p.joueur;
		ServerSocket s = new ServerSocket(12345);
		soc = s.accept();
		out = new ObjectOutputStream(soc.getOutputStream());
		out.flush();	 
        in = new ObjectInputStream(soc.getInputStream()); 
        out.writeObject(tableauAEmettre);
        out.flush();       
        Object objetRecu = in.readObject();
        tableauRecu = (Pion []) objetRecu; // l'objet recoit le tableau de pions (il faut transmettre les coordonnées x et y)
	}
	
	/**
	 * Ferme le socket.
	 * @throws IOException
	 */
	public void fermerServeur() throws IOException{
		soc.close();
	}
	
	/**
	 * Lis l'objet reçu.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public void lireAttaque() throws ClassNotFoundException, IOException{
		Object objetRecu = in.readObject();
	}
	
	/**
	 * Envoie les coordonnées.
	 * @param coordonnee
	 * @throws IOException
	 */
	public void envoyerAttaque(int coordonnee) throws IOException{
		out.writeObject(coordonnee);
	}
}
