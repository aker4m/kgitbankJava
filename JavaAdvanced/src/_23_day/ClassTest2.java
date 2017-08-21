package _23_day;

import java.util.Scanner;

public class ClassTest2 {
	public static void main(String[] args){
		int[] com = new int[6];
		for(int i=0; i<com.length;i++){
			com[i]=(int)(Math.random()*45)+1;
			for(int j=0;j<i;j++){
				if(com[i]==com[j]){
					i--;
					break;
				}
			}
		}
		Scanner in = new Scanner(System.in);
		int[] select = new int[6];
		for(int i=0;i<select.length;i++){
			do{
				System.out.print((i+1)+"번째 수를 입력: ");
				select[i] = in.nextInt();
			} while(select[i]<1 || select[i]>45);
			for(int j=0;i<i;j++){
				if(select[i]==select[j]){
					i--;
					break;
				}
			}
		}
		int count=0;
		for(int i=0;i<com.length;i++){
			for(int j=0;j<select.length;j++){
				if(com[i]==select[j]){
					count++;
					break;
				}
			}
		}
		System.out.println(count+"개를 맞추셨습니다.");
	}
}
