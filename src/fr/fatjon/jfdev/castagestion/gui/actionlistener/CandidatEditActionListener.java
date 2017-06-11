package fr.fatjon.jfdev.castagestion.gui.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.fatjon.jfdev.castagestion.beans.Candidat;
import fr.fatjon.jfdev.castagestion.dao.CandidatDao;
import fr.fatjon.jfdev.castagestion.gui.CandidatModifJFrame;



public class CandidatEditActionListener implements ActionListener{
	private CandidatModifJFrame cmjf;
	
	public CandidatEditActionListener(CandidatModifJFrame cmjf) {
        this.cmjf = cmjf;
    }
	
	@Override
    public void actionPerformed(ActionEvent ae) {
        Candidat candidatModifie = cmjf.getCandidat();
        candidatModifie.setPrenom(cmjf.getTfPrenom().getText());
        candidatModifie.setNom(cmjf.getTfNom().getText());
        
        new CandidatDao().enregistrer(candidatModifie);
        
        cmjf.getFenetrePrincipale().rafraichirFenetre();
        cmjf.setVisible(false);
        cmjf.dispose();
    }

}
