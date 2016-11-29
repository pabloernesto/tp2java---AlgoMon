package fiuba.algo3.algomon.vista;

import fiuba.algo3.algomon.control.Ejecutar;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PantallaEleccionAlgomones extends Scene {

	private static GridPane rootPane = new GridPane();
	private Ejecutar aplicacion;

	public PantallaEleccionAlgomones(Stage ventana, Ejecutar ejecutar) {
		super(rootPane ,480,480);
        this.aplicacion = aplicacion;

        mostrarPantallaEleccionAlgomones();		
	}

	private void mostrarPantallaEleccionAlgomones() {		
		Button btnSquirtle = new Button();
		btnSquirtle.setGraphic(new ImageView(new Image("images/front/squirtle.png")));
		Button btnCharmander = new Button();
		btnCharmander.setGraphic(new ImageView(new Image("images/front/CHARMANDER.png")));
		Button btnBulbasaur = new Button();
		btnBulbasaur.setGraphic(new ImageView(new Image("images/front/BULBASAUR.png")));
		Button btnRattata = new Button();
		btnRattata.setGraphic(new ImageView(new Image("images/front/rattata.png")));
		Button btnChansey = new Button();
		btnChansey.setGraphic(new ImageView(new Image("images/front/chansey.png")));
		Button btnJigglypuff = new Button();
		btnJigglypuff.setGraphic(new ImageView(new Image("images/front/jigglypuff.png")));
		
		HBox hboxAlgomones1 = new HBox();
		hboxAlgomones1.getChildren().addAll(btnSquirtle,btnCharmander,btnBulbasaur,btnRattata,btnChansey,btnJigglypuff);
		HBox hboxAlgomones2 = new HBox();
		hboxAlgomones2.getChildren().addAll(btnSquirtle,btnCharmander,btnBulbasaur,btnRattata,btnChansey,btnJigglypuff);
		
		rootPane.getChildren().addAll(hboxAlgomones1,hboxAlgomones2);
	}

	
}
