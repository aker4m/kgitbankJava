package _25_day;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class ClassTest2 {
	public static void main(String[] args){
		HashSet hs = new HashSet();
		Scanner in = new Scanner(System.in);
		
		hs.add("���缮");
		hs.add("������");
		hs.add("����");
		hs.add("��ȫö");
		hs.add("�ڸ��");
		hs.add("������");
		
		Iterator it = hs.iterator(); //�ݺ���, �����۾�
		while(it.hasNext()){
			Object obj = it.next(); //��ĳ����
			String name = (String)obj;
			System.out.println(name);
		}
		/*
		System.out.print("������ ����� �̸�: ");
		String name = in.next();
		if(hs.remove(name)){ //�ش� ��ü�� ������ ���� �� true, ������ false
			System.out.println(name+"����� �����Ͽ����ϴ�.");
		} else {
			System.out.println(name+"�� ���ѵ��� ����� �ƴմϴ�.");
		}
		*/
		/*
		System.out.print("ã���ô� ����� �̸� : ");
		String name = in.next();
		if(hs.contains(name)){ //�ش� ��ü�� ã�´�.
			System.out.println("���ѵ��� ����� �½��ϴ�.");
		}else {
			System.out.println("���ѵ��� ����� �ƴմϴ�.");
		}
		*/
		/*
		System.out.println("���ѵ��� ����� �� : "+hs.size());//ũ�� ���ϱ�
		hs.clear(); // �� �����ϰڴ�.
		System.out.println("���ѵ��� ����� �� : "+hs.size());
		*/
	}
}
