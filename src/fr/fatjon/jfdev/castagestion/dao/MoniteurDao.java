package fr.fatjon.jfdev.castagestion.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fatjon.jfdev.castagestion.beans.Moniteur;


public class MoniteurDao extends Dao<Moniteur>{
	
	public MoniteurDao() {
        super("moniteur");
    }
	
	@Override
    public Moniteur recupererParId(int id) {
        String sql = String.format(
                "SELECT * FROM %s WHERE idm = %d;",
                this.table, id
        );
        
        try {
            Statement stmt = Database.getStatement();
            ResultSet res = stmt.executeQuery(sql);
            boolean ligneExiste = res.next();
            if (!ligneExiste) {
                return null;
            }
            return new Moniteur(
                    res.getInt("idm"), 
                    res.getString("nomm"), 
                    res.getString("prenomm")
            );
            
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }
	
	@Override
    public ArrayList<Moniteur> recuperer() {
        String sql = String.format(
                "SELECT * FROM %s;",
                this.table
        );
        
        try {
            Statement stmt = Database.getStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Moniteur> moniteur = new ArrayList<>();
            while (rs.next()) {
                moniteur.add(new Moniteur(
                		rs.getInt("idm"), 
                        rs.getString("nomm"), 
                        rs.getString("prenomm")
                    )
                );
            }
            return moniteur;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }
	
	@Override
    public boolean enregistrer(Moniteur obj) {
        String sql;
        if (obj.getIdm() == -1) { // nouveau moniteur
            sql = String.format(
                "INSERT INTO %s (nomm, prenomm) VALUES('%s', '%s');",
                this.table, obj.getNomm(), obj.getPrenomm()
            );
        } else { // moniteur mis ра jour
            sql = String.format(
                "UPDATE %s SET nomm = '%s', prenomm = '%s' WHERE idm = %d;",
                this.table, obj.getNomm(), obj.getPrenomm(), obj.getIdm()
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
    public boolean supprimer(Moniteur obj) {
        String sql = String.format(
            "DELETE FROM %s WHERE idm"
            + " = %d;",
            this.table, obj.getIdm()
        );
        
        try {
            return Database.getStatement().executeUpdate(sql) == 1;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

}
