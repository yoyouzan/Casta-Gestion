package fr.fatjon.jfdev.castagestion.gui.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import fr.fatjon.jfdev.castagestion.gui.TemplateJFrame;

public class AideAproposActionListener implements ActionListener{
	private TemplateJFrame templateJFrame;
	
	
	public AideAproposActionListener(TemplateJFrame templateJFrame) {
		this.templateJFrame = templateJFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this.templateJFrame, "(c) 2017 JFdev", "A propos", JOptionPane.INFORMATION_MESSAGE);
	}

}
