import java.util.Scanner;

import model.Company;
import model.Individual;
import model.Product;
import repo.CustomerRepository;
import repo.ProductRepository;

public class Test {
	
	static Scanner input;
    static CustomerRepository cRepository;
    static ProductRepository pRepository;
	
	public static void main (String [] args) {
		
		// Scanner
        input = new Scanner(System.in);

        // Customer Repository
        cRepository = CustomerRepository.getInstance();
        // Product Repository
        pRepository = ProductRepository.getInstance();

        // And döngünün kontrolü	
        boolean mainLoop = true;

        // Ana döngü
        while (mainLoop){
        	
        	/**
        	 * Kullanıcıya yapmasını istediği işlemi seçtirebilmek için menü gösteriyorum.
             * [1] Sipariş ekle
             * [2] Ürün Listesi
             * [3] Müşteri Listesi
             * */
            int mainMenuAnswer = showMainMenu();

            // Gelen cevabı kontrol ediyorum.
            switch (mainMenuAnswer) {
                case 1:
                	System.out.println("Sipariş ekle");
                    break;
                case 2:
                	printProducts(); // ürünleri yazdıran method
                    break;
                case 3:
                	printCustomers(); // müşterileri yazdıran method
                    break;
                case 4:
                    System.out.println("Çıkış yapılıyor.");
                    mainLoop = false;
                    break;
                default:
                    System.out.println("Hatalı seçim.");
                    break;
            }
        }
		
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
    
 // Müşteri listesini yazdıran methodum.
    static void printCustomers(){
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
    }
    
 // Bu method ile fake repository üzerinden gelen ürünleri listeliyorum.
    static void printProducts(){
        for (Product p : pRepository.getProductList()) {
            System.out.println("["+p.getId()+"]"+" "+p.getName());
        }
    }
    
    
    
    static void brace(){
        System.out.println("*__*--*__*--*__*--*__*--*__*--*__*--*__*--*");
    }

}