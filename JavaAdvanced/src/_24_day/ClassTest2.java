package _24_day;

public class ClassTest2 {
	public static void main(String[] args){
		int co=6;
		for(int i=1;i<=9;++i){
			if(i<=5) co--;
			else co++;
			for(int j=1;j<=co;j++){
				System.out.print("*");
			}
			for(int j=1;j<=(6-co)*2-1;j++){
				System.out.print(" ");
			}
			for(int j=1;j<=co;j++){
				System.out.print("*");
			}
			System.out.println();
		}
		/*
		int co=0;
		for(int i=1;i<=9;i++){
			if(i<=5) co++;
			else co--;
			for(int k=1;k<=5-co;k++){
				System.out.print(" ");
			}
			for(int j=1;j<=2*co-1;j++){
				System.out.print("*");
			}
			System.out.println();
		}
		*/
		/*
		int co=0;
		for(int i=1;i<=9;i++){
			if(i<=5) co++;
			else co--;
			for(int j=1;j<=co;j++){
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		*/
		
		
	}
}
