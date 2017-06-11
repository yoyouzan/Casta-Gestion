package fr.fatjon.jfdev.castagestion.gui.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.fatjon.jfdev.castagestion.beans.Candidat;
import fr.fatjon.jfdev.castagestion.beans.Moniteur;
import fr.fatjon.jfdev.castagestion.dao.CandidatDao;
import fr.fatjon.jfdev.castagestion.dao.MoniteurDao;
import fr.fatjon.jfdev.castagestion.gui.CandidatAjoutJFrame;
import fr.fatjon.jfdev.castagestion.gui.CandidatModifJFrame;
import fr.fatjon.jfdev.castagestion.gui.MoniteurAjoutJFrame;
import fr.fatjon.jfdev.castagestion.gui.MoniteurJFrame;
import fr.fatjon.jfdev.castagestion.gui.MoniteurModifJFrame;

public class MoniteurBtnActionListener implements ActionListener{
	private MoniteurJFrame mjf;
	
	
	public MoniteurBtnActionListener(MoniteurJFrame mjf) {
		this.mjf = mjf;
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == mjf.getBtnInserer()) {
            afficherFenetreAjout();
        } else if (ae.getSource() == mjf.getBtnModifier()) {
            modifierMoniteurSelectionne();
        } else if (ae.getSource() == mjf.getBtnSupprimer()) {
            supprimerMoniteurSelectionne();
        }

    }
	
	private void afficherFenetreAjout() {
        MoniteurAjoutJFrame majf = new MoniteurAjoutJFrame(mjf);
        majf.setLocationRelativeTo(mjf);
        majf.setVisible(true);
    }
	
	private void supprimerMoniteurSelectionne() {
        Moniteur moniteurSelectionne = getMoniteurSelectionne();
        MoniteurDao moniteurDao = new MoniteurDao();
        moniteurDao.supprimer(moniteurSelectionne);

        mjf.rafraichirFenetre();

    }
	
	private void modifierMoniteurSelectionne() {
        Moniteur moniteurSelectionne = getMoniteurSelectionne();
        
        MoniteurModifJFrame mmjf = new MoniteurModifJFrame(mjf, moniteurSelectionne);
        mmjf.setVisible(true);
    }
	
	private Moniteur getMoniteurSelectionne() {
        if (mjf.getTabMoniteur().getSelectedRow() == -1) {
            return null;
        }

        int idSelectionne = (int) mjf.getTabMoniteur().getValueAt(
                mjf.getTabMoniteur().getSelectedRow(),
                0
        );

        MoniteurDao moniteurDao = new MoniteurDao();
        return moniteurDao.recupererParId(idSelectionne);
    }
}
