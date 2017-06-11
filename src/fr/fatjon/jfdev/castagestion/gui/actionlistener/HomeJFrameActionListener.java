package fr.fatjon.jfdev.castagestion.gui.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import fr.fatjon.jfdev.castagestion.gui.CandidatAjoutJFrame;
import fr.fatjon.jfdev.castagestion.gui.CandidatJFrame;
import fr.fatjon.jfdev.castagestion.gui.HomeJFrame;
import fr.fatjon.jfdev.castagestion.gui.MoniteurJFrame;

public class HomeJFrameActionListener implements ActionListener{
	
	private HomeJFrame homeJFrame;

	public HomeJFrameActionListener(HomeJFrame homeJFrame) {
		this.homeJFrame = homeJFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == homeJFrame.getBtnCandidat()) {
            afficherCandidat();
        } else if (e.getSource() == homeJFrame.getBtnMoniteur()) {
            afficherMoniteur();
        } else if (e.getSource() == homeJFrame.getBtnVehicule()) {
            afficherVehicule();
        }
		
	}
	private void afficherCandidat() {
		
        // Changer la fenetre actuelle
        homeJFrame.setVisible(false);
        CandidatJFrame cjf = new CandidatJFrame();
        cjf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cjf.setVisible(true);
    }
	
	private void afficherMoniteur() {
		
        // Changer la fenetre actuelle
        homeJFrame.setVisible(false);
        MoniteurJFrame mjf = new MoniteurJFrame();
        mjf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mjf.setVisible(true);
    }
	
	private void afficherVehicule() {
	
	    // Changer la fenetre actuelle
	    homeJFrame.setVisible(false);
	    CandidatJFrame cjf = new CandidatJFrame();
	    cjf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    cjf.setVisible(true);
	}
	
	

}
