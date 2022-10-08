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
	
    double imageX = 0;
    double imageY = 0;

	public void initialise() {
		List<ImageView> inventoryFoods = new ArrayList<ImageView>();
		inventoryFoods.add(inventoryFood1);
		inventoryFoods.add(inventoryFood2);
		inventoryFoods.add(inventoryFood3);
		inventoryFoods.add(inventoryFood4);
		
		List<ImageView> inventoryImages = new ArrayList<ImageView>();
		inventoryImages.add(inventoryImage1);
		inventoryImages.add(inventoryImage2);
		inventoryImages.add(inventoryImage3);
		inventoryImages.add(inventoryImage4);
		
		
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
		
		List<ImageView> foods = new ArrayList<ImageView>();
		foods.add(food1);
		
		List<ImageView> images = new ArrayList<ImageView>();
		images.add(image1);
		
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
            handleFoodCollision(character, foods, inventoryFoods);
            handleImageCollision(character, images, inventoryImages);
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