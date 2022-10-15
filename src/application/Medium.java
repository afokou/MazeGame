package application;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Polygon;

public class Medium extends GameLayout {
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
	@FXML
	ImageView image1;
	@FXML
	ImageView food1;
	@FXML
	ImageView inventoryFood1;
	@FXML
	ImageView inventoryFood2;
	@FXML
	ImageView inventoryFood3;
	@FXML
	ImageView inventoryFood4;
	@FXML
	ImageView inventoryImage1;
	@FXML
	ImageView inventoryImage2;
	@FXML
	ImageView inventoryImage3;
	@FXML
	ImageView inventoryImage4;
	
    public void initialiseCharacter(Class context) {
    	if (characterType == "red") {
    		character.setImage(new Image(context.getResourceAsStream("/resources/img/char1.png")));
    	}
    	if (characterType == "yellow") {
    		character.setImage(new Image(context.getResourceAsStream("/resources/img/char2.png")));
    	}
    	if (characterType == "blue") {
    		character.setImage(new Image(context.getResourceAsStream("/resources/img/char3.png")));
    	}
    }
	
    public void setup() {
    }
    
    public void run() {
    	
    }
}
