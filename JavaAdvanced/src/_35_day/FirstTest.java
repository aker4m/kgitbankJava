package _35_day;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Name{
	public static final String TEAMNAME[] = new String[]
			{"두산","NC","넥센","LG", "KIA", "SK", "한화", "롯데", "삼성", "KT"};
	public static final String BUTTONNAME[] = new String[]
			{"추가", "트레이드", "은퇴", "수정"};
	public static final String INPUTLABEL[] = new String[]
			{"이름", "타율", "홈런", "타점"};
	public static final String TRADELABEL[] = new String[]
			{"이름", "옮길팀"};
	public static final String EDITLABEL[] = new String[]
			{"타율", "홈런", "타점"};
}

class Member{
	private String name;
	private double avg;
	private int homerun;
	private int rbi;
	public Member(String name, double avg, int homerun, int rbi){
		this.name = name;
		this.avg = avg;
		this.homerun = homerun;
		this.rbi = rbi;
	}
	public void setAvg(double avg){
		this.avg = avg;
	}
	public void setHomerun(int homerun){
		this.homerun = homerun;
	}
	public void setRbi(int rbi){
		this.rbi = rbi;
	}
	public String getName(){
		return name;
	}
	public double getAvg(){
		return avg;
	}
	public int getHomerun(){
		return homerun;
	}
	public int getRbi(){
		return rbi;
	}
}



class MyFrameFirst extends Frame implements MouseListener{
	private Button[] team_bt = new Button[Name.TEAMNAME.length];
	private Button[] info_bt = new Button[Name.BUTTONNAME.length];
	
	private Panel team_p = new Panel();
	private Panel center_p = new Panel();
	private Panel main_p = new Panel();
	private Panel info_p = new Panel();
	private TextArea center_ta = new TextArea();
	
	private Dialog input_dlg = new Dialog(this, "입력");
	private Panel[] input_p = new Panel[Name.INPUTLABEL.length];
	private Label[] input_lb = new Label[Name.INPUTLABEL.length];
	private TextField[] input_tf = new TextField[Name.INPUTLABEL.length];
	private Button input_bt = new Button("입력");
	
	private Dialog trade_dlg = new Dialog(this, "트레이드");
	private Panel[] trade_p = new Panel[Name.TRADELABEL.length];
	private Label[] trade_lb = new Label[Name.TRADELABEL.length];
	private TextField[] trade_tf = new TextField[Name.TRADELABEL.length];
	private Button trade_bt = new Button("트레이드");
	
	private Dialog delete_dlg = new Dialog(this, "은퇴");
	private Panel delete_p = new Panel();
	private Label delete_lb = new Label("이름");
	private TextField delete_tf = new TextField();
	private Button delete_bt = new Button("은퇴");
	
	private Dimension screen = null;
	private MemberPro pro = new MemberPro();
	int teamNumber;
	
	
	
	public void init(){
		this.setLayout(new BorderLayout());
		team_p.setPreferredSize(new Dimension(100, 300));
		
		//구단명을 나타내는 곳
		this.add("West", team_p);
		team_p.setLayout(new GridLayout(10, 1));
		for(int i=0;i<team_bt.length;i++){
			team_bt[i]= new Button(Name.TEAMNAME[i]);
			team_p.add(team_bt[i]);
		}
		//중앙을 나타내는 곳
		this.add("Center", center_p);
		center_p.setLayout(new BorderLayout());
		center_p.add("Center", center_ta);
		center_p.add("South", info_p);
		info_p.setLayout(new GridLayout(1, 4));
		for(int i=0;i<info_bt.length;i++){
			info_bt[i] = new Button(Name.BUTTONNAME[i]);
			info_p.add(info_bt[i]);
		}
		buttonOff();
		input_dlg_setting();
		trade_dlg_setting();
		delete_dlg_setting();
		edit_dlg_setting();
	}
	protected void delete_dlg_setting(){
		delete_dlg.setLayout(new GridLayout(2, 1));
		delete_dlg.add(delete_p);
		delete_p.setLayout(new BorderLayout());
		delete_p.add("West", delete_lb);
		delete_p.add("Center", delete_tf);
		Panel p = new Panel();
		p.setLayout(new FlowLayout());
		p.add(delete_bt);
		delete_dlg.add(p);
	}
	protected void edit_dlg_setting(){
		
	}
	protected void trade_dlg_setting(){
		trade_dlg.setLayout(new GridLayout(3, 1));
		for(int i=0;i<Name.TRADELABEL.length;i++){
			trade_p[i] = new Panel();
			trade_dlg.add(trade_p[i]);
			trade_p[i].setLayout(new BorderLayout());
			trade_lb[i] = new Label(Name.TRADELABEL[i], Label.RIGHT);
			trade_tf[i] = new TextField();
			trade_p[i].add("West", trade_lb[i]);
			trade_p[i].add("Center", trade_tf[i]);
		}
		Panel p = new Panel();
		p.setLayout(new FlowLayout());
		p.add(trade_bt);
		trade_dlg.add(p);
	}
	protected void input_dlg_setting(){
		//추가 버튼을 눌렀을때 나타나는 Dialog를 설정하는 곳
				input_dlg.setLayout(new GridLayout(5,1));
				for(int i=0; i<Name.INPUTLABEL.length; ++i){
					input_p[i] = new Panel();
					input_dlg.add(input_p[i]);	
					input_p[i].setLayout(new BorderLayout());
					input_lb[i] = new Label(Name.INPUTLABEL[i], Label.RIGHT);
					input_tf[i] = new TextField();
					input_p[i].add("West", input_lb[i]);
					input_p[i].add("Center", input_tf[i]);
				}
				Panel p = new Panel();
				p.setLayout(new FlowLayout());
				p.add(input_bt);
				input_dlg.add(p);
	}
	
