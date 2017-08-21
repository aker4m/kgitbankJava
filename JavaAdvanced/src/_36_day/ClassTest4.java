package _36_day;

import java.awt.*;
import javax.swing.*;

class MyFrame04 extends JFrame{
	private JTabbedPane jtb = new JTabbedPane();
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();
	private JPanel jp3 = new JPanel();
	private JPanel jp4 = new JPanel();
	
	public void init(){
		//설정
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		con.add("Center",  jtb);
		jp1.setBackground(Color.red);
		jp2.setBackground(Color.blue);
		jp3.setBackground(Color.green);
		jp4.setBackground(Color.yellow);
		jtb.add("홍길동",  jp1);
		jtb.add("유재석",  jp2);
		jtb.add("김연아",  jp3);
		jtb.add("류현진",  jp4);
		
		
	}
	public void start(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
	public MyFrame04(String title){
		super(title);
		this.init(); //모양설정 또는 초기값설정
		this.start(); //event설정
		this.setSize(400, 300);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int)screen.getWidth()/2-(int)this.getWidth()/2;
		int ypos = (int)screen.getHeight()/2-(int)this.getHeight()/2;
		this.setLocation(xpos, ypos);
		this.setResizable(false);
		this.setVisible(true);
	}
}

public class ClassTest4 {
	public static void main(String[] args){
		MyFrame04 mf = new MyFrame04("탭보드");
	}
}
