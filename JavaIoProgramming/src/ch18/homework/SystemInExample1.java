package ch18.homework;

import java.io.IOException;
import java.io.InputStream;

public class SystemInExample1 {
    public static void main(String[] args) throws IOException {
        System.out.println("==메뉴==");
        System.out.println("1.예금 조회");
        System.out.println("2.예금 출금");
        System.out.println("3.예금 입금");
        System.out.println("4.종료 하기");
        System.out.print("메뉴를 선택하세요");
        
        InputStream is = System.in;
        char inputChar = (char)is.read();       //is.read()로 받은 값이 아스키코드이기 때문에 char로 변환
        switch(inputChar) {
            case '1' :
                System.out.println("예금 조회를 선택하셨습니다.");
                break;
            case '2' :
                System.out.println("예금 출금를 선택하셨습니다.");
                break;
            case '3' :
                System.out.println("예금 입금를 선택하셨습니다.");
                break;
            case '4' :
                System.out.println("종료 하기를 선택하셨습니다.");
                break;    
        }
    }
}
