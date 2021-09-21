package viewmodel;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Hardware;
import model.Manual;
import model.Order;
import model.Product;
import model.Software;
import repo.OrderRepository;

public class OrderViewModel {
	
	static OrderRepository oRepository = OrderRepository.getInstance();
	
		public JTable generateOrderWindow() {
		
		List<Order> myOrderList = oRepository.getOrderList(); // Get Order List 
		
		String orders[][] = new String[myOrderList.size()][5]; // Create new double array for table
		
		/**
		 * Fill the array with product values
		 * */
		
		int index = 0;
		for(Order o :myOrderList) {
			orders[index][0] = String.valueOf(o.getId());
			orders[index][1] = o.getCustomer().getName();
			orders[index][2] = o.getOrderDate().toString();
			orders[index][3] = String.valueOf(o.getOrderTotal());
			orders[index][4] = o.getItems().toString();
			index++;
		}
		 // Create new array for order field's titles.
		String[]title = {"Code","Name","Date","Order Total","Items"};
		
		JTable orderTable = new JTable(orders,title); // Create JTable
		orderTable.setBounds(30,40,200,300);
		
		return orderTable;
	} 

}
