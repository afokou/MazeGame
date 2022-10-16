package application;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public abstract class GameLayout {
	protected List<ImageView> inventoryFoods = new ArrayList<ImageView>();
	protected List<ImageView> inventoryImages = new ArrayList<ImageView>();
	List<Node> obstacles = new ArrayList<Node>();
	List<ImageView> foods = new ArrayList<ImageView>();
	List<ImageView> images = new ArrayList<ImageView>();
	public String characterType = "red";
	
    double imageX = 0;
    double imageY = 0;
	
	public abstract void initialiseCharacter(Class context);
	
	public abstract void setup();
	
	public abstract void run();
	
	protected void initialiseCharacterMovement(ImageView character) {
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
            character.setLayoutX(imageX);
            character.setLayoutY(imageY);
            handleFoodCollision(character, foods, inventoryFoods);
            handleImageCollision(character, images, inventoryImages);
        });
        
        character.setFocusTraversable(true);
	}
	
    public boolean isObstacleCollision(ImageView character, double imageX, double imageY, List<Node> obstacles)
    {
    	double oldImageX = character.getLayoutX();
    	double oldImageY = character.getLayoutY();
        character.setLayoutX(imageX);
        character.setLayoutY(imageY);
    	for (Node obstacle : obstacles) {
    		if(character.getBoundsInParent().intersects(obstacle.getBoundsInParent())) {
    	        character.setLayoutX(oldImageX);
    	        character.setLayoutY(oldImageY);
	            return true;
	        }
    	}
    	
        character.setLayoutX(oldImageX);
        character.setLayoutY(oldImageY);
    	return false;
    }
    
    public void handleFoodCollision(ImageView character, List<ImageView> foods, List<ImageView> inventoryFoods)
    {
    	for (ImageView food : foods) {
    		if(character.getBoundsInParent().intersects(food.getBoundsInParent()) && food.getScene() != null) {
    			Integer number = Integer.parseInt(food.getId().substring(food.getId().length() - 1));
	            AnchorPane sceneRoot = (AnchorPane)food.getScene().getRoot();
	            sceneRoot.getChildren().remove(food);
	            
	            ImageView inventoryFood = inventoryFoods.get(number - 1);
	            inventoryFood.setImage(food.getImage());
	            
	            break;
	        }
    	}
    }
    
    public void handleImageCollision(ImageView character, List<ImageView> images, List<ImageView> inventoryImages)
    {
    	for (ImageView image : images) {
    		if(character.getBoundsInParent().intersects(image.getBoundsInParent()) && image.getScene() != null) {
    			Integer number = Integer.parseInt(image.getId().substring(image.getId().length() - 1));
	            AnchorPane sceneRoot = (AnchorPane)image.getScene().getRoot();
	            sceneRoot.getChildren().remove(image);
	            
	            ImageView inventoryImage = inventoryImages.get(number - 1);
	            inventoryImage.setImage(image.getImage());
	            
	            break;
	        }
    	}
    }
}
