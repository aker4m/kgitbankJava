package _36_day;

import java.awt.*;
import javax.swing.*;

class MyFrame03 extends JFrame{
	private JToolBar jtb = new JToolBar();
	private JButton jbt1 = new JButton("1��");
	private JButton jbt2 = new JButton("2��");
	private JButton jbt3 = new JButton("3��");
	private JButton jbt4 = new JButton("4��");
	
	public void init(){
		//����
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		con.add("North", jtb);
		jtb.add(jbt1);
		jtb.addSeparator();
		jtb.add(jbt2);
		jtb.add(jbt3);
		jtb.addSeparator();
		jtb.add(jbt4);
		
	}
	public void start(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
	public MyFrame03(String title){
		super(title);
		this.init(); //��缳�� �Ǵ� �ʱⰪ����
		this.start(); //event����
		this.setSize(400, 300);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int)screen.getWidth()/2-(int)this.getWidth()/2;
		int ypos = (int)screen.getHeight()/2-(int)this.getHeight()/2;
		this.setLocation(xpos, ypos);
		this.setResizable(false);
		this.setVisible(true);
	}
}

public class ClassTest3 {
	public static void main(String[] args){
		MyFrame03 mf = new MyFrame03("����° �ǽ�");
	}
}
