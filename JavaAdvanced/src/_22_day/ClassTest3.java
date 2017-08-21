package _22_day;

import java.util.*;
public class ClassTest3 {
	public static void main(String[] args){
		int gcd = 0;		int lcm = 0;
		Scanner in = new Scanner(System.in);
		System.out.print("첫번째 수를 입력 : ");		int su1 = in.nextInt();
		System.out.print("두번째 수를 입력 : ");		int su2 = in.nextInt();
		if (su1>su2){
			int temp = su1;			su1 = su2;			su2 = temp;
		}
		for(int i=1; i<=su1; ++i){
			if (su1%i==0) {
				if (su2%i==0){
					gcd = i;
				}
			}
		}
		lcm = su1 * su2 / gcd;
		System.out.println("최대공약수 : " + gcd);
		System.out.println("최소공배수 : "+ lcm);
	}
}










