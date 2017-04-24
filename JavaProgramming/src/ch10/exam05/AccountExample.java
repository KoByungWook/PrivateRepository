package ch10.exam05;

public class AccountExample {

	public static void main(String[] args) {
		Account account = new Account();
		System.out.println("잔고 : " + account.getBalance());
		
		account.deposit(100000);
		System.out.println("잔고 : " + account.getBalance());
		
		try {
			account.withdraw(110000);
		} catch (BalanceInsufficientException e) {
			e.printStackTrace();
			System.out.println("---------------------");
			System.out.println(e.toString());				//위 아래 것에 비해 잘 몰라도됨
			System.out.println("---------------------");
			System.out.println(e.getMessage());			// 실제 예외처리할 때 쓰는 정보
		}
		
		
		System.out.println("잔고 : " + account.getBalance());
	}

}