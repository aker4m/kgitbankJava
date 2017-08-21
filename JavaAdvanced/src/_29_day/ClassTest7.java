package _29_day;

import java.awt.*;
import java.util.*;
class MyFrame7 extends Frame{

	private Label lb[] = new Label[7];
	private String lb_str[] = new String[]{"일","월","화","수","목","금","토"};
	private Button bt[] = new Button[42];
		
	private BorderLayout bl = new BorderLayout();
	private Panel lb_p = new Panel();
	private GridLayout gl = new GridLayout(1,7);
	private Panel bt_p = new Panel();
	private GridLayout bt_gl = new GridLayout(6,7);

	private Calendar cal;
	
	public void init(){
		this.setLayout(bl);
		this.add("North", lb_p);
		this.add("Center", bt_p);
		lb_p.setLayout(gl);
		bt_p.setLayout(bt_gl);
		for(int i=0; i<lb.length; ++i){
			lb[i] = new Label(lb_str[i], Label.CENTER);
			lb_p.add(lb[i]);
		}
		buttonSetting();
		for(int i=0; i<bt.length; ++i){
			bt_p.add(bt[i]);
		}
	}
	public void buttonSetting(){
		int week = cal.get(Calendar.DAY_OF_WEEK);
		int co = 0;
		for(int i=1; i<week; ++i){
			bt[co] = new Button("");
			bt[co].setEnabled(false);
			co++;
		}
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		for(int i=1; i<=lastDay; ++i){
			bt[co] = new Button(String.valueOf(i));
			co++;
		}
		for(int i=co; i<bt.length; ++i){
			bt[i] = new Button("");
			bt[i].setEnabled(false);
		}
	}
	public MyFrame7(String title, int year, int month){
		super(title);
		cal = Calendar.getInstance();
		cal.set(year, month-1, 1);
		this.init();
		super.setSize(400, 300);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

		int xpos = (int)screen.getWidth()/2 - this.getWidth()/2;
		int ypos = (int)screen.getHeight()/2 - this.getHeight()/2;
		super.setLocation(xpos, ypos);
		
		super.setResizable(false);
		super.setVisible(true);
	}
}
public class ClassTest7 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("년도를 입력 : ");
		int year = in.nextInt();
		System.out.print("월을 입력 : ");
		int month = in.nextInt();
		MyFrame7 mf = new MyFrame7("계산기", year, month);
	}
}