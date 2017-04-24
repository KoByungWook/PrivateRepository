package ch17.exam13;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class RootController implements Initializable {
    @FXML private Button btn1;
    @FXML private Button btn2;
    @FXML private Button btn3;
    @FXML private Button btn4;
    @FXML private Button btn5;
    @FXML private Button btn6;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("버튼 1이 클릭됨");
            }
        });
        
        //츛현
        btn2.setOnAction(e -> {
            System.out.println("버튼 2이 클릭됨");
        });
        
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("버튼 4가 눌렸네");
            }
        });
        
        btn5.setOnAction(e -> {
            System.out.println("버튼 5가 눌렸어");
        });
    }
    
    public void btn3Handle(ActionEvent event) {
        System.out.println("버튼 3이 클릭됨");
    }

    public void btn6Handle(ActionEvent event) {
        System.out.println("버튼 6도 눌림");
    }
}
