package ch17.exam28;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
    public static Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        AppMain.primaryStage = primaryStage;
        //Parent parent = FXMLLoader.load(AppMain.class.getResource("root.fxml"));
        
        //how2
        FXMLLoader loader = new FXMLLoader(getClass().getResource("root.fxml"));
        Parent parent = loader.load();
        RootController controller = loader.getController();
        controller.setPrimaryStage(primaryStage);
        
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
