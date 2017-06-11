package fr.fatjon.jfdev.castagestion.gui.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import fr.fatjon.jfdev.castagestion.dao.Database;
import fr.fatjon.jfdev.castagestion.gui.CandidatJFrame;
import fr.fatjon.jfdev.castagestion.gui.HomeJFrame;
import fr.fatjon.jfdev.castagestion.gui.LoginJFrame;



public class ConnexionActionListener implements ActionListener{
	
	private LoginJFrame loginJFrame;

    public ConnexionActionListener(LoginJFrame loginJFrame) {
        this.loginJFrame = loginJFrame;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        boolean loginOk = Database.connecter(
            this.loginJFrame.getTfNomUtilisateur().getText(),
            new String(this.loginJFrame.getTfMotDePasse().getPassword()) 
        );
        if (loginOk) {
           JOptionPane.showMessageDialog(
                loginJFrame, 
                "Vous ètes connecté !"
           );
           
           // Changer la fenetre actuelle
           loginJFrame.setVisible(false);
           HomeJFrame hjf = new HomeJFrame();
           hjf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           hjf.setVisible(true);
            
        } else {
           JOptionPane.showMessageDialog(
                loginJFrame, 
                "Identifiant ou mot de passe non valide", 
                "", 
                JOptionPane.ERROR_MESSAGE
           );
        }
        
    }

}
