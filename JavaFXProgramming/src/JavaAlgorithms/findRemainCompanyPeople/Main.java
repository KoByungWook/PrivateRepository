package JavaAlgorithms.findRemainCompanyPeople;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		for(int i=0; i<n; i++) {
			String name = scanner.next();
			String status = scanner.next();
			
			map.put(name, status);
		}
		
		Set<String> nameSet = map.keySet();
		Iterator<String> nameIterator = nameSet.iterator();
		String[] nameArr = new String[map.size()];
		int index = 0;
		while(nameIterator.hasNext()) {
			nameArr[index] = nameIterator.next();
			index++;
		}
		
		Arrays.sort(nameArr, Collections.reverseOrder());
		
		for(int i=0; i<nameArr.length; i++) {
			if(map.get(nameArr[i]).equals("enter")) {
				System.out.println(nameArr[i]);
			}
		}
		
	}
}
