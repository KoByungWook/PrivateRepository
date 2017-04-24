package ch06.exercise;

import java.util.*;

public class Account2Example {
	private static Account2[] accountArray = new Account2[100];
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		while(run) {
			System.out.println("-----------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("-----------------------------------------------");
			System.out.print("선택 > ");
			
			int selectNo = Integer.parseInt(scanner.nextLine());
			
			if(selectNo == 1) {
				createAccount();
			} else if(selectNo == 2) {
				accountList();
			} else if(selectNo == 3) {
				deposit();
			} else if(selectNo == 4) {
				
			} else if(selectNo == 5) {
				run = false;
			}  	
		}
		System.out.println("프로그램 종료");
	}
	
	private static void createAccount() {
		System.out.println("---------");
		System.out.println("계좌생성");
		System.out.println("---------");
		
		System.out.print("계좌번호 : ");
		String ano = scanner.nextLine();
		
		System.out.print("계좌주 : ");
		String owner = scanner.nextLine();
		
		System.out.print("초기입금액 : ");
		int balance = Integer.parseInt(scanner.nextLine());
		
		Account2 newaccount = new Account2(ano, owner, balance);
		for(int i=0 ; i<accountArray.length ; i++) {
			if(accountArray[i] == null) {
				accountArray[i] = newaccount;
				System.out.println();
				System.out.println("계좌가 생성되었습니다.");
				break;
			}
		}
	}
	
	private static void accountList() {
		System.out.println("---------");
		System.out.println("계좌목록");
		System.out.println("---------");
		
		for(int i=0 ; i<accountArray.length ; i++){
			if(accountArray[i] != null) {
				System.out.print(accountArray[i].getAno());
				System.out.print("  ");
				System.out.print(accountArray[i].getOwner());
				System.out.print("  ");
				System.out.println(accountArray[i].getBalance());
			} else 
				break;
		}
	}
	
	private static void deposit() {
		System.out.print("계좌번호 : ");
		String ano = scanner.nextLine();
		
		System.out.print("예금액 : ");
		int balance = Integer.parseInt(scanner.nextLine());
		
		for(int i=0 ; i<accountArray.length ; i++) {
			if(accountArray[i] != null) {
				if(accountArray[i].getAno().equals(ano)) {
					int newBalance = accountArray[i].getBalance() + balance;
					accountArray[i].setBalance(newBalance);
					System.out.println("예금이 성공되었습니다.");
				} else
					System.out.println("예금에 실패하였습니다");
					break;
			}
		}
	}
	// 코드 작성 진행 중

}
