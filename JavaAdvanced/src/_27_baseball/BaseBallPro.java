package _27_baseball;
import java.util.*;
public class BaseBallPro {
	HashMap map;
	Scanner in;
	public BaseBallPro(){
		map = new HashMap();
		in = new Scanner(System.in);
	}
	public void insert(){
		System.out.print("구단명을 입력 : ");
		String team = in.next();
		System.out.print("선수이름을 입력 : ");
		String name = in.next();
		HashMap ball = (HashMap)map.get(team);
		if (ball==null) ball = new HashMap();//새로운 구단명이 들어왔을때
		if (ball.containsKey(name)){//NullPointException
			System.out.println(team+"구단에는 " + name+"선수가 이미 존재합니다.");
			insert();
			return;
		}
		System.out.print("타율을 입력 : ");
		double avg = in.nextDouble();
		System.out.print("홈런의 수를 입력 : ");
		int homerun = in.nextInt();
		System.out.print("타점을 입력 : ");
		int rbi = in.nextInt();
		BaseBall insert = new BaseBall(name, avg, homerun, rbi); 
		ball.put(name, insert);
		map.put(team, ball);
	}
	public void view(){
		System.out.print("구단명을 입력 : ");
		String team = in.next();
		if (map.containsKey(team)){
			HashMap ball = (HashMap)map.get(team);
			//구한 구단명으로 구단의 명단을 담은 HashMap을 추출
			Set set = ball.keySet();//해당 Hashtable에 key값을 또 추출
			Iterator it = set.iterator();
			while(it.hasNext()){
				String name = (String)it.next();//key값을 하나 구하고
				BaseBall view = (BaseBall)ball.get(name);//구한 key값에 해당하는 선수명단을 구한후
				view.disp();//출력한다
			}
		}else {
			System.out.println("등록되지 않은 구단명 입니다.");
		}
	}
	public void delete(){
		System.out.print("구단명을 입력 : ");
		String team = in.next();
		HashMap ball = (HashMap)map.get(team);
		if (ball==null) {
			System.out.println("해당하는 구단이 없습니다.");
			delete();
			return;
		}
		System.out.print("선수이름을 입력 : ");
		String name = in.next();
		if (ball.containsKey(name)){
			System.out.println(team+"구단의 " + name+"님을 삭제하였습니다.");
			ball.remove(name);
			return;
		}else {
			System.out.println(name+"님은 " + team+"구단의 선수가 아닙니다.");
		}
	}
	public void edit(){
		System.out.print("구단명을 입력 : ");
		String team = in.next();
		HashMap ball = (HashMap)map.get(team);
		if (ball==null) {
			System.out.println("해당하는 구단이 없습니다.");
			edit();
			return;
		}
		System.out.print("선수이름을 입력 : ");
		String name = in.next();
		if (ball.containsKey(name)){
			BaseBall edit = (BaseBall)ball.get(name);
			System.out.print("타율을 입력 : ");
			double avg = in.nextDouble();
			System.out.print("홈런의 수를 입력 : ");
			int homerun = in.nextInt();
			System.out.print("타점을 입력 : ");
			int rbi = in.nextInt();
			edit.setAvg(avg);
			edit.setHomerun(homerun);
			edit.setRbi(rbi);
			System.out.println(team+"구단의 " + name+"선수의 자료를 수정하였습니다.");
		}else {
			System.out.println(name+"님은 " + team+"구단의 선수가 아닙니다.");
		}
	}
	public void exit(){
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
	}
}
