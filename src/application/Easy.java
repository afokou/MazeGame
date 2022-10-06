package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable; 
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode; 
import javafx.scene.input.KeyEvent; 


public class Easy {
	@FXML
	ImageView character;
    int imageX = 0;
    int imageY = 0;

	public void initialise() {
        character.getScene().addEventFilter(KeyEvent.ANY, key -> {
            if (key.getCode().equals(KeyCode.RIGHT)) {
                imageX += 5;
            } else if (key.getCode().equals(KeyCode.LEFT)) {
                imageX -= 5;
            } else if (key.getCode().equals(KeyCode.DOWN)) {
                imageY += 5;
            } else if (key.getCode().equals(KeyCode.UP)) {
                imageY -= 5;
            }
            updateImageView();
        });
        
        character.setFocusTraversable(true);
	}
	
    private void updateImageView() {
        character.setX(imageX);
        character.setY(imageY);
    }
}