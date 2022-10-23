package application;

import java.util.Timer;
import java.util.TimerTask;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class Hard extends GameLayout {
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
	ImageView brightness;
	@FXML
	Rectangle timeroverlay;
	
	double totalTime = 60;
	double countdown = 60;
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
    
    public void energyBarRun(Class context) {
		
    }
    
    public void run(Class context) {
		System.out.println("Started hard mode");
	    timer = new Timer();
	    timer.scheduleAtFixedRate(new TimerTask() {
	        public void run() {
	            if(countdown > 0) {
	            	double curOpacity = (double) Math.round(countdown / totalTime * 10) / 10;
	            	timeroverlay.setFill(new javafx.scene.paint.Color(0, 0, 0, 1.0 - curOpacity));
	                // System.out.println("Time left: " + countdown);
	            	
	            	if (countdown > 46) {
	            		brightness.setImage(new Image(context.getResourceAsStream("/resources/img/sun_full_1.png")));
	            	} else if (countdown > 32) {
	            		brightness.setImage(new Image(context.getResourceAsStream("/resources/img/sun_2.png")));
	            	} else if (countdown > 18) {
	            		brightness.setImage(new Image(context.getResourceAsStream("/resources/img/sun_3.png")));
	            	} else if (countdown > 4) {
	            		brightness.setImage(new Image(context.getResourceAsStream("/resources/img/sun_4.png")));
	            	} else {
	            		brightness.setImage(new Image(context.getResourceAsStream("/resources/img/sun_gone_5.png")));
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
