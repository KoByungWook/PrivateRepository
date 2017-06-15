package coap.exam04.client;

import com.pi4j.io.gpio.RaspiPin;
import hardware.buzzer.ActiveBuzzer;
import java.io.IOException;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapHandler;
import org.eclipse.californium.core.CoapObserveRelation;
import org.eclipse.californium.core.CoapResponse;

public class CoapResource06Client {
    //Field
    private CoapClient coapClient;
    private CoapObserveRelation coapObserveRelation;
    //Constructor
    public CoapResource06Client() {
        coapClient = new CoapClient();
    }
    //Method
    public void observe() {
        coapClient.setURI("coap://192.168.3.44/resource06");
        coapObserveRelation = coapClient.observe(new CoapHandler(){
            @Override
            public void onLoad(CoapResponse response) {
                String text = response.getResponseText();
                System.out.println("state=" + text);
            }

            @Override
            public void onError() {
            
            }
        });
        
    }
    
    public void shutdown() {
        coapObserveRelation.proactiveCancel();
        coapClient.shutdown();
    }
    
    public static void main(String[] args) throws IOException {
        CoapResource06Client client = new CoapResource06Client();
        client.observe();
        System.in.read();
        client.shutdown();
    }
}
