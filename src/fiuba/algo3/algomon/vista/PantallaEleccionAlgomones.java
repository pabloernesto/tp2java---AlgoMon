package fiuba.algo3.algomon.vista;

import java.util.ArrayList;
import fiuba.algo3.algomon.control.AlgomonesElegidosControlador;
import fiuba.algo3.algomon.control.Ejecutar;
import fiuba.algo3.algomon.excepciones.SeDebenElegirTresAlgomonesPorJugadorException;
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
import javafx.stage.Stage;

public class PantallaEleccionAlgomones extends Scene {

    private static FlowPane rootPane = new FlowPane();
    private Ejecutar aplicacion;

    public PantallaEleccionAlgomones(Stage ventana, Ejecutar ejecutar) {
        super(rootPane, 690, 500);
        this.aplicacion = ejecutar;

        mostrarPantallaEleccionAlgomones();
    }

    private void mostrarPantallaEleccionAlgomones() {
        BorderPane panelJ1 = new BorderPane();
        BorderPane panelJ2 = new BorderPane();

        // SETEAR PANTALLA
        rootPane.setStyle("-fx-background-color: #336699;");

        GridPane grillaAlgomones = new GridPane();
        grillaAlgomones.setHgap(30);
        grillaAlgomones.setVgap(30);

        GridPane grillaAlgomonesElegidos = new GridPane();
        grillaAlgomonesElegidos.setHgap(2);
        grillaAlgomonesElegidos.setVgap(10);

        CheckBox cbSquirtle = new CheckBox("Squirtle");
        ImageView iconSquirtle = new ImageView();
        Image imgSquirtle = new Image("images/front/Squirtle.png");
        cbSquirtle.selectedProperty().addListener(
            new ChangeListener<Boolean>() {
                public void changed(ObservableValue<? extends Boolean> ov, Boolean oldValue, Boolean newValue) {
                    iconSquirtle.setImage(newValue ? imgSquirtle : null);
                }
            });

        CheckBox cbBulbasaur = new CheckBox("Bulbasaur");
        ImageView iconBulbasaur = new ImageView();
        Image imgBulbasaur = new Image("images/front/Bulbasaur.png");
        cbBulbasaur.selectedProperty().addListener(
            new ChangeListener<Boolean>() {
                public void changed(ObservableValue<? extends Boolean> ov, Boolean oldValue, Boolean newValue) {
                    iconBulbasaur.setImage(newValue ? imgBulbasaur : null);
                }
            });
        CheckBox cbChansey = new CheckBox("Chansey");
        ImageView iconChansey = new ImageView();
        Image imgChansey = new Image("images/front/Chansey.png");
        cbChansey.selectedProperty().addListener(
            new ChangeListener<Boolean>() {
                public void changed(ObservableValue<? extends Boolean> ov, Boolean oldValue, Boolean newValue) {
                    iconChansey.setImage(newValue ? imgChansey : null);
                }
            });
        CheckBox cbCharmander = new CheckBox("Charmander");
        ImageView iconCharmander = new ImageView();
        Image imgCharmander = new Image("images/front/Charmander.png");
        cbCharmander.selectedProperty().addListener(
            new ChangeListener<Boolean>() {
                public void changed(ObservableValue<? extends Boolean> ov, Boolean oldValue, Boolean newValue) {
                    iconCharmander.setImage(newValue ? imgCharmander : null);
                }
            });
        CheckBox cbJigglypuff = new CheckBox("Jigglypuff");
        ImageView iconJigglypuff = new ImageView();
        Image imgJigglypuff = new Image("images/front/Jigglypuff.png");
        cbJigglypuff.selectedProperty().addListener(
            new ChangeListener<Boolean>() {
                public void changed(ObservableValue<? extends Boolean> ov, Boolean oldValue, Boolean newValue) {
                    iconJigglypuff.setImage(newValue ? imgJigglypuff : null);
                }
            });
        CheckBox cbRattata = new CheckBox("Rattata");
        ImageView iconRattata = new ImageView();
        Image imgRattata = new Image("images/front/Rattata.png");
        cbRattata.selectedProperty().addListener(
            new ChangeListener<Boolean>() {
                public void changed(ObservableValue<? extends Boolean> ov, Boolean oldValue, Boolean newValue) {
                    iconRattata.setImage(newValue ? imgRattata : null);
                }
            });

        ArrayList<CheckBox> cbs = new ArrayList<CheckBox>();
        cbs.add(cbSquirtle);
        cbs.add(cbBulbasaur);
        cbs.add(cbChansey);
        cbs.add(cbCharmander);
        cbs.add(cbJigglypuff);
        cbs.add(cbRattata);

        grillaAlgomones.add(cbSquirtle, 0, 0);
        grillaAlgomones.add(cbBulbasaur, 1, 0);
        grillaAlgomones.add(cbChansey, 2, 0);
        grillaAlgomones.add(cbCharmander, 0, 1);
        grillaAlgomones.add(cbJigglypuff, 1, 1);
        grillaAlgomones.add(cbRattata, 2, 1);

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
            + aplicacion.getModelo().jugador(0).nombre()
            +" elija 3 algomones:");
        lblEntrenador1.setStyle(
            "-fx-font-size:28 ; -fx-text-fill: #f5f5f5;"
            + "-fx-padding: 10px;");
        panelJ1.setTop(lblEntrenador1);

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
				new AlgomonesElegidosControlador(this, aplicacion, algomones, 0);
				rootPane.getChildren().remove(panelJ1);
	            panelJ2.setCenter(grillaAlgomones);
	            panelJ2.setRight(grillaAlgomonesElegidos);
	            rootPane.getChildren().add(panelJ2);
			} catch (SeDebenElegirTresAlgomonesPorJugadorException e1) {
				Label lblError = new Label("¡Debe elegir tres (3) algomones!");
				lblError.setStyle("-fx-text-fill: #f4f4f4");
				panelJ1.setLeft(lblError);
			}
        });
        panelJ1.setBottom(btnContinuar1);

        rootPane.getChildren().add(panelJ1);

        // JUGADOR 2

        Label lblEntrenador2 = new Label(
            "Entrenador/a "
            + aplicacion.getModelo().jugador(1).nombre()
            + " elija 3 algomones:");
            lblEntrenador2.setStyle(
                "-fx-font-size:28 ; -fx-text-fill: #f5f5f5;"
                + "-fx-padding: 10px;");
        panelJ2.setTop(lblEntrenador2);

        Button btnContinuar2 = new Button("Continuar");
        btnContinuar2.setOnAction(e -> {
            ArrayList<String> algomones = new ArrayList<String>();
            for (int i = 0; i < cbs.size() ; i++){
                if (cbs.get(i).isSelected())
                    algomones.add(cbs.get(i).getText());
            }
            try {
				new AlgomonesElegidosControlador(this, aplicacion, algomones, 1);
				//aplicacion.crearPantallaBatalla();
			} catch (SeDebenElegirTresAlgomonesPorJugadorException e1) {
				Label lblError = new Label("¡Debe elegir tres (3) algomones!");
				lblError.setStyle("-fx-text-fill: #f4f4f4");
				panelJ2.setCenter(lblError);
			}
        });
        panelJ2.setBottom(btnContinuar2);
    }
}
