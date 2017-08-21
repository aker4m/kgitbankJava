package _30_day;

import java.awt.*;

class MyFrameFirst extends Frame{
	private Label lb = new Label("당신의 생년월일은?", Label.CENTER);
	private Label lb1 = new Label("년");
	private Label lb2 = new Label("월");
	private Label lb3 = new Label("일");
	private Choice ch1 = new Choice();
	private Choice ch2 = new Choice();
	private Choice ch3 = new Choice();
	private Font font = new Font("", Font.BOLD, 30);
	
	private GridLayout gl = new GridLayout(2, 1);
	private Panel p = new Panel();
	private GridLayout gl1 = new GridLayout(1, 6);
	public void init(){
		this.setLayout(new GridLayout(2, 1));
		lb.setFont(font);
		this.add(lb);
		this.add(p);
		p.setLayout(gl1);
		for(int i=1950;i<=2017;i++){
			ch1.add(String.valueOf(i));
		}
		p.add(ch1);
		p.add(lb1);
		for(int i=1;i<=12;i++){
			ch2.add(String.valueOf(i));
		}
		p.add(ch2);
		p.add(lb2);
		for(int i=1;i<=31;i++){
			ch3.add(String.valueOf(i));
		}
		p.add(ch3);
		p.add(lb3);
	}
	public MyFrameFirst(String title){
		super(title);
		
		init();
		this.setSize(400, 300);
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
		MyFrameFirst mf = new MyFrameFirst("첫번째 문제");
	}
}
