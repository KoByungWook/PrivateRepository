package JavaAlgorithms.coin;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[] coinArr = new int[n];
		
		for(int i=0; i<n; i++) {
			int input = scanner.nextInt();
			coinArr[i] = input;
		}
		
		int count = 0;
		int remain = 0;
		for(int i=n-1; i>=0; i--) {
			count += (k / coinArr[i]);
			k = (k % coinArr[i]); 
		}
		
		System.out.println(count);
	}
}
