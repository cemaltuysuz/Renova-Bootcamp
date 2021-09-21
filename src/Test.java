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
	
	static Scanner input;
    static CustomerRepository cRepository;
    static ProductRepository pRepository;
    static OrderRepository oRepository;
    
    private static JTextField inputProductCode;
    private static JTextField inputProductCount;
    private static JTextField inputCustomerCode;
	
	public static void main (String [] args) {
		
		// Scanner
        input = new Scanner(System.in);
        
        ProductViewModel pViewModel	 = new ProductViewModel();
        CustomerViewModel cViewModel = new CustomerViewModel();
        OrderViewModel oViewModel = new OrderViewModel();

        cRepository = CustomerRepository.getInstance(); // Customer Repository
        pRepository = ProductRepository.getInstance(); // Product Repository
        oRepository = OrderRepository.getInstance(); // Order Repository
        
        JFrame jfm = new JFrame("Renova BootCamp"); // Main Window
        jfm.setResizable(false);
        jfm.setSize(700, 600); 						// Window Size
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
        testLabel.setBounds(168, 200, 87, 16);
        jfm.getContentPane().add(testLabel);
        
        // Product code TextField Settings
        inputProductCode = new JTextField();
        inputProductCode.setBounds(273, 197, 130, 26);
        jfm.getContentPane().add(inputProductCode);
        inputProductCode.setColumns(10);
        
        // Product Count JLabel For Information
        JLabel lblNewLabel = new JLabel("Product Count :");
        lblNewLabel.setBounds(166, 258, 87, 16);
        jfm.getContentPane().add(lblNewLabel);
        
     // Product Count TextField Settings
        inputProductCount = new JTextField();
        inputProductCount.setColumns(10);
        inputProductCount.setBounds(273, 253, 130, 26);
        jfm.getContentPane().add(inputProductCount);
        
        // Customer Code JLabel For Information
        JLabel lblNewLabel_1 = new JLabel("Customer Code:");
        lblNewLabel_1.setBounds(166, 313, 89, 16);
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
				 double orderTotal = 0L;
				 ArrayList<OrderItem> items = new ArrayList<OrderItem>(); 
				 int line = 1; 
				
				 int productCode = Integer.parseInt(inputProductCode.getText());
				 int productCount = Integer.parseInt(inputProductCount.getText());
				 int customerCode = Integer.parseInt(inputCustomerCode.getText());
				 
				 
			     
			     
			     orderTotal += pRepository.getProductList().get(productCode).getRetailPrice() * productCount;
			     
			     items.add(new OrderItem(
		        			line,
		        			pRepository.getProductList().get(productCode),
		        			productCount
		        			));
			     
			     Customer customer = cRepository.getCustomerList().get(customerCode);
			     
			     Date date = new Date(); // date sınıfım
		        	
		        	// order nesnesi
		        	Order order = new Order(
		        			customer, 
		        			oRepository.getOrderList().size(), 
		        			items, 
		        			date, 
		        			orderTotal 
		        			);
		        	
		        	oRepository.insertNewOrder(order);
				 
				
			}
        	
        });
        
        
        
        jfm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Closable (Main)
        jfm.setVisible(true); // visibility (Main)
        
        
        
        
        
        /**
    	 * Kullanıcıya yapmasını istediği işlemi seçtirebilmek için menü gösteriyorum.
         * [1] Sipariş ekle
         * [2] Ürün Listesi
         * [3] Müşteri Listesi
         * [4] Sipariş Listesi
         * [5] Çıkış
         * */
        
  /*   
        // And döngünün kontrolü	
        boolean mainLoop = true;

        // Ana döngü
        while (mainLoop){
        	
            int mainMenuAnswer = showMainMenu();

            // Gelen cevabı kontrol ediyorum.
            switch (mainMenuAnswer) {
                case 1:
                	insertNewOrder();
                    break;
                case 2:
                	printProducts(); // ürünleri yazdıran method
                    break;
                case 3:
                	printCustomers(); // müşterileri yazdıran method
                    break;
                case 4:
                    for(Order o : oRepository.getOrderList()) {
                    	brace();
                    	System.out.println("Sipariş sahibi müşteri :" + o.getCustomer().getName()+
                    			"\nSipariş id :" + o.getId()+ "\nSipariş içeriği :");
                    	brace();
                    	for(OrderItem item : o.getItems()) {
                    		System.out.println(
                    				"Birim fiyatı :"+item.getProduct().getRetailPrice()+" olan, "
                    				+item.getQuantity() +" adet " 
                    				+ item.getProduct().getName() 
                    				+"( Fiyat :"+item.getItemTotal() + ")");
                    	}
                    }
                    break;
                case 5:
                	mainLoop = false;
                default:
                    System.out.println("Hatalı seçim.");
                    break;
            }
        } 
  */
		
	} /*
	
	// Bu methodum ile kullanıcıya ana menüyü gösteriyor ve yapmak istediği işlemi seçtiriyorum.
    // Yaptığı seçimi geri döndürüyorum.
    static int showMainMenu() {
        int select = 0;
        boolean requestLoop = true;

        while (requestLoop) {
            System.out.println("Hoşgeldiniz ! Yapmak istediğiniz işlemi seçiniz : " +
                    "\n [1] Sipariş Ekle" +
                    "\n [2] Ürün Listesi" +
                    "\n [3] Müşteri Listesi"+
                    "\n [4] Sipariş Listesi"+
                    "\n [5] Çıkış");
            try {
                select = input.nextInt();
                requestLoop = false;
            } catch (Exception e) {
                System.out.println("Hata :" + e.getMessage());
            }
        }
        return select;
    }
    
 /**
  * Bu method ile müşteri listesini yazdırıyorum.
  * 
  * */
    /*
    static int printCustomers(){
        brace();
        System.out.println("[1] Bireysel Müşteri \n[2] Kurumsal Müşteri"); // Hangi tipte müşteriler ?
        int customerType = input.nextInt();
        // Bireysel Müşterileri yazdır
        if (customerType == 1) {
            brace();
            for (Individual individual : cRepository.getIndividualCustomerList()){
            	System.out.println("["+individual.getId()+"]" + " " + individual.getName());
            }
        }
        // Kurumsal Müşterileri yazdır
        else if(customerType == 2){
            brace();
            for (Company company : cRepository.getCorporateCustomerList()){
            	System.out.println("["+company.getId()+"]" + " " + company.getName());
            }
        }
        else{
            brace();
            System.out.println("Geçersiz işlem.");
        }
        return customerType;
    } */
	
    
 // Bu method ile fake repository üzerinden gelen ürünleri listeliyorum.
	
	/*
    static void printProducts(){
    	brace();
        for (Product p : pRepository.getProductList()) {
            System.out.println("["+p.getId()+"]"+" "+p.getName());
        }
    }
    */
    
    // Bu method ile yeni bir sipariş ekliyorum.
    static void insertNewOrder() {
    	/**
    	 * Bu kısımda bir döngü yaratıyorum. Bunun sebebi kullanıcı 
    	 * bir ürün yerine birden fazla ürün seçmek isteyebilir.
    	 * */
    	
    	
    	/**
    	 * Her döngü sonunda seçilen ürünü ve ürün sayısını OrderItem haline tanımladığım bu listenin içerisine göndereceğim.
    	 * Sonrasında bu listeyi bir adet order nesnesi oluşturmak için kullanacağım.
    	 * */
    	
    	ArrayList<OrderItem> items = new ArrayList<OrderItem>(); 
    	boolean productLoop = true; // Döngü kontrolü
    	int line = 1; // her döndüğünde line arttırırız.
    	
    	double orderTotal = 0L; // kullanıcı ürün ve adet girdiği zaman üstüne eklenecektir.
    	
    	// Döngü
    	while(productLoop) {
    		System.out.print("Siparişini girmek istediğiniz ürünün kodunu giriniz : (Ayrılmak için [0])");
        	
        	printProducts(); // Ürün listesini yazdırdım.
        	int productAnswer = input.nextInt(); // Ürünün index numarasını aldım. Index numarasına göre ekleme yapacağım.
    	
        	if(productAnswer == 0) { // Kullanıcı ürün seçiminden çıkmak istersen döngüyü kırıyor ve koşulu false yapıyorum.
        		productLoop = false;
        		break;
        	}
        	System.out.println("Bu üründen kaç adet gireceksiniz ?");
        	int productCount = input.nextInt();
        	
        	// Fiyat hesaplaması ve orderTotal değişkenine eklenmesi.
        	orderTotal += pRepository.getProductList().get(productAnswer-1).getRetailPrice() * productCount;
        	
        	
        	// OrderItem nesnesini oluşturdum.
        	items.add(new OrderItem(
        			line,
        			pRepository.getProductList().get(productAnswer-1),
        			productCount
        			));
    	}
    	
    	/**
    	 * Müşteri seçtirmek için hali hazırda yazmış olduğum printCustomers() methodundan yardım alacağım.
    	 * Bu method seçilen müşteri tipininin indexini geri döndüyor. Bu bilgi ile gerekli listeden müşteri
    	 * bilgisini alacağım.
    	 * */ 
    	brace();
    	
    	// Müşteri kısmının yanlış girilme olasılığından ötürü bir döngü oluşturuyorum.
    	// Böylelikle tekrar isteyebilirim.
    	
    	boolean customerLoop = true;
    	
    	while(customerLoop) {
    		System.out.println("Müşteri tipini giriniz :");
        	int customerType = printCustomers();
        	brace();
        	System.out.println("Müşteri kimliğini giriniz :");
        	int customerIndex = input.nextInt();
        	
        	Customer selectedCustomer = new Customer();
        	// Bireysel Müşteri
        	try {
        		if(customerType == 1) {
            		
            	}
            	else if (customerType == 2) {
            		selectedCustomer = cRepository.getCorporateCustomerList().get(customerIndex-1);
            	}
        		customerLoop = false; // Buraya kadar herşey düzgün gitti. Döngüden çıkılabilir.
        	}catch(Exception e) {
        		System.out.println("Lütfen listeden müşteri seçiniz.");
        	}
        	
        	// Sipariş için gerekli müşteri bilgisini edindim, şimdi diğer gerekli işlemleri yaparak 
        	// bir order nesnesi oluşturuyorum.
        	
        	Date date = new Date(); // date sınıfım
        	
        	// order nesnesi
        	Order order = new Order(
        			selectedCustomer, // Seçilen müşteri
        			oRepository.getOrderList().size()+1, // liste boyutu bir fazlası. (Liste boş ise ilk eleman id= 1 olur)
        			items, // yukarıda seçilen orderItemlar
        			date, // date
        			orderTotal // total
        			);
        	oRepository.insertNewOrder(order);
        	System.out.println("********** işlem başarılı ! Ana menuye yonlendiriliyorsunuz ************");
        	brace();
    	}

    }
    
    
    
    static void brace(){
        System.out.println("*__*--*__*--*__*--*__*--*__*--*__*--*__*--*");
    } 
}
