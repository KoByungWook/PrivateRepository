package test;

import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import hardware.buzzer.ActiveBuzzer;
import hardware.converter.PCF8591;
import hardware.led.RgbLedPWM;
import hardware.sensor.FlameSensor;
import java.io.IOException;

public class FlameSensorBuzzerRgbTest {
	public static void main(String[] args) throws IOException {
		PCF8591 pcf8591 = new PCF8591(0x48, PCF8591.AIN0);
		FlameSensor flameSensor = new FlameSensor(pcf8591, RaspiPin.GPIO_00);
		RgbLedPWM rgb = new RgbLedPWM(RaspiPin.GPIO_27, RaspiPin.GPIO_28, RaspiPin.GPIO_29);
		ActiveBuzzer buzzer = new ActiveBuzzer(RaspiPin.GPIO_01);
		
		flameSensor.setGpioPinListenerDigital(new GpioPinListenerDigital() {
			@Override
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent gpdsce) {
				if(gpdsce.getState() == PinState.LOW) {
					rgb.ledColorSet(255, 0, 0);
					buzzer.on();
				} else {
					rgb.ledColorSet(0, 0, 0);
					buzzer.off();
				}
			}
		});
		
		System.in.read();
	}
}
