package _29_day;

import java.awt.*;

class MyFrame5 extends Frame{
	private Label lb = new Label("제목 : ");
	private TextField tf = new TextField();
	private TextArea ta = new TextArea();
	private Button bt = new Button("확인");
	
	private BorderLayout bl = new BorderLayout();
	private Panel north_p = new Panel();
	private BorderLayout north_bl = new BorderLayout();
	private Panel south_p = new Panel();
	private FlowLayout south_fl = new FlowLayout(FlowLayout.RIGHT);
	
	public void init(){
		this.setLayout(bl);
		this.add("North", north_p);
		this.add("Center", ta);
		this.add("South", south_p);
		north_p.setLayout(north_bl);
		north_p.add("West",  lb);
		north_p.add("Center",  tf);
		south_p.setLayout(south_fl);
		south_p.add(bt);
	}
	
	public MyFrame5(String title){
		super(title);
		
		init();
		this.setSize(300, 400);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int)screen.getWidth()/2-(int)this.getWidth()/2;
		int ypos = (int)screen.getHeight()/2-(int)this.getHeight()/2;
		this.setLocation(xpos, ypos);
		this.setResizable(false);
		this.setVisible(true);
	}
}

public class ClassTest5 {
	public static void main(String[] args){
		MyFrame5 mf = new MyFrame5("게시판");
	}
}
