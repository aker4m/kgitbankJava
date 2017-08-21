package my.shop.mall;

public class Cart {
	private String select;
	private int qty;
	public Cart(String select, int qty){
		this.select = select;
		this.qty = qty;
	}
	public String getSelect() {
		return select;
	}
	public void setSelect(String select) {
		this.select = select;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
}
