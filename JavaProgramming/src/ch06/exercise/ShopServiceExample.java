package ch06.exercise;

public class ShopServiceExample {

	public static void main(String[] args) {
		ShopService obj1 = ShopService.getIntance();
		ShopService obj2 = ShopService.getIntance();
		
		if(obj1 == obj2) {
			System.out.println("���� shopService ��ü�Դϴ�");
		} else {
			System.out.println("�ٸ� shopService ��ü�Դϴ�");
		}
	}

}
