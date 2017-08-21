package _29_day;

import java.awt.*;

class MyFrame2 extends Frame{
	private Label lb = new Label("반장아 대답 잘했어!!");
	private Button bt = new Button("반장아 대답!!");
	private Button bt1 = new Button("빨리 대답해1!!");
	private Button bt2 = new Button("빨리 대답해2!!");
	private Button bt3 = new Button("빨리 대답해3!!");
	private Button bt4 = new Button("빨리 대답해4!!");
	
	private BorderLayout bl = new BorderLayout(5, 10);
	//private GridLayout gl = new GridLayout(4,3, 5, 10);//컴포넌트를 적용하기 위해
	//행, 열, 좌우의 간격, 위아래 간격
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
		super.setSize(400, 300);//400, 300사이즈 크기의 프레임 만들기
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		//가로와 세로의 값을 저장하는 클래스
		int xpos = (int)screen.getWidth()/2 -(int)this.getWidth()/2;
		int ypos = (int)screen.getHeight()/2 -(int)this.getHeight()/2;
		super.setLocation(xpos, ypos);// xpos, ypos좌표에 프레임 표시
		
		super.setResizable(false);//사이즈 조절 못하게 하겠다.
		super.setVisible(true); // 화면에 나타나게 하겠다
	}
}

public class ClassTest2 {
	public static void main(String[] args){
		MyFrame2 mf = new MyFrame2("awt실습");
	}
}
