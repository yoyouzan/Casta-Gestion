package fr.fatjon.jfdev.castagestion.gui.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.fatjon.jfdev.castagestion.beans.Moniteur;
import fr.fatjon.jfdev.castagestion.dao.MoniteurDao;
import fr.fatjon.jfdev.castagestion.gui.MoniteurModifJFrame;

public class MoniteurEditActionListener implements ActionListener{
	
	private MoniteurModifJFrame mmjf;

	public MoniteurEditActionListener(MoniteurModifJFrame mmjf) {
		this.mmjf = mmjf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Moniteur moniteurModifie = mmjf.getMoniteur();
		moniteurModifie.setPrenomm(mmjf.getTfPrenom().getText());
		moniteurModifie.setNomm(mmjf.getTfNom().getText());
        
        new MoniteurDao().enregistrer(moniteurModifie);
        
        mmjf.getFenetrePrincipale().rafraichirFenetre();
        mmjf.setVisible(false);
        mmjf.dispose();
		
	}
	
	

}
