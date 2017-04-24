package ch10.exam05;

public class AccountExample {

	public static void main(String[] args) {
		Account account = new Account();
		System.out.println("�ܰ� : " + account.getBalance());
		
		account.deposit(100000);
		System.out.println("�ܰ� : " + account.getBalance());
		
		try {
			account.withdraw(110000);
		} catch (BalanceInsufficientException e) {
			e.printStackTrace();
			System.out.println("---------------------");
			System.out.println(e.toString());				//�� �Ʒ� �Ϳ� ���� �� ���󵵵�
			System.out.println("---------------------");
			System.out.println(e.getMessage());			// ���� ����ó���� �� ���� ����
		}
		
		
		System.out.println("�ܰ� : " + account.getBalance());
	}

}