package ch17.homework0417.property;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class Controller implements Initializable {
    @FXML private Slider slider;
    @FXML private Label label;
    @FXML private TextField txt1;
    @FXML private TextField txt2;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
      slider.valueProperty().addListener(new ChangeListener<Number> () {
          @Override
          public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
              label.setFont(new Font(newValue.doubleValue()));
          }
      });
      
      txt1.textProperty().addListener((observable, oldValue, newValue) -> {
          txt2.setText(newValue.toUpperCase());
      });
    }

}
