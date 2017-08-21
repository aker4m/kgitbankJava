package _31_day;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

class MyFrameFirst extends Frame implements ActionListener{
	private Label title_lb = new Label("2017년 03월", Label.CENTER);
	private Button[] arrow_bt = new Button[2];
	private Label[] week_lb = new Label[7];
	private Button[] day_bt = new Button[42];
	private String[] day = new String[]{"일", "월", "화", "수", "목", "금", "토"};
	
	private BorderLayout title_bl = new BorderLayout();
	private BorderLayout bl = new BorderLayout();
	private GridLayout gl = new GridLayout(7, 7);
	private Panel title_p = new Panel();
	private Panel day_p = new Panel();
	
	private Calendar cal;
	
	private int year=2017;
	private int month=3;
	
	protected void init_layout(){
		this.setLayout(bl);
		this.add("North", title_p);
		title_p.setLayout(title_bl);
		title_p.add("West", arrow_bt[0]= new Button("◀"));
		title_p.add("East", arrow_bt[1]= new Button("▶"));
		arrow_bt[0].addActionListener(this);
		arrow_bt[1].addActionListener(this);
		title_p.add("Center", title_lb);
		//title_lb.setText("2017년 03월");
		this.add("Center", day_p);
		day_p.setLayout(gl);
		
		for(int i=0;i<week_lb.length;i++){
			week_lb[i]= new Label(day[i], Label.CENTER);
			day_p.add(week_lb[i]);
		}
		/*
		for(int i=0;i<day_bt.length;i++){
			day_bt[i] = new Button(String.valueOf(i));
			day_p.add(day_bt[i]);
		}
		*/
		WindowAdapter wa = new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		};
		this.addWindowListener(wa);
		
	}
	
	public void buttonSetting(){
		cal = Calendar.getInstance();
		cal.set(year, month-1, 1);
		int week = cal.get(Calendar.DAY_OF_WEEK);
		int co=0;
		for(int i=1;i<week;i++){
			day_bt[co] = new Button("");
			day_p.add(day_bt[co]);
			co++;
			
		}
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		for(int i=1; i<=lastDay; ++i){
			day_bt[co] = new Button(String.valueOf(i));
			day_p.add(day_bt[co]);
			co++;
		}
		for(int i=co; i<day_bt.length; ++i){
			day_bt[i] = new Button("");
			day_p.add(day_bt[i]);
		}
	}
	
	public void buttonSetting(int year, int month){
		cal.set(year, month-1, 1);
		int week = cal.get(Calendar.DAY_OF_WEEK);
		int co=0;
		for(int i=1;i<week;i++){
			day_bt[co].setLabel("");
			co++;
			
		}
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		for(int i=1; i<=lastDay; ++i){
			day_bt[co].setLabel(String.valueOf(i));
			co++;
		}
		for(int i=co; i<day_bt.length; ++i){
			day_bt[i].setLabel("");
		}
	}
	
	public MyFrameFirst(String title){
		super(title);
		
		this.init_layout();
		this.buttonSetting();
		this.setSize(400, 300);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int)screen.getWidth()/2-(int)this.getWidth()/2;
		int ypos = (int)screen.getHeight()/2-(int)this.getHeight()/2;
		this.setLocation(xpos, ypos);
		this.setResizable(false);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==arrow_bt[0] ){
			month--;
			if(month==0){
				month=12;
				year--;
			}
			title_lb.setText(year+"년"+month+"월");
			this.buttonSetting(year, month);
			
			
		}else if(e.getSource()==arrow_bt[1]){
			month++;
			if(month==13){
				month=1;
				year++;
			}
			title_lb.setText(year+"년"+month+"월");
			this.buttonSetting(year, month);
		}
		
	}
}

public class FirstTest {
	public static void main(String[] args){
		MyFrameFirst mff = new MyFrameFirst("달력 예제");
		
	}
}
