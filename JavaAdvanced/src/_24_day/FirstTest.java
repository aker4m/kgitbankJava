package _24_day;

import java.util.Scanner;

public class FirstTest {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 차 달팽이를 구할까요?:");
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		int cnt=0;
		
		for(int k=0;k<arr.length/2+1;++k){
			int j=n-1-k;
			for(int i=k;i<=j;++i){ arr[k][i]= ++cnt;}
			for(int i=k+1;i<=j;++i){ arr[i][j]= ++cnt;}
			for(int i=j-1;i>=k;--i){ arr[j][i]= ++cnt;}
			for(int i=j-1;i>=k+1;--i){ arr[i][k]= ++cnt;}
		}
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
