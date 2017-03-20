package it.polito.tdp.libretto.model;

import java.util.*;

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
		//contains usa equals quindi deve essere implementato
		if(!esami.contains(e)){
			esami.add(e);
			return true;
		}
		else
			return false;
	}
	
	//O scandisco una riga x volta con ciclo for
	//O usando contains
	/**
	 * Ricerca lista con codice specificato, altrimenti restituisce null.
	 * @param codice dell'esame da ricercare
	 * @return esame trovato o null
	 */
	public Esame trovaEsame(String codice){
		int pos=this.esami.indexOf(new Esame(codice, null, null));//creo un oggetto dello stesso tipo di quello che sto cercando e ne prendo l'indice per poter usare il get
		
		if(pos ==-1)
			return null;
		else{
			return esami.get(pos);
		}
		
	}
	
	
}
