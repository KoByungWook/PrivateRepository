package ch11.exam04;

public class SystemExample {
	
	public static void main(String[] args) {
		System.setSecurityManager(new SecurityManager() {
			@Override
			public void checkExit(int status) {		//System.exit ȣ��ɶ� �Բ� ȣ��, ���������� ����Ǹ� jvm ����;
				if(status != 75865) {
					throw new SecurityException();			//���� ���� -> throws �Ƚᵵ��
				}
			}
		});
		
		for(int i=0; i<10; i++) {
			System.out.println(i);
			if(i == 5) {
				try{
				System.exit(0);	
				} catch(SecurityException e) {

				}
			}
		}
	}
}
