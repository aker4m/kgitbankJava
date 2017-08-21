package _22_day;

import java.util.Scanner;

public class FirstTest {
	public static int guess(int min, int max){
		return (int)(Math.random()*(max-min+1))+min;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("1부터 100사이에서 당신이 생각한 수는?");
		int num, min=1, max=100;
		int answer, cnt=0;
		while(true){
			cnt++;
			num = guess(min, max);
			System.out.print("당신이 생각한 수는"+num+" 입니까?"+"\n 1.Up 2.down 3.correct: ");
			answer = sc.nextInt();
			switch(answer){
			case 1: min = num+1; break;
			case 2: max = num-1; break;
			case 3:
				System.out.println(cnt+"번 만에 당신의 정답을 맞췄군요");
				System.exit(0);
			default : 
				System.out.println("다시 입력하세요.");
			}	
		}
		
		
	}
}
