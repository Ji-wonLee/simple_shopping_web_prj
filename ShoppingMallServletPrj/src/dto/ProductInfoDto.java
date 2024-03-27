package dto;

public class ProductInfoDto {
	private String Proid;	// 상품 고유번호
	private String Proname;	// 상품명
	private int ProCount;	// 수량
	private double price;	// 가격
	
	public String getProid() {
		return Proid;
	}
	public void setProid(String proid) {
		Proid = proid;
	}
	public String getProname() {
		return Proname;
	}
	public void setProname(String proname) {
		Proname = proname;
	}
	public int getProCount() {
		return ProCount;
	}
	public void setProCount(int proCount) {
		ProCount = proCount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
