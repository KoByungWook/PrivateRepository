
package ch17.exam28;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RootController implements Initializable {
    private Stage primaryStage;

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void handleOpenFileChooser(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        //how 3
        //Button button = (Button) event.getSource();
        //Scene scene = button.getScene();
        //Stage primaryStage = (Stage)scene.getWindow();
        
        File file = fileChooser.showOpenDialog(((Button)event.getSource()).getScene().getWindow());       //(Button)event.getSource().getScene().getWindow()  -> 위의 내용 정리
        System.out.println(file.getPath());
    }

    @FXML
    private void handleSaveFileChooser(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog(primaryStage);
        System.out.println(file.getPath());
    }

    @FXML
    private void handleDirectoryChooser(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File file = directoryChooser.showDialog(AppMain.primaryStage);
        System.out.println(file.getPath());
    }

    @FXML
    private void handlePopup(ActionEvent event) throws Exception {
       //showNotification("알림", "메시지가 도착했습니다.");
       showNotification("경고", "메시지가 도착했습니다.");
    }
    
    private void showNotification(String type, String message) throws Exception {
        Popup popup = new Popup();
        HBox hbox = (HBox)FXMLLoader.load(getClass().getResource("popup.fxml"));
        ImageView imgMessage = (ImageView)hbox.lookup("#imgMessage");
        Label lblMessage = (Label)hbox.lookup("#lblMessage");
        
        if(type.equals("알림")){
            imgMessage.setImage(new Image(getClass().getResource("images/dialog-info.png").toString()));
        } else if(type.equals("경고")) {
            imgMessage.setImage(new Image(getClass().getResource("images/dialog-warning.png").toString()));
        }
        
        lblMessage.setText(message);
                
        popup.getContent().add(hbox);
        popup.setAutoHide(true);
        popup.show(AppMain.primaryStage);
    }

    @FXML
    private void handleCustom(ActionEvent event) throws IOException {
        showCustomDialog("error", "확인하셨습니까?");
    }
    
    private void showCustomDialog(String type, String message) throws IOException {
        Stage dialog = new Stage();
        Parent parent = FXMLLoader.load(getClass().getResource("custom-dialog.fxml"));
        
        ImageView icon = (ImageView)parent.lookup("#icon");
        Label lblmessage = (Label)parent.lookup("#message");
        Button btnOk = (Button)parent.lookup("#btnOk");
        
        if(type.equals("error")) {
            icon.setImage(new Image(getClass().getResource("images/dialog-" + type + ".png").toString()));
        } else if(type.equals("help")) {
            icon.setImage(new Image(getClass().getResource("images/dialog-" + type + ".png").toString()));
        } else if(type.equals("info")) {
            icon.setImage(new Image(getClass().getResource("images/dialog-" + type + ".png").toString()));
        } else if(type.equals("warning")) {
            icon.setImage(new Image(getClass().getResource("images/dialog-" + type + ".png").toString()));
        }
        
        lblmessage.setText(message);
        
        btnOk.setOnAction(e -> {
            dialog.hide();
        });
        
        Scene scene = new Scene(parent);
        dialog.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        dialog.initOwner(AppMain.primaryStage);
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.show();
    }
    
}
