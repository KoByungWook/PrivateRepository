package ch15.homework;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
	public static void main(String[] args) {
		Queue<Message> messageQueue = new LinkedList<Message>();
		
		messageQueue.offer(new Message("sendMail", "È«±æµ¿"));
		messageQueue.offer(new Message("sendSms", "½Å¿ë±Ç"));
		messageQueue.offer(new Message("sendKakaoTalk", "È«µÎ²²"));
		
		while(!messageQueue.isEmpty()) {
			Message message = messageQueue.poll();
			switch(message.command) {
				case "sendMail" :
					System.out.println(message.to + "´Ô¿¡°Ô ¸ÞÀÏÀ» º¸³À´Ï´Ù.");
					break;
				case "sendSms" :
					System.out.println(message.to + "´Ô¿¡°Ô SmsÀ» º¸³À´Ï´Ù.");
					break;
				case "sendKakaoTalk" :
					System.out.println(message.to + "´Ô¿¡°Ô KakaoTalkÀ» º¸³À´Ï´Ù.");
					break;
			}
		}
	}
}
