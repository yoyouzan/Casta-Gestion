package fr.fatjon.jfdev.castagestion.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.fatjon.jfdev.castagestion.dao.CandidatDao;
import fr.fatjon.jfdev.castagestion.gui.actionlistener.CandidatBtnActionListener;



public class CandidatJFrame extends TemplateJFrame {

	private BorderLayout borderLayout;
	private JPanel jpHome;
	private JPanel jpTableauCandidats;
	private JTable tabCandidats;

	// Boutons
	private JPanel jpControles;
	private JButton btnSupprimer;
	private JButton btnModifier;
	private JButton btnInserer;

	
	
	public CandidatJFrame() throws HeadlessException {
        setContentPane(creerPanelPrincipal());     
    }
	
    public void rafraichirFenetre() {
        CandidatJFrame candidatJFrame = new CandidatJFrame();   
        candidatJFrame.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }
    
	private JPanel creerPanelPrincipal() {

		borderLayout = new BorderLayout();
		
        jpHome = new JPanel(borderLayout);
        jpTableauCandidats = new JPanel();
        
        String[] colonnes = {"Id", "Nom", "Prenom", "Pseudo", "Mot de passe", "Email", "Telephone"};
        
        ModeleTableauCandidat modeleTableauCandidat = new ModeleTableauCandidat(new CandidatDao().recuperer());
        
        tabCandidats = new JTable(modeleTableauCandidat);
        
        jpTableauCandidats.add(new JScrollPane(tabCandidats));
        jpHome.add(creerPanelControles(), BorderLayout.WEST);
        jpHome.add(jpTableauCandidats, BorderLayout.CENTER);
        
        return jpHome;
	}
	
	
	private JPanel creerPanelControles() {

		GridLayout gridLayout = new GridLayout(0, 1);
		jpControles = new JPanel(gridLayout);

		// Creer les boutons
		btnInserer = new JButton("Inserer");
		btnModifier = new JButton("Modifier");
		btnSupprimer = new JButton("Supprimer");

		
		//Ajout des ActionListener
		ActionListener candidatActionListener = new CandidatBtnActionListener(this);
		btnInserer.addActionListener(candidatActionListener);
		btnModifier.addActionListener(candidatActionListener);
		btnSupprimer.addActionListener(candidatActionListener);

		// Ajout des boutons au panel de controle
		jpControles.add(btnInserer);
		jpControles.add(btnModifier);
		jpControles.add(btnSupprimer);


		return jpControles;
	}

	// Getters


	public JTable getTabCandidats() {
		return tabCandidats;
	}

	public JButton getBtnSupprimer() {
		return btnSupprimer;
	}

	public JButton getBtnModifier() {
		return btnModifier;
	}

	public JButton getBtnInserer() {
		return btnInserer;
	}

	public void refreshTable() {
		throw new UnsupportedOperationException("Not supported yet."); // To
																		// change
																		// body
																		// of
																		// generated
																		// methods,
																		// choose
																		// Tools
																		// |
																		// Templates.
	}

}
