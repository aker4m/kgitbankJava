package _21_day;

import java.util.Scanner;

public class ClassTest3 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("먹고 싶은 저녁 메뉴 : ");
		String menu = in.next();
		
		switch(menu){
		case "짜장면" : System.out.println("5000원 입니다.");break;
		case "짬뽕" : System.out.println("5500원 입니다.");break;
		case "순대국" : System.out.println("5000원 입니다.");break;
		case "김치찌개" : System.out.println("6000원 입니다.");break;
		default : System.out.println("알 수 없습니다.");
		}
	}
}
