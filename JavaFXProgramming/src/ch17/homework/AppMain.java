package ch17.homework;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AppMain extends Application {
    public AppMain() {
        System.out.println(Thread.currentThread().getName() + " AppMain() 호출");
    }

    @Override
    public void init() throws Exception {
        System.out.println(Thread.currentThread().getName() + " init() 호출");
    }
    
    public void start(Stage stage) throws Exception {
        System.out.println(Thread.currentThread().getName() + " start() 호출");
        
        VBox root = new VBox();
        root.setPrefWidth(350);
        root.setPrefHeight(150);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        root.setPadding(new Insets(10));
        
        Label label = new Label();
        label.setText("Hello World");
        label.setFont(new Font(50));
        
        Button button = new Button();
        button.setText("확인");
        button.setOnAction(event->Platform.exit());
        
        root.getChildren().add(button);
        root.getChildren().add(label);
        Scene scene = new Scene(root);
        
        stage.setTitle("AppMain");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println(Thread.currentThread().getName() + " stop() 호출");
    }
    
    
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " main() 호출");
        launch(args);
    }
}
