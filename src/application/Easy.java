package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Easy extends GameLayout {
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
	@FXML
	ImageView energyBar;
    
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
    	initialiseCharacterMovement(character);
    	dragAndDropFood(inventoryFoods, energyBar, context);
    }
    
    public void setup() {
		inventoryFoods.add(inventoryFood1);
		inventoryFoods.add(inventoryFood2);
		inventoryFoods.add(inventoryFood3);
		inventoryFoods.add(inventoryFood4);
		
		inventoryImages.add(inventoryImage1);
		inventoryImages.add(inventoryImage2);
		inventoryImages.add(inventoryImage3);
		inventoryImages.add(inventoryImage4);
		
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
		
		foods.add(food1);
		images.add(image1);
    }

	public void run(Class context) {
		System.out.println("Started easy mode");
	}
}
