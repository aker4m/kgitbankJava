package _27_day;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ClassTest2 {
	public static void main(String[] args){
		Calendar cal = Calendar.getInstance();
		System.out.println("cal = "+cal);
		System.out.println("�⵵ : "+cal.get(Calendar.YEAR));
		System.out.println("�� : " +(cal.get(Calendar.MONTH)+1));
		System.out.println("�� : "+cal.get(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.YEAR, 2016);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.DAY_OF_MONTH, 10);
		String msg="";
		switch(cal.get(Calendar.DAY_OF_WEEK)){
		case 1: msg="��"; break;
		case 2: msg="��"; break;
		case 3: msg="ȭ"; break;
		case 4: msg="��"; break;
		case 5: msg="��"; break;
		case 6: msg="��"; break;
		case 7: msg="��"; break;
		}
		System.out.println(msg+"�����Դϴ�.");
		/*
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
		System.out.println("date = "+date);
		System.out.println("���� ��¥ : "+sdf.format(date));
		System.out.println("���� �ð� : "+sdf2.format(date));
		*/
	}
	
}
