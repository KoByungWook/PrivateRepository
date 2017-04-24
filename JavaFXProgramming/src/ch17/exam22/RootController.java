package ch17.exam22;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RootController implements Initializable {
    @FXML 
    private TableView<Phone> tableView;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TableColumn tc0 = tableView.getColumns().get(0);
        TableColumn tc1 = tableView.getColumns().get(1);
        TableColumn tc2 = tableView.getColumns().get(2);
        
        tc0.setCellValueFactory(new PropertyValueFactory<Phone, String>("name"));  //Phone 객체의 String 타입의 name 필드의 값을 만들어서 셀에 넣어주겠다
        tc1.setCellValueFactory(new PropertyValueFactory<Phone, String>("image"));
        tc2.setCellValueFactory(new PropertyValueFactory<Phone, String>("content"));
        
        ObservableList<Phone> list = FXCollections.observableArrayList();
        list.add(new Phone("phone01.png", "galaxy s1", "첫 번째 모델"));
        list.add(new Phone("phone02.png", "galaxy s2", "두 번째 모델"));
        list.add(new Phone("phone03.png", "galaxy s3", "세 번째 모델"));
        
        tableView.setItems(list);
        
    }    
    
}
