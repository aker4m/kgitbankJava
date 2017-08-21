package _27_day;

import java.util.Calendar;
import java.util.Scanner;

public class ThirdTest {
	public static void main(String[] args){
		Calendar cal = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);
		System.out.print("년도를 입력: ");
		int year=sc.nextInt();
		System.out.print("월을 입력 : ");
		int month = sc.nextInt();
		int[][] arr = new int[6][7];
		
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		//Calendar.DAY_OF_WEEK
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				System.out.print(arr[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}
	}
}
