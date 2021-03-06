package fiuba.algo3.algomon.vista;

import java.util.ArrayList;
import fiuba.algo3.algomon.control.AlgomonesElegidosControlador;
import fiuba.algo3.algomon.control.Ejecutar;
import fiuba.algo3.algomon.excepciones.SeDebenElegirTresAlgomonesPorJugadorException;
import fiuba.algo3.algomon.modelo.Juego;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PantallaEleccionAlgomones extends Scene {

		static BorderPane rootPane = new BorderPane();
	    static FlowPane pantalla = new FlowPane();
	    private Ejecutar aplicacion;
	
	    public PantallaEleccionAlgomones(Stage ventana, Ejecutar ejecutar) {
	        super(rootPane, 500, 600);
	        this.aplicacion = ejecutar;
	
	        rootPane.setTop(aplicacion.barraDeMenu());
	        rootPane.setCenter(pantalla);
	        
	        mostrarPantallaEleccionAlgomones();
	    }
	
	    private void mostrarPantallaEleccionAlgomones() {
	    
	    BorderPane panelJ1 = new BorderPane();
	    panelJ1.setPrefSize(500,600);
	    BorderPane panelJ2 = new BorderPane();
	    panelJ2.setPrefSize(500,600);
	    
        // SETEAR PANTALLA
        pantalla.setStyle("-fx-background-color: #336699;");

        GridPane grillaAlgomones = new GridPane();
        grillaAlgomones.setPrefSize(250, 200);
        grillaAlgomones.setHgap(34);			grillaAlgomones.setVgap(34);
        grillaAlgomones.setStyle("-fx-padding:28 12; -fx-font-size: 16;");
        
        GridPane grillaAlgomonesElegidos = new GridPane();
        grillaAlgomonesElegidos.setPrefSize(250, 200);
        grillaAlgomonesElegidos.setHgap(8);		grillaAlgomonesElegidos.setVgap(14);
        grillaAlgomonesElegidos.setStyle("-fx-padding:14 10;");

        CheckBox cbSquirtle = new CheckBox("Squirtle");
        cbSquirtle.setStyle("-fx-text-fill: #ffff99;");
        ImageView iconSquirtle = new ImageView();
        Image imgSquirtle = new Image("images/front/Squirtle.png");
        cbSquirtle.selectedProperty().addListener(
            new ChangeListener<Boolean>() {
                public void changed(ObservableValue<? extends Boolean> ov, Boolean oldValue, Boolean newValue) {
                    iconSquirtle.setImage(newValue ? imgSquirtle : null);
                }
            });
        CheckBox cbBulbasaur = new CheckBox("Bulbasaur");
        cbBulbasaur.setStyle("-fx-text-fill: #ffff99;");
        ImageView iconBulbasaur = new ImageView();
        Image imgBulbasaur = new Image("images/front/Bulbasaur.png");
        cbBulbasaur.selectedProperty().addListener(
            new ChangeListener<Boolean>() {
                public void changed(ObservableValue<? extends Boolean> ov, Boolean oldValue, Boolean newValue) {
                    iconBulbasaur.setImage(newValue ? imgBulbasaur : null);
                }
            });
        CheckBox cbChansey = new CheckBox("Chansey");
        cbChansey.setStyle("-fx-text-fill: #ffff99;");
        ImageView iconChansey = new ImageView();
        Image imgChansey = new Image("images/front/Chansey.png");
        cbChansey.selectedProperty().addListener(
            new ChangeListener<Boolean>() {
                public void changed(ObservableValue<? extends Boolean> ov, Boolean oldValue, Boolean newValue) {
                    iconChansey.setImage(newValue ? imgChansey : null);
                }
            });
        CheckBox cbCharmander = new CheckBox("Charmander");
        cbCharmander.setStyle("-fx-text-fill: #ffff99;");
        ImageView iconCharmander = new ImageView();
        Image imgCharmander = new Image("images/front/Charmander.png");
        cbCharmander.selectedProperty().addListener(
            new ChangeListener<Boolean>() {
                public void changed(ObservableValue<? extends Boolean> ov, Boolean oldValue, Boolean newValue) {
                    iconCharmander.setImage(newValue ? imgCharmander : null);
                }
            });
        CheckBox cbJigglypuff = new CheckBox("Jigglypuff");
        cbJigglypuff.setStyle("-fx-text-fill: #ffff99;");
        ImageView iconJigglypuff = new ImageView();
        Image imgJigglypuff = new Image("images/front/Jigglypuff.png");
        cbJigglypuff.selectedProperty().addListener(
            new ChangeListener<Boolean>() {
                public void changed(ObservableValue<? extends Boolean> ov, Boolean oldValue, Boolean newValue) {
                    iconJigglypuff.setImage(newValue ? imgJigglypuff : null);
                }
            });
        CheckBox cbRattata = new CheckBox("Rattata");
        cbRattata.setStyle("-fx-text-fill: #ffff99;");
        ImageView iconRattata = new ImageView();
        Image imgRattata = new Image("images/front/Rattata.png");
        cbRattata.selectedProperty().addListener(
            new ChangeListener<Boolean>() {
                public void changed(ObservableValue<? extends Boolean> ov, Boolean oldValue, Boolean newValue) {
                    iconRattata.setImage(newValue ? imgRattata : null);
                }
            });

        ArrayList<CheckBox> cbs = new ArrayList<CheckBox>();
        cbs.add(cbSquirtle); cbs.add(cbBulbasaur); cbs.add(cbChansey); cbs.add(cbCharmander); cbs.add(cbJigglypuff); cbs.add(cbRattata);

        grillaAlgomones.add(cbSquirtle, 0, 0);
        grillaAlgomones.add(cbBulbasaur, 0, 1);
        grillaAlgomones.add(cbChansey, 0, 2);
        grillaAlgomones.add(cbCharmander, 0, 3);
        grillaAlgomones.add(cbJigglypuff, 0, 4);
        grillaAlgomones.add(cbRattata, 0, 5);

        grillaAlgomonesElegidos.add(iconSquirtle,0,0);
        grillaAlgomonesElegidos.add(iconBulbasaur,0,1);
        grillaAlgomonesElegidos.add(iconChansey, 0, 2);
        grillaAlgomonesElegidos.add(iconCharmander,1,0);        
        grillaAlgomonesElegidos.add(iconJigglypuff,1,1);
        grillaAlgomonesElegidos.add(iconRattata,1,2);

        panelJ1.setCenter(grillaAlgomones);
        panelJ1.setRight(grillaAlgomonesElegidos);

        // JUGADOR 1
        Label lblEntrenador1 = new Label(
            "Entrenador/a "
            + Juego.instancia().getJugadorNro(0).nombre()
            +"\n elija 3 algomones");
        	lblEntrenador1.setStyle("-fx-font-size:22 ; -fx-text-fill: #ffcc00; -fx-padding:20 94; -fx-font-weight: bold;");
        lblEntrenador1.setPrefSize(500, 100);
        panelJ1.setTop(lblEntrenador1);

        HBox hb1 = new HBox();
        hb1.setPrefSize(500, 100);
        
        Label errorAlgomones1 = new Label("Debe elegir tres (3) algomones!"); errorAlgomones1.setVisible(false);
        errorAlgomones1.setStyle("-fx-text-fill: #ff9966; -fx-font-size:16; -fx-padding:20");
        hb1.getChildren().add(errorAlgomones1);
        
        Button btnContinuar1 = new Button("Continuar");
        btnContinuar1.setOnAction(e -> {
            ArrayList<String> algomones = new ArrayList<String>();
            for (int i = 0; i < cbs.size() ; i++){
                if (cbs.get(i).isSelected()){
                    algomones.add(cbs.get(i).getText());
                    cbs.get(i).setSelected(false);
                }
            }
            try {
                AlgomonesElegidosControlador c =
                    new AlgomonesElegidosControlador(this, aplicacion,
                        algomones, 0);
                c.agregarAlgomones();
                pantalla.getChildren().remove(panelJ1);
                panelJ2.setCenter(grillaAlgomones);
                panelJ2.setRight(grillaAlgomonesElegidos);
                pantalla.getChildren().add(panelJ2);
            } catch (SeDebenElegirTresAlgomonesPorJugadorException e1) {
            	errorAlgomones1.setVisible(true);
            }
        });
        btnContinuar1.setStyle(	"-fx-background-radius: 30; -fx-padding: 20; -fx-background-color: #ffcc00;"
        		+ "-fx-font-size:18; -fx-font-weight:bold; -fx-text-fill:#336699;");
        hb1.getChildren().add(btnContinuar1);
        hb1.setStyle("-fx-padding: 0 10");
        panelJ1.setBottom(hb1);
        
        pantalla.getChildren().add(panelJ1);

        // JUGADOR 2
        Label lblEntrenador2 = new Label(
            "Entrenador/a "
            + Juego.instancia().getJugadorNro(1).nombre()
            + "\n elija 3 algomones:");
            lblEntrenador2.setStyle("-fx-font-size:22 ; -fx-text-fill: #ffcc00; -fx-padding:20 94; -fx-font-weight: bold");
            lblEntrenador2.setPrefSize(500, 100);
        
        panelJ2.setTop(lblEntrenador2);

        HBox hb2 = new HBox();
        hb2.setPrefSize(500, 100);
        
        Label errorAlgomones2 = new Label("Debe elegir tres (3) algomones!"); errorAlgomones2.setVisible(false);
        errorAlgomones2.setStyle("-fx-text-fill: #ff9966; -fx-font-size:16; -fx-padding:20");
        hb2.getChildren().add(errorAlgomones2);
        
        Button btnContinuar2 = new Button("Continuar");
        btnContinuar2.setOnAction(e -> {
            ArrayList<String> algomones = new ArrayList<String>();
            for (int i = 0; i < cbs.size() ; i++){
                if (cbs.get(i).isSelected())
                    algomones.add(cbs.get(i).getText());
            }
            try {
                AlgomonesElegidosControlador c =
                    new AlgomonesElegidosControlador(this, aplicacion, algomones, 1);
                c.agregarAlgomones();
                aplicacion.crearPantallaBatalla();
            } catch (SeDebenElegirTresAlgomonesPorJugadorException e1) {
            	 errorAlgomones2.setVisible(true);
            }
        });
        btnContinuar2.setStyle(	"-fx-background-radius: 30; -fx-padding: 20; -fx-background-color: #ffcc00;"
        		+ "-fx-font-size:18; -fx-font-weight:bold; -fx-text-fill:#336699;");
        hb2.getChildren().add(btnContinuar2);
        hb2.setStyle("-fx-padding: 0 10");
        panelJ2.setBottom(hb2);
    }
}
