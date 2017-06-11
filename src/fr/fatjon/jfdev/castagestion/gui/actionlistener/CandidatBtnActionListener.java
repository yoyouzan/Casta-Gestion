package fr.fatjon.jfdev.castagestion.gui.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.fatjon.jfdev.castagestion.beans.Candidat;
import fr.fatjon.jfdev.castagestion.dao.CandidatDao;
import fr.fatjon.jfdev.castagestion.gui.CandidatJFrame;
import fr.fatjon.jfdev.castagestion.gui.CandidatAjoutJFrame;
import fr.fatjon.jfdev.castagestion.gui.CandidatModifJFrame;


public class CandidatBtnActionListener implements ActionListener{
	private CandidatJFrame cjf;
	
	
	public CandidatBtnActionListener(CandidatJFrame cjf) {
		this.cjf = cjf;
	}



	@Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cjf.getBtnInserer()) {
            afficherFenetreAjout();
        } else if (ae.getSource() == cjf.getBtnModifier()) {
            modifierCandidatSelectionne();
        } else if (ae.getSource() == cjf.getBtnSupprimer()) {
            supprimerCandidatSelectionne();
        }

    }
	
	private void afficherFenetreAjout() {
        CandidatAjoutJFrame cajf = new CandidatAjoutJFrame(cjf);
        cajf.setLocationRelativeTo(cjf);
        cajf.setVisible(true);
    }

    private void supprimerCandidatSelectionne() {
        Candidat candidatSelectionne = getCandidatSelectionne();
        CandidatDao candidatDao = new CandidatDao();
        candidatDao.supprimer(candidatSelectionne);

        cjf.rafraichirFenetre();


    }

    private void modifierCandidatSelectionne() {
        Candidat candidatSelectionne = getCandidatSelectionne();
        
        CandidatModifJFrame cmjf = new CandidatModifJFrame(cjf, candidatSelectionne);
        cmjf.setVisible(true);
    }

    private Candidat getCandidatSelectionne() {
        if (cjf.getTabCandidats().getSelectedRow() == -1) {
            return null;
        }

        int idSelectionne = (int) cjf.getTabCandidats().getValueAt(
                cjf.getTabCandidats().getSelectedRow(),
                0
        );

        CandidatDao candidatDao = new CandidatDao();
        return candidatDao.recupererParId(idSelectionne);
    }


}
