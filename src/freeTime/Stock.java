package freeTime;

public class Stock {

	private String name; //종목이름
	private int code;  //종목코드
	private int price; //가격
	
	public Stock() {
		
	}

	public Stock(String name, int code, int price) {
		super();
		this.name = name;
		this.code = code;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Stock [name=" + name + ", code=" + code + ", price=" + price + "]";
	}
	
	
}
