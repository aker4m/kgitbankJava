package _23_day;

class A06{
	public void aaa(){
		System.out.println("aaa메소드 입니다.");
	}
	public void bbb(){
		System.out.println("ddd메소드 입니다.");
	}
	public void ccc(){
		System.out.println("ccc메소드 입니다.");
	}
}

public class ClassTest6 {
	public static void main(String[] args){
		A06 ap = new A06(){
			public void bbb(){
				System.out.println("bbb메소드 입니다.");
			} //익명중첩클래스
		};
		ap.aaa();
		ap.bbb();
		ap.ccc();
	}
}
