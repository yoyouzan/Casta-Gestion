package fr.fatjon.jfdev.castagestion.gui.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FichierQuitterActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent ae) {
		// Quitter l'application
		System.exit(0);

	}

}
