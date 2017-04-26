package JavaAlgorithms.nonRootSquareNumber;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int min = scanner.nextInt();
		int max = scanner.nextInt();
		int countNum = 0;
		
		int maxCheckNum = (int)Math.sqrt(max) + 1;
		
		for(int i=min; i<=max; i++) {
			int count = 0;
			for(int j=2; j<=maxCheckNum; j++) {
				if(i%(j*j) != 0 ) {
					continue;
				} else {
					countNum++;
					break;
				}
			}
		}
		
		int totalNum = max - min + 1;
		System.out.println(totalNum - countNum);
	}
}
