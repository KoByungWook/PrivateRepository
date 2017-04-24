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
		//날짜 얻기
		LocalDate currDate = LocalDate.now();
		System.out.println(currDate);
		
		LocalDate targetDate = LocalDate.of(2024, 5, 10);
		System.out.println(targetDate);
		
		//시간 얻기
		LocalTime currTime = LocalTime.now();
		System.out.println(currTime);
		
		LocalTime targetTime = LocalTime.of(6, 30, 1, 123);
		System.out.println(targetTime);
		
		//날짜와 시간 얻기
		LocalDateTime currDateTime = LocalDateTime.now();
		System.out.println(currDateTime);
		
		LocalDateTime targetDateTime = LocalDateTime.of(2024, 5, 10, 6, 30, 0, 0);
		System.out.println(targetDateTime);
		
		//협정 세계시와 시간존(TimeZone)
		ZonedDateTime utcDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
		System.out.println(utcDateTime);
		ZonedDateTime newyorkDateTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
		System.out.println(newyorkDateTime);
		
		//특정 시간의 타임스탬프 얻기
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
		
		System.out.println("차이(nanos) : " + instant1.until(instant2, ChronoUnit.NANOS));
	}

}
