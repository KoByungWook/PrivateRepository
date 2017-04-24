package ch06.exercise;

public class ShopService {
	private static ShopService shopService = new ShopService();
	
	private ShopService() {
		
	}
	
	static ShopService getIntance() {
		// TODO Auto-generated method stub
		return shopService;
	}
}
