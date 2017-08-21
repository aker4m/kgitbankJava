package _31_day;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class Menu{
	private String name;
	private int price;
	public Menu(String name, int price){
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
}
class MyFrame01 extends Frame implements ActionListener{
	private String[] name = new String[]{"사과", "오렌지", "배", "귤","키위","딸기","수박","참외","포도"};
	private int[] price = new int[]{1000, 500, 2000, 500, 300, 4000, 20000, 3000, 2000};
	private Button bt[] = new Button[9];
	String msg = "주문내역\n========\n";
	private TextArea ta = new TextArea(msg);
	private ArrayList<Menu> list = new ArrayList<Menu>();
	private Panel p = new Panel();
	private Panel p2 = new Panel();
	public void init(){
		this.setLayout(new BorderLayout());
		this.add("Center", p);
		p2.setPreferredSize(new Dimension(130, 200));
		this.add("East", p2);
		p.setLayout(new GridLayout(3,3));
		for(int i=0; i<bt.length; ++i){
			bt[i] = new Button(name[i] + price[i]);
			p.add(bt[i]); bt[i].addActionListener(this);
		}
		p2.setLayout(new BorderLayout());
		p2.add(ta);
		
	}
	public MyFrame01(String title){
		super(title);
		this.init();
		super.setSize(400, 300);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

		int xpos = (int)screen.getWidth()/2 - this.getWidth()/2;
		int ypos = (int)screen.getHeight()/2 - this.getHeight()/2;
		super.setLocation(xpos, ypos);
		
		super.setResizable(false);
		super.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		for(int i=0; i<bt.length; ++i){
			if (arg0.getSource()==bt[i]){
				Menu menu = new Menu(name[i], price[i]);
				list.add(menu);
			}
		}
		int sum = 0;
		ta.setText(msg);
		for(int i=0; i<list.size(); ++i){
			Menu menu = list.get(i);
			ta.append(menu.getName()+"\t"+menu.getPrice()+"\n");
			sum+= menu.getPrice();
		}
		ta.append("--------\n");
		ta.append("소계 :\t" + sum);
	}
}
public class ClassTest1 {
	public static void main(String[] args){
		MyFrame01 mf = new MyFrame01("awt실습");
	}
}