package it.polito.tdp.libretto.model;

import java.time.LocalDate;

//OGGETTO SEMPLICE CHE CONTIENE I DATI DI UN SINGOLO ESAME
//Contiene: dati privati, costruttore, get/setter, metodi di servizio (equals-to string-compare to-hash code) -> questi ci devono essere sempre!!

public class Esame {
	private String codice;
	private String titolo;
	private String docente;
	
	//private Docente docente; SAREBBE BENE UTILIZZARE UNA CLASSE DOCENTE PER AVERE INFO ARTICOLATE
	
	private boolean superato;
	private int voto;
	private LocalDate dataSuperamento;
	
	/**
	 * Nuovo esame non ancora superato
	 * @param codice
	 * @param titolo
	 * @param docente Cognome e Nome del docente titolare
	 */
	public Esame(String codice, String titolo, String docente) {
		this.codice = codice;
		this.titolo = titolo;
		this.docente = docente;
		
		this.superato=false;
	}

	/**
	 * @return the codice
	 */
	public String getCodice() {
		return codice;
	}

	/**
	 * @param codice the codice to set
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}

	/**
	 * @return the titolo
	 */
	public String getTitolo() {
		return titolo;
	}

	/**
	 * @param titolo the titolo to set
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	/**
	 * @return the docente
	 */
	public String getDocente() {
		return docente;
	}

	/**
	 * @param docente the docente to set
	 */
	public void setDocente(String docente) {
		this.docente = docente;
	}

	/**
	 * @return the superato
	 */
	public boolean isSuperato() {
		return superato;
	}

	/**
	 * @param superato the superato to set
	 */
	private void setSuperato(boolean superato) {
		this.superato = superato;
	}

	/**Restituisce il voto solo se l'esame e' superato
	 * @return the voto
	 */
	public int getVoto() {
		if(this.superato)
			return voto;
		throw new IllegalStateException("Esame "+this.codice+ " non ancora superato.");
	}

	/**
	 * @param voto the voto to set
	 */
	private void setVoto(int voto) {
		this.voto = voto;
	}

	/**
	 * @return the dataSuperamento
	 */
	public LocalDate getDataSuperamento() {
		if(this.superato)
			return dataSuperamento;
		throw new IllegalStateException("Esame "+this.codice+ " non ancora superato.");
	}

	/**
	 * @param dataSuperamento the dataSuperamento to set
	 */
	private void setDataSuperamento(LocalDate dataSuperamento) {
		this.dataSuperamento = dataSuperamento;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Esame [codice=" + codice + ", titolo=" + titolo + ", docente=" + docente + ", superato=" + superato
				+ ", voto=" + voto + ", dataSuperamento=" + dataSuperamento + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codice == null) ? 0 : codice.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Esame other = (Esame) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		return true;
	}
	
	/**
	 * Se l'esame non è ancora superato lo considera superato con il voto e a data specificati
	 * Se invece fosse gia superato da errore, genera un'eccezione.
	 * @param voto
	 * @param data
	 */
	public void supera(int voto, LocalDate data){
		if(!this.superato){
			this.superato=true;
			this.voto=voto;
			this.dataSuperamento=data;
		}
		else{
			//sull'oggetto interno non poteva essere chiamato tale metodo perche gia implementato 
			throw new IllegalStateException("Esame "+this.codice+ " gia' superato.");
		}
	}
	
	
	
	
	
	
	
	
	
}
