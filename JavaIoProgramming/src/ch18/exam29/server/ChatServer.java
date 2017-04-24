package ch18.exam29.server;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChatServer extends Application {
    public static Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("server.fxml"));

        Scene scene = new Scene(parent);
        primaryStage.setTitle("채팅서버");
        primaryStage.setScene(scene);
        
        primaryStage.setOnCloseRequest(event -> {
            ServerController.instance.stopServer();
	    System.out.println("server Close...");
	});
        
        
        primaryStage.show();
    }
    
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
