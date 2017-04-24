package ch11.homework;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class DateTimeCreateExample {

	public static void main(String[] args) throws InterruptedException {
		//��¥ ���
		LocalDate currDate = LocalDate.now();
		System.out.println(currDate);
		
		LocalDate targetDate = LocalDate.of(2024, 5, 10);
		System.out.println(targetDate);
		
		//�ð� ���
		LocalTime currTime = LocalTime.now();
		System.out.println(currTime);
		
		LocalTime targetTime = LocalTime.of(6, 30, 1, 123);
		System.out.println(targetTime);
		
		//��¥�� �ð� ���
		LocalDateTime currDateTime = LocalDateTime.now();
		System.out.println(currDateTime);
		
		LocalDateTime targetDateTime = LocalDateTime.of(2024, 5, 10, 6, 30, 0, 0);
		System.out.println(targetDateTime);
		
		//���� ����ÿ� �ð���(TimeZone)
		ZonedDateTime utcDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
		System.out.println(utcDateTime);
		ZonedDateTime newyorkDateTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
		System.out.println(newyorkDateTime);
		
		//Ư�� �ð��� Ÿ�ӽ����� ���
		Instant instant1 = Instant.now();
		Thread.sleep(10);
		Instant instant2 = Instant.now();
		if(instant1.isBefore(instant2)) {
			System.out.println("instant1 is more faster");
		} else if(instant1.isAfter(instant2)) {
			System.out.println("instant1 is more slower");
		} else {
			System.out.println("same time");
		}
		
		System.out.println("����(nanos) : " + instant1.until(instant2, ChronoUnit.NANOS));
	}

}
