package viewmodel;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Hardware;
import model.Manual;
import model.Order;
import model.OrderItem;
import model.Product;
import model.Software;
import repo.OrderRepository;

public class OrderViewModel {
	
	static OrderRepository oRepository = OrderRepository.getInstance();
	
		public JTable generateOrderWindow() {
		
		List<Order> myOrderList = oRepository.getOrderList(); // Get Order List 
		
		String orders[][] = new String[myOrderList.size()][7]; // Create new double array for table
		
		/**
		 * Fill the array with product values
		 * */
		
		int index = 0;
		for(Order o :myOrderList) {
			// current product
			Product p = o.getItems().get(0).getProduct();
			// current order item
			OrderItem oI = o.getItems().get(0);
			// Set array
			orders[index][0] = p.getName();
			orders[index][1] = o.getCustomer().getName();
			orders[index][2] = o.getOrderDate().toString();
			orders[index][3] = String.valueOf(o.getOrderTotal());
			orders[index][4] = String.valueOf(oI.getUnitPrice()); 
			orders[index][5] = String.valueOf(oI.getQuantity());
			orders[index][6] = String.valueOf(oI.getTax());
			index++;
		}
		 // Create new array for order field's titles.
		String[]title = {"Product","Customer","Date","Order Total","Unit Price","Quantity","Tax"};
		
		JTable orderTable = new JTable(orders,title); // Create JTable
		orderTable.setBounds(30,40,200,300);
		
		return orderTable;
	} 

}
