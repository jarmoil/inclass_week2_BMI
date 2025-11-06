package org.example.inclass_week2_bmi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.inclass_week2_bmi.BMIResultService;
import org.example.inclass_week2_bmi.LocalizationService;

import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;


public class BMIController {
    @FXML
    private Label welcomeText;

    @FXML
    private Label lblWeight;

    @FXML
    private Label lblHeight;

    @FXML
    private TextField tfWeight;


    @FXML
    private TextField tfHeight;

    @FXML
    private Button btnCalculate;

    @FXML
    private Label lblResult;

    @FXML
    private Label lblLocalTime; // New label for showing local time



    private Map<String, String> localizedStrings;


    public void initialize() {
        setLanguage(new Locale("en", "US"));

    }

    private void setLanguage(Locale locale) {
        lblResult.setText("");
        localizedStrings = LocalizationService.getLocalizedStrings(locale);
        lblWeight.setText(localizedStrings.getOrDefault("weight", "Weight"));
        lblHeight.setText(localizedStrings.getOrDefault("height", "Height"));
        btnCalculate.setText(localizedStrings.getOrDefault("calculate", "Calculate"));
        displayLocalTime(locale);
    }
    public void onCalculateClick(ActionEvent actionEvent) {
        try {
            double weight = Double.parseDouble(tfWeight.getText());
            double height = Double.parseDouble(tfHeight.getText()) / 100.0;
            double bmi = weight / (height * height);
            DecimalFormat df = new DecimalFormat("#0.00");
            lblResult.setText(localizedStrings.getOrDefault("result", "Your BMI is") + " " + df.format(bmi));
            // Save to database
            String language = Locale.getDefault().getLanguage(); // or store current locale
            BMIResultService.saveResult(weight, height, bmi, language);
        } catch (NumberFormatException e) {
            lblResult.setText(localizedStrings.getOrDefault("invalid", "Invalid input"));
        }
    }


    public void onENClick(ActionEvent actionEvent) {
        setLanguage(new Locale("en", "US"));
    }

    public void onFRClick(ActionEvent actionEvent) {
        setLanguage(new Locale("fr", "FR"));

    }

    public void onURClick(ActionEvent actionEvent) {
        setLanguage(new Locale("ur", "PA"));

    }

    public void onVIClick(ActionEvent actionEvent) {
        setLanguage(new Locale("vi", "VI"));

    }

    // Display the time

    private void displayLocalTime(Locale locale) {
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss", locale);
        String formattedTime = currentTime.format(formatter);
        lblLocalTime.setText(localizedStrings.getOrDefault("local_time", "Local Time") + ": " + formattedTime);
    }
}