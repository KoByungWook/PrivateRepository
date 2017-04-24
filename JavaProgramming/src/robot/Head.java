package robot;

public class Head {

	Eye eye = new Eye();
	Ear ear = new Ear();
	Mouth mouth = new Mouth();
	
	void see() {
		System.out.println("들어오는 손님을 발견한다.");
	}
	
	void said1() {
		System.out.println("들어온 손님에게 인사한다.");
		System.out.println("어서오세요. 주문하시겠어요?");
	}
	
	void said2() {
		System.out.println("맛있게 드세요.");
		System.out.println("안녕히 가세요.");
	}
	
	void hear(int x) {
		System.out.println("햄버거 " + x + "개를 주문받았다" );
	}
}
