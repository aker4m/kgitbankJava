package _26_day;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

class SungJuk{
	private String name;
	private int kor;
	private int eng;
	private int tot;
	private int rank;
	public SungJuk(String name, int kor, int eng){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		tot = kor + eng;
		rank = 1;
	}
	public void setKor(int kor){
		this.kor = kor;
		setTot();
	}
	public void setEng(int eng){
		this.eng = eng;
		setTot();
	}
	protected void setTot(){
		tot = kor + eng;
	}
	public String getName(){
		return name;
	}
	public int getKor(){
		return kor;
	}
	public int getEng(){
		return eng;
	}
	public int getTot(){
		return tot;
	}
	public int getRank(){
		return rank;
	}
	public void clearRank(){
		rank = 1;
	}
	public void plusRank(){
		rank++;
	}
	public void disp(){
		System.out.println(name+"���� ������ " + 
						tot+"���̰�, ������ " + rank +"�� �Դϴ�.");
	}
}
class SungPro{
	HashMap map;
	public SungPro(){
		map = new HashMap();
	}
	protected String inputStr(String str){
		Scanner in = new Scanner(System.in);
		System.out.print(str+"�� �Է� : ");
		return in.next();
	}
	protected int inputSub(String str){
		Scanner in = new Scanner(System.in);
		while(true){
			System.out.print(str+"������ �Է� : ");
			int sub = in.nextInt();
			if (sub>=0 && sub<=100) return sub;
				System.out.println(str+"������ 0������ 100�� ���̰��� �־��ּ���");
		}
	}
	public void insert(){
		String name = inputStr("�̸�");
		int kor = inputSub("����");
		int eng = inputSub("����");
		SungJuk insert = new SungJuk(name, kor, eng);
		map.put(name, insert);
	}
	protected void rank(){
		Set set = map.keySet();
		for(Iterator it=set.iterator(); it.hasNext(); ){
			String key = (String)it.next();
			SungJuk rank = (SungJuk)map.get(key);
			rank.clearRank();
			for(Iterator it2=set.iterator(); it2.hasNext(); ){
				String key2 = (String)it2.next();
				SungJuk rank2 = (SungJuk)map.get(key2);
				if (rank.getTot()<rank2.getTot()) rank.plusRank();
			}
		}
		/*
		Set set = map.keySet();
		SungJuk rank[] = new SungJuk[set.size()];
		set.toArray(rank);
		for(int i=0; i<rank.length; ++i){
			rank[i].clearRank();
			for(int j=0; j<rank.length; ++j){
				if (rank[i].getTot() < rank[j].getTot()) rank[i].plusRank();
			}
		}
		*/
	}
	public void view(){
		rank();
		Set set = map.keySet();
		Iterator it = set.iterator();
		while(it.hasNext()){
			Object obj = it.next();
			String key = (String)obj;
			SungJuk view = (SungJuk)map.get(key);
			view.disp();
		}
	}
	public void delete(){
		String name = inputStr("������ �л��� �̸�");
		if(map.containsKey(name)){
			map.remove(name);
			System.out.println(name+"�л��� �����Ͽ����ϴ�.");
			return;
		}
		System.out.println(name+"���� ���� �л��� �ƴմϴ�.");
		
	}
	public void edit(){
		String name = inputStr("������ �л��� �̸�");
		if(map.containsKey(name)){
			SungJuk edit = (SungJuk)map.get(name);
			if (edit.getName().equals(name)){
				edit.setKor(inputSub("������ ����"));
				edit.setEng(inputSub("������ ����"));
				System.out.println(name+"�л��� ������ �����Ͽ����ϴ�.");
				return;
			}
		}
		System.out.println(name+"���� ���� �л��� �ƴմϴ�.");
	}
	public void exit(){
		System.out.println("���α׷��� �����մϴ�.");
		System.exit(0);
	}
}
public class SecondTest {
	public static void main(String[] args) throws IOException{
		SungPro pro = new SungPro();
		while(true){
			System.out.print
			("1.�л��Է�  2.�л����  3.�л�����  4.�л�����  5.���� :");
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