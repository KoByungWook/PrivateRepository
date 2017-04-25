package ch11.homework;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataPrintExample {

	public static void main(String[] args) {
		Date now = new Date();
		
		SimpleDateFormat simpleDataFormat = new SimpleDateFormat("yyyy��  MM�� dd�� E���� HH�� mm��");
		System.out.println(simpleDataFormat.format(now));
	}

}
