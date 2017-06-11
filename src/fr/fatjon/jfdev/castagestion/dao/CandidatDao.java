package fr.fatjon.jfdev.castagestion.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fatjon.jfdev.castagestion.beans.Candidat;


public class CandidatDao extends Dao<Candidat>{
	
	public CandidatDao() {
        super("candidat");
    }
	
	@Override
    public Candidat recupererParId(int id) {
        String sql = String.format(
                "SELECT * FROM %s WHERE id = %d;",
                this.table, id
        );
        
        try {
            Statement stmt = Database.getStatement();
            ResultSet res = stmt.executeQuery(sql);
            boolean ligneExiste = res.next();
            if (!ligneExiste) {
                return null;
            }
            return new Candidat(
                    res.getInt("id"), 
                    res.getString("nom"), 
                    res.getString("prenom"),
                    res.getString("pseudo"),
                    res.getString("mdp"),
                    res.getString("email"),
                    res.getString("tel")
            );
            
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }
	
	@Override
    public ArrayList<Candidat> recuperer() {
        String sql = String.format(
                "SELECT * FROM %s;",
                this.table
        );
        
        try {
            Statement stmt = Database.getStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Candidat> candidat = new ArrayList<>();
            while (rs.next()) {
                candidat.add(new Candidat(
                		rs.getInt("id"), 
                        rs.getString("nom"), 
                        rs.getString("prenom"),
                        rs.getString("pseudo"),
                        rs.getString("mdp"),
                        rs.getString("email"),
                        rs.getString("tel")
                    )
                );
            }
            return candidat;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }
	
	@Override
    public boolean enregistrer(Candidat obj) {
        String sql;
        if (obj.getId() == -1) { // nouveau candidat
            sql = String.format(
                "INSERT INTO %s (nom, prenom, pseudo, mdp, email, tel) VALUES('%s', '%s', '%s', '%s', '%s', '%s');",
                this.table, obj.getNom(), obj.getPrenom(), obj.getPseudo(), obj.getMdp(), obj.getEmail(), obj.getTel()
            );
        } else { // candidat mis à jour
            sql = String.format(
                "UPDATE %s SET nom = '%s', prenom = '%s' WHERE id = %d;",
                this.table, obj.getNom(), obj.getPrenom(), obj.getId()
            );
        }
        
        
        try {
            Statement stmt = Database.getStatement();
            return stmt.executeUpdate(sql) == 1;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }
	
	@Override
    public boolean supprimer(Candidat obj) {
        String sql = String.format(
            "DELETE FROM %s WHERE id = %d;",
            this.table, obj.getId()
        );
        
        try {
            return Database.getStatement().executeUpdate(sql) == 1;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

}
