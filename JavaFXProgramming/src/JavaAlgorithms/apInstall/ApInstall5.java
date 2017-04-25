package JavaAlgorithms.apInstall;

import java.util.Arrays;
import java.util.Scanner;

public class ApInstall5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();

        int[] homeNoArr = new int[n];

        for(int i=0; i<n; i++) {
            homeNoArr[i] = scanner.nextInt();
        }
		
		Arrays.sort(homeNoArr);
		
		int checkNum = (homeNoArr[n-1] - homeNoArr[0]) / (c - 1);
		boolean flag = true;
		
		while(flag) {
			int count = 1;
			int homeIndex = homeNoArr[0];
			
			for(int i=1; i<n; i++) {
				if( homeNoArr[i]-homeIndex >= checkNum ) {
					homeIndex = homeNoArr[i];
					count++;
				}
			}
			
			if(count == c) flag = false;
			else checkNum--;
		}
	
		System.out.println(checkNum);
	}
}
