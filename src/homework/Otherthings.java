package homework;

public class Otherthings {

	private String name; // 이름
	private int price; // 가격

	public Otherthings(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Otherthings() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Otherthings [name=" + name + ", price=" + price + "]";
	}

}
