package homework;

public class Blended {
	
	private String name; //메뉴이름
	private int price;		//가격	
	private String size;	//사이즈
	private String type;    //따뜻한거 차가운거
	private String where;	//어디서 먹는지.
	
	public Blended() {
		
	}

	public Blended(String name, int price, String size, String type, String where) {
		super();
		this.name = name;
		this.price = price;
		this.size = size;
		this.type = type;
		this.where = where;
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

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}
}