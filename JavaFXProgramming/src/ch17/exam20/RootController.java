package ch17.exam20;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

public class RootController implements Initializable {

    @FXML
    private ListView<Phone> listView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(listView);
        listView.setCellFactory(new Callback<ListView<Phone>, ListCell<Phone>>() {      //listView 안에 셀을 만드는 역할
            @Override
            public ListCell<Phone> call(ListView<Phone> param) {                //phone 객체가 접근하면 call이 자동적으로 실행, listCell 생성
                ListCell<Phone> listCell = new ListCell<Phone>(){
                    @Override
                    protected void updateItem(Phone item, boolean empty) {      //listCell 안에 들어가는 것을 정의하는 메소드
                        super.updateItem(item, empty);      //선택된 항목을 파랗게 바꿔주고, 이벤트가 발생하게 해주는 코드가 부모 메소드에 존재
                        if(empty) return;                   //데이터가 들어가기 전 처음 실행할 때, nullpointerException 방지
                        try {
                            //cell에 들어갈 컨테이너 생성
                            HBox hbox = (HBox)FXMLLoader.load(getClass().getResource("item.fxml"));
                            ImageView phoneImage = (ImageView)hbox.lookup("#image");
                            Label phoneName = (Label)hbox.lookup("#name");
                            Label phoneContent = (Label)hbox.lookup("#content");
                            
                            phoneImage.setImage(new Image(getClass().getResource("images/"+item.getImage()).toString()));
                            phoneName.setText(item.getName());
                            phoneContent.setText(item.getContent());
                            
                            setGraphic(hbox);       //cell의 내용으로 설정
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    
                };
                return listCell;
            }
            
        });
        //선택 속성 감시
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Phone>() {
            @Override
            public void changed(ObservableValue<? extends Phone> observable, Phone oldValue, Phone newValue) {
                System.out.println(newValue.getName() + " " + newValue.getImage());
            }
            
        });
        
        //데이터 셋팅
        ObservableList<Phone> value = FXCollections.observableArrayList();
        value.add(new Phone("phone01.png", "galaxy s1", "삼성 스마트폰의 최초 모델"));
        value.add(new Phone("phone02.png", "galaxy s2", "삼성 스마트폰의 두번째 모델"));
        value.add(new Phone("phone03.png", "galaxy s3", "삼성 스마트폰의 세번째 모델"));
        listView.setItems(value);
    }    
    
}
