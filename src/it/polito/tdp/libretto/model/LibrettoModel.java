package it.polito.tdp.libretto.model;

import java.util.*;

import it.polito.tdp.libretto.db.EsameDAO;

public class LibrettoModel {
	private List<Esame> esami;
	
	public LibrettoModel(){
		this.esami=new ArrayList<Esame>();
	}
	
	/**
	 * Aggiunge un nuovo esame all'elenco degli esami, verificando che non ci sia gia'
	 * posso gestire in tre modi: non dire niente, cambiare il metodo a boolean o gestire un'eccezione
	 * @param e
	 * return false se esistema già e quindi non è possibile aggiungerlo
	 */
	public boolean addEsame(Esame e){
		EsameDAO dao=new EsameDAO();
		
		return dao.create(e);
	}
	
	//O scandisco una riga x volta con ciclo for
	//O usando contains
	/**
	 * Ricerca lista con codice specificato, altrimenti restituisce null.
	 * @param codice dell'esame da ricercare
	 * @return esame trovato o null
	 */
	public Esame trovaEsame(String codice){
		EsameDAO dao=new EsameDAO();
		Esame e=dao.find(codice);
		return e;
		
	}
	
	
}
