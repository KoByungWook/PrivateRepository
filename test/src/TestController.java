import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class TestController implements Initializable {

    @FXML
    private Rectangle rectangle;
    @FXML
    private Circle circle;
    @FXML
    private CheckBox check;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rectangle.setOnMouseClicked(e -> handleCircle(e));
        circle.setOnMouseClicked(e -> handleCircle(e));
        
        if(circle.getUserData().equals("on")) {
            circle.setCenterX(90);
            rectangle.setFill(Color.SPRINGGREEN);
        };
        
        check.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }
            
        });
    }    

    private void handleCircle(MouseEvent e) {
        if(circle.getUserData().equals("off")) {
            moveRight();
        } else if(circle.getUserData().equals("on")) {
            moveLeft();
        }
    }
    private void moveRight() {
        circle.setUserData("on");
        rectangle.setFill(Color.SPRINGGREEN);
        KeyValue keyValue = new KeyValue(circle.centerXProperty(), 90);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5), keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

    private void moveLeft() {
        circle.setUserData("off");
        rectangle.setFill(Color.WHITE);
        KeyValue keyValue = new KeyValue(circle.centerXProperty(), 30);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5), keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }
}
