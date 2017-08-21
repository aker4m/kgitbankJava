package _30_day;
import java.awt.*;

class MyFrame02 extends Frame{
	private Label lb = new Label("당신의 혈액형은?");
	private Choice ch = new Choice();
	private Label lb2 = new Label("당신의 생년월일은?");
	private Choice year = new Choice();
	private Choice month = new Choice();
	private Choice day = new Choice();
	private Label y_lb = new Label("년", Label.LEFT);
	private Label m_lb = new Label("월", Label.LEFT);
	private Label d_lb = new Label("일", Label.LEFT);
	private Panel p = new Panel();
	private Panel p_1 = new Panel();
	private Panel p_2 = new Panel();
	private Panel p_3 = new Panel();
	
	public void init(){
		this.setLayout(new GridLayout(4, 1));
		this.add(lb);
		ch.add("A형");
		ch.add("B형");
		ch.add("O형");
		ch.add("AB형");
		ch.add("기타");
		this.add(ch);
		this.add(lb2);
		this.add(p);
		p.setLayout(new GridLayout(1, 6));
		p.add(p_1);
		p.add(p_2);
		p.add(p_3);
		p_1.setLayout(new BorderLayout());
		p_2.setLayout(new BorderLayout());
		p_3.setLayout(new BorderLayout());
		for(int i=2017;i>=1950;i--){
			year.add(String.valueOf(i));
		}
		p_1.add(year);
		p_1.add("East", y_lb);
		for(int i=1;i<=12;i++){
			month.add(String.valueOf(i));
		}
		p_2.add(month);
		p_2.add("East", m_lb);
		for(int i=1;i<=31;i++){
			day.add(String.valueOf(i));
		}
		p_3.add(day);
		p_3.add("East", d_lb);
	}
	public MyFrame02(String title){
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
public class ClassTest2 {
	public static void main(String[] args){
		MyFrame02 mf = new MyFrame02("awt실습02");
	}
}
