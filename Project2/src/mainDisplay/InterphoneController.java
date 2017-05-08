package mainDisplay;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;


public class InterphoneController implements Initializable {
    private Media media;
    private MediaPlayer mediaPlayer;
    
    @FXML
    private MediaView mediaView;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnOpenDoor;


    @Override
    public void initialize(URL url, ResourceBundle rb) {   
        btnSave.setOnAction(e -> handleBtnSave(e));
        btnOpenDoor.setOnAction(e -> handleBtnOpenDoor(e));

    }    

    private void handleBtnSave(ActionEvent e) {
        media = new Media(getClass().getResource("sounds/interphone.mp3").toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        
        
        String mediaUriTemp = mediaView.getMediaPlayer().getMedia().getSource();
        String mediaUri = mediaUriTemp.substring(6);
        System.out.println(mediaUri);
        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat("MM월dd일E요일HH시mm분SS초");
            String name = sdf1.format(new Date()) + ".m4v";
            FileInputStream fis = new FileInputStream(mediaUri);
            FileOutputStream fos = new FileOutputStream("C:\\Temp\\" + name);
            byte[] byteArr = new byte[100];
            int readBytes = -1;
            while(true) {
                readBytes = fis.read(byteArr);
                if(readBytes == -1) break;
                fos.write(byteArr, 0 , readBytes);
            }
            
            fos.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void handleBtnOpenDoor(ActionEvent e) {
        media = new Media(getClass().getResource("sounds/openDoor.mp3").toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
}
