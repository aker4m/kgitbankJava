package _30_day;

import java.awt.*;

class MyFrame01 extends Frame{
	private Label lb1 = new Label("당신이 좋아하는 연예인은?");
	private Checkbox cb1 = new Checkbox("장동건");
	private Checkbox cb2 = new Checkbox("박보검");
	private Checkbox cb3 = new Checkbox("수지");
	private Checkbox cb4 = new Checkbox("박보영");
	
	private Label lb2 = new Label("당신의 연령대는 어디입니까?");
	private CheckboxGroup cg = new CheckboxGroup();
	private Checkbox la1 = new Checkbox("10대", cg, false);
	private Checkbox la2 = new Checkbox("20대", cg, true);
	private Checkbox la3 = new Checkbox("30대", cg, false);
	private Checkbox la4 = new Checkbox("40대", cg, false);
	private Checkbox la5 = new Checkbox("기타", cg, false);
	
	private Panel p1 = new Panel();
	private GridLayout gl1 = new GridLayout(1, 4);
	private GridLayout gl = new GridLayout(4, 1);
	
	private Panel p2 = new Panel();
	private GridLayout gl2 = new GridLayout(1, 5);
	
	public void init(){
		this.setLayout(gl);
		this.add(lb1);
		this.add(p1);
		p1.setLayout(gl1);
		p1.add(cb1);
		p1.add(cb2);
		p1.add(cb3);
		p1.add(cb4);
		this.add(lb2);
		this.add(p2);
		p2.setLayout(gl2);
		p2.add(la1);
		p2.add(la2);
		p2.add(la3);
		p2.add(la4);
		p2.add(la5);
	}
	public MyFrame01(String title){
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

public class ClassTest1 {
	public static void main(String[] args){
		MyFrame01 mf = new MyFrame01("awt실습");
	}
}
