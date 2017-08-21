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
		System.out.print("���ܸ��� �Է� : ");
		String team = in.next();
		System.out.print("�����̸��� �Է� : ");
		String name = in.next();
		HashMap ball = (HashMap)map.get(team);
		if (ball==null) ball = new HashMap();//���ο� ���ܸ��� ��������
		if (ball.containsKey(name)){//NullPointException
			System.out.println(team+"���ܿ��� " + name+"������ �̹� �����մϴ�.");
			insert();
			return;
		}
		System.out.print("Ÿ���� �Է� : ");
		double avg = in.nextDouble();
		System.out.print("Ȩ���� ���� �Է� : ");
		int homerun = in.nextInt();
		System.out.print("Ÿ���� �Է� : ");
		int rbi = in.nextInt();
		BaseBall insert = new BaseBall(name, avg, homerun, rbi); 
		ball.put(name, insert);
		map.put(team, ball);
	}
	public void view(){
		System.out.print("���ܸ��� �Է� : ");
		String team = in.next();
		if (map.containsKey(team)){
			HashMap ball = (HashMap)map.get(team);
			//���� ���ܸ����� ������ ����� ���� HashMap�� ����
			Set set = ball.keySet();//�ش� Hashtable�� key���� �� ����
			Iterator it = set.iterator();
			while(it.hasNext()){
				String name = (String)it.next();//key���� �ϳ� ���ϰ�
				BaseBall view = (BaseBall)ball.get(name);//���� key���� �ش��ϴ� ��������� ������
				view.disp();//����Ѵ�
			}
		}else {
			System.out.println("��ϵ��� ���� ���ܸ� �Դϴ�.");
		}
	}
	public void delete(){
		System.out.print("���ܸ��� �Է� : ");
		String team = in.next();
		HashMap ball = (HashMap)map.get(team);
		if (ball==null) {
			System.out.println("�ش��ϴ� ������ �����ϴ�.");
			delete();
			return;
		}
		System.out.print("�����̸��� �Է� : ");
		String name = in.next();
		if (ball.containsKey(name)){
			System.out.println(team+"������ " + name+"���� �����Ͽ����ϴ�.");
			ball.remove(name);
			return;
		}else {
			System.out.println(name+"���� " + team+"������ ������ �ƴմϴ�.");
		}
	}
	public void edit(){
		System.out.print("���ܸ��� �Է� : ");
		String team = in.next();
		HashMap ball = (HashMap)map.get(team);
		if (ball==null) {
			System.out.println("�ش��ϴ� ������ �����ϴ�.");
			edit();
			return;
		}
		System.out.print("�����̸��� �Է� : ");
		String name = in.next();
		if (ball.containsKey(name)){
			BaseBall edit = (BaseBall)ball.get(name);
			System.out.print("Ÿ���� �Է� : ");
			double avg = in.nextDouble();
			System.out.print("Ȩ���� ���� �Է� : ");
			int homerun = in.nextInt();
			System.out.print("Ÿ���� �Է� : ");
			int rbi = in.nextInt();
			edit.setAvg(avg);
			edit.setHomerun(homerun);
			edit.setRbi(rbi);
			System.out.println(team+"������ " + name+"������ �ڷḦ �����Ͽ����ϴ�.");
		}else {
			System.out.println(name+"���� " + team+"������ ������ �ƴմϴ�.");
		}
	}
	public void exit(){
		System.out.println("���α׷��� �����մϴ�.");
		System.exit(0);
	}
}
