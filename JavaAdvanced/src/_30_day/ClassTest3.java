package _30_day;

import java.awt.*;

class MyFrame03 extends Frame{
	private FileDialog fdlg = new FileDialog(this, "file save", FileDialog.SAVE);
	//FileDialog.LOAD
	/*
	private Dialog dlg = new Dialog(this, "경고", false);//이동 가능 or 불가능
	private Label lb = new Label("경고입니다.", Label.CENTER);
	private Button bt = new Button("확인");
	private Panel p = new Panel();
	*/
	//private List list = new List(5, true);
	
	public void init(){
		/*
		dlg.setLayout(new BorderLayout());
		dlg.add("Center", lb);
		dlg.add("South",  p);
		p.setLayout(new FlowLayout());
		p.add(bt);
		*/
		/*
		this.setLayout(new BorderLayout());
		for(char i='A'; i<='Z';i++){
			list.add(String.valueOf(i)+i+i);
		}
		this.add("Center", list);
		*/
	}
	public MyFrame03(String title){
		super(title);
		
		init();
		this.setSize(400, 300);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int)screen.getWidth()/2-(int)this.getWidth()/2;
		int ypos = (int)screen.getHeight()/2-(int)this.getHeight()/2;
		this.setLocation(xpos, ypos);
		this.setResizable(false);
		this.setVisible(true);
		
		try{
			Thread.sleep(1000);
		}catch(Exception e){}
		//dlg.setBounds(xpos, ypos, 150, 100);
		//dlg.setVisible(true);
		fdlg.setVisible(true);
	}
}
public class ClassTest3 {
	public static void main(String[] args){
		MyFrame03 mf = new MyFrame03("awt실습03");
	}
}
