package _21_day;

//import java.util.Arrays;
import java.util.Scanner;

public class ClassTest4 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		int[] arr = new int[10];
		for(int i=0;i<arr.length;i++){
			System.out.print(i+1+"번째 수를 입력:");
			arr[i]=in.nextInt();
		}
		
		//Arrays.sort(arr);
		for(int i=0;i<arr.length-1;++i){
			for(int j=i+1;j<arr.length;++j){
				if(arr[i]>arr[j]){
					int imsi = arr[i];
					arr[i] = arr[j];
					arr[j] = imsi;
				}
			}
		}
		
		for(int i=0;i<arr.length;i++){
			System.out.println(i+1+"번째 수 : "+arr[i]);
		}
	}
}
