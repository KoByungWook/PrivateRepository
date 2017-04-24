package ch17.exam21;

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
    private ListView<Food> listView;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listView.setCellFactory(new Callback<ListView<Food>, ListCell<Food>>() {
            @Override
            public ListCell<Food> call(ListView<Food> param) {
                ListCell<Food> listCell = new ListCell<Food>() {
                    @Override
                    protected void updateItem(Food item, boolean empty) {
                        super.updateItem(item, empty);
                        if(empty) return;
                        
                        try {
                            HBox hbox = (HBox)FXMLLoader.load(getClass().getResource("item.fxml"));
                            ImageView foodImage = (ImageView)hbox.lookup("#image");
                            Label foodName = (Label)hbox.lookup("#name");
                            ImageView foodScore = (ImageView)hbox.lookup("#score");
                            Label foodDescription = (Label)hbox.lookup("#description");
                            
                            foodImage.setImage(new Image(getClass().getResource("images/" + item.getImage()).toString()));
                            foodName.setText(item.getName());
                            foodScore.setImage(new Image(getClass().getResource("images/star" + item.getScore() +".png").toString()));
                            foodDescription.setText(item.getDescription());
                            
                            setGraphic(hbox);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        
                    }
                
                };
                return listCell;
            }

        });
        
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Food>(){
            @Override
            public void changed(ObservableValue<? extends Food> observable, Food oldValue, Food newValue) {
                System.out.println(newValue.getName() + " " + newValue.getScore() + "점");
            }
        });
        
        //클릭 이벤트 처리
//        listView.setOnMouseClicked(e -> {
//            Food food = listView.getSelectionModel().getSelectedItem();
//             System.out.println(food.getName() + " " + food.getScore() + "점");
//        });
        
        ObservableList<Food> value = FXCollections.observableArrayList();
        value.add(new Food("food01.png", "삼겹살", 10, "고기는 항상 옳다"));
        value.add(new Food("food02.png", "양념장어", 9, "힘"));
        value.add(new Food("food03.png", "장어", 8, "힘2"));
        value.add(new Food("food04.png", "육회비빔밥", 10, "육회는 사랑입니다"));
        value.add(new Food("food05.png", "새우볶음밥", 7, "짜장소스가 있었으면 좋겠다"));
        value.add(new Food("food06.jpg", "떡볶이", 8, "튀김을 달라"));
        listView.setItems(value);
        
        int max = 0;
        for(int i=0; i<value.size(); i++) {
            if(value.get(i).getScore() >= max) max = value.get(i).getScore();
        }
        System.out.println(max);
        
        for(int i=0; i<value.size(); i++) {
            if(value.get(i).getScore() == max)
                value.get(i).setName(value.get(i).getName() + " - 최고의 음식!");
        }
        
    }    
    
}
