package _24_day;

import java.io.IOException;

interface Terran{
	public abstract void attack();
	public abstract void move();
	/*
	public void attack(){
		System.out.println("이 메소드는 공격하는 기술을 만드는 곳입니다.");
	}
	public void move(){
		System.out.println("이 메소드는 이동하는 기술을 만드는 곳입니다.");
	}
	*/
}
class Marin implements Terran{
	public void attack(){
		System.out.println("마린이 공격을 합니다.");
	}
	public void move(){
		System.out.println("마린이 이동을 합니다.");
	}
}

class Tank implements Terran{
	public void attack(){
		System.out.println("탱크가 공격을 합니다.");
	}
	public void move(){
		System.out.println("탱크가 이동을 합니다.");
	}
}

public class ClassTest7 {
	public static void main(String[] args) throws IOException{
		System.out.print("1.마린 2.탱크 : ");
		int select1 = System.in.read()-48;
		System.in.skip(5);
		System.out.print("1.공격 2.이동 : ");
		int select2 = System.in.read()-48;
		
		Terran terran;
		if(select1 == 1)terran = new Marin();
		else terran = new Tank();
		if(select2 == 1)terran.attack();
		else terran.move();
	}
}
