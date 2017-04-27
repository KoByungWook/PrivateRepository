package JavaAlgorithms.continueSum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int[] numArr = new int[n];
		for(int i=0; i<n; i++) {
			numArr[i] = scanner.nextInt();
		}

		List<Integer> sumList = new ArrayList<Integer>();
		for(int i=0; i<n-1; i++) {
			for(int j=2; j<=n-1-i; j++) {
				int sum = 0;
				for (int k = i; k < i+j; k++) {
					sum += numArr[k];
				}
				sumList.add(sum);
			}
		}
		
		System.out.println(Collections.max(sumList));
	}
}
