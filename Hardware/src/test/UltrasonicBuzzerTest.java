package test;

import com.pi4j.io.gpio.RaspiPin;
import hardware.UltrasonicSensor;
import hardware.buzzer.ActiveBuzzer;

public class UltrasonicBuzzerTest {
	public static void main(String[] args) {
		UltrasonicSensor uts = new UltrasonicSensor(RaspiPin.GPIO_00, RaspiPin.GPIO_01);
		ActiveBuzzer buzzer = new ActiveBuzzer(RaspiPin.GPIO_02);
		
		while(true) {
			if(uts.getDistance() < 20) {
				buzzer.on();
			} else {
				buzzer.off();
			}
		}
	}
}
