package ch17.homework0417.eventhandler;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class Controller implements Initializable {
    @FXML private Button btn1;
    @FXML private Button btn2;
    @FXML private Button btn3;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       btn1.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
              System.out.println("1번 버튼 누름");
           }
       });
       
       btn2.setOnAction((event) -> {
           System.out.println("2번 버튼 누름");
       });
    }
    
    public void btn3Handle(ActionEvent event) {
        System.out.println("3번 버튼 누름");
    }

}
