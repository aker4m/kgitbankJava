package _27_day;

import java.util.Calendar;
import java.util.Scanner;

public class ThirdTest {
	public static void main(String[] args){
		Calendar cal = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);
		System.out.print("�⵵�� �Է�: ");
		int year=sc.nextInt();
		System.out.print("���� �Է� : ");
		int month = sc.nextInt();
		int[][] arr = new int[6][7];
		
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		//Calendar.DAY_OF_WEEK
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				System.out.print(arr[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}
	}
}
