package _27_day;

import java.util.Calendar;
import java.util.Scanner;

public class ClassTest3 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		System.out.print("�⵵�� �Է�: ");
		int year = in.nextInt();
		System.out.print("���� �Է� : ");
		int month = in.nextInt();
		
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, 1);
		/*
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		*/
		int week = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");
		
		for(int i=1;i<week; ++i){
			System.out.print("\t");
		}
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		for(int i=1;i<=lastDay;i++){
			System.out.print(i+"\t");
			if(week % 7 == 0){
				System.out.println();
			}
			week++;
		}
		
	}
}
