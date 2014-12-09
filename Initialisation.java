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

public class Initialisation extends JPanel {

	
	private static final long serialVersionUID = 4L;
	private int ok = 0;

	public IniPion [] nbPions;
	public Pion[] tableauPion;
	Joueur joueur;
	private JTextField txtInitialisationDeLa;
	private JTextField txtOuVoulezVous;
	JComboBox<?> comboBox;
	JComboBox<?> comboBox_1;
	int x;
	int y;
	int FINI = 0;

	
	/**
	 * Create the panel.
	 */
	public Initialisation(Joueur joueur, Pion[] tableauPion, int FINI, IniPion [] nbPions) {
		this.joueur = joueur;
		this.tableauPion = tableauPion;
		this.FINI = FINI;
		this.nbPions = nbPions;
		
		/**
		 * Initialise le tableau avec le pions disponibles et leur nom
		 */
		nbPions[0].a="Bombe";
		nbPions[0].i= 5;
		nbPions[1].a="Espion";
		nbPions[1].i= 1;
		nbPions[2].a="Eclaireur";
		nbPions[2].i= 8;
		nbPions[3].a="Demineur";
		nbPions[3].i= 5;
		nbPions[4].a="Sergent";
		nbPions[4].i= 4;
		nbPions[5].a="Lieutenant";
		nbPions[5].i= 4;
		nbPions[6].a="Capitaine";
		nbPions[6].i= 4;
		nbPions[7].a="Commendant";
		nbPions[7].i= 3;
		nbPions[8].a="Colonnel";
		nbPions[8].i= 2;
		nbPions[9].a="General";
		nbPions[9].i= 1;
		nbPions[10].a="Marechal";
		nbPions[10].i= 1;
		nbPions[11].a="Drapeau";
		nbPions[11].i= 1;
		
		
		gridBagLayoutInit ();
		JTextInit ();
		TextPaneInit ();
		boxInit();
		BoutonOK(this.nbPions);
		FINI = 1;
		
	}
		
		/**
		 * Initialise le gridBagLayout
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
		 * Titre
		 */
	public void JTextInit (){
		txtInitialisationDeLa = new JTextField();
		txtInitialisationDeLa.setText("Initialisation");
		GridBagConstraints gbc_txtInitialisationDeLa = new GridBagConstraints();
		gbc_txtInitialisationDeLa.insets = new Insets(0, 0, 5, 5);
		gbc_txtInitialisationDeLa.gridx = 3;
		gbc_txtInitialisationDeLa.gridy = 0;
		add(txtInitialisationDeLa, gbc_txtInitialisationDeLa);
		txtInitialisationDeLa.setColumns(10);
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
	
	public void BoutonOK(IniPion [] nbPions){
		
		ImageIcon icon = null;
		JButton btnOk = new JButton("OK");
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.insets = new Insets(0, 0, 0, 5);
		gbc_btnOk.gridx = 3;
		gbc_btnOk.gridy = 9;
		add(btnOk, gbc_btnOk);
		int k = 0;
		for(int i =0; i<12; i++){
			for(int j = nbPions[i].i; j>0; j-- ){
				while(ok == 0){
				txtOuVoulezVous = new JTextField();
				txtOuVoulezVous.setText("ou voulez vous placer :"+nbPions[i].a+" ");
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
				x = ((int)comboBox.getSelectedItem());
				tableauPion[k].setX(x);
				y = ((int)comboBox_1.getSelectedItem());
				tableauPion[k].setY(y);
				
				/*
				 * on initialise le grade et l'icon
				 */
				tableauPion[k].setGrade(i);
				if(joueur.color == 'b' ){
					icon = new ImageIcon ("image/images/PionsBleus"+i+".gif");
				}
				if(joueur.color == 'r' ){
					icon = new ImageIcon ("image/images/PionsRouges"+i+".gif");
					}
				tableauPion[k].setI(icon);
				
			
			}
			btnOk.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent arg0) {
			    	if (btnOk.isEnabled()) {
			            ok = 1;
			        }
			    }
			});
			}
			ok = 0;
		}
	}
	

}
