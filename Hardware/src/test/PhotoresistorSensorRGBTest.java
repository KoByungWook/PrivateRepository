package test;

import com.pi4j.io.gpio.RaspiPin;
import hardware.converter.PCF8591;
import hardware.led.RgbLedPWM;
import hardware.sensor.PhotoresistorSensor;

public class PhotoresistorSensorRGBTest {
	public static void main(String[] args) throws Exception {
		PCF8591 pcf8591 = new PCF8591(0x48, PCF8591.AIN0);
		PhotoresistorSensor sensor = new PhotoresistorSensor(pcf8591);
		RgbLedPWM rgb = new RgbLedPWM(RaspiPin.GPIO_00, RaspiPin.GPIO_02, RaspiPin.GPIO_03);
		
		rgb.ledColorSet(0, 0, 0);
		
		while(true) {
			if(sensor.getValue() > 120) {
				rgb.ledColorSet(0, 0, 255);
			} else if(sensor.getValue() <= 120 && sensor.getValue() >30) {
				rgb.ledColorSet(0, 255, 0);
			} else if(sensor.getValue() <= 30) {
				rgb.ledColorSet(255, 0, 0);
			}
		}
	}
}