	public void start(){
		for(int i=0;i<team_bt.length;i++){
			team_bt[i].addMouseListener(this);
		}
		for(int i=0;i<info_bt.length;i++){
			info_bt[i].addMouseListener(this);
		}
		input_bt.addMouseListener(this);
		trade_bt.addMouseListener(this);
		delete_bt.addMouseListener(this);
	}
	
	public void buttonOff(){
		for(int i=0;i<info_bt.length;i++){
			info_bt[i].setEnabled(false);
		}
	}
	public void buttonOn(){
		for(int i=0;i<info_bt.length;i++){
			info_bt[i].setEnabled(true);
		}
	}
	
	public MyFrameFirst(String title){
		super(title);
		this.init();
		this.start();
		this.setSize(700, 600);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int)screen.getWidth()/2-(int)this.getWidth()/2;
		int ypos = (int)screen.getHeight()/2-(int)this.getHeight()/2;
		this.setLocation(xpos, ypos);
		this.setResizable(false);
		this.setVisible(true);
		
		WindowAdapter wa = new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		};
		this.addWindowListener(wa);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void mouseReleased(MouseEvent me) {
		// TODO Auto-generated method stub
		if(me.getSource()==input_bt){
			process(4);
			input_dlg.setVisible(false);
			MemberSetting(teamNumber);
		}else if(me.getSource()==trade_bt){
			process(5);
			trade_dlg.setVisible(false);
			MemberSetting(teamNumber);
		}else if(me.getSource()==delete_bt){
			process(6);
			delete_dlg.setVisible(false);
			MemberSetting(teamNumber);
		}
		for(int i=0;i<team_bt.length;i++){
			if(me.getSource()==team_bt[i]){
				teamNumber = i;
				buttonOn();
				MemberSetting(teamNumber);
			}
		}
		for(int i=0;i<info_bt.length;i++){
			if(me.getSource()==info_bt[i]){
				process(i);
			}
		}
	}
	
	public void process(int i){
		switch(i){
		case 0: pro.insert_view();break;
		case 1: pro.trade_view();break;
		case 2: pro.delete_view();break;
		case 3: pro.edit();break;
		case 4: pro.insert();break;
		case 5: pro.trade();break;
		case 6: pro.delete();break;
		}
	}
	
	public void MemberSetting(int i){
		HashMap ball = pro.view(i);
		center_ta.setText(Name.TEAMNAME[i]+"\n이름\t타율\t홈런\t타점\n");
		if(ball == null){
			return ;
		}
		Set set = ball.keySet();
		Iterator it = set.iterator();
		while(it.hasNext()){
			String name = (String)it.next();
			Member view = (Member)ball.get(name);
			center_ta.append(view.getName()+"\t"+view.getAvg()+"\t"+view.getHomerun()+"\t"+view.getRbi()+"\n");
		}
	}
	
	class MemberPro{
		HashMap<Integer, HashMap<String, Member>> map;
		public MemberPro(){
			map = new HashMap<Integer, HashMap<String, Member>>();
			for(int i=0;i<Name.TEAMNAME.length;i++){
				map.put(i, new HashMap<String, Member>());
			}
		}
		public void trade_view(){
			trade_dlg.setSize(200, 100);
			int xpos = (int)screen.getWidth()/2-100;
			int ypos = (int)screen.getHeight()/2-100;
			trade_dlg.setLocation(xpos, ypos);
			trade_dlg.setResizable(false);
			trade_dlg.setVisible(true);
		}
		public void trade(){
			String name = trade_tf[0].getText();
			String tradeTeam = trade_tf[1].getText();
			int tradeTeamNumber =0;
			for(int i=0;i<Name.TEAMNAME.length;i++){
				if(tradeTeam.equals(Name.TEAMNAME[i])){
					tradeTeamNumber = i;
					break;
				}
			}
			HashMap<String, Member> team = map.get(tradeTeamNumber);
			Member trade = team.get(name);
			team.remove(name);
			map.put(teamNumber, team);
			HashMap<String, Member> tteam = map.get(tradeTeamNumber);
			tteam.put(trade.getName(), trade);
			map.put(tradeTeamNumber, tteam);
		}
		public void insert_view(){
			
		}
		public void insert(){
			String name = input_tf[0].getText();
			double avg = Double.parseDouble(input_tf[1].getText());
			int home = Integer.parseInt(input_tf[2].getText());
			int rbi = Integer.parseInt(input_tf[3].getText());
			Member insert = new Member(name, avg, home, rbi);
			HashMap<String, Member> team = map.get(teamNumber);
			team.put(name, insert);
			map.put(teamNumber, team);
			for(int i=0;i<input_tf.length;i++){
				input_tf[i].setText("");
			}
		}
		public HashMap view(int i){
			if(map.containsKey(i)){
				HashMap ball = (HashMap)map.get(i);
				return ball;
			}else {
				return null;
			}
		}
		public void delete_view(){
			delete_dlg.setSize(200,100);
			int xpos = (int)screen.getWidth()/2 - 100;
			int ypos = (int)screen.getHeight()/2 - 100;
			delete_dlg.setLocation(xpos, ypos);
			delete_dlg.setResizable(false);
			delete_dlg.setVisible(true);
		}
		public void delete(){
			String name = delete_tf.getText();
			HashMap<String, Member> team = map.get(teamNumber);
			team.remove(name);
			map.put(teamNumber, team);
		}
		public void edit(){
			
		}
		public void exit(){
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
		}
	}
}

public class FirstTest {

	public static void main(String[] args) {
		MyFrameFirst mff = new MyFrameFirst("선수정보 관리 프로그램");
	}

}
