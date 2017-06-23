package mainControlBoard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.RotateEvent;
import javafx.scene.shape.Circle;
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
	@FXML
	private Circle handleRotate;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        coapClient = new CoapClient();
//        
//        jsonObject = new JSONObject();
//        jsonObject.put("command", "status");
//        json = jsonObject.toString();
//        coapClient.setURI("coap://192.168.3.44/fronttire");
//        coapResponse = coapClient.post(json, MediaTypeRegistry.APPLICATION_JSON);
//        json = coapResponse.getResponseText();
//        jsonObject = new JSONObject(json);
//        
//        coapClient.shutdown();
//        
//		System.out.println(handleRotate.getRotate());

		handleRotate.setOnRotationFinished(e -> handleRotate(e));
    }

    private void handleBtnBuzzerOn() {
        
    }

	private void handleRotate(RotateEvent e) {
		coapClient = new CoapClient();
		
		jsonObject = new JSONObject();
        jsonObject.put("command", "status");
        json = jsonObject.toString();
        coapClient.setURI("coap://192.168.3.44/fronttire");
        coapResponse = coapClient.post(json, MediaTypeRegistry.APPLICATION_JSON);
        json = coapResponse.getResponseText();
        jsonObject = new JSONObject(json);
		
        int oldAngle = Integer.parseInt(jsonObject.getString("angle"));
		
		int changeAngle = (int) e.getTotalAngle();
		
		int newAngle = oldAngle + changeAngle;
		if(newAngle < 10) {
			newAngle = 10;
		} else if(newAngle >170) {
			newAngle = 170;
		}
		
        jsonObject = new JSONObject();
        jsonObject.put("command", "change");
        jsonObject.put("angle", String.valueOf(newAngle));
        json = jsonObject.toString();
        coapClient.setURI("coap://192.168.3.44/fronttire");
        coapResponse = coapClient.post(json, MediaTypeRegistry.APPLICATION_JSON);
        
        String resJson = coapResponse.getResponseText();
        jsonObject = new JSONObject(resJson);
        
        coapClient.shutdown();
		
	}



}
