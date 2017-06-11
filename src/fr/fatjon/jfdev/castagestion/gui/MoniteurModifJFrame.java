package fr.fatjon.jfdev.castagestion.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.fatjon.jfdev.castagestion.beans.Candidat;
import fr.fatjon.jfdev.castagestion.beans.Moniteur;
import fr.fatjon.jfdev.castagestion.gui.actionlistener.CandidatEditActionListener;
import fr.fatjon.jfdev.castagestion.gui.actionlistener.MoniteurEditActionListener;

public class MoniteurModifJFrame extends TemplateJFrame{
	
	private MoniteurJFrame fenetrePrincipale;
    private Moniteur moniteur;
    
    private JPanel panelAjoutMoniteur;
    private JLabel lblId;
    private JLabel lblIdValue;
    private JLabel lblNom;
    private JLabel lblPrenom;
    private JTextField tfNom;
    private JTextField tfPrenom;
    private JButton btnEdit;
    
    
    public MoniteurModifJFrame(MoniteurJFrame fenetrePrincipale, Moniteur moniteur) {
        this.setTitle("Casta_Gestion - Modification de Moniteur");
        
        this.fenetrePrincipale = fenetrePrincipale;
        this.moniteur = moniteur;
        
        this.setSize(600, 300);
        this.setLocationRelativeTo(fenetrePrincipale);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.setContentPane(genererPanelEditMoniteur());
        
        // Remplir avec les valeurs de l'objet candidat à modifier
        this.lblIdValue.setText(String.valueOf(this.moniteur.getIdm()));
        this.tfPrenom.setText(this.moniteur.getPrenomm());
        this.tfNom.setText(this.moniteur.getNomm());

        
    }
    
    private JPanel genererPanelEditMoniteur() {
        GridLayout gridLayout = new GridLayout(0,2);
        this.panelAjoutMoniteur = new JPanel(gridLayout);
        
        // Création des éléments
        this.lblId = new JLabel("Id");
        this.lblIdValue = new JLabel();
        this.lblNom = new JLabel("Nom");
        this.lblPrenom = new JLabel("Prenom");
        this.tfNom = new JTextField();
        this.tfPrenom = new JTextField();
        
        this.btnEdit = new JButton("Modifier");
        
        // ActionListener
        this.btnEdit.addActionListener(new MoniteurEditActionListener(this));
        
        
        // Ajout des éléments au Panel
        this.panelAjoutMoniteur.add(this.lblId);
        this.panelAjoutMoniteur.add(this.lblIdValue);
        this.panelAjoutMoniteur.add(this.lblNom);
        this.panelAjoutMoniteur.add(this.tfNom);
        this.panelAjoutMoniteur.add(this.lblPrenom);
        this.panelAjoutMoniteur.add(this.tfPrenom);

        
        this.panelAjoutMoniteur.add(new JLabel(""));
        this.panelAjoutMoniteur.add(this.btnEdit);
        
        return panelAjoutMoniteur;
    }

	public Moniteur getMoniteur() {
		return moniteur;
	}

	public JTextField getTfNom() {
		return tfNom;
	}

	public JTextField getTfPrenom() {
		return tfPrenom;
	}


	public MoniteurJFrame getFenetrePrincipale() {
		return fenetrePrincipale;
	}
    
    

}
