package _28_day;

import java.util.Scanner;

class PointException extends Exception{
	private String message;
	PointException(String msg){
		super(msg);
	}
	public String getMessage(){
		message = super.getMessage()+"0���� 100������ ���� �Է����ּ���.";
		return message;
	}
}

public class FirstTest {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("���������� �Է��ϼ���:");
			int kor = sc.nextInt();
			if(kor>=0 && kor<=100)
				break;
			try{
				if(kor<0 || kor>100)
					throw new PointException("�����ڵ�");
			}catch(Exception e){
				System.err.println(e.getMessage());
			}	
		}
		System.out.println("���α׷��� �����մϴ�.");
	}
}
