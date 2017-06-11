package fr.fatjon.jfdev.castagestion.gui.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import fr.fatjon.jfdev.castagestion.beans.Candidat;
import fr.fatjon.jfdev.castagestion.dao.CandidatDao;
import fr.fatjon.jfdev.castagestion.gui.CandidatAjoutJFrame;


public class CandidatAjoutActionListener implements ActionListener{
	private CandidatAjoutJFrame fenetre;
	
	public CandidatAjoutActionListener(CandidatAjoutJFrame fenetre) {
		this.fenetre = fenetre;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Candidat nouveauCandidat = new Candidat(-1, fenetre.getTfNom().getText(), fenetre.getTfPrenom().getText(), fenetre.getTfPseudo().getText(), fenetre.getTfMdp().getText(), fenetre.getTfEmail().getText(), fenetre.getTfTel().getText() );
		if (new CandidatDao().enregistrer(nouveauCandidat)) {
            JOptionPane.showMessageDialog(fenetre, "Candidat ajouté");
            fenetre.getFenetrePrincipale().rafraichirFenetre();
        } else {
            JOptionPane.showMessageDialog(fenetre, "Candidat non ajouté", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

}
