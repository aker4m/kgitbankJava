package _22_day;

class Bank{
	private String name;
	private double money;
	private static float rate;
	static{
		rate = 0.03f;
	}
	public Bank(String name, double money, float rate){
		this.name = name;
		this.money = money;
		Bank.rate = rate;
	}
	public void setRate(float rate){
		Bank.rate = rate;
	}
	public String getName(){
		return name;
	}
	public double getMoney(){
		return money;
	}
	public float getRate(){
		return rate;
	}
}

public class ClassTest6 {
	public static void main(String[] args){
		Bank aaa = new Bank("aaa", 1000.0, 0.03f);
		System.out.println(aaa.getName()+"님의 잔액은"+
				aaa.getMoney()+"원이고, 적용되는 이율은"+
				aaa.getRate()*100+"% 입니다.");
		System.out.println("========================================");
		Bank bbb = new Bank("aaa", 1000.0, 0.0282f);
		//aaa.setRate(0.0282f);
		System.out.println(aaa.getName()+"님의 잔액은"+
				aaa.getMoney()+"원이고, 적용되는 이율은"+
				aaa.getRate()*100+"% 입니다.");
		System.out.println(bbb.getName()+"님의 잔액은"+
				bbb.getMoney()+"원이고, 적용되는 이율은"+
				bbb.getRate()*100+"% 입니다.");
		System.out.println("========================================");
		Bank ccc = new Bank("aaa", 1000.0, 0.025f);
		//aaa.setRate(0.025f);
		//bbb.setRate(0.025f);
		System.out.println(aaa.getName()+"님의 잔액은"+
				aaa.getMoney()+"원이고, 적용되는 이율은"+
				aaa.getRate()*100+"% 입니다.");
		System.out.println(bbb.getName()+"님의 잔액은"+
				bbb.getMoney()+"원이고, 적용되는 이율은"+
				bbb.getRate()*100+"% 입니다.");
		System.out.println(ccc.getName()+"님의 잔액은"+
				ccc.getMoney()+"원이고, 적용되는 이율은"+
				ccc.getRate()*100+"% 입니다.");
		System.out.println("========================================");
	}
}
