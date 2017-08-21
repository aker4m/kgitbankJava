package _22_day;

import java.util.Scanner;

public class ThirdTest {
	public static int gcd(int p, int q){
		if (q == 0) 
			return p;
		return gcd(q, p%q);
	 }
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 정수를 입력하세요");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수를 입력하세요");
		int num2 = sc.nextInt();
		
		int gcd = gcd(num1, num2);
		int lcm = num1 * num2 / gcd;
		
		System.out.println("최대공약수는"+gcd+", 최대공배수는 "+lcm);
	}
}
