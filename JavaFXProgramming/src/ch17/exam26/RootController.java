package ch17.exam26;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart;

public class RootController implements Initializable {

    @FXML
    private PieChart pieChart;
    @FXML
    private BarChart<String, Integer> barChart;                    //< > 축에 들어가는 데이터 타입
    @FXML
    private AreaChart<String, Integer> areaChart;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Data> data1 = FXCollections.observableArrayList();       //Data -> PieChart.Data (import 안할 때)
        data1.add(new Data("AWT", 10));
        data1.add(new Data("Swing", 30));
        data1.add(new Data("SWT", 25));
        data1.add(new Data("JavaFX", 35));
        pieChart.setData(data1);
        
        XYChart.Series<String, Integer> series1 = new XYChart.Series<>();
        series1.setName("남자");
        ObservableList<XYChart.Data<String, Integer>> data2 = FXCollections.observableArrayList();       //Data -> PieChart.Data (import 안할 때)
        data2.add(new XYChart.Data<String, Integer>("2015", 70));
        data2.add(new XYChart.Data<String, Integer>("2016", 40));
        data2.add(new XYChart.Data<String, Integer>("2017", 50));
        data2.add(new XYChart.Data<String, Integer>("2018", 30));
        
        series1.setData(data2);
        barChart.getData().add(series1);         //데이터는 공유가 불가하다. 여러 차트 만들 때 앞에꺼 안나옴
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("여자");
        ObservableList<XYChart.Data> data3 = FXCollections.observableArrayList();
        data3.add(new XYChart.Data("2015", 40));
        data3.add(new XYChart.Data("2016", 20));
        data3.add(new XYChart.Data("2017", 90));
        data3.add(new XYChart.Data("2018", 80));
        
        series2.setData(data3);
        barChart.getData().add(series2);
        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("평균온도");
        ObservableList<XYChart.Data> data4 = FXCollections.observableArrayList();
        data4.add(new XYChart.Data("2015", 13));
        data4.add(new XYChart.Data("2016", 14));
        data4.add(new XYChart.Data("2017", 17));
        data4.add(new XYChart.Data("2018", 12));
        
        series3.setData(data4);
        areaChart.getData().add(series3);
        
        XYChart.Series series4 = new XYChart.Series();
        series4.setName("최저온도");
        ObservableList<XYChart.Data> data5 = FXCollections.observableArrayList();
        data5.add(new XYChart.Data("2015", -300));
        data5.add(new XYChart.Data("2016", 5));
        data5.add(new XYChart.Data("2017", 3));
        data5.add(new XYChart.Data("2018", -2));
        
        series4.setData(data5);
        areaChart.getData().add(series4);
    }    
    
}
