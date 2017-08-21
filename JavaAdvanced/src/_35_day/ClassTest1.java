package _35_day;

import java.awt.*;
import javax.swing.*;

class MyFrame01 extends JFrame{
	/*
	JButton jbt1 = new JButton("aaa");
	JButton jbt2 = new JButton("bbb");
	*/
	public void init(){
		//설정
		Container con = this.getContentPane();
		/*
		con.setLayout(new GridLayout(2, 1));
		con.add(jbt1);
		con.add(jbt2);
		*/
	}
	public void start(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void pain(Graphics g){
		
	}
	public void stop(){
		
	}
	public void destroy(){
		
	}
	
	public MyFrame01(String title){
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

public class ClassTest1 {
	public static void main(String[] args){
		MyFrame01 mf = new MyFrame01("swingTest");
	}
}
