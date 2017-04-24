package ch06.exercise;

import java.util.*;

public class Account2Example {
	private static Account2[] accountArray = new Account2[100];
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		while(run) {
			System.out.println("-----------------------------------------------");
			System.out.println("1.���»��� | 2.���¸�� | 3.���� | 4.��� | 5.����");
			System.out.println("-----------------------------------------------");
			System.out.print("���� > ");
			
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
		System.out.println("���α׷� ����");
	}
	
	private static void createAccount() {
		System.out.println("---------");
		System.out.println("���»���");
		System.out.println("---------");
		
		System.out.print("���¹�ȣ : ");
		String ano = scanner.nextLine();
		
		System.out.print("������ : ");
		String owner = scanner.nextLine();
		
		System.out.print("�ʱ��Աݾ� : ");
		int balance = Integer.parseInt(scanner.nextLine());
		
		Account2 newaccount = new Account2(ano, owner, balance);
		for(int i=0 ; i<accountArray.length ; i++) {
			if(accountArray[i] == null) {
				accountArray[i] = newaccount;
				System.out.println();
				System.out.println("���°� �����Ǿ����ϴ�.");
				break;
			}
		}
	}
	
	private static void accountList() {
		System.out.println("---------");
		System.out.println("���¸��");
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
		System.out.print("���¹�ȣ : ");
		String ano = scanner.nextLine();
		
		System.out.print("���ݾ� : ");
		int balance = Integer.parseInt(scanner.nextLine());
		
		for(int i=0 ; i<accountArray.length ; i++) {
			if(accountArray[i] != null) {
				if(accountArray[i].getAno().equals(ano)) {
					int newBalance = accountArray[i].getBalance() + balance;
					accountArray[i].setBalance(newBalance);
					System.out.println("������ �����Ǿ����ϴ�.");
				} else
					System.out.println("���ݿ� �����Ͽ����ϴ�");
					break;
			}
		}
	}
	// �ڵ� �ۼ� ���� ��

}
