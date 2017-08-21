package _24_day;

public class ThirdTest {
	public static void main(String[] args){
		char ch;
		for(int i=0;i<26;i++){
			ch='A';
			for(int j=0;j<=i;j++){
				System.out.print(ch);
				ch++;
			}
			System.out.println();
		}
	}
}
