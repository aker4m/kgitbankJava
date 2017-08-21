package _27_day;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Member{
	private String name;
	private String tel;
	
	public Member(String name, String tel){
		this.name = name;
		this.tel = tel;
	}
	public void setTel(String tel){
		this.tel = tel;
	}
	public String getName(){
		return name;
	}
	public String getTel(){
		return tel;
	}
	public void disp(){
		System.out.println(name+"���� ��ȭ��ȣ�� "+tel+" �Դϴ�.");
	}
}

class MemberPro{
	ArrayList<Member> list;
	Scanner sc;
	public MemberPro(){
		list = new ArrayList<Member>();
		sc = new Scanner(System.in);
	}
	public void insert(){
		System.out.print("�̸��� �Է��ϼ���:");
		String name = sc.next();
		System.out.print("��ȭ��ȣ�� �Է��ϼ���:");
		String tel = sc.next();
		Member insert = new Member(name, tel);
		list.add(insert);
	}
	public void delete(){
		System.out.print("������ ȸ���� �̸�: ");
		String name = sc.next();
		Iterator it = list.iterator();
		while(it.hasNext()){
			Object obj = it.next();
			Member delete = (Member)obj;
			if(name.equals(delete.getName())){
				list.remove(delete);
				System.out.println(name+"���� �����Ͽ����ϴ�.");
				return;
			}
		}
		System.out.println(name+"���� ȸ���� �ƴմϴ�.");
	}
	public void view(){
		Iterator<Member> it = list.iterator();
		while(it.hasNext()){
			Member view = it.next();
			//Object obj = it.next();
			//Member view = (Member)obj;
			view.disp();
			
			/*for(Member view : list){
				//Member view = (Member)obj;
				view.disp();
			}*/
			
		}
	}
	public void edit(){
		System.out.print("������ ȸ���� �̸� : ");
		String name = sc.next();
		Iterator<Member> it = list.iterator();
		while(it.hasNext()){
			Object obj = it.next();
			Member edit = (Member)obj;
			if(edit.getName().equals(name)){
				System.out.print("������ ��ȭ��ȣ�� �Է� : ");
				String tel = sc.next();
				edit.setTel(tel);
				System.out.println(name+"���� ��ȭ��ȣ�� �����Ͽ����ϴ�.");
				return;
			}
		}
		System.out.println(name+"���� ȸ���� �ƴմϴ�.");
	}
	public void exit(){
		System.out.println("���α׷��� �����մϴ�.");
		System.exit(0);
	}
}

public class SecondTest {
	public static void main(String[] args){
		MemberPro pro = new MemberPro();
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("1.ȸ������  2.ȸ������  3.ȸ������  4.ȸ������  5.����:");
			int select = sc.nextInt();
			switch(select){
			case 1: pro.insert(); break;
			case 2: pro.delete(); break;
			case 3: pro.view(); break;
			case 4: pro.edit(); break;
			case 5: pro.exit(); break;
			default: System.out.println("�߸��Է��ϼ̽��ϴ�.");
			}
		}
	}
}
