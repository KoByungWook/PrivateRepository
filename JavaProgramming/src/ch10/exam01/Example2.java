package ch10.exam01;

import java.util.Scanner;

public class Example2 {
	public static void main(String[] args) {
		try {
			String str = null;
			System.out.println(str.length());
		} catch(NullPointerException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("정상적으로 실행되도록 함");
		}
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("입력하세요");
			String strNum = scanner.nextLine();
			try {
				int Num = Integer.parseInt(strNum);
			} catch(NumberFormatException e) {
				System.out.println("숫자만 입력하세요");
			}
		}
	}
}
