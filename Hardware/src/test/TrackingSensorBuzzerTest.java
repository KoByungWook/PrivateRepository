package test;

import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import hardware.buzzer.ActiveBuzzer;
import hardware.sensor.TrackingSensor;
import java.io.IOException;

public class TrackingSensorBuzzerTest {
	public static void main(String[] args) throws IOException {
		TrackingSensor trackingSensor = new TrackingSensor(RaspiPin.GPIO_00);
		ActiveBuzzer activeBuzzer = new ActiveBuzzer(RaspiPin.GPIO_01);
		
		trackingSensor.setGpioPinListenerDigital(new GpioPinListenerDigital() {
			@Override
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
				if(event.getState() == PinState.HIGH) {
					activeBuzzer.off();
				} else {
					activeBuzzer.on();
				}
			}
		});
		
		System.out.println("ready");
		System.in.read();
	}
}
