package coap.exam04.server;

import hardware.converter.PCF8591;
import hardware.motor.PCA9685;
import hardware.sensor.ThermistorSensor;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class CoapResource05 extends CoapResource {
    private PCF8591 pcf8591;
    private ThermistorSensor thermistorSensor;
    private double degree;
    
    public CoapResource05() throws Exception {
        super("resource05");
        setObservable(true);
        getAttributes().setObservable();
        
        pcf8591 = new PCF8591(0x48, PCF8591.AIN1);
        thermistorSensor = new ThermistorSensor(pcf8591);
        
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        degree = thermistorSensor.getValue();
                    } catch (Exception ex) {
                    }
                    changed();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        };

        thread.start();
    }

    @Override
    public void handleGET(CoapExchange exchange) {
        exchange.respond("현재 온도: " + degree +"도");
    }

    @Override
    public void handlePOST(CoapExchange exchange) {
        
    }
}
