package _28_day;

import java.util.Scanner;

class PointException extends Exception{
	private String message;
	PointException(String msg){
		super(msg);
	}
	public String getMessage(){
		message = super.getMessage()+"0부터 100사이의 값을 입력해주세요.";
		return message;
	}
}

public class FirstTest {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("국어점수를 입력하세요:");
			int kor = sc.nextInt();
			if(kor>=0 && kor<=100)
				break;
			try{
				if(kor<0 || kor>100)
					throw new PointException("예외코드");
			}catch(Exception e){
				System.err.println(e.getMessage());
			}	
		}
		System.out.println("프로그램을 종료합니다.");
	}
}
