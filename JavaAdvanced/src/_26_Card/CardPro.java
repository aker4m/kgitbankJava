package _26_Card;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class CardPro {
	HashMap map, map2;
	Scanner in;
	public CardPro(){
		map = new HashMap(); //��ü �ڷḦ ������ ����
		//map : key-String, value-map2
		//map2 = new HashMap(); //map�ȿ� value������ ������ ����
		//map2 : key-String, value-Card
		in = new Scanner(System.in);
	}
	protected String getGroup(){
		System.out.print("1.ȸ��  2. ģ��  3.�ŷ�ó  4.��Ÿ : ");
		int select = in.nextInt();
		String result = null;
		switch(select){
		case 1: result = "ȸ��"; break;
		case 2: result = "ģ��"; break;
		case 3: result = "�ŷ�ó"; break;
		case 4: result = "��Ÿ"; break;
		default: getGroup();
		}
		return result;
	}
	public void insert(){
		String group = getGroup();
		System.out.print("�̸��� �Է� : ");
		String name = in.next();
		System.out.print("��ȭ��ȣ�� �Է� : ");
		String tel = in.next();
		System.out.print("ȸ����� �Է� : ");
		String company = in.next();
		System.out.print("�̸����� �Է� : ");
		String email = in.next();
		if(map.containsKey(group)){
			map2 = (HashMap)map.get(group);
		}else{
			map2 = new HashMap();
		}
		map2.put(name, new Card(name, tel, company, email));
		map.put(group, map2);
	}
	public void view(){
		String group = getGroup();
		HashMap view = (HashMap)map.get(group);
		Set set = view.keySet();
		for(Iterator it = set.iterator();it.hasNext();){
			String key = (String)it.next();
			Card card = (Card)view.get(key);
			System.out.print(card.getName()+"\t");
			System.out.print(card.getTel()+"\t");
			System.out.print(card.getCompany()+"\t");
			System.out.print(card.getEmail()+"\n");
		}
	}
	public void edit(){
		String group = getGroup();
		HashMap edit = (HashMap)map.get(group);
		System.out.print("������ ������ �̸� : ");
		String name = in.next();
		if(edit.containsKey(name)){
			Card card = (Card)edit.get(name);
			System.out.print("��ȭ��ȣ�� �Է� : ");
			card.setTel(in.next());
			System.out.print("ȸ����� �Է� : ");
			card.setCompany(in.next());
			System.out.print("�̸����� �Է� : ");
			card.setEmail(in.next());
			System.out.println(group+"��"+name+"���� ������ �����Ͽ����ϴ�.");
			return;
		}
		System.out.println(group+"��"+name+"���� ������ �����ϴ�.");
	}
	public void delete(){
		String group = getGroup();
		HashMap delete = (HashMap)map.get(group);
		System.out.print("������ ������ �̸� : ");
		String name = in.next();
		if(delete.containsKey(name)){
			delete.remove(name);
			System.out.println(group+"��"+name+"���� ������ �����Ͽ����ϴ�.");
			return;
		}
		System.out.println(group+"��"+name+"���� ������ �����ϴ�.");
	}
	public void exit(){
		System.out.println("���α׷��� �����մϴ�.");
		System.exit(0);
	}
}
