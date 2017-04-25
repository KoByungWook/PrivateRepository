package JavaAlgorithms.apInstall;

import java.util.Arrays;
import java.util.Scanner;

public class ApInstall4_correct {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();

        int[] homeNoArr = new int[n];
        for(int i=0; i<n; i++) {
            homeNoArr[i] = scanner.nextInt();
        }
		
		Arrays.sort(homeNoArr);
		
		int low = 0;
		int high = homeNoArr[n-1] - homeNoArr[0];
		
		
		while(low < high) {
			int count = 1;
			int homeIndex = homeNoArr[0];
			int checkNum = (low + high) / 2;
			for(int i=1; i<n; i++) {
				if( homeNoArr[i]-homeIndex >= checkNum ) {
					homeIndex = homeNoArr[i];
					count++;
				}
			}
			
			if(count >= c) low = checkNum;
			else high = checkNum;
			
			if(high - low == 1) break;
		}
	
		System.out.println(low);
	}
}
