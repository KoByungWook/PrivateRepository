package mainDisplay;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class MainDisplayController implements Initializable {

    @FXML
    private StackPane stackPane;
    @FXML
    private Label labelDate;
    @FXML
    private Label labelTime;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        boolean stop = false;
        Thread timeThread = new Thread() {
            @Override
            public void run() {
                SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
                SimpleDateFormat sdf2 = new SimpleDateFormat("MM월 dd일(E)");
                while(!stop) {
                    String nowTime = sdf1.format(new Date());
                    String nowDate = sdf2.format(new Date());
                    Platform.runLater(() -> {
                        labelTime.setText(nowTime);
                        labelDate.setText(nowDate);
                    });
                    
                    try {Thread.sleep(100);} catch (InterruptedException ex) {}
                }
            }
        };
        timeThread.setDaemon(true);
        timeThread.start();
        
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("buttonGroup.fxml"));
            stackPane.getChildren().add(parent);
            Button button = (Button) parent.lookup("#dragButton");
            parent.setTranslateY(265);
            
            button.setOnMouseClicked(e -> {
                if (button.getUserData().equals("false")) {
                    KeyValue keyValue = new KeyValue(parent.translateYProperty(), 160);
                    KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.8), keyValue);
                    Timeline timeline = new Timeline();
                    timeline.getKeyFrames().add(keyFrame);
                    timeline.play();
                    button.setUserData("true");
                    return;
                } else if(button.getUserData().equals("true")) {
                    KeyValue keyValue = new KeyValue(parent.translateYProperty(), 265);
                    KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.8), keyValue);
                    Timeline timeline = new Timeline();
                    timeline.getKeyFrames().add(keyFrame);
                    timeline.play();
                    button.setUserData("false");
                }
                
                
                
            });
            
        } catch (IOException ex) {}
    }    

    
}
