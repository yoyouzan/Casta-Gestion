package fr.fatjon.jfdev.castagestion.gui.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import fr.fatjon.jfdev.castagestion.beans.Moniteur;
import fr.fatjon.jfdev.castagestion.dao.MoniteurDao;
import fr.fatjon.jfdev.castagestion.gui.MoniteurAjoutJFrame;

public class MoniteurAjoutActionListener implements ActionListener{
	
	private MoniteurAjoutJFrame fenetre;

	public MoniteurAjoutActionListener(MoniteurAjoutJFrame fenetre) {
		this.fenetre = fenetre;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Moniteur nouveauMoniteur = new Moniteur(-1, fenetre.getTfNomm().getText(), fenetre.getTfPrenomm().getText());
		if (new MoniteurDao().enregistrer(nouveauMoniteur)) {
            JOptionPane.showMessageDialog(fenetre, "Moniteur ajouté");
            fenetre.getFenetrePrincipale().rafraichirFenetre();
        } else {
            JOptionPane.showMessageDialog(fenetre, "Moniteur non ajouté", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    
		
	}
	
	

}
