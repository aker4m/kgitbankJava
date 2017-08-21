package _29_day;

import java.awt.*;

class NewFrame extends Frame{
	private Button bt = new Button("확인");
	private Button bt2 = new Button("아니오");
	private Button bt3 = new Button("아니오2");
	private Panel p1 = new Panel();
	private Panel p2 = new Panel();
	
	private BorderLayout bl = new BorderLayout();
	private GridLayout gl1 = new GridLayout(1, 2);
	private GridLayout gl2 = new GridLayout(2, 1);
	public NewFrame(String title){
		super(title);
		this.setLayout(bl);
		this.add("South", p1);
		p1.setLayout(gl1);
		p1.add(bt);
		p1.add(p2);
		p2.setLayout(gl2);
		p2.add(bt2);
		p2.add(bt3);
		
		this.setSize(300, 300);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int)screen.getWidth()/2-(int)this.getWidth()/2;
		int ypos = (int)screen.getHeight()/2-(int)this.getHeight()/2;
		this.setLocation(xpos, ypos);
		this.setResizable(false);
		this.setVisible(true);
	}
	
}

public class FirstTest {
	public static void main(String[] args){
		NewFrame mf = new NewFrame("첫번째 문제");
	}
}
