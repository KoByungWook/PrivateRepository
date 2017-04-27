package mainDisplay;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Popup;
import javafx.stage.Stage;


public class NoticeController implements Initializable {

    @FXML
    private TableView<Notice> tableView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TableColumn tc0 = tableView.getColumns().get(0);
        TableColumn tc1 = tableView.getColumns().get(1);
        
        tc0.setCellValueFactory(new PropertyValueFactory<Notice, String>("date"));
        tc1.setCellValueFactory(new PropertyValueFactory<Notice, String>("title"));
        
        ObservableList<Notice> list = FXCollections.observableArrayList();
        
        list.add(new Notice("건물 계단 청소 공지", new Date().toString(), "내일 10시부터 2시까지 건물 계단 청소가 있을 예정입니다."));
        list.add(new Notice("단수 공지", new Date().toString(), "모레 11시부터 1시까지 단수 될 예정이오니 참고해주시기 바랍니다."));
        
        tableView.setItems(list);
        
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Notice> () {
            @Override
            public void changed(ObservableValue<? extends Notice> observable, Notice oldValue, Notice newValue) {
                Popup popup = new Popup();
                
                try {
                    Parent parent = FXMLLoader.load(getClass().getResource("noticePopup.fxml"));
                    Label labelTitle = (Label) parent.lookup("#labelTitle");
                    Label labelDate = (Label) parent.lookup("#labelDate");
                    TextArea areaNotice = (TextArea) parent.lookup("#areaNotice");
                    
                    labelTitle.setText("제목: " +newValue.getTitle());
                    labelDate.setText("날짜: " +newValue.getDate());
                    areaNotice.setText(newValue.getContent());
                    
                    popup.getContent().add(parent);
                    popup.setAutoHide(true);
                    popup.show(tableView.getScene().getWindow());
                } catch (IOException ex) {}
            }

        });    
    }
}
