package mainDisplay;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class MainController implements Initializable {
   
    @FXML
    private ImageView titleIcon;
    @FXML
    private Label titleLabel;
    @FXML
    private Label timeLabel;
    @FXML
    private BorderPane borderPane;
    @FXML
    private Button btnCall;
    @FXML
    private Button btnSetting;
    @FXML
    private Button btnControl;
    @FXML
    private Button btnSecurity;
	@FXML
	private StackPane stackPane;
	@FXML
	private Button btnNotice;
	@FXML
	private AnchorPane anchorPane;
	@FXML
	private Label labelNew;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        titleIcon.setImage(new Image(getClass().getResource("images/penguin.jpg").toString()));
        titleLabel.setText("Home Automation Controller");
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss ");
        boolean stop = false;
        Thread timeThread = new Thread() {
            @Override
            public void run() {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) HH:mm:ss");
                while(!stop) {
                    String nowDate = sdf.format(new Date());
                    Platform.runLater(() -> {
                        timeLabel.setText(nowDate);
                    });
                    
                    try {Thread.sleep(100);} catch (InterruptedException ex) {}
                }
            }
        };
        timeThread.setDaemon(true);
        timeThread.start();
        
        btnCall.setOnAction(e -> handleBtnCall(e));
        btnControl.setOnAction(e -> handleBtnControl(e));
        btnSecurity.setOnAction(e -> handleBtnSecurity(e));
        btnSetting.setOnAction(e -> handleBtnSetting(e));
		btnNotice.setOnAction(e -> handleBtnNotice(e));
    }    

    private void handleBtnCall(ActionEvent e) {
        System.out.println("전화 메뉴로 이동...");
		
		try {
			BorderPane callPane = FXMLLoader.load(getClass().getResource("call.fxml"));
			stackPane.getChildren().add(callPane);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
    }

    private void handleBtnControl(ActionEvent e) {
        System.out.println("제어 메뉴로 이동...");
    }
    
    private void handleBtnSecurity(ActionEvent e) {
         System.out.println("방범 메뉴로 이동...");
    }
    
    private void handleBtnSetting(ActionEvent e) {
        System.out.println("설정 메뉴로 이동...");
    }

	private void handleBtnNotice(ActionEvent e) {
		try {
			BorderPane noticePane = FXMLLoader.load(getClass().getResource("notice.fxml"));
			
			if(labelNew.getText().equals("N")) {
				anchorPane.getChildren().add(noticePane);

				noticePane.setLayoutX(60);
				noticePane.setLayoutY(10);

				labelNew.setText("");
				return;
			
			} else if(labelNew.getText().equals("")) {
				anchorPane.getChildren().remove(2);
				labelNew.setText("N");
			}
		} catch (IOException ex) {}
	}
}



