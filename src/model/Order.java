package model;

import java.util.ArrayList;
import java.util.Date;

public class Order {
	
	private Customer customer;
	private int id;
	private ArrayList<OrderItem> items;
	private Date orderDate;
	private double orderTotal;
	
	public Order() {
		
	}

	public Order(Customer customer, int id, ArrayList<OrderItem> item, Date orderDate, double orderTotal) {
		super();
		this.items = item;
		this.customer = customer;
		this.id = id;
		this.orderDate = orderDate;
		this.orderTotal = orderTotal;
	}
	
	// insert order item
	public void addOrderItem(OrderItem item) {
		items.add(item);
	}

	public Customer getCustomer() {
		return customer;
	}

	public int getId() {
		return id;
	}

	public ArrayList<OrderItem> getItems() {
		return items;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	@Override
	public String toString() {
		return "Order [customer=" + customer + ", id=" + id + ", items=" + items + ", orderDate=" + orderDate
				+ ", orderTotal=" + orderTotal + "]";
	}
	
	
	
	

}
