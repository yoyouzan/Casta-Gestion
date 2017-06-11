package fr.fatjon.jfdev.castagestion.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.fatjon.jfdev.castagestion.gui.actionlistener.CandidatAjoutActionListener;
import fr.fatjon.jfdev.castagestion.gui.actionlistener.MoniteurAjoutActionListener;

public class MoniteurAjoutJFrame extends JFrame{
	
	private MoniteurJFrame fenetrePrincipale;

	private JPanel panelAjoutMoniteur;
	private JLabel labelNomm;
	private JLabel labelPrenomm;
	private JTextField tfNomm;
	private JTextField tfPrenomm;
	private JButton btnAjout;
	
	public MoniteurAjoutJFrame(MoniteurJFrame fenetrePrincipale) {
		this.fenetrePrincipale = fenetrePrincipale;

		this.setTitle("Casta_Gestion - Ajout de moniteur");
		this.setSize(600, 300);
		this.setLocationRelativeTo(fenetrePrincipale);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setContentPane(genererPanelAjoutMoniteur());
	}
	
	private JPanel genererPanelAjoutMoniteur() {
		GridLayout gridLayout = new GridLayout(0, 2);
		this.panelAjoutMoniteur = new JPanel(gridLayout);

		// Création des éléments
		this.labelPrenomm = new JLabel("Prenom");
		this.tfPrenomm = new JTextField();
		this.labelNomm = new JLabel("Nom");
		this.tfNomm = new JTextField();
		this.btnAjout = new JButton("Ajouter");

		// ActionListener
		this.btnAjout.addActionListener(new MoniteurAjoutActionListener(this));

		// Ajout des éléments au Panel
		this.panelAjoutMoniteur.add(this.labelNomm);
		this.panelAjoutMoniteur.add(this.tfNomm);
		this.panelAjoutMoniteur.add(this.labelPrenomm);
		this.panelAjoutMoniteur.add(this.tfPrenomm);
		this.panelAjoutMoniteur.add(new JLabel(""));
		this.panelAjoutMoniteur.add(this.btnAjout);

		return panelAjoutMoniteur;
	}

	public JTextField getTfNomm() {
		return tfNomm;
	}

	public JTextField getTfPrenomm() {
		return tfPrenomm;
	}



	public MoniteurJFrame getFenetrePrincipale() {
		return fenetrePrincipale;
	}
	
	

}
