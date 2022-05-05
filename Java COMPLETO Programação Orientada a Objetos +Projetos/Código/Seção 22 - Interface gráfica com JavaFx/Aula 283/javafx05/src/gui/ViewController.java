package gui;

import java.util.Locale;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController {

	@FXML
	private TextField txtFirstNumber;
	@FXML
	private TextField txtSecondNumber;
	@FXML
	private Button btnCalculate;
	@FXML
	private Label lblResult;
	
	@FXML
	public void onCalculateAction() {
		try {
			Locale.setDefault(Locale.US);
			double firstNumber = Double.parseDouble(txtFirstNumber.getText());
			double secondNumber = Double.parseDouble(txtSecondNumber.getText());
			double result = firstNumber + secondNumber;
			lblResult.setText(String.format("%.2f", result));
		} catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Parse error", e.getMessage(), AlertType.ERROR);
		}
	}
	
}
