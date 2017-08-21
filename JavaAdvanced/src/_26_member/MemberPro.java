package _26_member;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class MemberPro {
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
			Object obj = it.next();
			String key = (String)obj;
			Member view = (Member)map.get(key);
			view.disp();
		}
	}
	public void delete(){
		System.out.print("������ ȸ���� �̸� : ");
		String name = in.next();
		if(map.containsKey(name)){
			map.remove(name);
			System.out.println(name+"���� �����Ͽ����ϴ�.");
			return;
		}
		System.out.println(name+"���� ���� ȸ���� �ƴմϴ�.");
	}
	public void edit(){
		System.out.print("������ ȸ���� �̸� : ");
		String name = in.next();
		if(map.containsKey(name)){
			Member edit = (Member)map.get(name);
			System.out.print("������ ��ȭ��ȣ�� �Է� : ");
			String tel = in.next();
			edit.setTel(tel);
			System.out.println(name+"���� ��ȭ��ȣ�� �����Ͽ����ϴ�.");
			return;
		}
		System.out.println(name+"���� ���� ȸ���� �ƴմϴ�.");
	}
	public void exit(){
		System.out.println("���α׷��� �����մϴ�.");
		System.exit(0);
	}
}
