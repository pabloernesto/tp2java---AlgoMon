package fiuba.algo3.algomon.modelo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AuxiliarImagen extends ImageView {

	    Algomon algomon;
	
	    public AuxiliarImagen(Algomon a) {
	        algomon = a;
	    }
	
	    public ImageView mostrarFrente() {
	        setImage(new Image(imagenFrentePath()));
	        return this;
	    }
	
	    public ImageView mostrarEspalda() {
	        setImage(new Image(imagenEspaldaPath()));
	        return this;
	    }
	
	    String imagenFrentePath() {
	        String path = "images/front/"
	            + algomon.nombreEspecie()
	            + ".png";
	        return path;
	    }
	
	    String imagenEspaldaPath() {
	        String path = "images/back/"
	            + algomon.nombreEspecie()
	            + ".png";
	        return path;
	    }
}
