package fr.fatjon.jfdev.castagestion.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class Database {
	
	private static final String DRIVER = 
            "com.mysql.jdbc.Driver";
    private static final String CONNECTION_STRING = 
            "jdbc:mysql://localhost:3306/autoecole2?useUnicode=true";
    
    public static Connection connection = null;
    private static String nomUtilisateur;
    private static String motDePasse;
    
    
    public static boolean connecter(String nomUtilisateur,
            String motDePasse) {
        
        
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(
                    CONNECTION_STRING, 
                    nomUtilisateur, 
                    motDePasse
            );
            
            Database.nomUtilisateur = nomUtilisateur;
            Database.motDePasse = motDePasse;
            return true;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(
                    null, 
                    "Erreur de chargement du driver JDBC.", 
                    "Erreur", 
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                    null, 
                    "Mauvais login ou mauvais passe", 
                    "Erreur", 
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
    }
    
    public static Statement getStatement() {
        // Tester si la connection est ouverte
        if (connection == null) {
            connecter(nomUtilisateur, motDePasse);
        }
        try {
            return connection.createStatement();
        } catch (SQLException ex) {
            System.err.println("Un msg d'erreur");
            return null;
        }
    }
    
    public static void deconnecter() {
        if (connection != null) {
            nomUtilisateur = null;
            motDePasse = null;
            
            try {
                connection.close();
            } catch (SQLException ex) {
                System.err.println("Erreur de deconnection à la base.");
            }
            connection = null;
        }
    }

}
