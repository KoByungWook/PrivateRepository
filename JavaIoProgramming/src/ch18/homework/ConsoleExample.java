package ch18.homework;

import java.io.Console;

public class ConsoleExample {
    public static void main(String[] args) {
        Console console = System.console();     //콘솔을 실행하기 위해서는 IDE에서는 불가능, 명령프롬프트로 가야함
        
        System.out.println("id: ");
        String id = console.readLine();     //사용자가 값을 입력하고 엔터칠 때까지 여기 머물러 있음.
        
        System.out.println("password: ");
        char[] charPass = console.readPassword();   //키보드 입력 문자를 콘솔에 보여주지 않고 문자열 읽기
        String strPassword = new String(charPass);
        
        System.out.println("----------------------");
        System.out.println(id);
        System.out.println(strPassword);
    }
}
