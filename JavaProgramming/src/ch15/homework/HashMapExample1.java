package ch15.homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample1 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("�ſ��", 85);
		map.put("ȫ�浿", 90);
		map.put("���ڹ�", 80);
		map.put("ȫ�浿", 95);
		System.out.println("�� ��ü ��: " + map.size() );
		
		System.out.println("\tȫ�浿: " + map.get("ȫ�浿"));
		System.out.println();
		
		Set<String> keySet = map.keySet();
		Iterator<String> iterator = keySet.iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			int value = map.get(key);
			System.out.println(key + ": " + value);
		}
		
		map.remove("ȫ�浿");
		System.out.println("�� ��ü ��: " + map.size());
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		while(entryIterator.hasNext()) {
			Map.Entry<String, Integer> entry = entryIterator.next();
			String key = entry.getKey();
			int value = entry.getValue();
			System.out.println(key + ": " + value);
		}
		System.out.println();
		
		map.clear();
		System.out.println("�� ��ü ��: " + map.size());
	}

}
