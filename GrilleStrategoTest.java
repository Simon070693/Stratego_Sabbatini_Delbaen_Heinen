/**
 * Test de la classe GrilleStratego
 */
package stratego;


import static org.junit.Assert.*;

import javax.swing.ImageIcon;

import org.junit.Test;

/**
 * @author marie
 */
public class GrilleStrategoTest{
	
	Principal p = new Principal();
	GrilleStratego g = new GrilleStratego(p);
	
	
	@Test
	public void test() {
		
						
		assertEquals(false,g.estDeplacementPossible(4, 5, p.joueur.tableauPion[0]));
		assertEquals(false,g.estDeplacementPossible(7, 6, p.joueur.tableauPion[39]));
		assertEquals(false,g.estDeplacementPossible(8, 5, p.joueur.tableauPion[31]));
		assertEquals(true,g.estDeplacementPossible(1, 8, p.joueur.tableauPion[31]));
		assertEquals(false,g.deplacementPion(p.joueur.tableauPion[31], 5, 2));
		assertEquals(false,g.deplacementPion(p.joueur.tableauPion[39], 4, 9));
	}

}
