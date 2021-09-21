import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Company;
import model.Customer;
import model.Hardware;
import model.Individual;
import model.Manual;
import model.Order;
import model.Product;
import model.Software;
import repo.CustomerRepository;
import repo.OrderRepository;
import repo.ProductRepository;
import util.ForcedListSelectionModel;
import viewmodel.CustomerViewModel;
import viewmodel.OrderViewModel;
import viewmodel.ProductViewModel;
import model.OrderItem;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class Test {
	
	// @author Cemal tüysüz
	// @date 10.09.2021
	
	// Define Scanner class
	static Scanner input;
	
	// Define Repositories
    static CustomerRepository cRepository;
    static ProductRepository pRepository;
    static OrderRepository oRepository;
    
    // Define TextFields
    private static JTextField inputProductCode;
    private static JTextField inputProductCount;
    private static JTextField inputCustomerCode;
	
	public static void main (String [] args) {
		
		// Scanner
        input = new Scanner(System.in);
        
        // init viewmodel classes
        ProductViewModel pViewModel	 = new ProductViewModel();
        CustomerViewModel cViewModel = new CustomerViewModel();
        OrderViewModel oViewModel = new OrderViewModel();

        cRepository = CustomerRepository.getInstance(); // Customer Repository
        pRepository = ProductRepository.getInstance(); // Product Repository
        oRepository = OrderRepository.getInstance(); // Order Repository
        
        // Main Window Settings
        JFrame jfm = new JFrame("Renova BootCamp"); 
        jfm.setResizable(false);
        jfm.setSize(700, 600); // Window Size
        jfm.setLocation(300, 150);
    
        JButton productList  = new JButton("Product List"); // it's open the Product List's window
        productList.setBounds(166, 5, 119, 29);
        JButton customerList = new JButton("Customer List"); // it's open the Customer List window
        customerList.setBounds(290, 5, 132, 29);
        JButton orderList    = new JButton("Order List"); // it's open the Order List window
        orderList.setBounds(427, 5, 106, 29);
        jfm.getContentPane().setLayout(null);
        
        jfm.getContentPane().add(productList); // Product list button add Content pane
        jfm.getContentPane().add(customerList); // Customer list button add Content pane
        jfm.getContentPane().add(orderList); // Order list button add Content pane
        
        // Product Code JLabel For Information
        JLabel testLabel = new JLabel("Product Code :");
        testLabel.setBounds(154, 200, 101, 16);
        jfm.getContentPane().add(testLabel);
        
        // Product code TextField Settings
        inputProductCode = new JTextField();
        inputProductCode.setBounds(273, 197, 130, 26);
        jfm.getContentPane().add(inputProductCode);
        inputProductCode.setColumns(10);
        
        // Product Count JLabel For Information
        JLabel lblNewLabel = new JLabel("Product Count :");
        lblNewLabel.setBounds(154, 258, 99, 16);
        jfm.getContentPane().add(lblNewLabel);
        
     // Product Count TextField Settings
        inputProductCount = new JTextField();
        inputProductCount.setColumns(10);
        inputProductCount.setBounds(273, 253, 130, 26);
        jfm.getContentPane().add(inputProductCount);
        
        // Customer Code JLabel For Information
        JLabel lblNewLabel_1 = new JLabel("Customer Code:");
        lblNewLabel_1.setBounds(154, 313, 101, 16);
        jfm.getContentPane().add(lblNewLabel_1);
        
     // Customer Code TextField Settings
        inputCustomerCode = new JTextField();
        inputCustomerCode.setColumns(10);
        inputCustomerCode.setBounds(273, 308, 130, 26);
        jfm.getContentPane().add(inputCustomerCode);
        
        // Insert Order Button Settings
        JButton insertNewOrder = new JButton("New Order");
        insertNewOrder.setBounds(231, 376, 117, 29);
        jfm.getContentPane().add(insertNewOrder);
        
        
        // ProductList button set OnClick Listener
        productList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// Generate product window
					JFrame productJF = new JFrame("Ürünler"); // Create a new JFrame for products
					productJF.setSize(700, 300); // Size
					productJF.setLocation(300, 150); // Location
					
					// get JTable productViewModel
					JTable productTable = pViewModel.generateProductWindow(); // getTable
					JScrollPane sc = new JScrollPane(productTable); // Scroll pane for show titles
					productJF.getContentPane().add(sc); // insert content pane
					
					productJF.setVisible(true); // visibility
				}catch(Exception e1) {
					// TODO ()
				}
			}
        });
        
        // CustomerListButton OnClick Listener
        customerList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// Generate product window
					JFrame customerWindow = cViewModel.generateCustomerWindow();
					customerWindow.setVisible(true); // visibility
				}catch(Exception e1) {
					// TODO ()
				}
			}
        });
        
     // OrderListButton OnClick Listener
        orderList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					// Generate Order window
					JFrame orderJF = new JFrame("Orders"); // Create a new JFrame for orders
					orderJF.setSize(700, 300); // Size
					orderJF.setLocation(300, 150); // Location
					
					
					JTable orderTable = oViewModel.generateOrderWindow(); // getTable
					JScrollPane sc = new JScrollPane(orderTable); // Scroll pane for show titles
					orderJF.getContentPane().add(sc); // insert content pane
					orderJF.setVisible(true); // visibility

			}
        });
        
        // Insert new order button
        
        insertNewOrder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Total Order
				 double orderTotal = 0L;
				 // Order Items in items array
				 ArrayList<OrderItem> items = new ArrayList<OrderItem>(); 
				 int line = 1; 
				// product code
				 int productCode = Integer.parseInt(inputProductCode.getText());
				 // product count
				 int productCount = Integer.parseInt(inputProductCount.getText());
				 // customer code
				 int customerCode = Integer.parseInt(inputCustomerCode.getText());
				 // calculate the order total
			     orderTotal += pRepository.getProductList().get(productCode).getRetailPrice() * productCount;
			     // insert array
			     items.add(new OrderItem(
		        			line,
		        			pRepository.getProductList().get(productCode),
		        			productCount
		        			));
			     // Create new customer
			     Customer customer = cRepository.getCustomerList().get(customerCode);
			     // get date
			     Date date = new Date(); // date sınıfım
		        	
		        // Create order instance
		        	Order order = new Order(
		        			customer, 
		        			oRepository.getOrderList().size(), 
		        			items, 
		        			date, 
		        			orderTotal 
		        			);
		        	// insert the array with Order Reposiyory
		        	oRepository.insertNewOrder(order);
				 
				
			}
        	
        });
        
        
        
        jfm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Closable (Main)
        jfm.setVisible(true); // visibility (Main)
        
	}
}
