package ch11.exam07;

import java.util.Map;
import java.util.Set;

class GetEnvExample {

	public static void main(String[] args) {
		
		String value = System.getenv("USERNAME");
		
		Map map = System.getenv();
		Set keys = map.keySet();
		for(Object objKey : keys) {
			String key = (String) objKey;
			String value1 = System.getenv(key);
			System.out.println("[" + key + "]" + value1);

		}

	}
}
