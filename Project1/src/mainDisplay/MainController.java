package mainDisplay;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainController implements Initializable {
    
    @FXML
    private ImageView titleIcon;
    @FXML
    private Label titleLabel;
    @FXML
    private Label timeLabel;

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
        
    }    
    
}
