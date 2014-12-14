/**
 * Classe Initialisation, initialise la postion des pions à placer.
 */

package stratego;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * @author Marie,Lionel,Simon
 * @date 12/12/14
 */

public class Initialisation extends JPanel {

	
	
	private int ok = 0;							//variable qui indique lorsqu'on à appuyé sur le bouton ok
	public String [] nbPions = new String[12];  //tableau contenant les noms des différents pions
	public int [] nbPion = new int[12];			//tableau contenant le nombres de pions de chaques sortes
	public Pion[] tableauPion = new Pion[40];	//tableau contenant les pions initialisés du joueur
	private Joueur joueur;						//le joueur
	private JTextField txtInit;					//JTextField contenant le titre du panel "Initialisation
	private JTextField txtOuVoulezVous;			//JTextField donne des indications à l'utilisateur
	private JComboBox<?> comboBox;				//Première boîte pour choisir où placer le pion
	private JComboBox<?> comboBox_1;			//Deuxième boîte pour choisir où placer le pion
	
	/**
	 * Constructeur du panel Initialisation.
	 * @param FINI != 1, nbPions != null, nbPion != null
	 */
	public Initialisation(Joueur joueur, String [] nbPions, int [] nbPion) {
		this.joueur = joueur;
		this.tableauPion = joueur.tableauPion;
		this.nbPions = nbPions;		
		gridBagLayoutInit ();
		JTextInit ();
		TextPaneInit ();
		boxInit();
		BoutonOK(nbPions, nbPion, joueur.tableauPion);
	}
	/**
	 * Initialise le gridBagLayout.
	 */
	public void gridBagLayoutInit (){
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
	}
	/**
	 * Titre.
	 */
	public void JTextInit (){
		txtInit = new JTextField();
		txtInit.setText("Initialisation");
		GridBagConstraints gbc_txtInit = new GridBagConstraints();
		gbc_txtInit.insets = new Insets(0, 0, 5, 5);
		gbc_txtInit.gridx = 3;
		gbc_txtInit.gridy = 0;
		add(txtInit, gbc_txtInit);
		txtInit.setColumns(10);
	}
	/**
	 * Texte expliquant ce que l'utilisateur doit faire.
	 */
	public void TextPaneInit (){
		JTextPane textPane = new JTextPane();
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.gridwidth = 3;
		StringBuilder sb = new StringBuilder();
		sb.append("Vous allez a present choisir où placer vos pions.").append("\n");
		sb.append("La première boîte vous fera choisir le numéro de la ligne..").append("\n");
		sb.append("La deuxieme le numero de la colonne.").append("\n");
		gbc_textPane.gridheight = 4;
		gbc_textPane.insets = new Insets(0, 0, 5, 5);
		gbc_textPane.fill = GridBagConstraints.BOTH;
		gbc_textPane.gridx = 2;
		gbc_textPane.gridy = 2;
		add(textPane, gbc_textPane);
	}
	/**
	 * Permet à l'utilisateur de choisir où placer ses pions en début de partie.
	 */
	public void boxInit (){
		
		String [] tab = {"1","2","3","4"};
		
		comboBox_1 = new JComboBox<Object>(tab);
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 2;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 0;
		gbc_comboBox_1.gridy = 6;
		add(comboBox_1, gbc_comboBox_1);
		
		String [] tab2 ={"1","2","3","4","5","6","7","8","9","10"};
		
		comboBox = new JComboBox<Object>(tab2);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 5;
		gbc_comboBox.gridy = 6;
		add(comboBox, gbc_comboBox);
	}
	/**
	 * Initialise le bouton ok et place dans le tableau "tableauPion" les choix de l'utilisateur sur la postion de ses pions.
	 * @param nbPions != null
	 * @param nbPion != null
	 */
	public void BoutonOK(String [] nbPions, int [] nbPion, Pion [] tableauPion){
		int j = 0;
		int x;
		int y;
		ImageIcon icon = null;
		JButton btnOk = new JButton("OK");												//initialise le bouton ok
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.insets = new Insets(0, 0, 0, 5);
		gbc_btnOk.gridx = 3;
		gbc_btnOk.gridy = 9;
		add(btnOk, gbc_btnOk);
		int k = 40;																		//nombre de boutons dans le tableau
		for(int i =0; i<12; i++){
			j = nbPion[i];															
			while(j>=1){																//tant qu'il reste la même sorte de pions à placé
				k--;
				txtOuVoulezVous = new JTextField();
				txtOuVoulezVous.setText("ou voulez vous placer :"+nbPions[i]+" ");
				GridBagConstraints gbc_txtOuVoulezVous = new GridBagConstraints();
				gbc_txtOuVoulezVous.insets = new Insets(0, 0, 5, 5);
				gbc_txtOuVoulezVous.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtOuVoulezVous.gridx = 3;
				gbc_txtOuVoulezVous.gridy = 5;
				add(txtOuVoulezVous, gbc_txtOuVoulezVous);
				txtOuVoulezVous.setColumns(10);
				
				/*
				 * dans le tableau de pion on initialise les positions choisies par l'utilisateur.
				 */
				x = Integer.valueOf((String)comboBox.getSelectedItem());
		
				y =Integer.valueOf((String)comboBox_1.getSelectedItem());
				
				
				/*
				 * on initialise le grade et l'icon
				 */
				if(joueur.color == 'b' ){
					icon = new ImageIcon ("image/images/PionsBleus"+i+".gif");
				}
				else{
					icon = new ImageIcon ("image/images/PionsRouges"+i+".gif");
					}
				
				tableauPion[k] = new Pion(x, y, i, icon);
			
				btnOk.addActionListener(new ActionListener() {									//permet de savoir quand l'utilisateur à terminé de choisir
				    public void actionPerformed(ActionEvent arg0) {
				    	if (btnOk.isEnabled()) {
				            ok = 1;
				        }
				    }
				});
				
				if(ok==1){
					j--;
				}				
			}
		}
	}
}
	


