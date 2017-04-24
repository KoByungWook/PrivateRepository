package assignment.homeController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class RootController implements Initializable {

	@FXML
	private Button btnSub1;
	@FXML
	private Button btnMain;
	@FXML
	private BorderPane borderPane;
	@FXML
	private StackPane stackPane;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		btnMain.setOnAction(e -> {
			
			try {
				Parent parent = FXMLLoader.load(getClass().getResource("root_1.fxml"));
				stackPane.getChildren().add(parent);
				
				Parent parent2 = FXMLLoader.load(getClass().getResource("root_2.fxml"));
				stackPane.getChildren().add(parent2);
				
				Parent parent3 = FXMLLoader.load(getClass().getResource("root_3.fxml"));
				stackPane.getChildren().add(parent3);
				
				Parent parent4 = FXMLLoader.load(getClass().getResource("root_4.fxml"));
				stackPane.getChildren().add(parent4);
				
				Timeline timeline = new Timeline();				
				KeyValue keyValue = new KeyValue(parent.translateYProperty(), -150);
				KeyFrame keyFrame = new KeyFrame(Duration.seconds(2), keyValue);
				timeline.getKeyFrames().add(keyFrame);
				timeline.play();
				
				Thread.sleep(300);
				
				Timeline timeline2 = new Timeline();
				KeyValue keyValue2 = new KeyValue(parent2.translateXProperty(), 150);
				KeyFrame keyFrame2 = new KeyFrame(Duration.seconds(2), keyValue2);
				timeline2.getKeyFrames().add(keyFrame2);
				timeline2.play();
				
				Thread.sleep(300);
				
				Timeline timeline3 = new Timeline();
				KeyValue keyValue3 = new KeyValue(parent3.translateYProperty(), 150);
				KeyFrame keyFrame3 = new KeyFrame(Duration.seconds(2), keyValue3);
				timeline3.getKeyFrames().add(keyFrame3);
				timeline3.play();
				
				Thread.sleep(300);
				
				Timeline timeline4 = new Timeline();
				KeyValue keyValue4 = new KeyValue(parent4.translateXProperty(), -150);
				KeyFrame keyFrame4 = new KeyFrame(Duration.seconds(2), keyValue4);
				timeline4.getKeyFrames().add(keyFrame4);
				timeline4.play();
				
				} catch (Exception ex) {
				
			}
		});
	}	
	
}
