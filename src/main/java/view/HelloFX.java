package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class HelloFX extends Application {
    private final static String MAIN_FXML_NAME = "sample.fxml";
    private final static String STYLE_SHEET_NAME = "styles.css";
    private final static String WINDOW_NAME = "JavaFX and Maven";

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(MAIN_FXML_NAME));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource(STYLE_SHEET_NAME).toExternalForm());
        stage.setTitle(WINDOW_NAME);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}