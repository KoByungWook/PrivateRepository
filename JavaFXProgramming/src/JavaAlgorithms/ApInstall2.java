package JavaAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class ApInstall2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        
        if( (n < 2 || n > 200000) || (c < 2 || c > n) ) return;

        int[] homeNoArr = new int[n];

        for(int i=0; i<n; i++) {
            homeNoArr[i] = scanner.nextInt();
            if( homeNoArr[i] > 1000000000 ) return;
        }
        
        Arrays.sort(homeNoArr);
        
        int checkNum = (homeNoArr[n-1] - homeNoArr[0]) / (c - 1);
        int maxLength= 0;
        
        boolean flag = true;
        while(flag) {
            for (int i = 0; i < n - 1; i++) {
                if (homeNoArr[i + 1] - homeNoArr[i] == checkNum-1) {
                    maxLength = checkNum-1;
                    flag = false;
                }  
            }
            checkNum--;
        }
        
        System.out.println(maxLength);
        
    }
}
