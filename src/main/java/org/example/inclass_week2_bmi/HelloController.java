package org.example.inclass_week2_bmi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController {

    @FXML private Label lblWeight;
    @FXML private Label lblHeight;
    @FXML private Label lblResult;
    @FXML private TextField tWeight;
    @FXML private TextField tHeight;
    @FXML private Button btnCalculate;

    @FXML
    public void initialize() {
        setLanguage("en", "US");
    }

    ResourceBundle rb;

    private void setLanguage(String language , String country) {
        Locale locale = new Locale(language, country);
        rb = ResourceBundle.getBundle("MessagesBundle", locale);
        lblWeight.setText(rb.getString("lblWeight.text"));
        lblHeight.setText(rb.getString("lblHeight.text"));
        lblResult.setText(rb.getString("lblResult.text"));
        btnCalculate.setText(rb.getString("btnCalculate.text"));
    }

    public void btnCalculateClick(ActionEvent actionEvent) {
        try {
            double weight = Double.parseDouble(tWeight.getText());
            double height = Double.parseDouble(tHeight.getText());
            double bmi = weight / (height * height);
            String result = String.format(rb.getString("lblResult.text") + " " + String.format("%.2f", bmi));
            lblResult.setText(result);
        } catch (NumberFormatException e) {
            lblResult.setText(rb.getString("lblInvalid.text"));
        }
    }


    public void onButton1Click(ActionEvent actionEvent) {
        setLanguage("en", "US");
    }

    public void onButton2Click(ActionEvent actionEvent) {
        setLanguage("fr", "FR");
    }

    public void onButton3Click(ActionEvent actionEvent) {
        setLanguage("ur", "PA");
    }

    public void onButton4Click(ActionEvent actionEvent) {
        setLanguage("vi", "VI");
    }

}
