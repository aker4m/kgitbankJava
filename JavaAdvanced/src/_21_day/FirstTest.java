package _21_day;

import java.util.Scanner;

public class FirstTest {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] num = new int[10];
		int tmp;
		
		for(int i=0;i<10;i++){
			System.out.print("정수"+(i+1)+"를 입력하세요:");
			num[i] = sc.nextInt();
		}
		for(int i=0;i<num.length-1;i++){
			for(int j=0;j<num.length-1-i;j++){
				if(num[j]>num[j+1]){
					tmp = num[j+1];
					num[j+1]=num[j];
					num[j]=tmp;
				}
			}
		}
		for(int i=0;i<num.length;i++){
			System.out.print(num[i]+" ");
		}
	}
}
