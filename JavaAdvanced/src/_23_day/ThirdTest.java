package _23_day;

import java.util.Arrays;

public class ThirdTest {
	public static void main(String[] args){
		int[] lotto = new int[45];
		int rank[] = new int[45];
		
		int[] com = new int[6];
		int max=1000000;
		for(int k=0;k<max;k++){
			for(int i=0;i<com.length;i++){
				com[i]=(int)(Math.random()*45)+1;
				for(int j=0;j<i;j++){
					if(com[i]==com[j]){
						i--;
						break;
					}
				}
			}
			for(int i=0;i<com.length;i++){
				lotto[com[i]-1]++;
			}
		}
		for(int i=0;i<lotto.length;i++){
			for(int j=0;j<lotto.length;j++){
				if(lotto[i]<lotto[j]) rank[i]++;
			}
		}
		for(int i=0;i<lotto.length;i++){
			System.out.println("로또번호 "+(i+1)+"번이 나온 횟수 = "+lotto[i]);
		}
		int co = 0;
		for(int i=0; i<6; ++i){
			for(int j=0; j<rank.length; ++j){
				if (i==rank[j]) {
					co++;
					System.out.print(j+1 +"  ");
					if (co==6) {
						i=5;
						break;
					}
				}
			}
		}
	}
}
