package _26_day;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ClassTest1 {
	public static void main(String[] args){
		HashMap map = new HashMap();
		
		map.put("���缮", "���׸�");
		map.put("�ڸ��", "���׸�");
		
		Set set = map.keySet();
		//key�� ����� ���� setŸ������ �Ѱ��ݴϴ�.
		Iterator it = set.iterator();
		while(it.hasNext()){
			String key = (String)it.next();
			String job = (String)map.get(key);
			System.out.println(key+"���� ������ "+job+"�Դϴ�.");
		}
		
		/*
		if(map.remove("��ȣ��")!= null){
			System.out.println("��ȣ������ �����Ͽ����ϴ�.");
		}else {
			System.out.println("��ȣ������ ���� ����� �ƴմϴ�.");
		}
		*/
		/*
		if(map.containsKey("��ȣ��")){
			System.out.println("��ȣ���� ���� ����Դϴ�.");
		}else{
			System.out.println("��ȣ���� ���� ����� �ƴմϴ�.");
		}
		*/
		/*
		Object obj = map.get("���缮");
		String job = (String)obj;
		System.out.println("���缮�� ����: "+job);
		*/
	}
}
