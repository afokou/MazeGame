package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class MazeGame extends Application 
{
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("/MazeGame.fxml"));
		Parent root = fxmlLoader.load();
		primaryStage.setTitle("MazeGame");
        primaryStage.setFullScreen(false);
//		primaryStage.setScene(new Scene(root, 600, 600));
        Scene scene = new Scene(root, Color.BEIGE);
        primaryStage.setScene(scene);


        //primaryStage.setVisible(true);
        primaryStage.setMaxWidth(400);
        primaryStage.setMaxHeight(400);
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(400);

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
