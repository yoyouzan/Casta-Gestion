package fr.fatjon.jfdev.castagestion.launcher;

import javax.swing.JFrame;

import fr.fatjon.jfdev.castagestion.gui.CandidatJFrame;
import fr.fatjon.jfdev.castagestion.gui.LoginJFrame;

public class Launcher {

	public static void main(String[] args) {
		
		LoginJFrame ljf = new LoginJFrame();
	       ljf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       ljf.setVisible(true);
	}

}
