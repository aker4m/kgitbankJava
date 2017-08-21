package _30_day;

import java.awt.*;

class MyFrameSecond extends Frame{
	private Button[] bt = new Button[9];
	private String[] str = new String[]{"포도", "사과", "딸기", 
			"귤", "수박", "감", "레몬", "오렌지", "멜론"};
	private Label lb = new Label("선택과일\n---------");
	private TextArea ta = new TextArea(10, 10);
	
	private BorderLayout bl1 = new BorderLayout();
	private Panel p1 = new Panel();
	private GridLayout gl = new GridLayout(3, 3);
	private Panel p2 = new Panel();
	private BorderLayout bl2 = new BorderLayout();
	
	public void init(){
		this.setLayout(bl1);
		this.add(p1);
		this.add("East", p2);
		p2.setLayout(bl2);
		p2.add("North", lb);
		p2.add("Center", ta);
		p1.setLayout(gl);
		for(int i = 0;i<bt.length;i++){
			bt[i]= new Button(str[i]);
			p1.add(bt[i]);
		}
	}
	public MyFrameSecond(String title){
		super(title);
		
		init();
		this.setSize(400, 300);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int)screen.getWidth()/2-(int)this.getWidth()/2;
		int ypos = (int)screen.getHeight()/2-(int)this.getHeight()/2;
		this.setLocation(xpos, ypos);
		//this.setResizable(false);
		this.setVisible(true);
		
	}
}
public class SecondTest {
	public static void main(String[] args){
		MyFrameSecond mfs = new MyFrameSecond("awt실습02");
	}
}
