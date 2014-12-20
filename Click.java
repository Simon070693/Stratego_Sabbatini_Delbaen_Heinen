/**
 * Redéfinit ActionListener
 */
package stratego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Click implements ActionListener{
    private Principal p;
    private char c;
   
    /**
     * Constructeur de Click.
     * @param p = Principal
     * @param c == 'r' | c== 'b'
     */
    public Click(Principal p, char c){
        this.p = p;
        this.c = c;
    }
    
    public void actionPerformed(final ActionEvent arg0)
    {
    	p.joueur.color = c;
    	p.getContentPane().remove(p.panel1);
    	p.setContentPane(p.panel2);
    	p.getContentPane().validate();
        p.repaint();
        
    	
    }
}

