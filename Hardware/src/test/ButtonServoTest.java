package test;

import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import hardware.button.Button;
import hardware.motor.SG90Servo;
import java.io.IOException;

public class ButtonServoTest {

    public static void main(String[] args) throws IOException {
        Button button1 = new Button(RaspiPin.GPIO_00);
        Button button2 = new Button(RaspiPin.GPIO_02);
        SG90Servo servoMotor = new SG90Servo(RaspiPin.GPIO_01, 8, 26);
        
        servoMotor.setAngle(0);
        
        button1.setGpioPinListenerDigital(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                int count = servoMotor.getAngle();
                if(event.getState() == PinState.LOW) {
                    for(int i=count; i<=180; i++) {
                        servoMotor.setAngle(i);
                    }
                }
            }
        });
        
        button2.setGpioPinListenerDigital(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                int count = servoMotor.getAngle();
                if(event.getState() == PinState.LOW) {
                    for(int i=count; i>=0; i--) {
                        servoMotor.setAngle(i);
                    }
                }
            }
        });
        
        System.in.read();
    }
}
