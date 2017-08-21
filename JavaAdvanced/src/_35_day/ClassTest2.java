package _35_day;

import java.awt.*;
import java.io.File;

import javax.swing.*;

class MyFrame02 extends JFrame{
	private ImageIcon ii1 = new ImageIcon("./src/_35_day/a.gif");
	private ImageIcon ii2 = new ImageIcon("./src/_35_day/b.gif");
	private ImageIcon ii3 = new ImageIcon("./src/_35_day/c.gif");
	private ImageIcon ii4 = new ImageIcon("./src/_35_day/d.gif");
	private JToggleButton jtb1 = new JToggleButton(ii1);
	private JToggleButton jtb2 = new JToggleButton(ii2);
	private JToggleButton jtb3 = new JToggleButton("버튼3", ii3);
	private JToggleButton jtb4 = new JToggleButton("버튼4", ii4);
	
	private ButtonGroup bg = new ButtonGroup();
	
	public void init(){
		//설정
		Container con = this.getContentPane();
		JFileChooser jfc = new JFileChooser(".");
		int res = jfc.showOpenDialog(this);
		if(res==0){
			File file = jfc.getSelectedFile();
			System.out.println(file);
		}
		//res가 0이면 파일 열기 선택, 그렇지 않으면 취소
		/*
		Color color = JColorChooser.showDialog(this, "색상선택!", Color.red);
		con.setBackground(color);
		*/
		/*
		con.setLayout(new GridLayout(1, 4));
		jtb1.setRolloverIcon(ii4);
		jtb2.setSelectedIcon(ii4);
		jtb2.setToolTipText("버튼을 누르면 4번 이미지가 나와요");
		bg.add(jtb1); con.add(jtb1);
		bg.add(jtb2); con.add(jtb2);
		jtb3.setHorizontalTextPosition(SwingConstants.CENTER);
		jtb3.setVerticalTextPosition(SwingConstants.BOTTOM);
		bg.add(jtb3); con.add(jtb3);
		bg.add(jtb4); con.add(jtb4);
		*/
	}
	public void start(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
	public MyFrame02(String title){
		super(title);
		this.init(); //모양설정 또는 초기값설정
		this.start(); //event설정
		this.setSize(500, 300);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int)screen.getWidth()/2-(int)this.getWidth()/2;
		int ypos = (int)screen.getHeight()/2-(int)this.getHeight()/2;
		this.setLocation(xpos, ypos);
		this.setResizable(false);
		this.setVisible(true);
		
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){}
		String name = JOptionPane.showInputDialog(this, "이름이 뭐니?", "질문", JOptionPane.QUESTION_MESSAGE);
		JOptionPane.showMessageDialog(this, name+"님이 입장하셨습니다.", "메시지", JOptionPane.WARNING_MESSAGE);
		/*
		int res = JOptionPane.showConfirmDialog(this, "반장아 대답 할꺼니?", "질문", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		System.out.println("res="+res);
		if(res==0){
			JOptionPane.showMessageDialog(this, "반장아, 고마워", "메세지", JOptionPane.WARNING_MESSAGE);
		}
		//JOptionPane.showMessageDialog(this, "반장아, 대답은 언제 해줄꺼니?", "메세지", JOptionPane.QUESTION_MESSAGE);
		*/
		
	}
}

public class ClassTest2 {
	public static void main(String[] args){
		MyFrame02 mf = new MyFrame02("swingTest");
	}
}
