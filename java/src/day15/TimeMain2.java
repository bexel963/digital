package day15;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeMain2 {

	public static void main(String[] args) throws ParseException {
		//p.544~545 날짜를 문자열로
		Date date = new Date();
		
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");	// 정보를 이 포멧에 맞게 바꿔줌
		String dateString = simpleFormat.format(date);
		
		SimpleDateFormat simpleFormat1 = new SimpleDateFormat("yyyy-MM-dd E요일");
		String dateString1 = simpleFormat1.format(date);
		
		
		System.out.println(dateString);
		System.out.println(dateString1);
		
		//날짜를 문자열로
		String dateString2 = "2020-01-01 14:30:00";
		SimpleDateFormat simpleFormat2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date2 = simpleFormat2.parse(dateString2);
		System.out.println(date2);
		
	}

}
