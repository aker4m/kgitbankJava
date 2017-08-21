package _28_day;

import java.util.Scanner;

class SubException extends Exception{
	private String message;
	public SubException(String msg){
		super(msg);
	}
	public String getMessage(){
		message = super.getMessage()+"������ 0������ 100�� ������ ���� �Է��� �ּ���!!";
		return message;
	}
}

public class ClassTest7 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		try{
			System.out.print("���������� �Է�:");
			int kor = in.nextInt();
			if(kor<0 || kor>100) throw new SubException("����");
			System.out.println("�Է��Ͻ� ���������� "+kor+"�� �Դϴ�.");
		}catch(SubException e){
			System.err.println(e.getMessage());
		}finally{
			System.out.println("���������� �Է¹޴� ���α׷�");
		}
	}
}
