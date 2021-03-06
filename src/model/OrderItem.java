package model;

public class OrderItem implements Taxable {
	private int lineNbr;
	private Product product;
	private int quantity;
	
	public OrderItem(int lineNbr, Product product, int quantity){
		super();
		this.lineNbr = lineNbr;
		this.product = product;
		this.quantity = quantity;
	}
	

	public int getLineNbr() {
		return lineNbr;
	}


	public Product getProduct() {
		return product;
	}


	public int getQuantity() {
		return quantity;
	}

	public double getItemTotal() {		
		return getProduct().getRetailPrice() * this.quantity;
	}
	
	public double getUnitPrice() {
		return getProduct().getRetailPrice();
	}

	@Override
	public double getTax() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	

}
