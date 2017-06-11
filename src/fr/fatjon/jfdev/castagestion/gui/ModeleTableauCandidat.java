package fr.fatjon.jfdev.castagestion.gui;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import fr.fatjon.jfdev.castagestion.beans.Candidat;

public class ModeleTableauCandidat extends AbstractTableModel{
	
	private ArrayList<Candidat> candidat;
    private String headers[] = {"Id", "Nom", "Prenom", "Pseudo", "Mot de passe", "Email", "Telephone"};
    
    public ModeleTableauCandidat(ArrayList<Candidat> candidat) {
		this.candidat = candidat;
	}

	@Override
    public int getRowCount() {
        return candidat.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int i) {
        return headers[i]; 
    }

    
    @Override
    public Object getValueAt(int ligne, int col) {
        switch (col) {
            case 0: 
                return candidat.get(ligne).getId();
            case 1: 
                return candidat.get(ligne).getNom();
            case 2:
                return candidat.get(ligne).getPrenom();
            case 3:
                return candidat.get(ligne).getPseudo();
            case 4:
                return candidat.get(ligne).getMdp();
            case 5:
                return candidat.get(ligne).getEmail();
            case 6:
                return candidat.get(ligne).getTel();
            default:
                return "Erreur";
        }
    }
    
    public void removeRow(int rowIndex) {
        // Mettre à jour l'Arraylist
        candidat.remove(rowIndex);
        // Informer la JTable de la suppression
        fireTableRowsDeleted(rowIndex,rowIndex);
    }

}
