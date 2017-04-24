package ch17.exam20;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(AppMain.class.getResource("root.fxml"));
        Scene scene = new Scene(parent);
        
        primaryStage.setTitle("AppMain");
        primaryStage.setScene(scene);
        
        primaryStage.setOnCloseRequest(event -> {
            System.out.println("Close...");
        });
        
        
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
