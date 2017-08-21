package _38_day;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.*;

class MyFrame extends JFrame implements ActionListener {
	//프레임 필드멤버
	private JButton left_bt = new JButton("◀");
	private JLabel title_lb = new JLabel("", JLabel.CENTER);
	private JButton right_bt = new JButton("▶");
	private JLabel lb[] = new JLabel[7];
	private String lb_str[] = new String[]{"일","월","화","수","목","금","토"};
	private JButton bt[] = new JButton[42];
		
	private BorderLayout bl = new BorderLayout();
	private JPanel title_p = new JPanel();
	private BorderLayout title_bl = new BorderLayout();
	private JPanel bt_p = new JPanel();
	private GridLayout bt_gl = new GridLayout(7,7);
	private Container con;
	
	//달력정보 필드멤버
	private Calendar cal;
	private int year, month;
	
	//파일관련 필드멤버
	private File dir;
	private File file;
	
	//다이얼로그 필드멤버
	private JDialog jdlg = new JDialog();
	private Dimension screen = null;
	private JLabel jlb = new JLabel();
	private JTextArea jta = new JTextArea();
	private JButton jbt = new JButton("확인");
	private JPanel jp = new JPanel();
	private Container jdlg_con = jdlg.getContentPane();
	
	private int y;
	private int m;
	private int d;
	
	public void init(){
		//배경레이아웃
		con = this.getContentPane();
		con.setLayout(bl);
		con.add("North", title_p);
		title_p.setLayout(title_bl);
		title_p.add("West", left_bt);
		left_bt.addActionListener(this);
		//title_lb.setText(year+"년 " + (month+1) +"월");
		title_lb.setFont(new Font("", Font.BOLD, 25));
		title_p.add("Center", title_lb);
		title_p.add("East", right_bt);
		right_bt.addActionListener(this);
		con.add("Center", bt_p);
		bt_p.setLayout(bt_gl);
		
		//버튼레이아웃
		for(int i=0; i<lb.length; ++i){
			lb[i] = new JLabel(lb_str[i], JLabel.CENTER);
			bt_p.add(lb[i]);
		}
		for(int i=0; i<bt.length; ++i){
			bt[i] = new JButton("");
		}
		buttonSetting();
		for(int i=0; i<bt.length; ++i){
			bt_p.add(bt[i]);
			bt[i].addActionListener(this);
		}
		
		//파일내용 초기화
		dir = new File("D:\\raonolje_bigdata\\workspace\\JavaAdvanced\\src\\_38_day");
		
		//다이얼로그 초기화
		jbt.addActionListener(this);
	}
	public void buttonSetting(){
		title_lb.setText(year+"년 " + (month+1) +"월");
		int week = cal.get(Calendar.DAY_OF_WEEK);
		int co = 0;
		for(int i=1; i<week; ++i){
			bt[co].setEnabled(true);
			bt[co].setLabel("");
			bt[co].setEnabled(false);
			co++;
		}
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		for(int i=1; i<=lastDay; ++i){
			bt[co].setEnabled(true);
			bt[co].setLabel(String.valueOf(i));
			co++;
		}
		for(int i=co; i<bt.length; ++i){
			bt[co].setEnabled(true);
			bt[co].setLabel("");
			bt[co].setEnabled(false);
			co++;
		}
	}
	public void start(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public MyFrame(String title){
		super(title);
		cal = Calendar.getInstance();
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		this.init();
		this.start();
		super.setSize(400, 300);
		screen = Toolkit.getDefaultToolkit().getScreenSize();

		int xpos = (int)screen.getWidth()/2 - this.getWidth()/2;
		int ypos = (int)screen.getHeight()/2 - this.getHeight()/2;
		super.setLocation(xpos, ypos);
		
		super.setResizable(false);
		super.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == left_bt){
			month--;
			if (month<0) {
				month = 11; 
				year--;
				cal.set(Calendar.YEAR, year);
			}
		}else if (ae.getSource()==right_bt){
			month++;
			if (month>11) {
				month = 0; 
				year++;
				cal.set(Calendar.YEAR, year);
			}
		}
		cal.set(Calendar.MONTH, month);
		buttonSetting();
		
		for(int i=0;i<bt.length;i++){
			if(ae.getSource()==bt[i]){
				jdlg.setSize(300, 200);
				int xpos = (int)screen.getWidth()/2-150;
				int ypos = (int)screen.getHeight()/2-100;
				jdlg.setLocation(xpos, ypos);
				jdlg.setResizable(false);
				jdlg.setVisible(true);
				
				y = year;
				m = month+1;
				d = Integer.parseInt(bt[i].getLabel());
				
				jdlg_con.setLayout(new BorderLayout());
				jdlg_con.add("North", jlb);
				jlb.setText(y+"년 "+m+"월 "+d+"일");
				jlb.setHorizontalAlignment(JLabel.CENTER);
				jlb.setFont(new Font("", Font.BOLD, 25));
				jdlg_con.add("Center", jta);
				jdlg_con.add("South", jp);
				jp.setLayout(new BorderLayout());
				jp.add("East", jbt);
				jbt.setSize(20, 20);
				
				file = new File(dir, y+"-"+m+"-"+d+".txt");
				if(file.exists()){
					try{
						FileReader fr = new FileReader(file);
						BufferedReader br = new BufferedReader(fr);
						String text = "";
						while(true){
							String msg = br.readLine();
							if(msg == null) break;
							text +=msg+"\n";
						}
						jta.append(text);
						
					}catch(IOException e){}
				}
			}
		}
		if(ae.getSource()==jbt){
			
			file = new File(dir, y+"-"+m+"-"+d+".txt");
			String text = jta.getText();
			jta.setText("");
			jdlg.setVisible(false);
			
			try {
				FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);
				
				pw.println(text);
				pw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
public class FirstTest {
	public static void main(String[] args){
		MyFrame mf = new MyFrame("달력 파일 저장 프로그램");
	}
}