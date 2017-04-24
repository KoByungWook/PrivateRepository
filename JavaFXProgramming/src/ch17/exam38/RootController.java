package ch17.exam38;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class RootController implements Initializable {

    @FXML
    private ProgressBar progressBar;
    @FXML
    private Label label;
    @FXML
    private Label lblWorkDone;
    @FXML
    private Button btnStart;
    @FXML
    private Button btnStop;
    
    private Task<Integer> task;
    @FXML
    private Label lblResult;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
	btnStart.setOnAction(e -> handleBtnStart(e));
	btnStop.setOnAction(e -> handleBtnStop(e));
    }    

    private void handleBtnStart(ActionEvent e) {
	task = new Task<Integer>(){
	    @Override
	    protected Integer call() throws Exception {		// UI변경 코드를 작성할 수 없다
		int result = 0;
		for(int i=0; i<=100; i++) {
		    result += i;
		    //how 1
//		    updateProgress(i, 100); //Task 의 메소드
//		    updateMessage(String.valueOf(i));
		    
		    //how 2
		    double value = i;
		    Platform.runLater(() -> {
	
			progressBar.setProgress(value/100.0);
			lblWorkDone.setText(String.valueOf(value));
		    });
		    if(isCancelled()) { break;}
		    try { Thread.sleep(100); } catch(Exception e) {}
		}
		return result;
	    }

	    @Override
	    protected void succeeded() {
		int result = getValue();
		lblResult.setText(String.valueOf(result));
	    }

	    @Override
	    protected void cancelled() {
		lblResult.setText("작업 취소됨");
	    }

	    @Override
	    protected void failed() {
		
	    }
	    
	    
	    
	};
	
//	progressBar.progressProperty().bind(task.progressProperty());
//	lblWorkDone.textProperty().bind(task.messageProperty());
	
	Thread thread = new Thread(task);
	thread.setDaemon(true);
	thread.start();
    }

    private void handleBtnStop(ActionEvent e) {
	task.cancel();
    }

}
