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
		System.out.println("1���� 100���� ��ǻ�Ͱ� ������ ���ڴ�?");
		Timer timer = new Timer();
		timer.setDaemon(true);
		timer.start();
		while(true){
			System.out.print("�Է� :");
			int select = sc.nextInt();
			if(number>select){
				System.out.println("UP!!!");
			}
			else if(number<select){
				System.out.println("Down!!!");
			}
			else{
				System.out.println("�����Դϴ�.");
				break;
			}
		}
		System.out.println("���α׷��� �����մϴ�.");
		
	}
}
