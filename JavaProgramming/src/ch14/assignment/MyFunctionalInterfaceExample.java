package ch14.assignment;

public class MyFunctionalInterfaceExample {
	public static void main(String[] args) {
		MyFunctionalInterface fi;
		
		fi = new MyFunctionalInterface() {
			@Override
			public void method() {
				String str = "method call1";
				System.out.println(str);
				
			}
		};
		fi.method();
		
		fi = () -> {
			String str = "method call1";
			System.out.println(str);
		};
		fi.method();
		
		fi = () -> { System.out.println("method call2"); };
		fi.method();
		
		fi = () -> System.out.println("method call3");
		fi.method();
	}

}
