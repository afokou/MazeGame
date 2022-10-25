package application;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Levels implements EventHandler<MouseEvent> {
	@FXML
	Button easyLevel;

	@FXML
	Button mediumLevel;

	@FXML
	Button hardLevel;
	@FXML
	Button levelsInfo;

	public void initialize() {
	}

	@Override
	public void handle(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}