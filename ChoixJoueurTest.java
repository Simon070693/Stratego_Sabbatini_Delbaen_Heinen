package stratego;

import static org.junit.Assert.*;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.junit.Test;

public class ChoixJoueurTest {

	/**
	 * Pour tester la classe ChoixJoueur, il faut recréer une Jframe dans laquelle on rajoute le panel 1
	 * Dans le panel 1 on rajoute le contenu de ChoixJoueur, c'est à dire 2 boutons, 1 pour joueur avec les pions bleus
	 * et l'autre pour joueur avec les pions rouge
	 */
	@Test
	public void test() {
		ChoixJoueur panel1;
			JFrame frame=new JFrame();
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
			panel1 = new ChoixJoueur(); // pour l'instant on ne peu pas tester avec les paramètres car la classe joueur n'est pas fonctionelle
										//si on veut tester il suffit de mettre les paramètres en commentaires pour tester uniquement 
										//l'interface graphique
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						
						frame.add(panel1);
						panel1.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();  
				}
			}
			}); 
		}
		}

