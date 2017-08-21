package _26_sungjuk;

class SungJuk{
	private String name;
	private int kor;
	private int eng;
	private int tot;
	private int rank;
	public SungJuk(String name, int kor, int eng){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		tot = kor + eng;
		rank = 1;
	}
	public void setKor(int kor){
		this.kor = kor;
		setTot();
	}
	public void setEng(int eng){
		this.eng = eng;
		setTot();
	}
	protected void setTot(){
		tot = kor + eng;
	}
	public String getName(){
		return name;
	}
	public int getKor(){
		return kor;
	}
	public int getEng(){
		return eng;
	}
	public int getTot(){
		return tot;
	}
	public int getRank(){
		return rank;
	}
	public void clearRank(){
		rank = 1;
	}
	public void plusRank(){
		rank++;
	}
	public void disp(){
		System.out.println(name+"님의 총점은 " + 
						tot+"점이고, 순위는 " + rank +"등 입니다.");
	}
}