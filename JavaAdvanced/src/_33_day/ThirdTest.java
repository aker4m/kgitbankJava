package _33_day;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class MyFrameThird extends Frame implements ActionListener, Runnable{
	private Button[] bt = new Button[9];
	private Label time_lb = new Label("시간");
	private Label time_lb2 = new Label("10초");
	private Label point_lb = new Label("점수");
	private Label point_lb2 = new Label();
	private Button start_bt = new Button("시작");
	private Button end_bt = new Button("종료");
	private Font f = new Font("", Font.BOLD, 30);
	
	private BorderLayout main_bl = new BorderLayout();
	private Panel mole_p = new Panel();
	private GridLayout mole_gl = new GridLayout(3, 3);
	private Panel info_p = new Panel();
	private GridLayout info_gl = new GridLayout(6, 1);
	
	private int time;
	private int num;
	private int point;
	private int co=1;
	public void init(){
		this.setLayout(main_bl);
		this.add("Center", mole_p);
		mole_p.setLayout(mole_gl);
		for(int i=0;i<bt.length;i++){
			mole_p.add(bt[i]=new Button());
			bt[i].setEnabled(false);
			bt[i].addActionListener(this);
			bt[i].setFont(f);
		}
		this.add("East", info_p);
		info_p.setLayout(info_gl);
		info_p.add(time_lb);
		info_p.add(time_lb2);
		info_p.add(point_lb);
		info_p.add(point_lb2);
		info_p.add(start_bt);
		info_p.add(end_bt);
		start_bt.addActionListener(this);
		end_bt.addActionListener(this);
		
		WindowAdapter wa = new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		};
		this.addWindowListener(wa);
	}
	
	public void play(){
		for(int i=0;i<bt.length;i++){
			bt[i].setEnabled(true);
			bt[i].setLabel("");
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=1;i<10;i++){
			list.add(i);
		}
		Collections.shuffle(list);
		
		for(int i=0;i<bt.length;i++){
			bt[i].setLabel(String.valueOf(list.get(i)));
		}
	}
	
	public MyFrameThird(String title){
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==start_bt){
			point=0;
			for(int i=0;i<bt.length;i++){
				bt[i].setEnabled(true);
			}
			point_lb2.setText(String.valueOf(point));
			Thread th = new Thread(this);
			th.start();
			co=1;
			play();
			start_bt.setEnabled(false);
		}
		
		for(int i=0;i<bt.length;i++){
			if(e.getSource()==bt[i]){
				if(Integer.parseInt(bt[i].getLabel())==co){
					bt[i].setEnabled(false);
					co++;
					point+=10;
					if(co>9){
						point+=30;
						play();
						co=1;
					}
					point_lb2.setText(String.valueOf(point));
				}
			}
		}
				
		if(e.getSource()==end_bt){
			System.exit(0);
		}
	}
	
	@Override
	public void run() {
		time=10;
		while(time>0){
			try{
				Thread.sleep(1000);//현재스레드 재우기
			}catch(Exception e){}
			time--;
			time_lb2.setText(""+time+"초");
		}
		for(int i=0;i<bt.length;i++){
			bt[i].setEnabled(false);
		}
		start_bt.setEnabled(true);
	}
}

public class ThirdTest {
	public static void main(String[] args){
		MyFrameThird frame = new MyFrameThird("세번째 실습");
	}
}
