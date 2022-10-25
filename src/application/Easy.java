package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
	ImageView obstacle1;
	@FXML
	ImageView obstacle2;
	@FXML
	ImageView obstacle3;
	@FXML
	ImageView obstacle4;
	@FXML
	ImageView obstacle5;
	@FXML
	ImageView obstacle6;
	@FXML
	ImageView obstacle7;
	@FXML
	ImageView obstacle8;
	@FXML
	ImageView obstacle9;
	@FXML
	ImageView obstacle10;
	@FXML
	ImageView imagee1;
	@FXML
	ImageView imagee2;
	@FXML
	ImageView imagee3;
	@FXML
	ImageView imagee4;
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
	Rectangle timeroverlay;
	@FXML
	ImageView energyBar;

	@FXML 
	ImageView brightness;
	
	double totalTime = 150;
	double countdown = 150;
	Timer timer;

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
    	findOutifYouWon(foods, foods, context);
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
		//images.add(image1);
		images.add(imagee1);
		images.add(imagee2);
		images.add(imagee3);
		images.add(imagee4);
    }
    

    public void run(Class context) {
	    timer = new Timer();
	    timer.scheduleAtFixedRate(new TimerTask() {
	        public void run() {
	 
	            if(countdown > 0) {
	            	double curOpacity = (double) Math.round(countdown / totalTime * 10) / 10;
	            	timeroverlay.setFill(new javafx.scene.paint.Color(0, 0, 0, 1.0 - curOpacity));
	            	
	            	if (countdown > 130) {
	            		brightness.setImage(new Image(context.getResourceAsStream("/resources/img/sun_full_1.png")));
	            		energyBar.setImage(new Image(context.getResourceAsStream("/resources/img/energy_full_5.png")));
	            	} else if (countdown > 60) {
	            		brightness.setImage(new Image(context.getResourceAsStream("/resources/img/sun_full_1-1.png")));
	            		energyBar.setImage(new Image(context.getResourceAsStream("/resources/img/energy_4.png")));
	            	} else if (countdown > 15) {
	            		brightness.setImage(new Image(context.getResourceAsStream("/resources/img/sun_full_1-2.png")));
	            		energyBar.setImage(new Image(context.getResourceAsStream("/resources/img/energy_3.png")));
	            		
	            	} else if (countdown > 5 ) {
	            		brightness.setImage(new Image(context.getResourceAsStream("/resources/img/sun_full_1-3.png")));
	            		energyBar.setImage(new Image(context.getResourceAsStream("/resources/img/energy_2.png")));
	            	} else {
	            		brightness.setImage(new Image(context.getResourceAsStream("/resources/img/sun_full_1-4.png")));
	            		energyBar.setImage(new Image(context.getResourceAsStream("/resources/img/energy_1.png")));
	         
	            	}
	            	
	            	
	                countdown--;
	                
	            }
	            else {
	                timer.cancel();
	            }
	        }
	    }, 1000,1000);
    }
}
