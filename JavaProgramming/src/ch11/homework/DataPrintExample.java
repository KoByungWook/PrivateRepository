package ch11.homework;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataPrintExample {

	public static void main(String[] args) {
		Date now = new Date();
		
		SimpleDateFormat simpleDataFormat = new SimpleDateFormat("yyyy년  MM월 dd일 E요일 HH시 mm분");
		System.out.println(simpleDataFormat.format(now));
	}

}
