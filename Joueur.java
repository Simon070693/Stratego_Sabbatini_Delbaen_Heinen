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


public  class Joueur  implements Runnable {
	
	private Joueur adversaire;
	private boolean estPret;
	private boolean partieGagnee;
	private char color;
	private BufferedReader in;
	private PrintStream out;
	public Pion[] tableauPion;

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

	public Joueur(Socket socket, char couleur) {
		this(socket);
		this.color = couleur;
	}
	
	
	public boolean capitule(){
		return false;
	}
	
	public boolean encorePionJouable(Pion[] tabP){
		int i;
		int j;
		for(i=0; i<40; i++){
			j = tabP[i].getGrade(); 
			if(j < 11){
				return true;
			}
		}
		return false;
	}

	public void run() {}
}



