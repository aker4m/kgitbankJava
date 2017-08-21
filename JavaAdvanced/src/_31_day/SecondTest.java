package _31_day;

import java.awt.*;
import java.awt.event.*;

class MyFrameSecond extends Frame implements ActionListener{
	private Button[] bt = new Button[9];
	private String[] fruit = new String[]{"오렌지", "자두", "포도", "사과", "딸기", "파인애플", "체리", "망고", "참외"};
	private int[] value = new int[]{1000, 1500, 2000, 2500, 3000, 3500, 4000, 4500, 5000};
	private Label list_lb = new Label("주문내역\n---------", Label.CENTER);
	private TextArea ta = new TextArea(5, 5);
	private Button init_bt = new Button("초기화");
	
	private BorderLayout main_bl = new BorderLayout();
	private Panel fruit_p = new Panel();
	private GridLayout fruit_gl = new GridLayout(3, 3);
	private BorderLayout list_bl = new BorderLayout();
	private Panel list_p = new Panel();
	
	private int sum=0;
	private String tmp="";
	public void init(){
		this.setLayout(main_bl);
		this.add("Center", fruit_p);
		fruit_p.setLayout(fruit_gl);
		for(int i=0;i<bt.length;i++){
			bt[i]= new Button(fruit[i]+"\n"+value[i]);
			fruit_p.add(bt[i]);
			bt[i].addActionListener(this);
		}
		this.add("East", list_p);
		list_p.setLayout(list_bl);
		list_p.add("North", list_lb);
		list_p.add("Center", ta);
		list_p.add("South", init_bt);
		init_bt.addActionListener(this);
		
		
		WindowAdapter wa = new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		};
		this.addWindowListener(wa);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<bt.length;i++){
			if(e.getSource()==bt[i]){
				sum += value[i];
				tmp +=fruit[i]+" : "+value[i]+"\n";
				ta.setText(tmp+"소계 : "+ sum);
				
			}
			if(e.getSource()==init_bt){
				sum=0;
				tmp="";
				ta.setText("");
			}
		}
	}
}

public class SecondTest {
	public static void main(String[] args){
		MyFrameSecond mfs = new MyFrameSecond("두번째 문제");
	}
}
