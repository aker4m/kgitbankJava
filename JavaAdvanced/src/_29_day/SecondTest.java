package _29_day;

import java.awt.*;

class MyFrame extends Frame{
	private Label lb = new Label("전화기예제", Label.CENTER);
	private Button bt[] = new Button[12];
	private String str[] = new String[]{"*", "0", "#"};
	private Panel p = new Panel();
	
	private BorderLayout bl = new BorderLayout();
	private GridLayout gl = new GridLayout(4, 3);
	
	public void init(){
		this.setLayout(bl);
		this.add("North", lb);
		this.add("Center", p);
		p.setLayout(gl);
		for(int i=0;i<bt.length;i++){
			if(i<9) bt[i] = new Button(String.valueOf(i+1));
			else bt[i] = new Button(str[i-9]);
			p.add(bt[i]);
		}
	}
	public MyFrame(String title){
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
public class SecondTest {
	public static void main(String[] args){
		MyFrame mf = new MyFrame("SecondTest");
	}
}
