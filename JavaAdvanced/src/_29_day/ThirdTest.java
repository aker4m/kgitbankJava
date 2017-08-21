package _29_day;

import java.awt.*;
import java.awt.event.*;

class ThirdFrame extends Frame implements ActionListener{
	private MenuBar mb = new MenuBar();
	private Menu view = new Menu("보기");
	private Menu edit = new Menu("편집");
	private Menu help = new Menu("도움말");
	
	private Menu log = new Menu("기록");
	
	private MenuItem normal = new MenuItem("일반용");
	private MenuItem advanced = new MenuItem("공학용");
	private MenuItem basic = new MenuItem("기본");
	
	private MenuItem copy = new MenuItem("복사");
	private MenuItem paste = new MenuItem("붙여넣기");
	
	private MenuItem logCopy = new MenuItem("기록복사");
	private MenuItem logEdit = new MenuItem("편집");
	private MenuItem logDelete = new MenuItem("기록삭제");
	
	private MenuItem version = new MenuItem("버젼보기");
	
	private TextField tf = new TextField();
	private Button[] bt = new Button[16];
	private String[] str1 = new String[]{"+", "-", "*"};
	private String[] str2 = new String[]{"0", "=", "%", "/"};
	
	private BorderLayout bl = new BorderLayout();
	private Panel p = new Panel();
	private GridLayout gl = new GridLayout(4,4);
	
	public void init(){
		this.setLayout(bl);
		this.add("North", tf);
		this.add("Center", p);
		p.setLayout(gl);
		int j=0;
		for(int i=0;i<bt.length;i++){
			if(i<4) bt[i]=new Button(String.valueOf(i+7));
			else if(i<8) bt[i]=new Button(String.valueOf(i));
			else bt[i]=new Button(String.valueOf(i-7));
			if(i%4==3 && i<12) bt[i]=new Button(str1[j++]);
			if(i>=12) bt[i]=new Button(str2[i-12]);
			p.add(bt[i]);
		}
		WindowAdapter wa = new WindowAdapter(){
			public void windowClosing(WindowEvent arg0){
				System.exit(0);
			}
		};
		this.addWindowListener(wa);
	}
	
	public void menuInit(){
		this.setMenuBar(mb);
		mb.add(view);
		mb.add(edit);
		mb.add(help);
		view.add(normal);
		view.add(advanced);
		view.addSeparator();
		view.add(basic);
		
		edit.add(copy);
		edit.add(paste);
		edit.addSeparator();
		edit.add(log);
		log.add(logCopy);
		log.add(logEdit);
		log.add(logDelete);
		
		help.add(version);
	}
	
	public void init2(){
		for(int i=0;i<bt.length;i++){
			bt[i].addActionListener(this);
		}
	}
	
	public ThirdFrame(String title){
		super(title);
		
		init();
		init2();
		menuInit();
		this.setSize(400, 300);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int)screen.getWidth()/2-(int)this.getWidth()/2;
		int ypos = (int)screen.getHeight()/2-(int)this.getHeight()/2;
		this.setLocation(xpos, ypos);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg0){
		for(int i=0;i<bt.length;i++){
			if(arg0.getSource()==bt[i]){
				if(i<4) tf.setText(tf.getText()+String.valueOf(i+7));
				else if(i<8) tf.setText(tf.getText()+String.valueOf(i));
				else tf.setText(tf.getText()+String.valueOf(i-7));
				if(i%4==3 && i<12){
					int j=(int)i/4;
					tf.setText(tf.getText()+str1[j]);
				}
				if(i>=12) tf.setText(tf.getText()+str2[i-12]);
			}
		}
	}
	
}

public class ThirdTest {
	public static void main(String[] args){
		ThirdFrame tf = new ThirdFrame("세번째 문제");
	}
}
