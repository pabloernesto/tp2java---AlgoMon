package fiuba.algo3.algomon.control;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Sonido {
	
    MediaPlayer player;
    
    	public Sonido(){
    		String uriString = new File("sounds/Pokemon_theme_song.mp3").toURI().toString();
    		player = new MediaPlayer( new Media(uriString));
    	}
    }