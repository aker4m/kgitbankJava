package _30_day;

import java.awt.*;

class MyFrame03 extends Frame{
	private FileDialog fdlg = new FileDialog(this, "file save", FileDialog.SAVE);
	//FileDialog.LOAD
	/*
	private Dialog dlg = new Dialog(this, "���", false);//�̵� ���� or �Ұ���
	private Label lb = new Label("����Դϴ�.", Label.CENTER);
	private Button bt = new Button("Ȯ��");
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
		MyFrame03 mf = new MyFrame03("awt�ǽ�03");
	}
}
