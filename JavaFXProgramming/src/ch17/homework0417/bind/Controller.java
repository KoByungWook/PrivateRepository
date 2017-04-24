package ch17.homework0417.bind;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class Controller implements Initializable {
    @FXML private TextArea txt1;
    @FXML private TextArea txt2;
    @FXML private TextArea txt3;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
         txt1.textProperty().bind(txt2.textProperty());
    }

}
