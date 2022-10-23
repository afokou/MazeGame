package application;

import java.util.Timer;
import java.util.TimerTask;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class Medium extends GameLayout {
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
	ImageView imagem1;
	@FXML
	ImageView imagem2;
	@FXML
	ImageView imagem3;
	@FXML
	ImageView imagem4;
	@FXML
	ImageView imagem5;
	@FXML
	ImageView imagem6;
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
	Rectangle timeroverlay;
	@FXML
	ImageView energyBar;
	
	@FXML 
	ImageView brightness;
	
	double totalTime = 100;
	double countdown = 100;
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

		
		foods.add(food1);
		foods.add(food2);
		foods.add(food3);
		images.add(imagem1);
		images.add(imagem2);
		images.add(imagem3);
		images.add(imagem4);
		images.add(imagem5);
		images.add(imagem6);
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
