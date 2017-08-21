package _22_day;

class A04{//사용자 정의 자료형
	int a;
	int b; //멤버필드-선언
	int c, d, e, f, g, h, i, j, k, l, m, n;
	A04(){ //생성자
		a=10;b=20;c=30;d=40;e=50;f=60;
	}
	A04(int x){
		a=x;
		b=20;
	}
	A04(int a, int b){
		this.a=a;
		this.b=b;
	}
	/*
	 * 생성자의 특징
	 * 1. 클래스의 이름과 동일한 메소드
	 * 2. 반환형이 없다(void조차 없다)
	 * 3. 멤버필드의 초기값을 지정하기 위해
	 * 4. 객체를 생성할 때 딱 한번 호출되어 사용
	 * 5. 메소드처럼 사용 불가
	 * 6. 메소드의 일부이므로, 오버로딩이 가능하다
	 * 7. 만약, 생성자를 만들지 않으면 default생성자를 jvm이 만들어 준다.
	 * (생성자가 하나라도 있으면 default생성자 안만들어 진다)
	 */
	void disp(){//멤버메소드-기능
		System.out.println("a="+a);
		System.out.println("b="+b);
	}
}

public class ClassTest4 {
	public static void main(String[] args){
		A04 ap = new A04(); //힙에 메모리 영역 할당, 동적 메모리 할당
		//객체를 생성하면 메모리에 멤버필드가 올라간다
		A04 bp = new A04(100);
		A04 cp = new A04(100, 200);
		ap.disp();
		bp.disp();
		cp.disp();
	}
}
