module org.example.inclass_week2_bmi {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.inclass_week2_bmi to javafx.fxml;
    exports org.example.inclass_week2_bmi;
}