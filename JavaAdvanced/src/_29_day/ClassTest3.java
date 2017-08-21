package _29_day;

import java.awt.*;

class MyFrame3 extends Frame{
	private Button bt = new Button("YES");
	private Button bt2 = new Button("NO");
	private Button bt3 = new Button("NO2");
	
	private Panel p1 = new Panel();
	private Panel p2 = new Panel();
	
	private BorderLayout bl = new BorderLayout();
	private GridLayout gl1 = new GridLayout(1,2);
	private GridLayout gl2 = new GridLayout(2,1);

	public MyFrame3(String title){
		super(title);
		this.setLayout(bl);
		this.add("South", p1);
		p1.setLayout(gl1);
		p1.add(bt);
		p1.add(p2);
		p2.setLayout(gl2);
		p2.add(bt2);
		p2.add(bt3);

		super.setSize(400, 300);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

		int xpos = (int)screen.getWidth()/2 - this.getWidth()/2;
		int ypos = (int)screen.getHeight()/2 - this.getHeight()/2;
		super.setLocation(xpos, ypos);
		
		super.setResizable(false);
		super.setVisible(true);
	}
}
public class ClassTest3 {
	public static void main(String[] args){
		new MyFrame3("awt½Ç½À");
	}
}
