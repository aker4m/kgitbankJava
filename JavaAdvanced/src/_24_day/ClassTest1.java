package _24_day;

public class ClassTest1 {
	public static void main(String[] args){
		int[][] arr = new int[5][5];
		int co=0;
		for(int k=0;k<3;++k){
			int j=4-k;
			for(int i=k;i<=j;++i){ arr[k][i]= ++co;}
			for(int i=k+1;i<=j;++i){ arr[i][j]= ++co;}
			for(int i=j-1;i>=k;--i){ arr[j][i]= ++co;}
			for(int i=j-1;i>=k+1;--i){ arr[i][k]= ++co;}
		}
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
