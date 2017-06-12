package hardware.laser;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;

public class LaserEmitter {
	//Field
	private GpioPinDigitalOutput laserPin;
	private String status = "off";
	//Constructor
	public LaserEmitter(Pin laserPinNo) {
		GpioController gpioController = GpioFactory.getInstance();
		laserPin = gpioController.provisionDigitalOutputPin(laserPinNo);
		stop();
	}
	//Method
	public void shot() {
		laserPin.low();
		status = "on";
	}
	
	public void stop() {
		laserPin.high();
		status = "off";	
	}

	public String getStatus() {
		return status;
	}
	
	public static void main(String[] args) throws InterruptedException {
		LaserEmitter test = new LaserEmitter(RaspiPin.GPIO_25);
		for(int i=0; i<5; i++) {
			test.shot();
			Thread.sleep(2000);
			test.stop();
			Thread.sleep(200);
		}
	}
}
