package fiuba.algo3.algomon.control;

import java.net.URL;
import java.util.ResourceBundle;

import fiuba.algo3.algomon.vista.Ejecutar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class PrimeraPantallaControlador implements Initializable{
	
	private Ejecutar programaPrincipal;
	
	@FXML
    private void nuevaVentana(ActionEvent evento) {
        //llamado desde el boton que existe en la vista.
    }
	
	public void setProgramaPrincipal(Ejecutar programaPrincipal) {
		this.programaPrincipal = programaPrincipal;		
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

}