package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;

public abstract class GameLayout {
	
	@FXML 
	Button home;
	
	@FXML
	Button help;

	protected List<ImageView> inventoryFoods = new ArrayList<ImageView>();
	protected List<ImageView> inventoryImages = new ArrayList<ImageView>();
	List<Node> obstacles = new ArrayList<Node>();
	List<ImageView> foods = new ArrayList<ImageView>();
	List<ImageView> images = new ArrayList<ImageView>();
	public String characterType = "red";
	
	
    double imageX = 0;
    double imageY = 0;
    public int imagecount =0;
	
	public abstract void initialiseCharacter(Class context);
	
	public abstract void setup();
	
	public abstract void resetGame();
	
	public abstract void resetTimer(Class context);
	
	public abstract void run(Class context);
	
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
	            inventoryFood.getProperties().put("isFood", true);
	            
	    		inputCombination(MazeGame.getLevelScene());

	            break;
	        }
    	}
    }
    
    public void dragAndDropFood(List<ImageView> inventoryFoods, ImageView energyBar, Class context) {
    	for(ImageView inventory : inventoryFoods ) {
        	inventory.setOnDragDetected(new EventHandler<MouseEvent> () {
                   public void handle(MouseEvent event) {
                	Object isOpen = inventory.getProperties().get("isFood");
               		if(isOpen != null && isOpen.equals(true)) {
            			Dragboard db = inventory.startDragAndDrop(TransferMode.ANY);
            			ClipboardContent content = new ClipboardContent();
            			content.putImage(new Image(context.getResourceAsStream("/resources/img/energy_full_5.png")));
            			resetTimer(context);
  	
            			db.setContent(content);
                      	event.consume();
           			}
                   }
               });
        	
        	
            inventory.setOnDragDone(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {

                    Dragboard db = event.getDragboard();

                   if (db.hasImage()) {
                	    inventory.getProperties().put("isFood", false);
                	    inventory.setImage(new Image(context.getResourceAsStream("/resources/img/Rectangle.png")));
                        energyBar.setImage(new Image(context.getResourceAsStream("/resources/img/energy_full_5.png")));
                    }
                     event.consume(); 

                }
            });
        }
       }

  public void findOutifYouWon(List<ImageView> images, List<ImageView> inventoryImages, Class context) {
    	for(ImageView puzzlePieces : inventoryImages ) {	
    		if((boolean) puzzlePieces.getProperties().get("isImage")) {
    			
    		}
    		if(!(boolean) puzzlePieces.getProperties().get("isImage")) {
    			Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setContentText("You won");
    		}
    
    		else {
    			System.out.println("do nothing");
    		}
    	}
    }
    
	  public String userInput ="";
	  public Timer timer = new Timer();  
	  public int timeTyping = 0;
	  public String timerLabel = new String("Time for typing: " + timeTyping + " / 10s");
	  boolean timeOver = false;
	  boolean survived = false;
	  
	  public void setTimer() {
	      this.timer.scheduleAtFixedRate(new TimerTask() {
	        @Override
	        public void run() {
	          if (timeTyping <10) {
	            
	               timeTyping++;
	               System.out.println(timeTyping);
	            }
	          };   
	      }, 0,1000);
	  }
	
	public void inputCombination(Scene scene) {
	  System.out.println("input requested");
	  setTimer();
	  System.out.println("timer requested");
	  Alert inputalert = new Alert(AlertType.INFORMATION);
	  inputalert.setContentText("Close the window and type HELP to survive the night\nYou have 10 seconds");
	  inputalert.show();
	  
	  scene.setOnMouseMoved(mevent -> {
		  if ((timeTyping >9)&&(!timeOver)&&(!survived)) {
			  timeOver = true;
			  Alert timeOut = new Alert(AlertType.INFORMATION);
		      timeOut.setContentText("The time ran out. You lost.");
		      timeOut.show();
		      }
	  });
	  scene.setOnKeyPressed(event -> {
	   	  	System.out.println("input method");
	          if (event.getCode() == KeyCode.H)  {
	            System.out.println("pressed H");
	              userInput = userInput + "H";  
	            System.out.println(userInput);
	            } else if (event.getCode() == KeyCode.E)  {
	                System.out.println("pressed E");
	              userInput = userInput + "E";  
	                System.out.println(userInput);
	            } else if (event.getCode() == KeyCode.L)  {
	                System.out.println("pressed L");
	              userInput = userInput + "L";  
	                System.out.println(userInput);
	            } else if (event.getCode() == KeyCode.X)  {
	                System.out.println("pressed X");
	              userInput = "";  
	                System.out.println(userInput);
	            } else if (event.getCode() == KeyCode.P)  {
	                System.out.println("pressed P");
	                userInput = userInput + "P";  
	                System.out.println(userInput);
	                if (userInput.equals("HELP")){
	              inputalert.setContentText("Well done, you made it through the night");
	              inputalert.show();
	              survived = true;
	              resetTimer(getClass());
	                  
	            }
	        }
	   });
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
	            
	            imagecount++;
	            if(imagecount==4) {	         
	            	iWon();
	            }
	            if(imagecount==6) {
	            	Alert type = new Alert(AlertType.NONE,"You won, press the home button to play again!!",ButtonType.OK);	            	
	            	type.show();
	            }
	            if(imagecount==8) {
	            	Alert type = new Alert(AlertType.NONE,"You won, press the home button to play again!!",ButtonType.OK);	            	
	            	type.show();
	            }
	             
	            break;
	        }
    	}
    }
    
    public void iWon() {
    	Stage myDialog = new Stage();
        myDialog.initModality(Modality.WINDOW_MODAL);
        VBox vBox = new VBox();
        Button menu = new Button("Go to menu");
        
        menu.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #ff66c4;");
        vBox.setStyle("-fx-background-color: #ff66c4");
        vBox.getChildren().addAll(new Text("You found your missing puzzle piece, great job!!"),menu);
        
        Scene dialogScene = new Scene(vBox,200,100);
        myDialog.setScene(dialogScene);
        myDialog.show();
        
        myDialog.show();
        menu.setOnAction(event -> {
            myDialog.close();
            resetGame();
			try {
				MazeGame.main.startGame();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
              
        });
    }
}
