package fr.fatjon.jfdev.castagestion.gui;

import java.awt.HeadlessException;
import javax.swing.JFrame;

public class TemplateJFrame extends JFrame {

	public TemplateJFrame() throws HeadlessException {

		setTitle("Casta_Gestion");
		setSize(800, 600);
		// Centrer sur l'écran
		setLocationRelativeTo(null);
		// Assigner une barre de menu
		setJMenuBar(new MainJMenuBar(this));
	}

}
