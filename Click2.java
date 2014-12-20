/**
 * Redéfinit ActionListener.
 */
package stratego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Click2 implements ActionListener{
    private Principal p;
    private int j;
    private int i;
    private int k;
   
    /**
     * Constructeur de Click2
     * @param p = Principal
     * @param j != null
     * @param i != null
     * @param k != null
     */
    public Click2(Principal p, int j, int i, int k){
        this.p = p;
        this.j = j;
        this.i = i;
        this.k = k;
    }
    
    public void actionPerformed(final ActionEvent arg0)    {
    	if(j==0){
    		i++;
    	}
    	if(i==12){
    		p.getContentPane().remove(p.panel2);
        	p.setContentPane(p.panel3);
        	p.getContentPane().validate();
            p.repaint();
    	}
    }
}

