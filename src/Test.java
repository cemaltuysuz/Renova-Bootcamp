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
import viewmodel.ProductViewModel;
import model.OrderItem;
public class Test {
	
	// @author Cemal tüysüz
	// @date 10.09.2021
	
	static Scanner input;
    static CustomerRepository cRepository;
    static ProductRepository pRepository;
    static OrderRepository oRepository;
	
	public static void main (String [] args) {
		
		// Scanner
        input = new Scanner(System.in);
        
        ProductViewModel pViewModel = new ProductViewModel();

        cRepository = CustomerRepository.getInstance(); // Customer Repository
        pRepository = ProductRepository.getInstance(); // Product Repository
        oRepository = OrderRepository.getInstance(); // Order Repository
        
        JFrame jfm = new JFrame("Renova BootCamp"); // Main Window
        jfm.setSize(700, 600); 						// Window Size
        jfm.setLocation(300, 150); 					// Window Location
        
        jfm.getContentPane().setLayout(new FlowLayout()); // Layout
    
        JButton productList  = new JButton("Product List"); // it's open the Product List's window
        JButton customerList = new JButton("Customer List"); // it's open the Customer List window
        JButton orderList    = new JButton("Order List"); // it's open the Order List window
        
        jfm.getContentPane().add(productList); // Product list button add Content pane
        jfm.getContentPane().add(customerList); // Customer list button add Content pane
        jfm.getContentPane().add(orderList); // Order list button add Content pane
        
        // ProductList button set OnClick Listener
        productList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// Generate product window
					JFrame productsWindow = pViewModel.generateProductWindow(); 
					productsWindow.setVisible(true); // visibility
				}catch(Exception e1) {
					// TODO ()
				}
			}
        });
        
        // CustomerListButton set OnClick Listener
        customerList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// Generate product window
					JFrame customerWindow = pViewModel.generateProductWindow(); 
					customerWindow.setVisible(true); // visibility
				}catch(Exception e1) {
					// TODO ()
				}
			}
        });
        
     // OrderListButton set OnClick Listener
        orderList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// Generate product window
					JFrame customerWindow = pViewModel.generateProductWindow(); 
					customerWindow.setVisible(true); // visibility
				}catch(Exception e1) {
					// TODO ()
				}
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
		
	}
	
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
    }
    
 // Bu method ile fake repository üzerinden gelen ürünleri listeliyorum.
    static void printProducts(){
    	brace();
        for (Product p : pRepository.getProductList()) {
            System.out.println("["+p.getId()+"]"+" "+p.getName());
        }
    }
    
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
            		selectedCustomer = cRepository.getIndividualCustomerList().get(customerIndex-1);
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
