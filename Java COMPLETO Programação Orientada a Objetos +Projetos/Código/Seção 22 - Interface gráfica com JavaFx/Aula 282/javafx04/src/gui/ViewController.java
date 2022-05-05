package gui;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;

public class ViewController {

	@FXML
	private Button btnClickHere;
	@FXML
	private Label lblTextArea;
	
	public void onBtnClickHereAction() {
		Alerts.ShowALert("Alert title", "Alert header", "Hello", AlertType.INFORMATION);
	}
	
}
