/**
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
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur extends Joueur {

	private Principal p;
	private Socket soc;
	Pion[] tableauAEmettre;
	Pion[] tableauRecu;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	/**
	 * Constructeur qui permet d'envoyer un tableau de pion .
	 */
	public Serveur(Principal p) throws IOException, ClassNotFoundException{ // il faut lancer le serveur en même temps que le jeu
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
        tableauRecu = (Pion []) objetRecu;
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
	public void lireDeplacement() throws ClassNotFoundException, IOException{
		Object objetRecu = in.readObject();	
	}
	
	/**
	 * Envoie les coordonnées.
	 * @param coordonee
	 * @throws IOException
	 */
	public void envoyerDeplacement(int coordonee) throws IOException{
		out.writeObject(coordonee);
		
	}
}
