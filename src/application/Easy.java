package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.shape.Polygon;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode; 
import javafx.scene.input.KeyEvent; 


public class Easy {
	@FXML
	ImageView character;
	@FXML
	Polygon obstacle1;
	@FXML
	Polygon obstacle2;
	@FXML
	Polygon obstacle3;
	@FXML
	Polygon obstacle4;
	@FXML
	Polygon obstacle5;
	@FXML
	Polygon obstacle6;
	@FXML
	Polygon obstacle7;
	@FXML
	Polygon obstacle8;
	@FXML
	Polygon obstacle9;
	@FXML
	Polygon obstacle10;
	
    double imageX = 0;
    double imageY = 0;

	public void initialise() {
		List<Node> obstacles = new ArrayList<Node>();
		obstacles.add(obstacle1);
		obstacles.add(obstacle2);
		obstacles.add(obstacle3);
		obstacles.add(obstacle4);
		obstacles.add(obstacle5);
		obstacles.add(obstacle6);
		obstacles.add(obstacle7);
		obstacles.add(obstacle8);
		obstacles.add(obstacle9);
		obstacles.add(obstacle10);
		
		imageX = character.getLayoutX();
		imageY = character.getLayoutY();
        character.getScene().addEventFilter(KeyEvent.ANY, key -> {
            if (key.getCode().equals(KeyCode.RIGHT) && !isObstacleCollision(character, imageX + 5, imageY, obstacles)) {
                imageX += 5;
            } else if (key.getCode().equals(KeyCode.LEFT) && !isObstacleCollision(character, imageX - 5, imageY, obstacles)) {
                imageX -= 5;
            } else if (key.getCode().equals(KeyCode.DOWN) && !isObstacleCollision(character, imageX, imageY + 5, obstacles)) {
                imageY += 5;
            } else if (key.getCode().equals(KeyCode.UP) && !isObstacleCollision(character, imageX, imageY - 5, obstacles)) {
                imageY -= 5;
            }
            updateImageView();
        });
        
        character.setFocusTraversable(true);
	}
	
    private void updateImageView() {
        character.setLayoutX(imageX);
        character.setLayoutY(imageY);
    }
    
    public boolean isObstacleCollision(ImageView character, double imageX, double imageY, List<Node> obstacles)
    {
    	double oldImageX = character.getLayoutX();
    	double oldImageY = character.getLayoutY();
        character.setLayoutX(imageX);
        character.setLayoutY(imageY);
    	for (Node obstacle : obstacles) {
    		if(obstacle != null && character.getBoundsInParent().intersects(obstacle.getBoundsInParent())) {
    	        character.setLayoutX(oldImageX);
    	        character.setLayoutY(oldImageY);
	            return true;
	        }
    	}
    	
        character.setLayoutX(oldImageX);
        character.setLayoutY(oldImageY);
    	return false;
    }
}