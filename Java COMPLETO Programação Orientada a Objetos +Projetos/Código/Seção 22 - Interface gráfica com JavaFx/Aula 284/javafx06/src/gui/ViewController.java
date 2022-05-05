package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController implements Initializable {

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

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Constraints.setTextFieldDouble(txtFirstNumber);
		Constraints.setTextFieldDouble(txtSecondNumber);
		Constraints.setTextFieldMaxLength(txtFirstNumber, 12);
		Constraints.setTextFieldMaxLength(txtSecondNumber, 12);
	}
	
}
