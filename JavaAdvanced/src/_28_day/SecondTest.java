package _28_day;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Timer extends Thread{
	
}

public class SecondTest {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int number = (int)(Math.random()*100)+1;
		System.out.println("1부터 100까지 컴퓨터가 생각한 숫자는?");
		Timer timer = new Timer();
		timer.setDaemon(true);
		timer.start();
		while(true){
			System.out.print("입력 :");
			int select = sc.nextInt();
			if(number>select){
				System.out.println("UP!!!");
			}
			else if(number<select){
				System.out.println("Down!!!");
			}
			else{
				System.out.println("정답입니다.");
				break;
			}
		}
		System.out.println("프로그램을 종료합니다.");
		
	}
}
