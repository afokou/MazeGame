package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.MouseEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

public class MazeGame extends Application 
{
    public static Stage primaryStage;
    public static MazeGame main;
	private Scene startView, levelsView, charactersView, easyView, mediumView, hardView;
	private Intro introController;
	private Levels levelsController;
	private Characters charactersController;
	private GameLayout easyController;
	private GameLayout mediumController;
	private GameLayout hardController;
	
	private String level = "easy";
	
	@Override
	public void start(Stage primaryStage) throws Exception {
        MazeGame.primaryStage = primaryStage;
        MazeGame.main = this;
        startGame();
	}

	public void startGame() throws Exception
	{
		FXMLLoader start = new FXMLLoader(getClass().getResource("/scenes/Intro/Intro.fxml"));
		FXMLLoader levels = new FXMLLoader(getClass().getResource("/scenes/Intro/Levels.fxml"));
		FXMLLoader characters = new FXMLLoader(getClass().getResource("/scenes/Intro/Characters.fxml"));
		FXMLLoader easy = new FXMLLoader(getClass().getResource("/scenes/Game/Easy.fxml"));
		FXMLLoader medium = new FXMLLoader(getClass().getResource("/scenes/Game/Medium.fxml"));
		FXMLLoader hard = new FXMLLoader(getClass().getResource("/scenes/Game/Hard.fxml"));
		
		startView = new Scene(start.load());
		levelsView = new Scene(levels.load());
		charactersView = new Scene(characters.load());
		easyView = new Scene(easy.load());
		mediumView = new Scene(medium.load());
		hardView = new Scene(hard.load());
		
		introController = start.getController();
		levelsController = levels.getController();
		charactersController = characters.getController();
		easyController = easy.getController();
		mediumController = medium.getController();
		hardController = hard.getController();
		
		introController.start.setOnAction(e -> {
			primaryStage.setScene(levelsView);
        });
		
		levelsController.easyLevel.setOnAction(e -> {
			level = "easy";
			primaryStage.setScene(charactersView);
        });
		
		levelsController.mediumLevel.setOnAction(e -> {
			level = "medium";
			primaryStage.setScene(charactersView);
        });
		
		levelsController.hardLevel.setOnAction(e -> {
			level = "hard";
			primaryStage.setScene(charactersView);
        });
		
		charactersController.char1.setPickOnBounds(true);
		charactersController.char1.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				getLevelController().characterType = "red";
				getLevelController().initialiseCharacter(getClass());
				primaryStage.setScene(getLevelScene());
				getLevelController().run(getClass());
			}
		});
		charactersController.char2.setPickOnBounds(true);
		charactersController.char2.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				getLevelController().characterType = "yellow";
				getLevelController().initialiseCharacter(getClass());
				primaryStage.setScene(getLevelScene());
				getLevelController().run(getClass());
			}
		});
		charactersController.char3.setPickOnBounds(true);
		charactersController.char3.setOnMouseClicked(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				getLevelController().characterType = "blue";
				getLevelController().initialiseCharacter(getClass());
				primaryStage.setScene(getLevelScene());
				getLevelController().run(getClass());
			}
		});
		
		easyController.setup();
		mediumController.setup();
		hardController.setup();
		
		primaryStage.setTitle("Game");
		primaryStage.setScene(startView);
		primaryStage.show();
	}
	
	private Scene getLevelScene() {
		if (level == "easy") {
			return easyView;
		}
		
		if (level == "medium") {
			return mediumView;
		}
		
		if (level == "hard") {
			return hardView;
		}
		
		return null;
	}
	
	private GameLayout getLevelController() {
		if (level == "easy") {
			return easyController;
		}
		
		if (level == "medium") {
			return mediumController;
		}
		
		if (level == "hard") {
			return hardController;
		}
		
		return null;
	}

	/**
	 * The main function should never be changed
	 * @param args The arguments given when you launch the application in command line
	 */
	public static void main(String[] args) 
	{
		//We launch the application
		launch(args);
	}
}
