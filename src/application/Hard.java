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
	ImageView obstacle11;
	@FXML
	ImageView obstacle12;
	@FXML
	ImageView obstacle13;
	@FXML
	ImageView obstacle14;
	@FXML
	ImageView obstacle15;
	@FXML
	ImageView obstacle16;
	@FXML
	ImageView obstacle17;
	@FXML
	ImageView obstacle18;
	@FXML
	ImageView obstacle19;
	@FXML
	ImageView obstacle20;
	@FXML
	ImageView obstacle21;
	@FXML
	ImageView obstacle22;
	//@FXML
	//ImageView image1;
	@FXML
	ImageView imageh1;
	@FXML
	ImageView imageh2;
	@FXML
	ImageView imageh3;
	@FXML
	ImageView imageh4;
	@FXML
	ImageView imageh5;
	@FXML
	ImageView imageh6;
	@FXML
	ImageView imageh7;
	@FXML
	ImageView imageh8;
	@FXML
	ImageView food1;
	@FXML
	ImageView food2;
	@FXML
	ImageView food3;
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
	ImageView inventoryImage5;
	@FXML
	ImageView inventoryImage6;
	@FXML
	ImageView inventoryImage7;
	@FXML
	ImageView inventoryImage8;

	@FXML
	Rectangle timeroverlay;
	@FXML
	ImageView energyBar;
	
	@FXML 
	ImageView brightness;
	
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
		inventoryImages.add(inventoryImage5);
		inventoryImages.add(inventoryImage6);
		inventoryImages.add(inventoryImage7);
		inventoryImages.add(inventoryImage8);
		
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
		obstacles.add(obstacle11);
		obstacles.add(obstacle12);
		obstacles.add(obstacle13);
		obstacles.add(obstacle14);
		obstacles.add(obstacle15);
		obstacles.add(obstacle16);
		obstacles.add(obstacle17);
		obstacles.add(obstacle18);
		obstacles.add(obstacle19);
		obstacles.add(obstacle20);
		obstacles.add(obstacle21);
		obstacles.add(obstacle22);
		
		foods.add(food1);
		foods.add(food2);
		foods.add(food3);
		images.add(imageh1);
		images.add(imageh2);
		images.add(imageh3);
		images.add(imageh4);
		images.add(imageh5);
		images.add(imageh6);
		images.add(imageh7);
		images.add(imageh8);
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
	            		brightness.setImage(new Image(context.getResourceAsStream("/resources/img/sun_full_1-1.png")));
	            	} else if (countdown > 18) {
	            		brightness.setImage(new Image(context.getResourceAsStream("/resources/img/sun_full_1-2.png")));
	            	} else if (countdown > 4) {
	            		brightness.setImage(new Image(context.getResourceAsStream("/resources/img/sun_full_1-3.png")));
	            	} else {
	            		brightness.setImage(new Image(context.getResourceAsStream("/resources/img/sun_full_1-4.png")));
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
