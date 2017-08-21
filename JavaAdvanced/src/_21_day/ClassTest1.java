package _21_day;

import java.io.IOException;

public class ClassTest1 {
	public static void main(String[] args) throws IOException{
		System.out.print("첫번째 수를 입력 : ");
		int su1 = System.in.read()-48;
		System.in.skip(5);
		System.out.print("두번째 수를 입력 : ");
		int su2 = System.in.read()-48;
		
		System.out.println("입력하신 두 수의 합 : "+(su1+su2));
		/*
		System.out.print("숫자를 입력 :");
		int res = System.in.read()-48;
		
		System.out.println("입력하신 수의 제곱은 : "+res*res);
		
		System.out.print("한글자를 입력:");
		int res = System.in.read();
		
		System.out.println("입력하신 값 : "+(char)res);
		*/
	}
}
