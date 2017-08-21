package _26_day;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
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
		System.out.println(name+"���� ��ȭ��ȣ�� " + tel + "�Դϴ�.");
	}
}

class MemberPro{
	HashMap map;
	Scanner in;
	public MemberPro(){
		map = new HashMap();
		in = new Scanner(System.in);
	}
	public void insert(){
		System.out.print("�̸��� �Է� : ");
		String name = in.next();
		System.out.print("��ȭ��ȣ�� �Է� : ");
		String tel = in.next();
		Member insert = new Member(name, tel);
		map.put(name, insert);
	}
	public void view(){
		Set set = map.keySet();
		Iterator it = set.iterator();
		while(it.hasNext()){
			String key = (String)it.next();
			Member view = (Member)map.get(key);
			view.disp();
		}
	}
	public void delete(){
		System.out.print("������ ȸ���� �̸� : ");
		String name = in.next();
		if(map.remove(name)!=null){
			System.out.println(name+"���� �����Ͽ����ϴ�.");
		}else{
			System.out.println(name+"���� ���� ȸ���� �ƴմϴ�.");
		}
		
	}
	public void edit(){
		System.out.print("������ ȸ���� �̸� : ");
		String name = in.next();
		Set set = map.keySet();
		Iterator it = set.iterator();
		if(map.containsKey(name)){
			System.out.print("������ ��ȭ��ȣ�� �Է� : ");
			String tel = in.next();
			map.put(name, new Member(name, tel));
			System.out.println(name+"���� ��ȭ��ȣ�� �����Ͽ����ϴ�.");
			return;
		}else{
			System.out.println(name+"���� ���� ȸ���� �ƴմϴ�.");
		}
		
	}
	public void exit(){
		System.out.println("���α׷��� �����մϴ�.");
		System.exit(0);
	}
}
public class FirstTest {
	public static void main(String[] args) throws IOException{
		MemberPro pro = new MemberPro();
		while(true){
			System.out.print
			("1.����Է�  2.������  3.�������  4.�������  5.���� :");
			int select = System.in.read() - 48;
			System.in.skip(5);
			switch(select){
			case 1 :	pro.insert(); break;
			case 2 :	pro.view(); break;
			case 3 :	pro.delete(); break;
			case 4 :	pro.edit(); break;
			case 5 :	pro.exit(); break;
			default :	System.out.println("�߸��Է��ϼ̽��ϴ�.");
			}
		}
	}
}
