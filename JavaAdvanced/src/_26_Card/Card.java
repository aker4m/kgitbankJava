package _26_Card;

public class Card {
	private String name;
	private String tel;
	private String company;
	private String email;
	
	public Card(String name, String tel, String company, String email){
		this.name = name;
		this.tel = tel;
		this.company = company;
		this.email = email;
	}
	public void setTel(String tel){
		this.tel = tel;
	}
	public void setCompany(String company){
		this.company=company;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getName(){
		return name;
	}
	public String getTel(){
		return tel;
	}
	public String getCompany(){
		return company;
	}
	public String getEmail(){
		return email;
	}
}
