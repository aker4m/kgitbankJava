package _29_day;

import java.awt.*;
class MyFrame4 extends Frame{
	private Label lb = new Label("전화기예제", Label.CENTER);
	private Button bt[] = new Button[12];
	private String str[] = new String[]{"*", "0", "#"};
	private Font font = new Font("consolas", Font.BOLD, 30);	
	//Font.BOLD - 굵은 글씨
	//Font.ITALIC - 기울림체
	//Font.PLAIN - 일반글씨
	
	private BorderLayout bl = new BorderLayout();
	private Panel p = new Panel();
	private GridLayout gl = new GridLayout(4,3);
	
	public void init(){
		Color color = new Color(180, 230, 20);
		Cursor cur = new Cursor(Cursor.HAND_CURSOR);
		this.setLayout(bl);
		this.setCursor(cur);
		lb.setFont(font);
		lb.setForeground(color);
		this.add("North", lb);
		this.add("Center", p);
		p.setLayout(gl);
		for(int i=0; i<bt.length; ++i){
			if (i<9) bt[i] = new Button(String.valueOf(i+1));
			else bt[i] = new Button(str[i-9]);
			bt[i].setFont(new Font("", Font.ITALIC, 25));
			bt[i].setBackground(Color.BLUE);
			bt[i].setForeground(Color.YELLOW);
			p.add(bt[i]);
		}
	}
	public MyFrame4(String title){
		super(title);
		this.init();
		super.setSize(300, 400);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

		int xpos = (int)screen.getWidth()/2 - this.getWidth()/2;
		int ypos = (int)screen.getHeight()/2 - this.getHeight()/2;
		super.setLocation(xpos, ypos);
		
		super.setResizable(false);
		super.setVisible(true);
	}
}
public class ClassTest4 {
	public static void main(String[] args){
		MyFrame4 mf = new MyFrame4("전화기예제");
	}
}
