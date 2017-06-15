package coap.exam03.client;

import coap.exam02.client.*;
import java.io.IOException;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapHandler;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.json.JSONObject;

public class CoapResource03AsyncClient {
    //Field
    private CoapClient coapClient;
    
    //Constructor
    public CoapResource03AsyncClient() {
        coapClient = new CoapClient();
        coapClient.useCONs();//default
    }
    
    //Method
    public void get(int angle) {
        String queryString = "kind=ultrasonicsensor&angle=" + angle;
        coapClient.setURI("coap://192.168.3.44:5683/resource02?" + queryString);

        coapClient.get(new CoapHandler() {
            @Override
            public void onLoad(CoapResponse response) {
                if (response != null && response.getCode() == CoAP.ResponseCode.CONTENT) {
                    String text = response.getResponseText();
                    System.out.println(angle + "도 거리: " + text);
                }
            }

            @Override
            public void onError() {

            }
        });
    }
    
    public void post(int angle) {
//        String queryString = "kind=ultrasonicsensor&angle="+angle;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("kind", "ultrasonicsensor");
        jsonObject.put("angle", angle);
        String json = jsonObject.toString();
        
        coapClient.setURI("coap://192.168.3.44:5683/resource02");
        
        coapClient.post(new CoapHandler() {
            @Override
            public void onLoad(CoapResponse response) {
                if (response != null && response.getCode() == CoAP.ResponseCode.CONTENT) {
                    String text = response.getResponseText();
                    System.out.println(angle + "도 거리: " + text);
                }
            }

            @Override
            public void onError() {
                
            }
        }, json, MediaTypeRegistry.APPLICATION_JSON);
    }
    
    public void shutdown() {
        coapClient.shutdown();
    }
    
    public static void main(String[] args) throws InterruptedException, IOException {
        CoapResource03AsyncClient client = new CoapResource03AsyncClient();
        
        for(int i=30; i<150; i+=5) {
            client.post(i);
            Thread.sleep(1000);
        }
        System.in.read();
        client.shutdown();
    }
}
