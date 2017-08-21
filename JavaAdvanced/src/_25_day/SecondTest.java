package _25_day;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


class Member2{
	private String name;
	private String phone;
	
	public Member2(String name, String phone){
		this.name = name;
		this.phone = phone;
	}
	public void disp(){
		System.out.println(name+"���� ��ȭ��ȣ�� "+phone+" �Դϴ�.");
	}
}

public class SecondTest {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		HashSet<Member2> hs = new HashSet<Member2>();
		
		while(true){
			System.out.print("1.����Է�  2.������  3.�������  4.�������  5.���� :");
			int num = sc.nextInt();
			
			switch(num){
			case 1:
				System.out.print("����� �̸��� �Է��ϼ���");
				String name = sc.next();
				System.out.print("����� ��ȭ��ȣ�� �Է��ϼ���");
				String phone = sc.next();
				hs.add(new Member2(name, phone));
				break;
			case 2:
				Iterator<Member2> it = hs.iterator();
				while(it.hasNext()){
					Object obj = it.next();
					Member2 member = (Member2)obj;
					member.disp();
				}
				break;
			case 3:
				System.out.print("������ ��� �̸��� �Է��ϼ���.");
				name = sc.next();
				
				break;
			case 4:
				break;
			case 5:
				System.out.print("���α׷��� �����մϴ�.");
				System.exit(0);
			default:
				System.out.println("�߸� �Է��Ͽ����ϴ�.");
			}
		}
		
	}
}
