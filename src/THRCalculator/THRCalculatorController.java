package THRCalculator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class THRCalculatorController {


    @FXML
    private Button calculateButton;

    @FXML
    private TextField ageTextField;

    @FXML
    private TextField maxTextField;

    @FXML
    private TextField zoneTextField;

    @FXML
    private Label heartBeatLabel;

    @FXML
    private TextField heartBeatTextField;

    @FXML
    private Label resultLabel;

    @FXML
    private TextField resultTextField;


    @FXML
    private void calculateButtonPressed(ActionEvent event) {
        try {
            double age = Integer.parseInt(ageTextField.getText());
            double heartRate = Integer.parseInt(heartBeatTextField.getText());
            double max = 220 - age;
            double lowerRange = max * 0.5;
            double upperRange = max * 0.85;
            String result = "";
            if (heartRate >= lowerRange && heartRate <= upperRange){
                result = "Target HR Zone";
            }else if (heartRate < lowerRange){
                result = "Below Target HR Zone";
            }else if (heartRate > upperRange){
                result = "Above Target HR Zone";
            }

            maxTextField.setText(String.valueOf(max));
            zoneTextField.setText(lowerRange+" - "+upperRange);
            resultTextField.setText(result);


        }
        catch (NumberFormatException ex) {
//            amountTextField.setText("Enter amount");
            ageTextField.setText("Enter proper input");
            heartBeatTextField.setText("Enter proper input");

        }
    }

    // called by FXMLLoader to initialize the controller
    public void initialize() {
        ////Nothing needs to be here! chill
    }
}
