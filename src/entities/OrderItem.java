package entities;

public class OrderItem {
	//Atributos
	private Integer quantity;
	private Double price;
	
	//Association
	Product product;
	
	//Constructors
	public OrderItem() {
	}

	public OrderItem(Integer quantity, Double price, Product product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	//Getrs and Setrs 
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
		
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	//Valor total do item
	public Double subTotal() {
		return product.getPrice() * quantity;
	}

	@Override
	public String toString() {
		return (getProduct().getName() + ", $" + getProduct().getPrice() + ", Quantity: " + quantity + ", SubTotal: $" + subTotal());
	}	
}
