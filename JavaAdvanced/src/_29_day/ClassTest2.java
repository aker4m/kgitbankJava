package _29_day;

import java.awt.*;

class MyFrame2 extends Frame{
	private Label lb = new Label("����� ��� ���߾�!!");
	private Button bt = new Button("����� ���!!");
	private Button bt1 = new Button("���� �����1!!");
	private Button bt2 = new Button("���� �����2!!");
	private Button bt3 = new Button("���� �����3!!");
	private Button bt4 = new Button("���� �����4!!");
	
	private BorderLayout bl = new BorderLayout(5, 10);
	//private GridLayout gl = new GridLayout(4,3, 5, 10);//������Ʈ�� �����ϱ� ����
	//��, ��, �¿��� ����, ���Ʒ� ����
	//private FlowLayout fl = new FlowLayout(FlowLayout.RIGHT);
	public MyFrame2(String title){
		super(title);
		this.setLayout(bl);
		this.add("North", lb);
		this.add("South", bt);
		this.add("East", bt1);
		this.add("West", bt2);
		this.add("Center", bt3);
		this.add(bt4);
		super.setSize(400, 300);//400, 300������ ũ���� ������ �����
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		//���ο� ������ ���� �����ϴ� Ŭ����
		int xpos = (int)screen.getWidth()/2 -(int)this.getWidth()/2;
		int ypos = (int)screen.getHeight()/2 -(int)this.getHeight()/2;
		super.setLocation(xpos, ypos);// xpos, ypos��ǥ�� ������ ǥ��
		
		super.setResizable(false);//������ ���� ���ϰ� �ϰڴ�.
		super.setVisible(true); // ȭ�鿡 ��Ÿ���� �ϰڴ�
	}
}

public class ClassTest2 {
	public static void main(String[] args){
		MyFrame2 mf = new MyFrame2("awt�ǽ�");
	}
}
