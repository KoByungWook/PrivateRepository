package coap.exam02.client;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.json.JSONObject;

public class CoapResource02Client {
    //Field
    private CoapClient coapClient;
    
    //Constructor
    public CoapResource02Client() {
        coapClient = new CoapClient();
        coapClient.useCONs();//default
    }
    
    //Method
    public String get(int angle) {
        String queryString = "kind=ultrasonicsensor&angle="+angle;
        coapClient.setURI("coap://192.168.3.44:5683/resource02?" + queryString);
        CoapResponse response = coapClient.get();
        //2.05(content)는 안에 내용이 있는 정상응답
        if (response == null) {
            return get(angle);
        } else {
            if (response != null && response.getCode() == CoAP.ResponseCode.CONTENT) {
                return response.getResponseText();
            } else {
                return null;
            }
        }
        
    }
    
    public String post(int angle) {
//        String queryString = "kind=ultrasonicsensor&angle="+angle;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("kind", "ultrasonicsensor");
        jsonObject.put("angle", angle);
        String json = jsonObject.toString();
        System.out.println(json);
        
        coapClient.setURI("coap://192.168.3.44:5683/resource02");
        CoapResponse response = coapClient.post(json, MediaTypeRegistry.TEXT_PLAIN);
        //2.05(content)는 안에 내용이 있는 정상응답
        if (response == null) {
            return get(angle);
        } else {
            if (response != null && response.getCode() == CoAP.ResponseCode.CONTENT) {
                return response.getResponseText();
            } else {
                return null;
            }
        }
        
    }
    
    public void shutdown() {
        coapClient.shutdown();
    }
    
    public static void main(String[] args) throws InterruptedException {
        CoapResource02Client client = new CoapResource02Client();
        
        for(int i=30; i<150; i+=5) {
            String text = client.post(i);
            System.out.println(i + "도 거리:" + text);
        }
        client.shutdown();
    }
}
