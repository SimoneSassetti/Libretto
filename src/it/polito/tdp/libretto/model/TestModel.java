package it.polito.tdp.libretto.model;

public class TestModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LibrettoModel m=new LibrettoModel();
		
		m.addEsame(new Esame("03FYZ","Tecniche di Programmazione","Corno Fulvio"));
		m.addEsame(new Esame("01QZP","Ambient Intelligence","Corno Fulvio"));
		m.addEsame(new Esame("01QZP","Ambient Intelligence","Corno Fulvio"));
		System.out.println(m.trovaEsame("03FYZ"));
		System.out.println(m.trovaEsame("01QZP"));
		System.out.println(m.trovaEsame("LA322"));
	}

}
