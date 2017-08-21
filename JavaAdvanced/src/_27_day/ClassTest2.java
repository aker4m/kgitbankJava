package _27_day;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ClassTest2 {
	public static void main(String[] args){
		Calendar cal = Calendar.getInstance();
		System.out.println("cal = "+cal);
		System.out.println("년도 : "+cal.get(Calendar.YEAR));
		System.out.println("월 : " +(cal.get(Calendar.MONTH)+1));
		System.out.println("일 : "+cal.get(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.YEAR, 2016);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.DAY_OF_MONTH, 10);
		String msg="";
		switch(cal.get(Calendar.DAY_OF_WEEK)){
		case 1: msg="일"; break;
		case 2: msg="월"; break;
		case 3: msg="화"; break;
		case 4: msg="수"; break;
		case 5: msg="목"; break;
		case 6: msg="금"; break;
		case 7: msg="토"; break;
		}
		System.out.println(msg+"요일입니다.");
		/*
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
		System.out.println("date = "+date);
		System.out.println("현재 날짜 : "+sdf.format(date));
		System.out.println("현재 시간 : "+sdf2.format(date));
		*/
	}
	
}
