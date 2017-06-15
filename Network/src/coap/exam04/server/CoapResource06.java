package coap.exam04.server;

import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import hardware.buzzer.ActiveBuzzer;
import hardware.converter.PCF8591;
import hardware.sensor.GasSensor;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class CoapResource06 extends CoapResource{
    //Field
    private String state;
    private PCF8591 pcf8591;
    private GasSensor gasSensor;
    private ActiveBuzzer buzzer;
    //Constructor
    public CoapResource06() {
        super("resource06");
        setObservable(true);
        getAttributes().setObservable();
        
        pcf8591 = new PCF8591(0x48, PCF8591.AIN2);
        gasSensor = new GasSensor(pcf8591, RaspiPin.GPIO_23);
        buzzer = new ActiveBuzzer(RaspiPin.GPIO_24);
        
        Thread thread = new Thread() {
            @Override
            public void run() {
                gasSensor.setGpioPinListenerDigital(new GpioPinListenerDigital() {
                    @Override
                    public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                       if(event.getState() == PinState.HIGH) {
                           state = "정상 상태";
                           buzzer.off();
                           changed();
                       } else if(event.getState() == PinState.LOW) {
                           state = "가스 검출";
                           buzzer.on();
                           changed();
                       }
                    }
                });
            }
        };
        
        thread.start();
    }
    //Method

    @Override
    public void handleGET(CoapExchange exchange) {
        exchange.respond(state);
    }

    @Override
    public void handlePOST(CoapExchange exchange) {
//        JSONObject jsonObject = new JSONObject(exchange.getRequestText());
//        value = jsonObject.getInt("value");
//        if(value > 30) {
//            changed();
//        }
        exchange.respond("ok");
    }
}
