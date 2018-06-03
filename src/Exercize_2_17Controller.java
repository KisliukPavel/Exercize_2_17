import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Exercize_2_17Controller {

	@FXML
	private Button start_Button;

	@FXML
	private TextField number1_Text_Field;

	@FXML
	private TextField number2_Text_Field;

	@FXML
	private TextField number3_Text_Field;

	@FXML
	private TextField sum_Text_Field;

	@FXML
	private TextField product_Text_Field;

	@FXML
	private TextField average_Text_Field;

	@FXML
	private TextField largest_Text_Field;

	@FXML
	private TextField smallest_Text_Field;

	@FXML
	private Label warning_Label;

	@FXML
	void start_Button_On_Action(ActionEvent event) {
		//-------------------------------check input numbers
		if(!(check_Input(number1_Text_Field.getText())) ||
				!(check_Input(number2_Text_Field.getText())) || !
						(check_Input(number3_Text_Field.getText()))){
			//-----------------------------
			warning_Label.setVisible(true);
			sum_Text_Field.setDisable(true);
			product_Text_Field.setDisable(true);
			average_Text_Field.setDisable(true);
			largest_Text_Field.setDisable(true);
			smallest_Text_Field.setDisable(true);
		}
		//-------------------------------check empty fields
		else if(isEmpty(number1_Text_Field.getText()) ||
					isEmpty(number2_Text_Field.getText()) ||
							isEmpty(number3_Text_Field.getText())) {
			//-----------------------------
			warning_Label.setVisible(false);
			sum_Text_Field.setDisable(true);
			product_Text_Field.setDisable(true);
			average_Text_Field.setDisable(true);
			largest_Text_Field.setDisable(true);
			smallest_Text_Field.setDisable(true);
		}
		//-------------------------------if everything correct perform programm
		else{
			warning_Label.setVisible(false);
			sum_Text_Field.setDisable(false);
			product_Text_Field.setDisable(false);
			average_Text_Field.setDisable(false);
			largest_Text_Field.setDisable(false);
			smallest_Text_Field.setDisable(false);
			//-----------------------------sum
			Integer sum = Integer.valueOf(number1_Text_Field.getText()) +
					Integer.valueOf(number2_Text_Field.getText()) +
							Integer.valueOf(number3_Text_Field.getText());
			sum_Text_Field.setText(sum.toString());
			//-----------------------------product
			Integer product = Integer.valueOf(number1_Text_Field.getText()) *
					Integer.valueOf(number2_Text_Field.getText()) *
					Integer.valueOf(number3_Text_Field.getText());
			product_Text_Field.setText(product.toString());
			//-----------------------------average
			Double average = (Double.valueOf(number1_Text_Field.getText()) +
					Double.valueOf(number2_Text_Field.getText()) +
					Double.valueOf(number3_Text_Field.getText())) / 3;
			average_Text_Field.setText(String.format("%.2f", average));
			//-----------------------------largest
			largest_Text_Field.setText(max_Number(Integer.valueOf(number1_Text_Field.getText()),
					Integer.valueOf(number2_Text_Field.getText()),
							Integer.valueOf(number3_Text_Field.getText()))
					.toString());
			//-----------------------------smallest
			smallest_Text_Field.setText(min_Number(Integer.valueOf(number1_Text_Field.getText()),
					Integer.valueOf(number2_Text_Field.getText()),
					Integer.valueOf(number3_Text_Field.getText()))
					.toString());
			//-----------------------------
		}
	}

	boolean check_Input(String text_Field)
	{
		if(text_Field.length() > 2) return false;
		for(int i = 0; i < text_Field.length(); i++) {
			if(!(Character.isDigit(text_Field.charAt(i)))) {
				return false;
			}
		}
		return true;
	}

	boolean isEmpty(String text_Field)
	{
		return (0 == text_Field.length()) ? true : false;
	}

	Integer max_Number(Integer v1, Integer v2, Integer v3)
	{
		Integer max = v1;
		if(v2 > max) max = v2;
		if(v3 > max) max = v3;
		return max;
	}

	Integer min_Number(Integer v1, Integer v2, Integer v3)
	{
		Integer min = v1;
		if(v2 < min) min = v2;
		if(v3 < min) min = v3;
		return min;
	}
}
