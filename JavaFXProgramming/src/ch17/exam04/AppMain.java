package ch17.exam04;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(AppMain.class.getResource("root.fxml"));        //loader = > xml 해석 , fxml 내 첫번째 태그에 대한 객체 생성
        //                          load(getClass().getResource(  ); 과 같음
        //HBox hbox = (HBox)FXMLLoader.load(getClass().getResource());
        //Scene scene = new Scene(hbox);
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
