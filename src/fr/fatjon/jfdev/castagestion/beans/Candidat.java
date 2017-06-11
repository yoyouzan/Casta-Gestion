package fr.fatjon.jfdev.castagestion.beans;

public class Candidat {

	private int id;
	private String nom;
	private String prenom;
	private String pseudo;
	private String mdp;
	private String email;
	private String tel;
	
	public Candidat() {
	}

	public Candidat(int id, String nom, String prenom, String pseudo, String mdp, String email, String tel) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
		this.mdp = mdp;
		this.email = email;
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s - %s - %s - %s - %s [%d]",this.tel,this.email,this.mdp,this.pseudo, this.nom, this.prenom, this.id);
	}

	
	// Getters et Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	

}
