package org.example.inclass_week2_bmi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load() , 400, 600);
        stage.setTitle("Jarmon BMI Calculator!");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
}
