
package JavaAlgorithms.systemConvert;

import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String data = scanner.next();
		int n = Integer.parseInt(scanner.next());
		int result = 0;
		
		for(int i=0; i<data.length(); i++) {
			char index = data.charAt(i);
			
			if('0' <= index && index <= '9') {
				index -= 48;
			} else if('A' <= index && index <='Z') {
				index -= 55;
			}
			
			result += (int)index * Math.pow(n, data.length()-1-i);
		}
		
		System.out.println(result);
	}
}
