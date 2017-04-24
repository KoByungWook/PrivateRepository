package ch12.review;

public class WaitNotifyExample2 {

	public static void main(String[] args) {
		Databox databox = new Databox();
		
		ProducerThread pt = new ProducerThread(databox);
		ConsumerThread ct = new ConsumerThread(databox);
		
		pt.start();
		ct.start();
	}

}
