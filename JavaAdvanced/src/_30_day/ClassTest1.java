package _30_day;

import java.awt.*;

class MyFrame01 extends Frame{
	private Label lb1 = new Label("����� �����ϴ� ��������?");
	private Checkbox cb1 = new Checkbox("�嵿��");
	private Checkbox cb2 = new Checkbox("�ں���");
	private Checkbox cb3 = new Checkbox("����");
	private Checkbox cb4 = new Checkbox("�ں���");
	
	private Label lb2 = new Label("����� ���ɴ�� ����Դϱ�?");
	private CheckboxGroup cg = new CheckboxGroup();
	private Checkbox la1 = new Checkbox("10��", cg, false);
	private Checkbox la2 = new Checkbox("20��", cg, true);
	private Checkbox la3 = new Checkbox("30��", cg, false);
	private Checkbox la4 = new Checkbox("40��", cg, false);
	private Checkbox la5 = new Checkbox("��Ÿ", cg, false);
	
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
		MyFrame01 mf = new MyFrame01("awt�ǽ�");
	}
}
