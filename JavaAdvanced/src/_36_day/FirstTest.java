package _36_day;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyImage extends Canvas{
	private Image img = null;
	public void setImage(Image img){
		this.img = img;
	}
	public void paint(Graphics g){
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}
}

class MyFrameFirst extends JFrame implements ActionListener{
	private JTabbedPane jtb = new JTabbedPane();
	private String[] str = new String[]{"유재석", "박명수", "정준하", "하하", "양세형"};
	private JPanel[] jp  = new JPanel[5];
	private MyImage img = new MyImage();
	
	public void init(){
		//설정
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		con.add("Center", jtb);
		for(int i=0;i<jp.length;i++){
			jtb.add(str[i], jp[i]);
			
		}
		
	}
	public void start(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
		
	public MyFrameFirst(String title){
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
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		Image image = null;
		if(ae.getSource()==jp[0]){
			image = Toolkit.getDefaultToolkit().getImage("./src/_36_day/유재석.jpg");
		}
		img.setImage(image);
		img.repaint();
	}
}

public class FirstTest {
	public static void main(String[] args){
		MyFrameFirst frame = new MyFrameFirst("첫번째 문제");
	}
}
