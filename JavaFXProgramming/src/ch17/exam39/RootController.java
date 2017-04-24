package ch17.exam39;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.concurrent.Service;
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
    private Label lblWorkDone;
    @FXML
    private Label lblResult;
    @FXML
    private Button btnStart;
    @FXML
    private Button btnStop;
    
    private TimeService timeService;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
	btnStart.setOnAction(e -> handleBtnStart(e));
	btnStop.setOnAction(e -> handleBtnStop(e));
    }    

    private void handleBtnStart(ActionEvent e) {
	if(timeService == null) {
	    timeService = new TimeService();
	    timeService.start();
	    btnStart.setText("재시작");
	} else {
	    timeService.restart();
	}    
    }

    private void handleBtnStop(ActionEvent e) {
	lblResult.setText("작업 멈춤");
	btnStart.setText("시작");
    }
    
    class TimeService extends Service<Integer> {
	@Override
	protected Task<Integer> createTask() {
	    Task<Integer> task = new Task<Integer>() {
		@Override
		protected Integer call() throws Exception {
		    int sum = 0;
		    for(int i=1; i<=100; i++) {
			if(isCancelled()) break;
			sum += i;
			try { Thread.sleep(100); } catch(Exception e) {}
			
			double value = i;
			Platform.runLater(() -> {
			    progressBar.setProgress(value/100);
			    lblWorkDone.setText(String.valueOf(value));
			});
		    }
		    return sum;
		}
	    };
	    return task;
	}

	@Override
	protected void succeeded() {
	    lblResult.setText(getValue().toString());
	}
	
	
	
    }
    
}
