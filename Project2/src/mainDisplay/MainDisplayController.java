package mainDisplay;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class MainDisplayController implements Initializable {

    @FXML
    private StackPane stackPane;
    @FXML
    private Label labelDate;
    @FXML
    private Label labelTime;
    @FXML
    private Button btnElevator;
    @FXML
    private Button btnOpenDoor;
    @FXML
    private Button btnSetting;
    @FXML
    private Button btnCall;
    @FXML
    private Button btnControl;
    @FXML
    private Button btnLock;
    @FXML
    private Button btnMenu;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        boolean stop = false;
        Thread timeThread = new Thread() {
            @Override
            public void run() {
                SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy년 MM월 dd일(E)");
                while (!stop) {
                    String nowTime = sdf1.format(new Date());
                    String nowDate = sdf2.format(new Date());
                    Platform.runLater(() -> {
                        labelTime.setText(nowTime);
                        labelDate.setText(nowDate);
                    });

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        };
        timeThread.setDaemon(true);
        timeThread.start();
        
        btnMenu.setOnAction(e -> handleBtnMenu(e));
//        try {
//            Parent parent = FXMLLoader.load(getClass().getResource("buttonGroup.fxml"));
//            stackPane.getChildren().add(parent);
//            Button button = (Button) parent.lookup("#dragButton");
//            parent.setTranslateY(265);
//
//            button.setOnMouseClicked(e -> {
//                if (button.getUserData().equals("false")) {
//                    KeyValue keyValue = new KeyValue(parent.translateYProperty(), 160);
//                    KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.8), keyValue);
//                    Timeline timeline = new Timeline();
//                    timeline.getKeyFrames().add(keyFrame);
//                    timeline.play();
//                    button.setUserData("true");
//                    return;
//                } else if (button.getUserData().equals("true")) {
//                    KeyValue keyValue = new KeyValue(parent.translateYProperty(), 265);
//                    KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.8), keyValue);
//                    Timeline timeline = new Timeline();
//                    timeline.getKeyFrames().add(keyFrame);
//                    timeline.play();
//                    button.setUserData("false");
//                }
//
//            });
//
//        } catch (IOException ex) {
//        }
    }

    private void handleBtnMenu(ActionEvent e) {
        if(btnMenu.getUserData().equals("close")) {
            btnMenu.setUserData("open");
            //Call 버튼 이동
            KeyValue keyValue1 = new KeyValue(btnCall.translateXProperty(), -225);
            KeyValue keyValue2 = new KeyValue(btnCall.translateYProperty(), 75);
            KeyFrame keyFrame1 = new KeyFrame(Duration.seconds(0.7), keyValue1);
            KeyFrame keyFrame2 = new KeyFrame(Duration.seconds(0.7), keyValue2);
            Timeline timeline1 = new Timeline();
            timeline1.getKeyFrames().add(keyFrame1);
            timeline1.getKeyFrames().add(keyFrame2);
            //Control 버튼 이동
            KeyValue keyValue3 = new KeyValue(btnControl.translateXProperty(), -75);
            KeyValue keyValue4 = new KeyValue(btnControl.translateYProperty(), 120);
            KeyFrame keyFrame3 = new KeyFrame(Duration.seconds(0.5), keyValue3);
            KeyFrame keyFrame4 = new KeyFrame(Duration.seconds(0.5), keyValue4);
            Timeline timeline2 = new Timeline();
            timeline2.getKeyFrames().add(keyFrame3);
            timeline2.getKeyFrames().add(keyFrame4);
            //Lcck 버튼 이동
            KeyValue keyValue5 = new KeyValue(btnLock.translateXProperty(), 75);
            KeyValue keyValue6 = new KeyValue(btnLock.translateYProperty(), 120);
            KeyFrame keyFrame5 = new KeyFrame(Duration.seconds(0.5), keyValue5);
            KeyFrame keyFrame6 = new KeyFrame(Duration.seconds(0.5), keyValue6);
            Timeline timeline3 = new Timeline();
            timeline3.getKeyFrames().add(keyFrame5);
            timeline3.getKeyFrames().add(keyFrame6);
            //Setting 버튼 이동
            KeyValue keyValue7 = new KeyValue(btnSetting.translateXProperty(), 225);
            KeyValue keyValue8 = new KeyValue(btnSetting.translateYProperty(),75);
            KeyFrame keyFrame7 = new KeyFrame(Duration.seconds(0.7), keyValue7);
            KeyFrame keyFrame8 = new KeyFrame(Duration.seconds(0.7), keyValue8);
            Timeline timeline4 = new Timeline();
            timeline4.getKeyFrames().add(keyFrame7);
            timeline4.getKeyFrames().add(keyFrame8);
            //timeline 실행
            timeline1.play(); timeline2.play(); timeline3.play(); timeline4.play();
            return;
        } else if(btnMenu.getUserData().equals("open")) {
            btnMenu.setUserData("close");
            //call 버튼 이동
            KeyValue keyValue1 = new KeyValue(btnCall.translateXProperty(), 0);
            KeyValue keyValue2 = new KeyValue(btnCall.translateYProperty(), 0);
            KeyFrame keyFrame1 = new KeyFrame(Duration.seconds(0.4), keyValue1);
            KeyFrame keyFrame2 = new KeyFrame(Duration.seconds(0.4), keyValue2);
            Timeline timeline1 = new Timeline();
            timeline1.getKeyFrames().add(keyFrame1);
            timeline1.getKeyFrames().add(keyFrame2);
            //Control 버튼 이동
            KeyValue keyValue3 = new KeyValue(btnControl.translateXProperty(), 0);
            KeyValue keyValue4 = new KeyValue(btnControl.translateYProperty(), 0);
            KeyFrame keyFrame3 = new KeyFrame(Duration.seconds(0.4), keyValue3);
            KeyFrame keyFrame4 = new KeyFrame(Duration.seconds(0.4), keyValue4);
            Timeline timeline2 = new Timeline();
            timeline2.getKeyFrames().add(keyFrame3);
            timeline2.getKeyFrames().add(keyFrame4);
            //Lcck 버튼 이동
            KeyValue keyValue5 = new KeyValue(btnLock.translateXProperty(), 0);
            KeyValue keyValue6 = new KeyValue(btnLock.translateYProperty(), 0);
            KeyFrame keyFrame5 = new KeyFrame(Duration.seconds(0.4), keyValue5);
            KeyFrame keyFrame6 = new KeyFrame(Duration.seconds(0.4), keyValue6);
            Timeline timeline3 = new Timeline();
            timeline3.getKeyFrames().add(keyFrame5);
            timeline3.getKeyFrames().add(keyFrame6);
            //Setting 버튼 이동
            KeyValue keyValue7 = new KeyValue(btnSetting.translateXProperty(), 0);
            KeyValue keyValue8 = new KeyValue(btnSetting.translateYProperty(), 0);
            KeyFrame keyFrame7 = new KeyFrame(Duration.seconds(0.4), keyValue7);
            KeyFrame keyFrame8 = new KeyFrame(Duration.seconds(0.4), keyValue8);
            Timeline timeline4 = new Timeline();
            timeline4.getKeyFrames().add(keyFrame7);
            timeline4.getKeyFrames().add(keyFrame8);
            //timeline 실행
            timeline1.play(); timeline2.play(); timeline3.play(); timeline4.play();
        }
    }

}
