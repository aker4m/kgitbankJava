package _22_day;

class A05{
	private int kor;
	
	public void setKor(int kor){
		if(kor<0 || kor>100) return;
		this.kor=kor;
	}
	public int getKor(){
		return kor;
	}
}

public class ClassTest5 {
	public static void main(String[] args){
		A05 ap = new A05();
		//ap.a=100; //.:참조연산자
		//ap.b=200;
	}
}
