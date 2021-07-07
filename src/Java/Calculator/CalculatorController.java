package Java.Calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController {

    private long number1;
    private String operator = "";
    private boolean start = true;

    @FXML
    private Label output;

    @FXML
    private void processNumPad(ActionEvent event){
        if(start) {
            output.setText("");
            start = false;
        }

        String value = ((Button)event.getSource()).getText();
        output.setText(output.getText() + value);
    }

    @FXML
    private void processOperator(ActionEvent event){
        if(output.getText().equals("ERR"))
            return;

        String value = ((Button)event.getSource()).getText();

        if(!value.equals("=")){
            if(!operator.isEmpty()){
                return;
            }

            operator = value;
            number1 = Long.parseLong(output.getText());
            output.setText("");
        }

        else{
            if(operator.isEmpty()){
                return;
            }

            if(output.getText().isEmpty()){
                output.setText("ERR");
                operator = "";
                start = true;
                return;
            }

            output.setText(operation(number1, Long.parseLong(output.getText()), operator));
            operator = "";
            start = true;
        }
    }

    @FXML
    private void clearOut(){
        output.setText("0");
        start = true;
        operator = "";
    }

    @FXML
    private void notWorking(){
        System.out.println("this button does not work yet ^^ ");
    }

    String operation(long number1, long number2, String op){
        switch (op){
            case"+":
                if(number1 + number2 == 69)
                    return "segggz";
                if(number1 + number2 > 999_999_999)
                    return "W CHUJ";
                return String.valueOf(number1 + number2);
            case"-":
                if(number1 - number2 == 69)
                    return "segggz";
                return String.valueOf(number1 - number2);
            case"×":
                if(number1 * number2 == 69)
                    return "segggz";
                if(number1 * number2 > 999_999_999)
                    return "W CHUJ";
                return String.valueOf(number1 * number2);
            case"÷":
                if(number2 == 0){
                    return "ERR";
                }
                if(number1 / number2 == 69)
                    return "segggz";
                return String.valueOf(number1 / number2);
        }
        return "ERR";
    }
}
