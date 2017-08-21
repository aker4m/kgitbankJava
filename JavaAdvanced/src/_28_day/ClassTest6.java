package _28_day;

class MyException extends Exception{
	private String message;
	public MyException(String msg){
		super(msg);
	}
	public String getMessage(){
		message = super.getMessage()+"내가 만든 예외클래스!!";
		return message;
	}
}

public class ClassTest6 {
	public static void main(String[] args){
		try{
			throw new MyException("예외코드 : ");//강제예외
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
	}
}

/* 예외클래스 만들기
 *1.extends Exception
 *2.public String getMessage() 메소드를 오버라이드 한다.
 *
 */
