package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;


public class Controller {

    /**
     * Ustawienia poczatkowe wyswietlanego tekstu
     * @param output przekazuje tekst
     */
    @FXML
    private Text output;

    private double number1 = 0;
    private String operator = "";
    private boolean start = true;
    private boolean isContinued = false;


    private Model model = new Model();

    /**
     * Obsluga klawiatury numerycznej
     * @param event przekazany parametr z UI
     */
    @FXML
    private void processNumpad(ActionEvent event) {
        if (start) {
            output.setText("");
            start = false;
        }
        if (isContinued) {
            output.setText("");
            isContinued = false;
        }



        //Poniższa formuła pozyskuje wartość poprzez kliknięcię "Button"
        String value = ((Button) event.getSource()).getText();
        //Przekazanie wartości do okna
        output.setText(output.getText() + value);
    }


    /**
     * Obsluga operatorow
     * @param event przekazany parametr z UI
     */
    @FXML
    private void processOperator(ActionEvent event) {
        if (output.getText().equals("")) {
            return;
        }
        String value = ((Button) event.getSource()).getText();
            double outputValue = Double.parseDouble(output.getText());



        if (!"=".equals(value)) {
            if (!operator.isEmpty()) {

                    output.setText(String.valueOf(model.calculate(number1, Double.parseDouble(output.getText()), operator)));
                    number1 = Double.parseDouble(output.getText());
                    isContinued = true;
                    operator = value;

                return;
            }

            operator = value;

                number1 = Double.parseDouble(output.getText());

            output.setText("");

        } else {
            if (operator.isEmpty())
                return;

            output.setText(String.valueOf(model.calculate(number1, Double.parseDouble(output.getText()), operator)));
            operator = "";
            start = true;
        }
    }

    /**
     * Obsluga CE Button
     */
    @FXML
    private void handleCEButton() {
        operator = "";
        number1 = 0;
        output.setText("");
    }

    /**
     * Obsluga C Button, usuwanie ostatniego znaku ze Stringa.
     */

    @FXML
    private void handleCButton() {
        String str = output.getText();
    //sprawdza czy podana jest wartość
        if (str != null && str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        output.setText(str);
    }

    /**
     * Obsługa w przypadku gdy obliczenia obierają jedna wartosc
     * @param event
     */

    @FXML
    private void processSingleDigitAction (ActionEvent event) {
        String operator = ((Button) event.getSource()).getText();
        if(!output.getText().equals("")) {
           output.setText("" + model.calculate(Double.parseDouble(output.getText()), operator));
        }
    }
}