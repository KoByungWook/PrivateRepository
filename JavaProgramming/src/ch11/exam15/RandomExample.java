package ch11.exam15;

import java.util.Random;

public class RandomExample {
	public static void main(String[] args) {
		int maxNum = 11;
		
		//how 1

			
			double random = Math.random();
			int num = (int)(random*maxNum) + 5;	//

		
		//how 2
		Random obj = new Random();
		int num2 = obj.nextInt(maxNum) +1;
		System.out.println(num2);
	}
}
