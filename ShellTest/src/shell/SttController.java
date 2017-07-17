package shell;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class SttController implements Initializable {
    
    @FXML
    private Button btnRecognize;
    @FXML
    private TextArea textArea;
    
    private String[] dataArr;
    private String data;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnRecognize.setOnAction(e -> handleBtnRecognize());
    }    

    private void handleBtnRecognize() {
        textArea.clear();
        
        try {
            Process ps = Runtime.getRuntime().exec("/home/pi/./stt.sh");
            ps.waitFor();
            //System.out.println(ps.exitValue());
            ps.destroy();
            
            FileReader fr = new FileReader("/home/pi/NetBeansProjects/ShellTest/stt.txt");
            BufferedReader br = new BufferedReader(fr);
            br.readLine();
            data = br.readLine();
            System.out.println(data); 
            
            // "[" 기준으로 첫 번째 파싱
            dataArr = data.split("\\[");
            data = dataArr[2];
            // "]" 기준으로 두 번째 파싱
            dataArr = data.split("]");
            data = dataArr[0];
            System.out.println(data);
            
            //마지막 transcript 앞 쪽 파싱
            dataArr = data.split("transcript\":\"");
            data = dataArr[dataArr.length - 1];
            //마지막 transcript 뒤 쪽 파싱
            dataArr = data.split("\"");
            data = dataArr[0];
            System.out.println(data);
            
            //공백 없애기
            data = data.replaceAll(" ","");
            System.out.println(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        textArea.setText(data);
    }
    
}
