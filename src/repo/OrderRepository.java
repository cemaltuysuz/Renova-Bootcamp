package repo;

import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Order;

public class OrderRepository {
	
	private final ArrayList<Order> orderList;
	
	public OrderRepository() {
	this.orderList = new ArrayList<Order>();
	}
	
	// Instance
	public static OrderRepository orderRepository;
	
	
	// Tekil yapı
	 public static OrderRepository getInstance(){
	    if (orderRepository == null) {
	        orderRepository = new OrderRepository();
	      }
	    return orderRepository;
	 }
	 
	 // Sipariş listesini getir
	 public List<Order> getOrderList(){
		 return this.orderList;
	 }
	 // Sipariş listesine yeni bir sipariş ekle.
	 public void insertNewOrder (Order order) {
		 this.orderList.add(order);
	 }
	 
	
	

}
