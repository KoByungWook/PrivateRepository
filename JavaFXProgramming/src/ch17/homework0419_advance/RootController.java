package ch17.homework0419_advance;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RootController implements Initializable {
    private boolean endOfMedia;
    private Stage primaryStage;
    private MediaPlayer mediaPlayer;
    private Media media;
    
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnPause;
    @FXML
    private Button btnStop;
    @FXML
    private MediaView mediaView;
    @FXML
    private Slider sliderTime;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private ProgressIndicator progressIndicator;
    @FXML
    private Label labelTime;
    @FXML
    private Slider sliderVol;
    @FXML
    private Button btnOpen;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        media = new Media(getClass().getResource("medias/video.m4v").toString());
        mediaPlayer = new MediaPlayer(media);

        btnOpen.setOnAction(e -> {
            mediaPlayer.dispose();
            
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(AppMain.primaryStage);
            URI uriPath = file.toURI();
            
            media = new Media(uriPath.toString());
            mediaPlayer = new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaPlayer);
            
            System.out.println(mediaView.getMediaPlayer());
            
            mediaPlayer.setOnReady(() -> {
                btnPlay.setDisable(false);
                btnPause.setDisable(true);
                btnStop.setDisable(true);
                labelTime.setText( 0 + "/" + (int)mediaPlayer.getTotalDuration().toSeconds() +"sec");
            });
        
            mediaPlayer.setOnPlaying(() -> {
                btnPlay.setDisable(true);
                btnPause.setDisable(false);
                btnStop.setDisable(false);
            });
        
            mediaPlayer.setOnPaused(() -> {
                btnPlay.setDisable(false);
                btnPause.setDisable(true);
                btnStop.setDisable(false);
            });
        
            mediaPlayer.setOnStopped(() -> {
                btnPlay.setDisable(false);
                btnPause.setDisable(true);
                btnStop.setDisable(true);
            });
        
            mediaPlayer.setOnEndOfMedia(() -> {
                endOfMedia = true;
                btnPlay.setDisable(false);
                btnPause.setDisable(true);
                btnStop.setDisable(true);
                progressBar.setProgress(1.0);
                progressIndicator.setProgress(1.0);                                 ///1.0으로 맞춰주는 작업 실행해야 정확히 끝 지점 출력
            });
        
            btnPlay.setOnAction( event -> {
                if(endOfMedia) {
                    mediaPlayer.stop();
                    mediaPlayer.seek(mediaPlayer.getStartTime());
                }
                mediaPlayer.play();
                endOfMedia = false;
            } );
            btnPause.setOnAction( event -> mediaPlayer.pause() );
            btnStop.setOnAction( event -> mediaPlayer.stop() );
        
            sliderVol.valueProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    mediaPlayer.setVolume(sliderVol.getValue() / 100.0);
                }
            });
            sliderVol.setValue(50);

            sliderTime.valueProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    if(Math.abs(newValue.doubleValue() - oldValue.doubleValue()) > 1) {
                        mediaPlayer.seek(Duration.seconds(mediaPlayer.getTotalDuration().toSeconds() * sliderTime.getValue() /100.0));
                    } 
                }

            });

            mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
                @Override
                public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                    double progress = mediaPlayer.getCurrentTime().toSeconds() / mediaPlayer.getTotalDuration().toSeconds();
                    progressBar.setProgress(progress);
                    progressIndicator.setProgress(progress);

                    sliderTime.setValue(progress * 100);
                    labelTime.setText((int)mediaPlayer.getCurrentTime().toSeconds() + "/" + (int)mediaPlayer.getTotalDuration().toSeconds() +"sec");


                }

            });
        });    
    }    
    
}
