package _27_day;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

class BaseBall{
	private String name;
	private double AVG; // Bating Average, 타율
	private int HR; // Home Run, 홈런
	private int RBI; // Run Batted In, 타점
	
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
		System.out.println(name+" 선수의 타율 : "+AVG+", 홈런 수: "+HR+	", 타점: "+RBI);
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
		System.out.print("구단명을 입력하세요:");
		String team = sc.nextLine();
		t = new Team(team);
	}
	protected String getTeam(){
		System.out.print("구단명을 입력하세요:");
		String team = sc.nextLine();
		if(team.equals(t.getTeam())){
			return team;
		}else {
			System.out.println("같은 팀이 없습니다.");
			return getTeam();
		}
	}
	protected String getGroup(){
		System.out.print("구단명을 입력하세요:");
		String result = sc.next();
		if(map.containsKey(result)){
			return result;
		}else{
			System.out.println("잘못입력하였습니다.");
			return getGroup();
		}
		
	}
	public void insert(){
		System.out.print("구단명을 입력하세요:");
		String group = sc.next();
		System.out.print("이름을 입력 : ");
		String name = sc.next();
		System.out.print("타율을 입력 : ");
		double AVG = sc.nextDouble();
		System.out.print("홈런 개수를 입력 : ");
		int HR = sc.nextInt();
		System.out.print("타점을 입력 :");
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
		System.out.print("수정할 명함의 이름 : ");
		String name = sc.next();
		if (edit.containsKey(name)){
			BaseBall base = (BaseBall)edit.get(name);
			System.out.print("타율을 입력 : ");
			base.setAVG(sc.nextDouble());
			System.out.print("홈런 개수를 입력 : ");
			base.setHR(sc.nextInt());
			System.out.print("타점을 입력 : ");
			base.setRBI(sc.nextInt());
			System.out.println(group+"에 " + name+"님의 명함을 수정하였습니다.");
			return;
		}
		System.out.println(group+"에 " + name +"님의 명함은 없습니다.");
	}
	public void edit(){
		String group = getGroup();
		HashMap delete = (HashMap)map.get(group);
		System.out.print("삭제할 선수의 이름 : ");
		String name = sc.next();
		if (delete.containsKey(name)){
			delete.remove(name);
			System.out.println(group+"에 " + name+"님의 명함을 삭제하였습니다.");
			return;
		}
		System.out.println(group+"에 " + name +"님의 명함은 없습니다.");
	}
	public void exit(){
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
	}
}

public class FirstTest {
	public static void main(String[] args){
		BaseBallPro pro = new BaseBallPro();
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("1.입력  2.출력  3.삭제  4.수정  5.종료 :");
			int select = sc.nextInt();
			switch(select){
			case 1: pro.insert(); break;
			case 2: pro.view(); break;
			case 3: pro.delete(); break;
			case 4: pro.edit(); break;
			case 5: pro.exit(); break;
			default : System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
}
