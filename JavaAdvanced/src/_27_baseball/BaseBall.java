package _27_baseball;

public class BaseBall {
	private String name;
	private double avg;
	private int homerun;
	private int rbi;
	public BaseBall(String name, double avg, int homerun, int rbi){
		this.name = name;
		this.avg = avg;
		this.homerun = homerun;
		this.rbi = rbi;
	}
	public void setAvg(double avg){
		this.avg = avg;
	}
	public void setHomerun(int homerun){
		this.homerun = homerun;
	}
	public void setRbi(int rbi){
		this.rbi = rbi;
	}
	public String getName(){
		return name;
	}
	public double getAvg(){
		return avg;
	}
	public int getHomerun(){
		return homerun;
	}
	public int getRbi(){
		return rbi;
	}
	public void disp(){
		System.out.println(name + "\t" + avg + "\t" + homerun +"\t" + rbi);
	}
}
