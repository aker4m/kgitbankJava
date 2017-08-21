package _23_day;

import java.util.Scanner;

public class FourthTest {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int[] com = new int[3];
		int[] select = new int[3];
		for(int i=0;i<com.length;i++){
			com[i]=(int)(Math.random()*9)+1;
			for(int j=0;j<i;j++){
				if(com[i]==com[j]){
					i--;
					break;
				}
			}
		}
		int cnt=0;
		String str;
		while(true){
			int strike=0, ball=0;
			System.out.print("수를 입력하세요 :");
			str = sc.next();
			for(int i=0;i<3;i++){
				select[i]=str.charAt(i)-48;
			}
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					if(com[i]==select[j] && i==j){
						strike++;
					}
					if(com[i]==select[j] && i!=j){
						ball++;
					}
				}
			}
			cnt++;
			System.out.println(strike+" "+ball);
			if(strike==3)
				break;
		}
		System.out.println(cnt+"번 만에 맞추셨습니다.");
	}
}
