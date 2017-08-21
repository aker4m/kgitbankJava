package _27_day;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

class BaseBall{
	private String name;
	private double AVG; // Bating Average, Ÿ��
	private int HR; // Home Run, Ȩ��
	private int RBI; // Run Batted In, Ÿ��
	
	public BaseBall(String name, double AVG, int HR, int RBI){
		this.name = name;
		this.AVG = AVG;
		this.HR = HR;
		this.RBI = RBI;
	}
	
	public void setAVG(double AVG){
		this.AVG = AVG;
	}
	public void setHR(int HR){
		this.HR = HR;
	}
	public void setRBI(int RBI){
		this.RBI = RBI;
	}
	public String getName(){
		return name;
	}
	public double getAVG(){
		return AVG;
	}
	public int getHR(){
		return HR;
	}
	public int getRBI(){
		return RBI;
	}
	public void disp(){
		System.out.println(name+" ������ Ÿ�� : "+AVG+", Ȩ�� ��: "+HR+	", Ÿ��: "+RBI);
	}
}

class Team{
	private String team;
	
	public Team(String team){
		this.team = team;
	}
	public void setTeam(String team){
		this.team = team;
	}
	public String getTeam(){
		return team;
	}
}

class BaseBallPro{
	HashMap map, map2;
	Scanner sc;
	Team t;
		
	public BaseBallPro(){
		map = new HashMap();
		sc = new Scanner(System.in);
	}
	protected void setTeam(){
		System.out.print("���ܸ��� �Է��ϼ���:");
		String team = sc.nextLine();
		t = new Team(team);
	}
	protected String getTeam(){
		System.out.print("���ܸ��� �Է��ϼ���:");
		String team = sc.nextLine();
		if(team.equals(t.getTeam())){
			return team;
		}else {
			System.out.println("���� ���� �����ϴ�.");
			return getTeam();
		}
	}
	protected String getGroup(){
		System.out.print("���ܸ��� �Է��ϼ���:");
		String result = sc.next();
		if(map.containsKey(result)){
			return result;
		}else{
			System.out.println("�߸��Է��Ͽ����ϴ�.");
			return getGroup();
		}
		
	}
	public void insert(){
		System.out.print("���ܸ��� �Է��ϼ���:");
		String group = sc.next();
		System.out.print("�̸��� �Է� : ");
		String name = sc.next();
		System.out.print("Ÿ���� �Է� : ");
		double AVG = sc.nextDouble();
		System.out.print("Ȩ�� ������ �Է� : ");
		int HR = sc.nextInt();
		System.out.print("Ÿ���� �Է� :");
		int HBI = sc.nextInt();
		if(map.containsKey(group)){
			map2 = (HashMap)map.get(group);
		}else{
			map2 = new HashMap();
		}
		map2.put(name, new BaseBall(name, AVG, HR, HBI));
		map.put(group, map2);
		
	}
	public void view(){
		String group = getGroup();
		HashMap view = (HashMap)map.get(group);
		Set set = view.keySet();
		for(Iterator it = set.iterator();it.hasNext();){
			String key=(String)it.next();
			BaseBall base = (BaseBall)view.get(key);
			base.disp();
		}
	}
	public void delete(){
		String group = getGroup();
		HashMap edit = (HashMap)map.get(group);
		System.out.print("������ ������ �̸� : ");
		String name = sc.next();
		if (edit.containsKey(name)){
			BaseBall base = (BaseBall)edit.get(name);
			System.out.print("Ÿ���� �Է� : ");
			base.setAVG(sc.nextDouble());
			System.out.print("Ȩ�� ������ �Է� : ");
			base.setHR(sc.nextInt());
			System.out.print("Ÿ���� �Է� : ");
			base.setRBI(sc.nextInt());
			System.out.println(group+"�� " + name+"���� ������ �����Ͽ����ϴ�.");
			return;
		}
		System.out.println(group+"�� " + name +"���� ������ �����ϴ�.");
	}
	public void edit(){
		String group = getGroup();
		HashMap delete = (HashMap)map.get(group);
		System.out.print("������ ������ �̸� : ");
		String name = sc.next();
		if (delete.containsKey(name)){
			delete.remove(name);
			System.out.println(group+"�� " + name+"���� ������ �����Ͽ����ϴ�.");
			return;
		}
		System.out.println(group+"�� " + name +"���� ������ �����ϴ�.");
	}
	public void exit(){
		System.out.println("���α׷��� �����մϴ�.");
		System.exit(0);
	}
}

public class FirstTest {
	public static void main(String[] args){
		BaseBallPro pro = new BaseBallPro();
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("1.�Է�  2.���  3.����  4.����  5.���� :");
			int select = sc.nextInt();
			switch(select){
			case 1: pro.insert(); break;
			case 2: pro.view(); break;
			case 3: pro.delete(); break;
			case 4: pro.edit(); break;
			case 5: pro.exit(); break;
			default : System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}
	}
}
