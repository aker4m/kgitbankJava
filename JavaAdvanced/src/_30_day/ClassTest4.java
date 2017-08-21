package _30_day;

import java.awt.*;

class MyFrame04 extends Frame{
	private MenuBar mb = new MenuBar();
	private Menu file = new Menu("����");
	private Menu edit = new Menu("����");
	private Menu help = new Menu("����");
	
	private MenuItem fnew = new MenuItem("������");
	private MenuItem fopen = new MenuItem("���Ͽ���");
	private MenuItem fsave = new MenuItem("��������");
	private MenuItem fexit = new MenuItem("����");
	
	private Menu ecolor = new Menu("������");
	private Menu esize = new Menu("�������");
	
	private CheckboxMenuItem ered = new CheckboxMenuItem("������");
	private CheckboxMenuItem egreen = new CheckboxMenuItem("���");
	private CheckboxMenuItem eblue = new CheckboxMenuItem("�Ķ���");
	
	public void init(){
		this.setMenuBar(mb);
		mb.add(file);
		mb.add(edit);
		mb.add(help);
		file.add(fnew);
		file.addSeparator();
		file.add(fopen);
		file.add(fsave);
		file.addSeparator();
		file.add(fexit);
		
		edit.add(ecolor);
		edit.addSeparator();
		edit.add(esize);
		
		ecolor.add(ered);
		ecolor.add(egreen);
		ecolor.add(eblue);
	}
	public MyFrame04(String title){
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
public class ClassTest4 {
	public static void main(String[] args){
		MyFrame04 mf = new MyFrame04("awt�ǽ�");
	}
}
