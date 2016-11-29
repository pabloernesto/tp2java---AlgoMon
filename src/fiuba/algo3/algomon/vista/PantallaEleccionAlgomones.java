package fiuba.algo3.algomon.vista;

import java.util.ArrayList;

import fiuba.algo3.algomon.control.AlgomonesElegidosControlador;
import fiuba.algo3.algomon.modelo.Algomon;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PantallaEleccionAlgomones extends Scene {

	private static FlowPane rootPane = new FlowPane();
	private Ejecutar aplicacion;
	private ArrayList<Algomon> algomonesJ1, algomonesJ2;

	public PantallaEleccionAlgomones(Stage ventana, Ejecutar ejecutar) {
		super(rootPane ,690 ,500 );
        this.aplicacion = ejecutar;

        mostrarPantallaEleccionAlgomones();		
	}

	private void mostrarPantallaEleccionAlgomones() {
		// JUGADOR 1
		Label lblEntrenador1 = new Label("Entrenador/a "+ aplicacion.getModelo().jugador(0).nombre() +" elija 3 algomones.");
			lblEntrenador1.setStyle("-fx-font-size:16 ; ");
		Button btnSquirtle1 = new Button();	
			btnSquirtle1.setGraphic(new ImageView(new Image("images/front/squirtle.png"))); 
//			btnSquirtle1.setOnMouseClicked(e -> {
//				if (btnSquirtle1.isSelected()) {
//					btnSquirtle1.setStyle("-fx-background-color: #336699");
//		        	btnSquirtle1.setSelected(false);
//				}else{
//					btnSquirtle1.setStyle("-fx-background-color: #ffffff ");
//				    btnSquirtle1.setSelected(true);	
//				}
//			});
//		btnSquirtle1.setStyle("-fx-background-color: #336699");    	
		Button btnCharmander1 = new Button();
			btnCharmander1.setGraphic(new ImageView(new Image("images/front/CHARMANDER.png")));
		Button btnBulbasaur1 = new Button();
			btnBulbasaur1.setGraphic(new ImageView(new Image("images/front/BULBASAUR.png")));
		Button btnRattata1 = new Button();
			btnRattata1.setGraphic(new ImageView(new Image("images/front/rattata.png")));
		Button btnChansey1 = new Button();
			btnChansey1.setGraphic(new ImageView(new Image("images/front/chansey.png")));
		Button btnJigglypuff1 = new Button();
			btnJigglypuff1.setGraphic(new ImageView(new Image("images/front/jigglypuff.png")));
		
		GridPane grillaAlgomones1 = new GridPane();
			grillaAlgomones1.setHgap(10);	grillaAlgomones1.setVgap(10);
		    grillaAlgomones1.add(btnSquirtle1, 0, 0); 
		    grillaAlgomones1.add(btnCharmander1, 1, 0); 
		    grillaAlgomones1.add(btnBulbasaur1, 2, 0); 
		    grillaAlgomones1.add(btnRattata1, 0, 1); 
		    grillaAlgomones1.add(btnChansey1, 1, 1); 
		    grillaAlgomones1.add(btnJigglypuff1, 2, 1); 
			
		BorderPane panelJ1 = new BorderPane();
			panelJ1.setTop(lblEntrenador1);
			panelJ1.setCenter(grillaAlgomones1);

		// JUGADOR 2
		Label lblEntrenador2 = new Label("Entrenador  elija 3 algomones.");
		Button btnSquirtle2 = new Button();
			btnSquirtle2.setGraphic(new ImageView(new Image("images/front/squirtle.png")));
		Button btnCharmander2 = new Button();
			btnCharmander2.setGraphic(new ImageView(new Image("images/front/CHARMANDER.png")));
		Button btnBulbasaur2 = new Button();
			btnBulbasaur2.setGraphic(new ImageView(new Image("images/front/BULBASAUR.png")));
		Button btnRattata2 = new Button();
			btnRattata2.setGraphic(new ImageView(new Image("images/front/rattata.png")));
		Button btnChansey2 = new Button();
			btnChansey2.setGraphic(new ImageView(new Image("images/front/chansey.png")));
		Button btnJigglypuff2 = new Button();
			btnJigglypuff2.setGraphic(new ImageView(new Image("images/front/jigglypuff.png")));		
		
		GridPane grillaAlgomones2 = new GridPane();
			grillaAlgomones2.setHgap(10);	grillaAlgomones2.setVgap(10);
		    grillaAlgomones2.add(btnSquirtle2, 0, 0); 
		    grillaAlgomones2.add(btnCharmander2, 1, 0); 
		    grillaAlgomones2.add(btnBulbasaur2, 2, 0); 
		    grillaAlgomones2.add(btnRattata2, 0, 1); 
		    grillaAlgomones2.add(btnChansey2, 1, 1); 
		    grillaAlgomones2.add(btnJigglypuff2, 2, 1);
			
		BorderPane panelJ2 = new BorderPane();
			panelJ2.setTop(lblEntrenador2);
			panelJ2.setCenter(grillaAlgomones2);
		
		// BOTON CONTINUAR
			
		Button btnContinuar = new Button("Continuar");
		btnContinuar.setOnAction(e -> {
        	new AlgomonesElegidosControlador(this,aplicacion,algomonesJ1,algomonesJ2);
		});;
		
		rootPane.getChildren().addAll(panelJ1,panelJ2,btnContinuar);
		rootPane.setStyle("-fx-background-color: #336699;");
	}

	
}
