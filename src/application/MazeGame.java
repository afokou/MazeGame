package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.MouseEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

public class MazeGame extends Application {
	public static Stage primaryStage;
	public static MazeGame main;
	private Scene startView, levelsView, charactersView;
	private static Scene easyView;
	private static Scene mediumView;
	private static Scene hardView;
	private Intro introController;
	private Levels levelsController;
	private Characters charactersController;
	private GameLayout easyController;
	private GameLayout mediumController;
	private GameLayout hardController;

	public static String level = "easy";

	@Override
	public void start(Stage primaryStage) throws Exception {
		MazeGame.primaryStage = primaryStage;
		MazeGame.main = this;
		startGame();
	}

	public void startGame() throws Exception {
		FXMLLoader start = new FXMLLoader(getClass().getResource("/scenes/Intro/Intro.fxml"));
		FXMLLoader levels = new FXMLLoader(getClass().getResource("/scenes/Intro/Levels.fxml"));
		FXMLLoader characters = new FXMLLoader(getClass().getResource("/scenes/Intro/Characters.fxml"));
		FXMLLoader easy = new FXMLLoader(getClass().getResource("/scenes/Game/Easy.fxml"));
		FXMLLoader medium = new FXMLLoader(getClass().getResource("/scenes/Game/Medium.fxml"));
		FXMLLoader hard = new FXMLLoader(getClass().getResource("/scenes/Game/Hard.fxml"));

		startView = new Scene(start.load());
		levelsView = new Scene(levels.load());
		charactersView = new Scene(characters.load());
		setEasyView(new Scene(easy.load()));
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

		easyController.home.setOnAction(e -> {
			try {
				easyController.resetGame();
				MazeGame.main.startGame();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		mediumController.home.setOnAction(e -> {
			try {
				mediumController.resetGame();
				MazeGame.main.startGame();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		hardController.home.setOnAction(e -> {
			try {
				hardController.resetGame();
				MazeGame.main.startGame();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		easyController.help.setOnAction(e -> {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText(
					"Find all the puzzle pieces to win the game, drag the apple to the engery bar to get more time. If you encounter a dog, type help to receive extra time.");
			alert.show();
		});

		mediumController.help.setOnAction(e -> {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText(
					"Find all the puzzle pieces to win the game, drag the apple to the engery bar to get more time");
			alert.show();
		});

		hardController.help.setOnAction(e -> {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText(
					"Find all the puzzle pieces to win the game, drag the apple to the engery bar to get more time");
			alert.show();
		});

		introController.infoStart.setOnAction(e -> {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText(
					"Find all the puzzle pieces to win the game, drag the apple to the engery bar to get more time. When you collect all the puzzle pieces you win the game. When the sun is no longer shining and the energy bar is out you lose the game");
			alert.show();
		});

		levelsController.levelsInfo.setOnAction(e -> {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("Choose a level");
			alert.show();
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

	public static Scene getLevelScene() {
		if (level == "easy") {
			return getEasyView();
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
	 * 
	 * @param args The arguments given when you launch the application in command
	 *             line
	 */
	public static void main(String[] args) {
		// We launch the application
		launch(args);
	}

	public static Scene getEasyView() {
		return easyView;
	}

	public void setEasyView(Scene easyView) {
		this.easyView = easyView;
	}
}
