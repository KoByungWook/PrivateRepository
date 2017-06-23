package mqtt.exam02;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;

public class Device {
	//Field
	private String url = "tcp://localhost:1883";	//브로커에 접속하기 위한 정보
	private String myClientId;
	private String topicRequest;
	private String topicResponse;
	private int qos = 1;
	private MqttClient mqttClient;
	
	private MqttCallback callback = new MqttCallback() {
		@Override
		public void deliveryComplete(IMqttDeliveryToken imdt) {
			
		}
		
		@Override
		public void messageArrived(String string, MqttMessage mm) throws Exception {
			System.out.println("Message -> " + mm.toString());
			System.out.print("input message or q(quit): ");
		}

		@Override
		public void connectionLost(Throwable thrwbl) {
			try {
				close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	};
	//Constructor
	public Device(String myClientId) throws MqttException {
		this.myClientId = myClientId;
		topicRequest = "/devices/" + myClientId + "/request";
		topicResponse = "/devices/" + myClientId + "/response";
		
		mqttClient = new MqttClient(url, myClientId);
		mqttClient.setCallback(callback);
		mqttClient.connect();
	}
	
	//Method
	public void subcribe() throws MqttException {
		mqttClient.subscribe(topicResponse);
	}
	
	public void publish(String targetClientId, String text) throws MqttException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("from", myClientId);
		jsonObject.put("to", targetClientId);
		jsonObject.put("text", text);
		String json = jsonObject.toString();
		
		MqttMessage mqttMessage = new MqttMessage(json.getBytes());
		mqttMessage.setQos(qos);
		mqttClient.publish(topicRequest, mqttMessage);
	}
	
	public void close() throws MqttException {
		if(mqttClient != null) {
			mqttClient.disconnect();
			mqttClient.close();
			mqttClient = null;
		}
	}
}