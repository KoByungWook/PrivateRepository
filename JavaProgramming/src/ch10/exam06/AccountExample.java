package ch10.exam06;

public class AccountExample {

	public static void main(String[] args) {
		Account account = new Account();
		System.out.println("�ܰ� : " + account.getBalance());
		
		account.deposit(100000);
		System.out.println("�ܰ� : " + account.getBalance());
		
		try {
			account.withdraw(110000);
		} catch (BalanceInsufficientException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("�ܰ� : " + account.getBalance());
	}

}
