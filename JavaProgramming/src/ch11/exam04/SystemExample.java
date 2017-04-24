package ch11.exam04;

public class SystemExample {
	
	public static void main(String[] args) {
		System.setSecurityManager(new SecurityManager() {
			@Override
			public void checkExit(int status) {		//System.exit 호출될때 함께 호출, 정상적으로 실행되면 jvm 종료;
				if(status != 75865) {
					throw new SecurityException();			//실행 예외 -> throws 안써도댐
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
