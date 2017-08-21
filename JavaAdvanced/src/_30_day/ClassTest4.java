package _30_day;

import java.awt.*;

class MyFrame04 extends Frame{
	private MenuBar mb = new MenuBar();
	private Menu file = new Menu("파일");
	private Menu edit = new Menu("편집");
	private Menu help = new Menu("도움말");
	
	private MenuItem fnew = new MenuItem("새파일");
	private MenuItem fopen = new MenuItem("파일열기");
	private MenuItem fsave = new MenuItem("파일저장");
	private MenuItem fexit = new MenuItem("종료");
	
	private Menu ecolor = new Menu("색상선택");
	private Menu esize = new Menu("사이즈선택");
	
	private CheckboxMenuItem ered = new CheckboxMenuItem("빨강색");
	private CheckboxMenuItem egreen = new CheckboxMenuItem("녹색");
	private CheckboxMenuItem eblue = new CheckboxMenuItem("파란색");
	
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
		MyFrame04 mf = new MyFrame04("awt실습");
	}
}
