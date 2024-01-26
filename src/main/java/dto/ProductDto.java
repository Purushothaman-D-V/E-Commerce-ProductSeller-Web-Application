package dto;

public class ProductDto 
{
	private int id;
	private String name;
	private double price;
	private String brand;
	private double discount;
	private byte[] image;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public String getBrand() {
		return brand;
	}
	public double getDiscount() {
		return discount;
	}
	public byte[] getImage() {
		return image;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
}
