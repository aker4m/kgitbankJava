package _36_day;

import java.awt.*;
import javax.swing.*;

class MyFrame02 extends JFrame{
	private JInternalFrame jif1 = new JInternalFrame("1번", true, true, true, true);
	private JInternalFrame jif2 = new JInternalFrame("2번", false, true, true, true);
	private JInternalFrame jif3 = new JInternalFrame("3번", true, false, true, true);
	private JInternalFrame jif4 = new JInternalFrame("4번", true, true, false, true);
	private JInternalFrame jif5 = new JInternalFrame("5번", true, true, true, false);
	private JDesktopPane jdp = new JDesktopPane();
	
	public void init(){
		//설정
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		con.add("Center", jdp);
		jif1.setBounds(10, 10, 200, 150);
		jif2.setBounds(20, 30, 200, 150);
		jif3.setBounds(30, 50, 200, 150);
		jif4.setBounds(40, 70, 200, 150);
		jif5.setBounds(50, 90, 200, 150);
		jif1.setVisible(true);
		jif2.setVisible(true);
		jif3.setVisible(true);
		jif4.setVisible(true);
		jif5.setVisible(true);
		jdp.add(jif1);
		jdp.add(jif2);
		jdp.add(jif3);
		jdp.add(jif4);
		jdp.add(jif5);
	}
	public void start(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
	public MyFrame02(String title){
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
}


public class ClassTest2 {
	public static void main(String[] args){
		MyFrame02 mf = new MyFrame02("두번째 실습");
	}
}
