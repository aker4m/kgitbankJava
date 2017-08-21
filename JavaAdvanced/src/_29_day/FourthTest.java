package _29_day;

import java.awt.*;
import java.util.Calendar;
import java.util.Scanner;


class FourthFrame extends Frame{
		
	private Label[] lb = new Label[7];
	private String[] str = new String[]{"일", "월", "화", "수", "목", "금", "토"};
	private Button[] bt	 = new Button[35];
	
	private Panel p = new Panel();
	private BorderLayout bl = new BorderLayout();
	private GridLayout gl = new GridLayout(6, 7, 5, 5);
	
	public void init(){
		Scanner in = new Scanner(System.in);
		
		System.out.print("년도를 입력: ");
		int year = in.nextInt();
		System.out.print("월을 입력 : ");
		int month = in.nextInt();
		
		TextField tf = new TextField(year+"년"+month+"월");
		
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, 1);
		int week = cal.get(Calendar.DAY_OF_WEEK);
				
				
		this.setLayout(bl);
		this.add("North", tf);
		this.add("Center", p);
		p.setLayout(gl);
		for(int i=0;i<lb.length;i++){
			lb[i]= new Label(str[i], Label.CENTER);
			p.add(lb[i]);
		}
		for(int i=1;i<week; ++i){
			bt[i]= new Button();
			bt[i].setEnabled(false);
			p.add(bt[i]);
		}
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
				
		for(int i=1;i<=lastDay;i++){
			bt[i]= new Button(String.valueOf(i));
			p.add(bt[i]);
			
		}
		
	}
	
	public FourthFrame(String title){
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
public class FourthTest {
	public static void main(String[] args){
		FourthFrame ff = new FourthFrame("네번째 문제");
		
	}
}
