package _23_day;

class A06{
	public void aaa(){
		System.out.println("aaa�޼ҵ� �Դϴ�.");
	}
	public void bbb(){
		System.out.println("ddd�޼ҵ� �Դϴ�.");
	}
	public void ccc(){
		System.out.println("ccc�޼ҵ� �Դϴ�.");
	}
}

public class ClassTest6 {
	public static void main(String[] args){
		A06 ap = new A06(){
			public void bbb(){
				System.out.println("bbb�޼ҵ� �Դϴ�.");
			} //�͸���øŬ����
		};
		ap.aaa();
		ap.bbb();
		ap.ccc();
	}
}
