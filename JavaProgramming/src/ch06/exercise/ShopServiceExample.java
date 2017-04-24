package ch06.exercise;

public class ShopServiceExample {

	public static void main(String[] args) {
		ShopService obj1 = ShopService.getIntance();
		ShopService obj2 = ShopService.getIntance();
		
		if(obj1 == obj2) {
			System.out.println("같은 shopService 객체입니다");
		} else {
			System.out.println("다른 shopService 객체입니다");
		}
	}

}
