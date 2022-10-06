package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class MazeGame extends Application 
{
	private Scene startView, levelsView, charactersView, easyView;
	private Intro introController;
	private Levels levelsController;
	private Characters charactersController;
	private Easy easyController;
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		FXMLLoader start = new FXMLLoader(getClass().getResource("/scenes/Intro/Intro.fxml"));
		FXMLLoader levels = new FXMLLoader(getClass().getResource("/scenes/Intro/Levels.fxml"));
		FXMLLoader characters = new FXMLLoader(getClass().getResource("/scenes/Intro/Characters.fxml"));
		FXMLLoader easy = new FXMLLoader(getClass().getResource("/scenes/Game/Easy.fxml")); 
		
		startView = new Scene(start.load());
		levelsView = new Scene(levels.load());
		charactersView = new Scene(characters.load());
		easyView = new Scene(easy.load());
		
		introController = start.getController();
		levelsController = levels.getController();
		charactersController = characters.getController();
		easyController = easy.getController();
		
		introController.start.setOnAction(e -> {
			primaryStage.setScene(levelsView);
        });
		
		levelsController.easyLevel.setOnAction(e -> {
			primaryStage.setScene(charactersView);
        });
		
		levelsController.mediumLevel.setOnAction(e -> {
			primaryStage.setScene(charactersView);
        });
		
		levelsController.hardLevel.setOnAction(e -> {
			primaryStage.setScene(charactersView);
        });
		
		charactersController.char1.setOnAction(e -> {
			primaryStage.setScene(easyView);
		});
		
		easyController.initialise();
		
		primaryStage.setTitle("Game");
		primaryStage.setScene(startView);
		primaryStage.show();
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
