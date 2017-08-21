package _21_day;

import java.util.*;

public class ClassTest2 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		System.out.print("이름을 입력 : ");
		String name = in.next();
		System.out.print("국어점수를 입력 : ");
		int kor = in.nextInt(); // => InputMismatchException
		//int kor = Integer.parseInt(in.next()); => NumberFormatException
		
		System.out.println(name+"님의 국어점수는 "+kor+"점 입니다.");
	}
}
