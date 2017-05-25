
package test;

import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import hardware.buzzer.ActiveBuzzer;
import hardware.converter.PCF8591;
import hardware.led.DualColorLed;
import hardware.motor.SG90Servo;
import hardware.sensor.GasSensor;


public class GasSensorBuzzerDualLedServoMotorTest {
	public static void main(String[] args) throws Exception {
		PCF8591 pcf8591 = new PCF8591(0x48, PCF8591.AIN0);
		GasSensor gasSensor = new GasSensor(pcf8591, RaspiPin.GPIO_00);
		DualColorLed dualLed = new DualColorLed(RaspiPin.GPIO_27, RaspiPin.GPIO_28);
		ActiveBuzzer buzzer = new ActiveBuzzer(RaspiPin.GPIO_03);
		SG90Servo servo = new SG90Servo(RaspiPin.GPIO_01, 8, 26);
		
		gasSensor.setGpioPinListenerDigital(new GpioPinListenerDigital() {
			@Override
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
				if(event.getState() == PinState.LOW) {
					dualLed.red();
					if(buzzer.getStatus() == "off") buzzer.on();
					servo.setAngle(180);
				} else if(event.getState() == PinState.HIGH) {
					dualLed.green();
					if(buzzer.getStatus() == "on") buzzer.off();
					servo.setAngle(0);
				}
			}
		});
		
		while(true) {
			double value = gasSensor.getValue();
			System.out.println(value);
			if(value < 200) {
				//방법1:Analog 값을 이용해서 처리
			}
			Thread.sleep(1000);
		}
	}
}
