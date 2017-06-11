package fr.fatjon.jfdev.castagestion.dao;

import java.util.ArrayList;

public abstract class Dao<T>{
	protected String table;
 
    public Dao(String table) {
        this.table = table;
    }
    
    public abstract T recupererParId(int id);
    public abstract ArrayList<T> recuperer();
    public abstract boolean enregistrer(T obj);
    public abstract boolean supprimer(T obj);

}
