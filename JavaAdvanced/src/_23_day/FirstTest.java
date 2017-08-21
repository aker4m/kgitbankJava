package _23_day;

import java.util.Scanner;

public class FirstTest {
	public static void main(String[] args){
		int alpha[] = new int[26];
		
		Scanner in = new Scanner(System.in);
		System.out.print("문자열을 입력하세요!!");
		String str = in.nextLine();
		
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			if(ch>'Z') ch -=32;
			if(ch>='A' && ch<='Z'){
				alpha[ch-65]++;
			}
		}
		for(int i=0;i<26;i++){
			if(alpha[i]>0){
				System.out.printf("%c = %d\n", (char)(i+65), alpha[i]);
			}
		}
	}
}
