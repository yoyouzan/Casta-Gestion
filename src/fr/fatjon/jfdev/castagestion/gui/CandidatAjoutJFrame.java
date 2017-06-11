package fr.fatjon.jfdev.castagestion.gui;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.lang.reflect.GenericSignatureFormatError;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.fatjon.jfdev.castagestion.gui.actionlistener.CandidatAjoutActionListener;

public class CandidatAjoutJFrame extends JFrame {
	private CandidatJFrame fenetrePrincipale;

	private JPanel panelAjoutCandidat;
	private JLabel labelNom;
	private JLabel labelPrenom;
	private JLabel labelPseudo;
	private JLabel labelMdp;
	private JLabel labelEmail;
	private JLabel labelTel;
	private JTextField tfNom;
	private JTextField tfPrenom;
	private JTextField tfPseudo;
	private JTextField tfMdp;
	private JTextField tfEmail;
	private JTextField tfTel;
	private JButton btnAjout;

	public CandidatAjoutJFrame(CandidatJFrame fenetrePrincipale) {
		this.fenetrePrincipale = fenetrePrincipale;

		this.setTitle("Casta_Gestion - Ajout de candidat");
		this.setSize(600, 300);
		this.setLocationRelativeTo(fenetrePrincipale);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setContentPane(genererPanelAjoutCandidat());
	}

	private JPanel genererPanelAjoutCandidat() {
		GridLayout gridLayout = new GridLayout(0, 2);
		this.panelAjoutCandidat = new JPanel(gridLayout);

		// Création des éléments
		this.labelPrenom = new JLabel("Prenom");
		this.tfPrenom = new JTextField();
		this.labelNom = new JLabel("Nom");
		this.tfNom = new JTextField();
		this.labelPseudo = new JLabel("Pseudo");
		this.tfPseudo = new JTextField();
		this.labelMdp = new JLabel("Mot de Passe");
		this.tfMdp = new JTextField();
		this.labelEmail= new JLabel("Email");
		this.tfEmail = new JTextField();
		this.labelTel= new JLabel("Telephone");
		this.tfTel = new JTextField();
		this.btnAjout = new JButton("Ajouter");

		// ActionListener
		this.btnAjout.addActionListener(new CandidatAjoutActionListener(this));

		// Ajout des éléments au Panel
		this.panelAjoutCandidat.add(this.labelNom);
		this.panelAjoutCandidat.add(this.tfNom);
		this.panelAjoutCandidat.add(this.labelPrenom);
		this.panelAjoutCandidat.add(this.tfPrenom);
		this.panelAjoutCandidat.add(this.labelPseudo);
		this.panelAjoutCandidat.add(this.tfPseudo);
		this.panelAjoutCandidat.add(this.labelMdp);
		this.panelAjoutCandidat.add(this.tfMdp);
		this.panelAjoutCandidat.add(this.labelEmail);
		this.panelAjoutCandidat.add(this.tfEmail);
		this.panelAjoutCandidat.add(this.labelTel);
		this.panelAjoutCandidat.add(this.tfTel);
		this.panelAjoutCandidat.add(new JLabel(""));
		this.panelAjoutCandidat.add(this.btnAjout);

		return panelAjoutCandidat;
	}

	// Getters
	

	public JTextField getTfNom() {
		return tfNom;
	}

	public JTextField getTfPrenom() {
		return tfPrenom;
	}
	
	public JTextField getTfPseudo() {
		return tfPseudo;
	}

	public JTextField getTfMdp() {
		return tfMdp;
	}

	public JTextField getTfEmail() {
		return tfEmail;
	}

	public JTextField getTfTel() {
		return tfTel;
	}

	public CandidatJFrame getFenetrePrincipale() {
		return fenetrePrincipale;
	}
	
	
	
	public CandidatJFrame getFenetrePrincipale() {
		return fenetrePrincipale;
	}
	public CandidatJFrame getFenetrePrincipale() {
		return fenetrePrincipale;
	}


	
	
	
	
	

}
