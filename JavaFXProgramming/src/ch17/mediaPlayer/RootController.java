package ch17.mediaPlayer;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
	private Label labelTime;
	@FXML
	private Slider sliderVol;
	@FXML
	private Button btnOpen;
	@FXML
	private TableView<Video> tableView;
	@FXML
	private Button btnDelete;
	@FXML
	private Button btnFast;
	@FXML
	private Button btnSlow;
	@FXML
	private StackPane stackPane;
	@FXML
	private BorderPane borderPane;
	@FXML
	private VBox vbox;
	@FXML
	private HBox hbox;
	@FXML
	private VBox vbox2;

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		//TableColumn 및 list 선언
		TableColumn tc0 = tableView.getColumns().get(0);
		ObservableList<Video> list = FXCollections.observableArrayList();

		//open 버튼 눌렀을 때, 파일 받아와 데이터 얻고 Video 객체 생성해 tableView에 세팅
		btnOpen.setOnAction(e -> {
			FileChooser fileChooser = new FileChooser();
			File file = fileChooser.showOpenDialog(AppMain.primaryStage);
			URI uriPath = file.toURI();

			String fileName = file.getName();
			tc0.setCellValueFactory(new PropertyValueFactory<Video, String>("fileName"));

			list.add(new Video(fileName, uriPath));
			tableView.setItems(list);
		});

		//tableView에 속성 감시
		tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Video>() {

			@Override
			public void changed(ObservableValue<? extends Video> observable, Video oldValue, Video newValue) {
				//delete 버튼 눌렀을 때, tableView에서 해당 목록 제거
				btnDelete.setOnAction(e -> {
					list.remove(newValue);
					System.out.println(Thread.currentThread().toString());
				});

				//oldValue가 있었는 지 확인하고, UI 초기화
				if (oldValue != null) {
					mediaPlayer.stop();
					mediaPlayer.dispose();
					sliderTime.setValue(0);
				}

				//medieView 및 mediaPlayer 세팅
				media = new Media(newValue.getUriPath().toString());
				mediaPlayer = new MediaPlayer(media);
				mediaView.setMediaPlayer(mediaPlayer);

				borderPane.heightProperty().addListener(new ChangeListener<Number>() {
					@Override
					public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
						vbox.setPrefHeight(newValue.doubleValue() - 42);
					}
				});

				vbox.heightProperty().addListener(new ChangeListener<Number>() {
					@Override
					public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
						stackPane.setPrefHeight(newValue.doubleValue() - 30);
					}
				});

				stackPane.heightProperty().addListener(new ChangeListener<Number>() {
					@Override
					public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
						mediaView.setFitHeight(stackPane.getHeight());
					}
				});

				borderPane.widthProperty().addListener(new ChangeListener<Number>() {
					@Override
					public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
						vbox.setPrefWidth(newValue.doubleValue() - 115);
						hbox.setPrefWidth(newValue.doubleValue());
					}
				});

				vbox.widthProperty().addListener(new ChangeListener<Number>() {
					@Override
					public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
						stackPane.setPrefWidth(newValue.doubleValue());
						vbox2.setPrefWidth(newValue.doubleValue());
						sliderTime.setPrefWidth(newValue.doubleValue());
					}
				});

				stackPane.widthProperty().addListener(new ChangeListener<Number>() {
					@Override
					public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
						mediaView.setFitWidth(stackPane.getWidth());
					}
				});

//		stackPane.widthProperty().addListener(new ChangeListener<Number> () {
//		    @Override
//		    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//			mediaView.setFitHeight(media.getWidth());
//			mediaView.setFitWidth(newValue.doubleValue());
//		    }
//		});
//		mediaView.fitHeightProperty().bind(Bindings.selectDouble(mediaView.parentProperty(), "height"));
//		mediaView.fitWidthProperty().bind(Bindings.selectDouble(mediaView.parentProperty(), "width"));
//		mediaView.setPreserveRatio(false);
				//mediaPlayer status 세팅
				mediaPlayer.setOnReady(() -> {
					btnPlay.setDisable(false);
					btnPause.setDisable(true);
					btnStop.setDisable(true);
					btnFast.setDisable(true);
					btnSlow.setDisable(true);
					labelTime.setText(0 + "/" + (int) mediaPlayer.getTotalDuration().toSeconds() + "sec");
				});

				mediaPlayer.setOnPlaying(() -> {
					btnPlay.setDisable(true);
					btnPause.setDisable(false);
					btnStop.setDisable(false);
					btnFast.setDisable(false);
					btnSlow.setDisable(false);
				});

				mediaPlayer.setOnPaused(() -> {
					btnPlay.setDisable(false);
					btnPause.setDisable(true);
					btnStop.setDisable(false);
					btnFast.setDisable(false);
					btnSlow.setDisable(false);
				});

				mediaPlayer.setOnEndOfMedia(() -> {
					endOfMedia = true;
					btnPlay.setDisable(false);
					btnPause.setDisable(true);
					btnStop.setDisable(true);
					btnFast.setDisable(true);
					btnSlow.setDisable(true);
				});

				//배속 및 감속 설정
				btnFast.setOnMouseClicked(e -> {

					if (mediaPlayer.getRate() < 7.8) {
						mediaPlayer.setRate(mediaPlayer.getRate() + 0.2);
					} else {
						return;
					}
				});

				btnSlow.setOnMouseClicked(e -> {
					if (mediaPlayer.getRate() > 0.2) {
						mediaPlayer.setRate(mediaPlayer.getRate() - 0.2);
					} else {
						return;
					}
				});

				//재생, 일시정지, 중지 설정
				btnPlay.setOnAction(event -> {

					if (endOfMedia) {
						mediaPlayer.stop();
						mediaPlayer.seek(mediaPlayer.getStartTime());
					}
					mediaPlayer.play();
					endOfMedia = false;
				});
				btnPause.setOnAction(event -> mediaPlayer.pause());
				btnStop.setOnAction(event -> mediaPlayer.stop());

				//볼륨 슬라이더 속성감시 설정
				sliderVol.valueProperty().addListener(new ChangeListener<Number>() {

					@Override
					public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
						mediaPlayer.setVolume(sliderVol.getValue() / 100.0);
					}
				});
				sliderVol.setValue(50);

				//재생시간 슬라이더 속성감시 설정
				sliderTime.valueProperty().addListener(new ChangeListener<Number>() {
					@Override
					public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
						if (Math.abs(newValue.doubleValue() - oldValue.doubleValue()) > 0.5) {
							mediaPlayer.seek(Duration.seconds(mediaPlayer.getTotalDuration().toSeconds() * sliderTime.getValue() / 100.0));
						}
					}
				});

				//mediaPlayer 속성감시 설정
				mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
					@Override
					public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
						double progress = mediaPlayer.getCurrentTime().toSeconds() / mediaPlayer.getTotalDuration().toSeconds();
						sliderTime.setValue(mediaPlayer.getCurrentTime().toSeconds() / mediaPlayer.getTotalDuration().toSeconds() * 100);

						labelTime.setText((int) mediaPlayer.getCurrentTime().toSeconds() / 60 + ":" + (int) mediaPlayer.getCurrentTime().toSeconds() % 60
								+ "/" + (int) mediaPlayer.getTotalDuration().toSeconds() / 60 + ":" + (int) mediaPlayer.getTotalDuration().toSeconds() % 60);
						//labelTime.setText((int)mediaPlayer.getCurrentTime().toSeconds() + "/" + (int)mediaPlayer.getTotalDuration().toSeconds() +"sec");
					}
				});
			}
		});
	}
}
