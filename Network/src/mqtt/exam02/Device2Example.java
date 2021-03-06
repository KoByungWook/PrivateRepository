package mqtt.exam02;

import java.util.Scanner;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Device2Example {
	public static void main(String[] args) throws MqttException {
		Device device = new Device("device1");
		device.subcribe();
		
		Scanner scanner = new Scanner(System.in, "UTF-8");
		while(true) {
			System.out.print("input message or q(quit): ");
			String text = scanner.nextLine();
			if(text.equals("q")) break;
			device.publish("device2", text);
		}
		
		device.close();
	}
}
