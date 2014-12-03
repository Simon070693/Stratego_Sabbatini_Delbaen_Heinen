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
import java.util.Observable;

public  class Joueur extends Observable  implements Runnable {
	protected int numero;
	protected int nbPoints;
	protected BufferedReader in;
	protected PrintStream out;
	protected Joueur adversaire;
	protected boolean jouer;
	protected boolean jeuFini;
	protected boolean partieGagnee;
	protected boolean partiePerdue;

	public Joueur() {}

	public Joueur(Socket socket) {
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintStream(socket.getOutputStream());
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		(new Thread(this)).start();
		adversaire = new Joueur();
	}

	public Joueur(Socket socket, int numero) {
		this(socket);
		this.numero = numero;
	}
	
	public static boolean partieGagne(Drapeau d){
		if(d.estAttrape()==true){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean capitule(){
		return false;
	}
	
	public boolean encorePionJouable(Pion[] tabP){
		int i;
		int j;
		for(i=0; i<40; i++){
			j = tabP[i].getGrade(); 
			if(j == (int)j){
				return true;
			}
		}
		return false;
	}

	public void run() {}
}

