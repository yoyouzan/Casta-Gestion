package fr.fatjon.jfdev.castagestion.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.fatjon.jfdev.castagestion.dao.CandidatDao;
import fr.fatjon.jfdev.castagestion.dao.MoniteurDao;
import fr.fatjon.jfdev.castagestion.gui.actionlistener.CandidatBtnActionListener;
import fr.fatjon.jfdev.castagestion.gui.actionlistener.MoniteurBtnActionListener;

public class MoniteurJFrame extends TemplateJFrame{
	
	private BorderLayout borderLayout;
	private JPanel jpHome;
	private JPanel jpTableauMoniteur;
	private JTable tabMoniteur;
	
	// Boutons
	private JPanel jpControles;
	private JButton btnSupprimer;
	private JButton btnModifier;
	private JButton btnInserer;

	
	
	public MoniteurJFrame() throws HeadlessException {
		setContentPane(creerPanelPrincipal());
	}
	
	public void rafraichirFenetre() {
        MoniteurJFrame moniteurJFrame = new MoniteurJFrame();   
        moniteurJFrame.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }
	
	private JPanel creerPanelPrincipal() {

		borderLayout = new BorderLayout();
		
        jpHome = new JPanel(borderLayout);
        jpTableauMoniteur = new JPanel();
        
        String[] colonnes = {"Id", "Nom", "Prenom"};
        
        ModeleTableauMoniteur modeleTableauMoniteur = new ModeleTableauMoniteur(new MoniteurDao().recuperer());
        
        tabMoniteur = new JTable(modeleTableauMoniteur);
        
        jpTableauMoniteur.add(new JScrollPane(tabMoniteur));
        jpHome.add(creerPanelControles(), BorderLayout.WEST);
        jpHome.add(jpTableauMoniteur, BorderLayout.CENTER);
        
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
		ActionListener moniteurBtnActionListener = new MoniteurBtnActionListener(this);
		btnInserer.addActionListener(moniteurBtnActionListener);
		btnModifier.addActionListener(moniteurBtnActionListener);
		btnSupprimer.addActionListener(moniteurBtnActionListener);

		// Ajout des boutons au panel de controle
		jpControles.add(btnInserer);
		jpControles.add(btnModifier);
		jpControles.add(btnSupprimer);


		return jpControles;
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

	public JTable getTabMoniteur() {
		return tabMoniteur;
	}
	
	public void refreshTable() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	

}
