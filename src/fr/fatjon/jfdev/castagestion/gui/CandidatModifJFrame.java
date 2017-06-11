package fr.fatjon.jfdev.castagestion.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import fr.fatjon.jfdev.castagestion.beans.Candidat;
import fr.fatjon.jfdev.castagestion.gui.actionlistener.CandidatEditActionListener;


public class CandidatModifJFrame extends TemplateJFrame{
	
	private CandidatJFrame fenetrePrincipale;
    private Candidat candidat;
    
    private JPanel panelAjoutCandidat;
    private JLabel lblId;
    private JLabel lblIdValue;
    private JLabel lblNom;
    private JLabel lblPrenom;
    private JLabel lblPseudo;
    private JLabel lblMdp;
    private JLabel lblEmail;
    private JLabel lblTel;
    private JTextField tfNom;
    private JTextField tfPrenom;
    private JTextField tfPseudo;
    private JTextField tfMdp;
    private JTextField tfEmail;
    private JTextField tfTel;
    private JButton btnEdit;
    
    public CandidatModifJFrame(CandidatJFrame fenetrePrincipale, Candidat candidat) {
        this.setTitle("Casta_Gestion - Modification de Candidat");
        
        this.fenetrePrincipale = fenetrePrincipale;
        this.candidat = candidat;
        
        this.setSize(600, 300);
        this.setLocationRelativeTo(fenetrePrincipale);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.setContentPane(genererPanelEditCandidat());
        
        // Remplir avec les valeurs de l'objet candidat à modifier
        this.lblIdValue.setText(String.valueOf(this.candidat.getId()));
        this.tfPrenom.setText(this.candidat.getPrenom());
        this.tfNom.setText(this.candidat.getNom());
        this.tfPseudo.setText(this.candidat.getPseudo());
        this.tfMdp.setText(this.candidat.getMdp());
        this.tfEmail.setText(this.candidat.getEmail());
        this.tfTel.setText(this.candidat.getTel());
        
    }
    
    private JPanel genererPanelEditCandidat() {
        GridLayout gridLayout = new GridLayout(0,2);
        this.panelAjoutCandidat = new JPanel(gridLayout);
        
        // Création des éléments
        this.lblId = new JLabel("Id");
        this.lblIdValue = new JLabel();
        this.lblNom = new JLabel("Nom");
        this.lblPrenom = new JLabel("Prenom");
        this.lblPseudo = new JLabel("Pseudo");
        this.lblMdp = new JLabel("Mot de passe");
        this.lblEmail = new JLabel("Email");
        this.lblTel = new JLabel("Telephone");
        this.tfNom = new JTextField();
        this.tfPrenom = new JTextField();
        this.tfPseudo = new JTextField();
        this.tfMdp = new JTextField();
        this.tfEmail = new JTextField();
        this.tfTel = new JTextField();
        
        this.btnEdit = new JButton("Modifier");
        
        // ActionListener
        this.btnEdit.addActionListener(new CandidatEditActionListener(this));
        
        
        // Ajout des éléments au Panel
        this.panelAjoutCandidat.add(this.lblId);
        this.panelAjoutCandidat.add(this.lblIdValue);
        this.panelAjoutCandidat.add(this.lblNom);
        this.panelAjoutCandidat.add(this.tfNom);
        this.panelAjoutCandidat.add(this.lblPrenom);
        this.panelAjoutCandidat.add(this.tfPrenom);
        this.panelAjoutCandidat.add(this.lblPseudo);
        this.panelAjoutCandidat.add(this.tfPseudo);
        this.panelAjoutCandidat.add(this.lblMdp);
        this.panelAjoutCandidat.add(this.tfMdp);
        this.panelAjoutCandidat.add(this.lblEmail);
        this.panelAjoutCandidat.add(this.tfEmail);
        this.panelAjoutCandidat.add(this.lblTel);
        this.panelAjoutCandidat.add(this.tfTel);
        
        this.panelAjoutCandidat.add(new JLabel(""));
        this.panelAjoutCandidat.add(this.btnEdit);
        
        return panelAjoutCandidat;
    }
    
    // Getters
    
    
    
    public JTextField getTfTitre() {
        return tfNom;
    }

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

	public JTextField getTfAuteur() {
        return tfPrenom;
    }

    public Candidat getCandidat() {
		return candidat;
	}

	public CandidatJFrame getFenetrePrincipale() {
        return fenetrePrincipale;
    }

}
