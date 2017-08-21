package _24_day;

import java.io.IOException;

interface Terran{
	public abstract void attack();
	public abstract void move();
	/*
	public void attack(){
		System.out.println("�� �޼ҵ�� �����ϴ� ����� ����� ���Դϴ�.");
	}
	public void move(){
		System.out.println("�� �޼ҵ�� �̵��ϴ� ����� ����� ���Դϴ�.");
	}
	*/
}
class Marin implements Terran{
	public void attack(){
		System.out.println("������ ������ �մϴ�.");
	}
	public void move(){
		System.out.println("������ �̵��� �մϴ�.");
	}
}

class Tank implements Terran{
	public void attack(){
		System.out.println("��ũ�� ������ �մϴ�.");
	}
	public void move(){
		System.out.println("��ũ�� �̵��� �մϴ�.");
	}
}

public class ClassTest7 {
	public static void main(String[] args) throws IOException{
		System.out.print("1.���� 2.��ũ : ");
		int select1 = System.in.read()-48;
		System.in.skip(5);
		System.out.print("1.���� 2.�̵� : ");
		int select2 = System.in.read()-48;
		
		Terran terran;
		if(select1 == 1)terran = new Marin();
		else terran = new Tank();
		if(select2 == 1)terran.attack();
		else terran.move();
	}
}
