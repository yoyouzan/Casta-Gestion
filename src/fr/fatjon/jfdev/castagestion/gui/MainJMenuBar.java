package fr.fatjon.jfdev.castagestion.gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import fr.fatjon.jfdev.castagestion.gui.actionlistener.AideAproposActionListener;
import fr.fatjon.jfdev.castagestion.gui.actionlistener.FichierQuitterActionListener;



public class MainJMenuBar extends JMenuBar{
	
	private JMenu jMenuFichier;
	private JMenu jMenuAide;
	private JMenuItem jMenuItemFichierQuitter;
	private JMenuItem jMenuItemAideApropos;
	private TemplateJFrame templateJFrame;

	public MainJMenuBar(TemplateJFrame templateJFrame) {
		this.templateJFrame = templateJFrame;
		
		
		jMenuFichier = new JMenu("Fichier");
		jMenuAide = new JMenu("Aide");
		jMenuItemFichierQuitter = new JMenuItem("Quitter");
		jMenuItemAideApropos = new JMenuItem("A propos");
		
		//ActionListener

		jMenuItemFichierQuitter.addActionListener(new FichierQuitterActionListener());
		jMenuItemAideApropos.addActionListener(new AideAproposActionListener(this.templateJFrame));

		
		//Ajouter les items aux menus
		jMenuFichier.add(jMenuItemFichierQuitter);
		jMenuAide.add(jMenuItemAideApropos);
		
		//Ajouter les menus à la barre
		this.add(jMenuFichier);
		this.add(jMenuAide);
	}
}
