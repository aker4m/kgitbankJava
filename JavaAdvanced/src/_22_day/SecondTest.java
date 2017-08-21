package _22_day;

import java.util.Scanner;

public class SecondTest {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 차 마방진을 만들까요?");
		int n=sc.nextInt();

		int[][] arr = new int[n][n];
		
		int row=0, col=n/2;
		int cnt=1;
		while(cnt<=n*n){
			arr[row][col]=cnt;
			int oldRow=row;
			int oldCol=col;
			row--; col++;
			if(row<0) row=n-1;
			if(col>n-1) col=0;
			if(arr[row][col]!=0){
				row=oldRow;
				col=oldCol;
				row++;
			}
			cnt++;
		}
		
		
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
