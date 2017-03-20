package it.polito.tdp.libretto;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.libretto.model.Esame;
import it.polito.tdp.libretto.model.LibrettoModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LibrettoController {

	/**
	 * Model m=new Model();
	 * 
	 * E' SBAGLIATO FARE COSI PERCHE DEVO LAVORA SU UN UNICO MODELLO E FACENDO COSI NE CREO UNO OGNI VOLTA CHE IL CONTROLLER VIENE INTERPELLATO
	 * 
	 */
	
	LibrettoModel model;
	//NEL MAIN CI SARA QUALCUNO CHE CE LO PASSERA
	public void setModel(LibrettoModel model) {
		this.model = model;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtCodice;

    @FXML
    private TextField txtTitolo;

    @FXML
    private TextField txtDocente;

    @FXML
    private Button btnCerca;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtMessage;

    @FXML
    void handleCerca(ActionEvent event) {
    	String codice=txtCodice.getText();
    	if(codice.length()<5){
    		txtMessage.appendText("Dati esame insufficienti.\n");
    		return;
    	}
    	Esame e=model.trovaEsame(codice);
    	if(e==null){
    		txtMessage.appendText("Codice "+codice+" non trovato.\n");
    	}else{
    		txtMessage.appendText("Codice "+codice+" trovato.\n");
    	}
    	txtCodice.setText(e.getCodice());
    	txtTitolo.setText(e.getTitolo());
    	txtDocente.setText(e.getDocente());
    }

    @FXML
    void handleInserisci(ActionEvent event) {
    	//RECUPERA I DATI DALLA VISTA
    	String codice=txtCodice.getText();
    	String titolo=txtTitolo.getText();
    	String docente=txtDocente.getText();
    	
    	//VERIFICA LA VALIDITA DEI DATI
    	if(codice.length()<5 || titolo.length()==0 || docente.length()==0){
    		//lo diciamo all'utente e non prendiamo i dati
    		txtMessage.appendText("Dati esame insufficienti.\n");
    		return;
    	}
    	
    	//CHIEDE AL MODEL DI EFFETTURA LE OPERAZIONI (INSERIMENTO)
    	Esame e=new Esame(codice, titolo, docente);
    	boolean b=model.addEsame(e);
    	
    	//AGGIORNA LA VISTA CON IL RISULTATO DELL'OPERAZIONE
    	if(b){
    		txtMessage.appendText("Esame aggiunto con successo.\n");
    	}
    	else{
    		txtMessage.appendText("Esame non aggiunto (codice duplicato).\n");
    	}	
    }

    @FXML
    void initialize() {
        assert txtCodice != null : "fx:id=\"txtCodice\" was not injected: check your FXML file 'Libretti.fxml'.";
        assert txtTitolo != null : "fx:id=\"txtTitolo\" was not injected: check your FXML file 'Libretti.fxml'.";
        assert txtDocente != null : "fx:id=\"txtDocente\" was not injected: check your FXML file 'Libretti.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'Libretti.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Libretti.fxml'.";
        assert txtMessage != null : "fx:id=\"txtMessage\" was not injected: check your FXML file 'Libretti.fxml'.";

    }
}

