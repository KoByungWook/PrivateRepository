package mainControlBoard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.json.JSONObject;

public class TestController implements Initializable {

    private CoapClient coapClient;
    private JSONObject jsonObject = null;
    private String json = null;
    private CoapResponse coapResponse = null;
    
    @FXML
    private Button btnBuzzerOn;
    @FXML
    private Button btnBuzzerOff;
    @FXML
    private Label labelBuzzerStatus;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        coapClient = new CoapClient();
        
        jsonObject = new JSONObject();
        jsonObject.put("command", "status");
        json = jsonObject.toString();
        coapClient.setURI("coap://192.168.43.166/buzzer");
        coapResponse = coapClient.post(json, MediaTypeRegistry.APPLICATION_JSON);
        json = coapResponse.getResponseText();
        jsonObject = new JSONObject(json);

        labelBuzzerStatus.setText(jsonObject.getString("status"));
        
        coapClient.shutdown();
        
        btnBuzzerOn.setOnAction(e -> handleBtnBuzzerOn());
        btnBuzzerOff.setOnAction(e -> handleBtnBuzzerOff());
    }

    private void handleBtnBuzzerOn() {
        coapClient = new CoapClient();
        
        jsonObject = new JSONObject();
        jsonObject.put("command", "change");
        jsonObject.put("status", "on");
        json = jsonObject.toString();
        coapClient.setURI("coap://192.168.43.166/buzzer");
        coapResponse = coapClient.post(json, MediaTypeRegistry.APPLICATION_JSON);
        
        String resJson = coapResponse.getResponseText();
        jsonObject = new JSONObject(resJson);
        
        labelBuzzerStatus.setText(jsonObject.getString("status"));
        
        coapClient.shutdown();
    }

    private void handleBtnBuzzerOff() {
        coapClient = new CoapClient();
        
        jsonObject = new JSONObject();
        jsonObject.put("command", "change");
        jsonObject.put("status", "off");
        json = jsonObject.toString();
        coapClient.setURI("coap://192.168.43.166/buzzer");
        coapResponse = coapClient.post(json, MediaTypeRegistry.APPLICATION_JSON);
        
        String resJson = coapResponse.getResponseText();
        jsonObject = new JSONObject(resJson);
        
        labelBuzzerStatus.setText(jsonObject.getString("status"));
        
        coapClient.shutdown();
    }

}
