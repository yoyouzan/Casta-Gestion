package fr.fatjon.jfdev.castagestion.beans;

public class Moniteur {
	
	private int idm;
	private String nomm;
	private String prenomm;

	
	
	public Moniteur() {

	}


	public Moniteur(int idm, String nomm, String prenomm) {
		this.idm = idm;
		this.nomm = nomm;
		this.prenomm = prenomm;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s [%d]",this.prenomm, this.nomm, this.idm);
	}


	public int getIdm() {
		return idm;
	}


	public void setIdm(int idm) {
		this.idm = idm;
	}


	public String getNomm() {
		return nomm;
	}


	public void setNomm(String nomm) {
		this.nomm = nomm;
	}


	public String getPrenomm() {
		return prenomm;
	}


	public void setPrenomm(String prenomm) {
		this.prenomm = prenomm;
	}



	
	
	
	
	

}
