package fr.fatjon.jfdev.castagestion.gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import fr.fatjon.jfdev.castagestion.beans.Moniteur;

public class ModeleTableauMoniteur extends AbstractTableModel{
	
	private ArrayList<Moniteur> moniteur;
	private String headers[] = {"Id", "Nom", "Prenom"};
	
	public ModeleTableauMoniteur(ArrayList<Moniteur> moniteur) {

		this.moniteur = moniteur;
	}
	
	@Override
	public int getRowCount() {
		return moniteur.size();
	}
	
	@Override
	public int getColumnCount() {
		return 3;
	}
	
	@Override
	public String getColumnName(int i) {
		return headers[i];
	}
	
	@Override
    public Object getValueAt(int ligne, int col) {
        switch (col) {
	        case 0: 
	            return moniteur.get(ligne).getIdm();
	        case 1: 
	            return moniteur.get(ligne).getNomm();
	        case 2: 
	            return moniteur.get(ligne).getPrenomm();
	        default:
                return "Erreur";
	        }
	}
	
    public void removeRow(int rowIndex) {
        // Mettre à jour l'Arraylist
        moniteur.remove(rowIndex);
        // Informer la JTable de la suppression
        fireTableRowsDeleted(rowIndex,rowIndex);
    }
	
	
	

}
