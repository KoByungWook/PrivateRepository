
package ch17.homework0418;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

public class RootController implements Initializable {

    @FXML
    private ListView<Baseball> listView;
    @FXML
    private TableView<Player> tableView;
    @FXML
    private Button btnClose;
    @FXML
    private ImageView imageTitle;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
                      
        btnClose.setOnAction(e -> {
            Platform.exit();
        });
        
        listView.setCellFactory(new Callback<ListView<Baseball>, ListCell<Baseball>>() {
            @Override
            public ListCell<Baseball> call(ListView<Baseball> param) {
                ListCell<Baseball> listCell = new ListCell<Baseball>() {
                    @Override
                    protected void updateItem(Baseball item, boolean empty) {
                        super.updateItem(item, empty);
                        if(empty) return;
                        
                        try {
                            HBox hbox = (HBox)FXMLLoader.load(getClass().getResource("item.fxml"));
                            ImageView image = (ImageView)hbox.lookup("#image");
                            Label teamName = (Label)hbox.lookup("#teamName");
                            Label rank = (Label)hbox.lookup("#rank");
                            
                            image.setImage(new Image(getClass().getResource("images/" + item.getTeamName() + ".png").toString()));
                            teamName.setText(item.getTeamName());
                            rank.setText("현재 순위 : " + String.valueOf(item.getRank()));
                            
                            setGraphic(hbox);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    
                };
                
                return listCell;
            }
            
        });
        ObservableList<Baseball> value = FXCollections.observableArrayList();
        value.add(new Baseball("kia", 1));
        value.add(new Baseball("lotte", 2));
        value.add(new Baseball("kt", 3));
        value.add(new Baseball("lg", 4));
        value.add(new Baseball("nc", 5));
        value.add(new Baseball("sk", 6));
        value.add(new Baseball("doosan", 7));
        value.add(new Baseball("nexen", 8));
        value.add(new Baseball("hanhwa", 9));
        value.add(new Baseball("samsung", 10));
        
        listView.setItems(value);
        
        TableColumn tc0 = tableView.getColumns().get(0);
        TableColumn tc1 = tableView.getColumns().get(1);
        
        tc0.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
        tc1.setCellValueFactory(new PropertyValueFactory<Player, String>("avg"));
        
        ObservableList<Player> list = FXCollections.observableArrayList();
       
        listView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if(newValue.intValue() == 0) {
                    list.clear();
                    list.add(new Player("안치홍", "0.367"));
                    list.add(new Player("김선빈", "0.364"));
                    list.add(new Player("나지완", "0.350"));
                    list.add(new Player("이명기", "0.348"));
                    list.add(new Player("최형우", "0.348")); 
                } else if(newValue.intValue() == 1) {
                    list.clear();
                    list.add(new Player("이대호", "0.460"));
                    list.add(new Player("이우민", "0.378"));
                    list.add(new Player("전준우", "0.371"));
                    list.add(new Player("나경민", "0.333"));
                    list.add(new Player("번즈", "0.304")); 
                } else if(newValue.intValue() == 2) {
                    list.clear();
                    list.add(new Player("오정복", "0.538"));
                    list.add(new Player("윤요섭", "0.400"));
                    list.add(new Player("장성우", "0.353"));
                    list.add(new Player("박경수", "0.308"));
                    list.add(new Player("심우준", "0.293")); 
                } else if(newValue.intValue() == 3) {
                    list.clear();
                    list.add(new Player("손주인", "0.385"));
                    list.add(new Player("이천웅", "0.375"));
                    list.add(new Player("최재원", "0.345"));
                    list.add(new Player("이형종", "0.333"));
                    list.add(new Player("임훈", "0.333")); 
                } else if(newValue.intValue() == 4) {
                    list.clear();
                    list.add(new Player("손시헌", "0.389"));
                    list.add(new Player("박민우", "0.370"));
                    list.add(new Player("권희동", "0.326"));
                    list.add(new Player("모창민", "0.324"));
                    list.add(new Player("스크럭스", "0.302")); 
                } else if(newValue.intValue() == 5) {
                    list.clear();
                    list.add(new Player("이홍구", "0.438"));
                    list.add(new Player("한동민", "0.432"));
                    list.add(new Player("김동엽", "0.327"));
                    list.add(new Player("정진기", "0.316"));
                    list.add(new Player("나주환", "0.308")); 
                } else if(newValue.intValue() == 6) {
                    list.clear();
                    list.add(new Player("박세혁", "0.545"));
                    list.add(new Player("류지혁", "0.385"));
                    list.add(new Player("민병헌", "0.339"));
                    list.add(new Player("최주환", "0.333"));
                    list.add(new Player("허경민", "0.333")); 
                } else if(newValue.intValue() == 7) {
                    list.clear();
                    list.add(new Player("김웅빈", "0.400"));
                    list.add(new Player("허정협", "0.387"));
                    list.add(new Player("김태완", "0.385"));
                    list.add(new Player("윤석민", "0.379"));
                    list.add(new Player("채태인", "0.372")); 
                } else if(newValue.intValue() == 8) {
                    list.clear();
                    list.add(new Player("이성열", "0.368"));
                    list.add(new Player("정근우", "0.350"));
                    list.add(new Player("송광민", "0.333"));
                    list.add(new Player("장민석", "0.333"));
                    list.add(new Player("김태균", "0.326")); 
                } else if(newValue.intValue() == 9) {
                    list.clear();
                    list.add(new Player("정병곤", "0.400"));
                    list.add(new Player("조동찬", "0.370"));
                    list.add(new Player("김헌곤", "0.325"));
                    list.add(new Player("강한울", "0.320"));
                    list.add(new Player("박해민", "0.293")); 
                }
                
                tableView.setItems(list);
            }
            
        });
    }    
    
}
