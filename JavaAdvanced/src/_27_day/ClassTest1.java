package _27_day;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClassTest1 {
	public static void main(String[] args){
		ArrayList<String> list = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		
		list.add("���缮");
		list.add("������");
		list.add("����");
		list2.add("������");
		/*
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		//���� �ڽ�
		*/
		System.out.println(list.indexOf("������"));
		
		for(int i=0;i<list.size();i++){
			Object obj = list.get(i); // index�� ����Ÿ�� ������ �� �ִ�.
			String name = (String)obj;
			System.out.println(name);
		}
		list.add(1, "�ڸ��");
		for(Iterator it = list.iterator();it.hasNext(); ){
			Object obj = it.next();
			String name = (String)obj;
			System.out.println(name);
		}
	}
}
