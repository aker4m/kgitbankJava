package _28_day;

import java.util.Scanner;

class SubException extends Exception{
	private String message;
	public SubException(String msg){
		super(msg);
	}
	public String getMessage(){
		message = super.getMessage()+"점수는 0점에서 100점 사이의 값을 입력해 주세요!!";
		return message;
	}
}

public class ClassTest7 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		try{
			System.out.print("국어점수를 입력:");
			int kor = in.nextInt();
			if(kor<0 || kor>100) throw new SubException("국어");
			System.out.println("입력하신 국어점수는 "+kor+"점 입니다.");
		}catch(SubException e){
			System.err.println(e.getMessage());
		}finally{
			System.out.println("국어점수를 입력받는 프로그램");
		}
	}
}
