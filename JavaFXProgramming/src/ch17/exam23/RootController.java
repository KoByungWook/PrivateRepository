package ch17.exam23;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RootController implements Initializable {

    @FXML
    private ListView<String> listView;
    @FXML
    private TableView<Phone> tableView;
    @FXML
    private ImageView imageView;
    @FXML
    private Button btnOk;
    @FXML
    private Button btnCancle;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> data1 = FXCollections.observableArrayList();
        data1.add("Galaxy S1");
        data1.add("Galaxy S2");
        data1.add("Galaxy S3");
        data1.add("Galaxy S4");
        data1.add("Galaxy S5");
        data1.add("Galaxy S6");
        
        listView.setItems(data1);
        
        listView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                tableView.getSelectionModel().select(newValue.intValue());
                tableView.scrollTo(newValue.intValue());
            }
        
        });
        
        //-------------------------------------------------------------------------------------------------------
        
        TableColumn tc0 = tableView.getColumns().get(0);
        TableColumn tc1 = tableView.getColumns().get(1);
        
        tc0.setCellValueFactory(new PropertyValueFactory<Phone, String>("name"));  //Phone 객체의 String 타입의 name 필드의 값을 만들어서 셀에 넣어주겠다
        tc1.setCellValueFactory(new PropertyValueFactory<Phone, String>("image"));

        ObservableList<Phone> list = FXCollections.observableArrayList();
        list.add(new Phone("phone01.png", "galaxy s1", "첫 번째 모델"));
        list.add(new Phone("phone02.png", "galaxy s2", "두 번째 모델"));
        list.add(new Phone("phone03.png", "galaxy s3", "세 번째 모델"));
        list.add(new Phone("phone04.png", "galaxy s4", "네 번째 모델"));
        list.add(new Phone("phone05.png", "galaxy s5", "다섯 번째 모델"));
        list.add(new Phone("phone06.png", "galaxy s6", "여섯 번째 모델"));

        tableView.setItems(list);
        
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Phone> () {
            @Override
            public void changed(ObservableValue<? extends Phone> observable, Phone oldValue, Phone newValue) {
                imageView.setImage(new Image(getClass().getResource("Images/" + newValue.getImage()).toString()));
            }
        });
        
        
        
    }    
    
}
