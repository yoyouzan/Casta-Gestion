package fr.fatjon.jfdev.castagestion.gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JPanel;

import fr.fatjon.jfdev.castagestion.gui.actionlistener.HomeJFrameActionListener;

public class HomeJFrame extends TemplateJFrame{
	
	private JPanel jpGestion;
	private JButton btnCandidat;
	private JButton btnMoniteur;
	private JButton btnVehicule;
	
	
	public HomeJFrame() throws HeadlessException {
		setTitle("Gestion");
        setSize(450, 450);
        setLocationRelativeTo(null);
        setContentPane(creerPanelChoixGestion());
        
	}
	

	private JPanel creerPanelChoixGestion(){
		
		GridLayout gridLayout = new GridLayout(3,0);
		
		// Création des éléments
		jpGestion = new JPanel(gridLayout);
		btnCandidat = new JButton("Gestion Candidat");
		btnMoniteur = new JButton("Gestion Moniteur");
		btnVehicule = new JButton("Gestion Vehicule");
		
		// ActionListener
		btnCandidat.addActionListener(new HomeJFrameActionListener(this));
		btnMoniteur.addActionListener(new HomeJFrameActionListener(this));
		btnVehicule.addActionListener(new HomeJFrameActionListener(this));
		
		// Ajout de tous les éléments au Panel
		jpGestion.add(btnCandidat);
		jpGestion.add(btnMoniteur);
		jpGestion.add(btnVehicule);
		
		return jpGestion;
	}
	
	
	// Getters et Setters

	public JPanel getJpGestion() {
		return jpGestion;
	}

	public void setJpGestion(JPanel jpGestion) {
		this.jpGestion = jpGestion;
	}

	public JButton getBtnCandidat() {
		return btnCandidat;
	}

	public void setBtnCandidat(JButton btnCandidat) {
		this.btnCandidat = btnCandidat;
	}

	public JButton getBtnMoniteur() {
		return btnMoniteur;
	}

	public void setBtnMoniteur(JButton btnMoniteur) {
		this.btnMoniteur = btnMoniteur;
	}

	public JButton getBtnVehicule() {
		return btnVehicule;
	}

	public void setBtnVehicule(JButton btnVehicule) {
		this.btnVehicule = btnVehicule;
	}
	
	
	


}
