package fr.fatjon.jfdev.castagestion.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fr.fatjon.jfdev.castagestion.gui.actionlistener.ConnexionActionListener;


public class LoginJFrame extends TemplateJFrame{
	
	private JPanel jpIdentification;
    private JLabel lblNomUtilisateur;
    private JLabel lblMotDePasse;
    private JTextField tfNomUtilisateur;
    private JPasswordField tfMotDePasse;
    private JButton btnConnexion;
    private JLabel img;
    
    
    
    public LoginJFrame() throws HeadlessException {
        setTitle("Connection");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setContentPane(creerJPanelIdentification());
    }
    
    private JPanel creerJPanelIdentification() {
    	
        GridLayout gridLayout = new GridLayout(0,2);
        
        //Création des éléments
        jpIdentification = new JPanel(gridLayout);
        lblNomUtilisateur = new JLabel("Nom d'utilisateur");
        tfNomUtilisateur = new JTextField(25);
        lblMotDePasse = new JLabel("Mot de passe");
        tfMotDePasse = new JPasswordField(25);
        btnConnexion = new JButton("Se connecter");
        
        
        // Image
        JPanel pane = new JPanel();
        JLabel image = new JLabel( new ImageIcon( "logo.png"));
        pane.setLayout(new BorderLayout());
        getContentPane().add(pane, BorderLayout.CENTER);
        pane.add(image);
        

        
        //ActionListener
        btnConnexion.addActionListener(new ConnexionActionListener(this));
        
        //Ajout de tous les éléments au Panel

        jpIdentification.add(lblNomUtilisateur);
        jpIdentification.add(tfNomUtilisateur);
        jpIdentification.add(lblMotDePasse);
        jpIdentification.add(tfMotDePasse);
        jpIdentification.add(pane);
        jpIdentification.add(btnConnexion);
        
       
        
        
        
        return jpIdentification;
    }
    
    public JTextField getTfNomUtilisateur() {
        return tfNomUtilisateur;
    }

    public JPasswordField getTfMotDePasse() {
        return tfMotDePasse;
    }

}
