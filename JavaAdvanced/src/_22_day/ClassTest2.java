package _22_day;

public class ClassTest2 {
	public static void main(String[] args){
		int arr[][] = new int[5][5];
		
		int i=0;//행을 관리
		int j=2;//열을 관리
		int co = 1;//1~25까지 숫자를 카운트
		while(co<=25){
			arr[i][j]=co;
			int oldI = i;
			int oldJ = j;
			i--;
			j++;
			if(i<0) i=4;
			if(j>4) j=0;
			if(arr[i][j]!=0){
				i=oldI;
				j=oldJ;
				i++;
			}
			co++;
			
		}
		for(i=0;i<arr.length;i++){
			for(j=0;j<arr[i].length;j++){
				System.out.printf("%d\t" , arr[i][j]);
			}
			System.out.println();
		}
	}
}
