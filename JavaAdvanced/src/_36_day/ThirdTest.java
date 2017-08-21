package _36_day;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class Student{
	private String name;
	private int kor;
	private int eng;
	private int total;
	private int rank;
	
	public Student(String name, int kor, int eng){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		total = kor+eng;
		rank = 1;
	}
	public void setKor(int kor){
		this.kor = kor;
		setTotal();
	}
	public void setEng(int eng){
		this.eng = eng;
		setTotal();
	}
	public void setTotal(){
		total = kor+eng;
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
	public int getTotal(){
		return total;
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
}

class MyFrameThird extends JFrame implements ActionListener{
	private JTabbedPane jtb = new JTabbedPane();
	private JPanel[] jp = new JPanel[4];
	private JButton jbt1 = new JButton("추가");
	private JButton jbt2 = new JButton("수정");
	private JButton jbt3 = new JButton("삭제");
	private JPanel south_p = new JPanel();
	private JTextArea[] jp_ta = new JTextArea[4];
	
	private StudentPro pro;
	private int classNumber=0;
	
	public void init(){
		//설정
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		con.add("Center",  jtb);
		con.add("South", south_p);
		south_p.setLayout(new GridLayout(1, 3));
		south_p.add(jbt1);
		south_p.add(jbt2);
		south_p.add(jbt3);
		for(int i=0;i<jp.length;i++){
			jp[i] = new JPanel();
			jtb.add(i+1+"반", jp[i]);
			jp_ta[i] = new JTextArea();
			jp[i].add(jp_ta[i]);
		}
		
		pro = new StudentPro();
	}
	public void start(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jbt1.addActionListener(this);
		jbt2.addActionListener(this);
		jbt3.addActionListener(this);
	}
		
	public MyFrameThird(String title){
		super(title);
		this.init(); //모양설정 또는 초기값설정
		this.start(); //event설정
		this.setSize(600, 500);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int)screen.getWidth()/2-(int)this.getWidth()/2;
		int ypos = (int)screen.getHeight()/2-(int)this.getHeight()/2;
		this.setLocation(xpos, ypos);
		this.setResizable(false);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==jbt1){
			selectedNumber();
			pro.insert();
			pro.rank();
			StudentSetting(classNumber);
		}
		if(ae.getSource()==jbt2){
			selectedNumber();
			pro.edit();
			pro.rank();
			StudentSetting(classNumber);
		}
		if(ae.getSource()==jbt3){
			selectedNumber();
			pro.delete();
			pro.rank();
			StudentSetting(classNumber);
		}
	}
	public void selectedNumber(){
		for(int i=0;i<jp.length;i++){
			if(jtb.getSelectedIndex()==i) classNumber = i;
		}
	}
	public void StudentSetting(int classNumber){
		HashMap<String, Student> stu = pro.view(classNumber);
		
		jp_ta[classNumber].setText(classNumber+1+"반\n이름\t국어\t영어\t총점\t순위\t");	
		
		Set set = stu.keySet();
		Iterator it = set.iterator();
		while(it.hasNext()){
			String name = (String)it.next();
			Student view =(Student)stu.get(name);
			jp_ta[classNumber].append("\n"+view.getName()+"\t"+view.getKor()+"\t"+view.getEng()+"\t"+view.getTotal()+"\t"+view.getRank());
		}
	}
	
	class StudentPro{
		HashMap<Integer, HashMap<String, Student>> map;
		public StudentPro(){
			map = new HashMap<Integer, HashMap<String, Student>>();
			for(int i=0;i<jp.length;i++){
				map.put(i,  new HashMap<String, Student>());
			}
		}
		public void insert(){
			String name = JOptionPane.showInputDialog("이름을 입력하세요");
			String tmp_kor = JOptionPane.showInputDialog("국어점수를 입력하세요");
			int kor = Integer.parseInt(tmp_kor);
			String tmp_eng = JOptionPane.showInputDialog("영어점수를 입력하세요");
			int eng = Integer.parseInt(tmp_eng);
			Student insert = new Student(name, kor, eng);
			HashMap<String, Student> stu = map.get(classNumber);
			stu.put(name, insert);
			map.put(classNumber, stu);
		}
		public HashMap<String, Student> view(int classNumber){
			if(map.containsKey(classNumber)){
				HashMap<String, Student> stu = (HashMap<String, Student>)map.get(classNumber);
				return stu;
			}else {
				return null;
			}
		}
		
		protected void rank(){
			for(int i=0;i<jp.length;i++){
				HashMap<String, Student> stu = map.get(i);
				Set set = stu.keySet();
				for(Iterator it = set.iterator();it.hasNext();){
					String name=(String)it.next();
					Student rank = (Student)stu.get(name);
					rank.clearRank();
					
					for(Iterator it2=set.iterator(); it2.hasNext(); ){
						String name2 = (String)it2.next();
						Student rank2 = (Student)stu.get(name2);
						if (rank.getTotal()<rank2.getTotal()) rank.plusRank();
					}
					stu.put(name, rank);
					map.put(i, stu);
				}
			}
		}
		
		public void delete(){
			String name = JOptionPane.showInputDialog("삭제할 학생의 이름은?");
			HashMap<String, Student> stu = map.get(classNumber);
			stu.remove(name);
			map.put(classNumber, stu);
			
		}
		public void edit(){
			String name = JOptionPane.showInputDialog("수정할 학생의 이름은?");
			HashMap<String, Student> stu = map.get(classNumber);
			if(stu.containsKey(name)){
				Student edit = (Student)stu.get(name);
				if (edit.getName().equals(name)){
					String tmp_kor = JOptionPane.showInputDialog("수정할 국어점수는?");
					edit.setKor(Integer.parseInt(tmp_kor));
					String tmp_eng = JOptionPane.showInputDialog("수정할 영어점수는?");
					edit.setEng(Integer.parseInt(tmp_eng));
					stu.put(name, edit);
					map.put(classNumber, stu);
				}
			}else{
				JOptionPane.showMessageDialog(null, name+"님은 저희 학생이 아닙니다.");	
			}
		}
	}
}

public class ThirdTest {
	public static void main(String[] args) {
		MyFrameThird frame = new MyFrameThird("세번째 문제");
	}
}
