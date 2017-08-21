package _32_day;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class Member{
	String name;
	String tel;
	public Member(String name, String tel){
		this.name = name;
		this.tel = tel;
	}
		public void setTel(String tel){
		this.tel = tel;
	}
	public String getName(){
		return name;
	}
	public String getTel(){
		return tel;
	}
}

class MyDialog extends Dialog implements ActionListener{
	private Label name_lb = new Label("이름");
	private Label tel_lb = new Label("전화번호");
	private TextField name_tf = new TextField(20);
	private TextField tel_tf = new TextField(20);
	private Button confirm_bt = new Button("확인");
	private Button cancel_bt = new Button("취소");
	private Panel name_p = new Panel();
	private Panel tel_p = new Panel();
	private Panel bt_p = new Panel();
	
	private GridLayout gl = new GridLayout(3, 1);
	
	private String name;
	private String tel;
	public String getName(){
		return name;
	}
	public String getTel(){
		return tel;
	}
	public void init(){
		this.setLayout(gl);
		this.add(name_p);
		name_p.add(name_lb);
		name_p.add(name_tf);
		this.add(tel_p);
		tel_p.add(tel_lb);
		tel_p.add(tel_tf);
		
		this.add(bt_p);
		bt_p.add(confirm_bt);
		bt_p.add(cancel_bt);
		confirm_bt.addActionListener(this);
		cancel_bt.addActionListener(this);
	}
	
	public MyDialog(Frame frame, String msg){
		super(frame, msg);
		
		this.init();
		this.setSize(300, 150);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int)screen.getWidth()/2-(int)this.getWidth()/2;
		int ypos = (int)screen.getHeight()/2-(int)this.getHeight()/2;
		this.setLocation(xpos, ypos);
		this.setVisible(true);
		WindowAdapter wa = new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				dispose();
			}
		};
		this.addWindowListener(wa);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==confirm_bt ){
			String name = name_tf.getText();
			String tel = tel_tf.getText();
			
			dispose();
		}else if(ae.getSource()==cancel_bt){
			dispose();
		}
	}
}

class MyFrameFirst extends Frame implements ActionListener{
	private Label top_lb = new Label("회원명단", Label.CENTER);
	private Button[] bt = new Button[4];
	private String[] str = new String[]{"입력", "출력", "삭제", "수정"};
	private Font font = new Font("",Font.BOLD, 30);
	private Label center_name = new Label("이름");
	private Label center_tel = new Label("전화번호");
	private TextArea name_ta = new TextArea(5,5);
	private TextArea tel_ta = new TextArea(5,5);
	
	private BorderLayout main_bl = new BorderLayout();
	private BorderLayout top_bl = new BorderLayout();
	private Panel top_p = new Panel();
	private BorderLayout center_bl = new BorderLayout();
	private BorderLayout center_left_bl = new BorderLayout();
	private BorderLayout center_right_bl = new BorderLayout();
	private GridLayout center_gl = new GridLayout(1,2);
	private Panel center_p = new Panel();
	private Panel center_left = new Panel();
	private Panel center_right = new Panel();
	private Panel bottom_p = new Panel();
	private GridLayout bottom_gl = new GridLayout(1, 4);
	
	private HashMap<String, Member> map;
	
	public void init(){
		map = new HashMap<String, Member>();
		this.setLayout(main_bl);
		this.add("North", top_p);
		top_p.setLayout(top_bl);
		top_p.add("Center", top_lb);
		top_lb.setFont(font);
		this.add("Center", center_p);
		center_p.setLayout(center_gl);
		center_p.add(center_left);
		center_left.setLayout(center_left_bl);
		center_left.add("North", center_name);
		center_left.add(name_ta);
		center_p.add(center_right);
		center_right.setLayout(center_right_bl);
		center_right.add("North", center_tel);
		center_right.add(tel_ta);
		this.add("South", bottom_p);
		bottom_p.setLayout(bottom_gl);
		for(int i=0;i<bt.length;i++){
			bt[i]= new Button(str[i]);
			bottom_p.add(bt[i]);
			bt[i].addActionListener(this);
		}
	}
		
	public MyFrameFirst(String title){
		super(title);
		
		this.init();
		this.setSize(400, 300);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int)screen.getWidth()/2-(int)this.getWidth()/2;
		int ypos = (int)screen.getHeight()/2-(int)this.getHeight()/2;
		this.setLocation(xpos, ypos);
		this.setResizable(false);
		this.setVisible(true);
		WindowAdapter wa = new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		};
		this.addWindowListener(wa);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		 if(ae.getSource()==bt[0]){
			 MyDialog md = new MyDialog(this, "입력");
			 
		 }else if(ae.getSource()==bt[1]){
			 Set set = map.keySet();
			 Iterator it = set.iterator();
			 while(it.hasNext()){
				 String key = (String)it.next();
				 Member view = (Member)map.get(key);
				 name_ta.setText(view.getName());
				 tel_ta.setText(view.getTel());
			 }
		 }else if(ae.getSource()==bt[2]){
			 MyDialog md = new MyDialog(this, "삭제");
		 }else if(ae.getSource()==bt[3]){
			 MyDialog md = new MyDialog(this, "수정");
		 }
	}
}

public class FirstTest {
	public static void main(String[] args){
		MyFrameFirst mff = new MyFrameFirst("첫번째 문제");
	}
}
