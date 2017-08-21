package _23_day;

public class ClassTest3 {
	public static void main(String[] args){
		int lotto[] = new int[45];
		int rank[] = new int[45];
		int su[] = new int[6];
		int max = 200;
		for(int i=0; i<max; ++i){
			for(int j=0; j<6; ++j){
				su[j] = (int)(Math.random()*45) + 1;
				for(int k=0; k<j; ++k){
					if (su[j]==su[k]){
						j--;
						break;
					}
				}//end k
			}//end j
			for(int j=0; j<6; ++j){
				lotto[su[j]-1]++;
			}
		}//end i
		for(int i=0; i<lotto.length; ++i){
			for(int j=0; j<lotto.length; ++j){
				if (lotto[i] < lotto[j]) rank[i]++;
			}
		}
		
		
		for(int i=0; i<45; ++i){
			System.out.print(i+1 +" : ");
			for(int j=0; j<lotto[i]; ++j){
				System.out.print("*");
			}
			System.out.println();
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
