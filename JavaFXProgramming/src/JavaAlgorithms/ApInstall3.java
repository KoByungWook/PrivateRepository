package JavaAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class ApInstall3 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();

        int[] homeNoArr = new int[n];

        for(int i=0; i<n; i++) {
            homeNoArr[i] = scanner.nextInt();
        }
        
        Arrays.sort(homeNoArr);
        
        int maxLength= 0;
        
        int count = 1;
        int sumNum = homeNoArr[0];
        int avg = (homeNoArr[n-1] - homeNoArr[0]) / (c-1);
        int checkNum = avg;
      
        for(int i=1; i<n; i++) {
            if(homeNoArr[i] == sumNum + checkNum){
                sumNum += checkNum;
                checkNum = avg;  
            } else {
                checkNum++;
            }      
        }
       
        
    }
}