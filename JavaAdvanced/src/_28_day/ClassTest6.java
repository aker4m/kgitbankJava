package _28_day;

class MyException extends Exception{
	private String message;
	public MyException(String msg){
		super(msg);
	}
	public String getMessage(){
		message = super.getMessage()+"���� ���� ����Ŭ����!!";
		return message;
	}
}

public class ClassTest6 {
	public static void main(String[] args){
		try{
			throw new MyException("�����ڵ� : ");//��������
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
	}
}

/* ����Ŭ���� �����
 *1.extends Exception
 *2.public String getMessage() �޼ҵ带 �������̵� �Ѵ�.
 *
 */
