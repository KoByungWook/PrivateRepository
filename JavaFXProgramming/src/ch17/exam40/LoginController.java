
package ch17.exam40;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class LoginController implements Initializable {

    @FXML
    private BorderPane login;
    @FXML
    private Button btnMain;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
	btnMain.setOnAction(e -> handleBtnMain());
    }    

    private void handleBtnMain() {
	Parent parent;
	try {
	    parent = FXMLLoader.load(getClass().getResource("root.fxml"));
	    Scene scene = new Scene(parent);
	
	    Stage primaryStage = (Stage) btnMain.getScene().getWindow();
	    primaryStage.setScene(scene);
	    primaryStage.show();
	    
	} catch (IOException ex) {
	    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	
    }
    
}
