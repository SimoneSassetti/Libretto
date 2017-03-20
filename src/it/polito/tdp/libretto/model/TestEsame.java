package it.polito.tdp.libretto.model;

import java.time.LocalDate;

/**
 * SERVE X CONTROLLARE SE LE CLASSI SONO IMPLEMENTATE IN MODO CORRETTO
 * 
 *
 */
public class TestEsame {

	public static void main(String[] args) {
		
		Esame tdp=new Esame("03FYZ","Tecniche di Programmazione","Corno Fulvio");
		Esame ami=new Esame("01QZP","Ambient Intelligence","Corno Fulvio");
		
		System.out.println(ami.equals(tdp));
		
		tdp.supera(30, LocalDate.now());
		System.out.println(tdp);
		tdp.supera(18, LocalDate.now());
		System.out.println(tdp);
	}

}
