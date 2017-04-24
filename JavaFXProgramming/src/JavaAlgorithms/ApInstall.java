package JavaAlgorithms;

import java.util.Scanner;

public class ApInstall {
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
        
        int max = 0;
        int min = 0;
        for(int i=0; i<n; i++) {
            if(homeNoArr[i] > max) 
                max = homeNoArr[i];
            else if(homeNoArr[i] < min) {
                min = homeNoArr[i];
            }
        }
        
        int checkMaxLength = (max - min) / (c - 1);
        int maxLength = 0;
        
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n-1; j++) {
                int checkDistance = Math.abs(homeNoArr[i] - homeNoArr[j]);
                if(checkDistance < checkMaxLength) {
                    if(checkDistance > maxLength) {
                        maxLength = Math.abs(homeNoArr[i] - homeNoArr[j]);
                    }    
                }
            }
        }
        
        System.out.println(maxLength);
    }
}
