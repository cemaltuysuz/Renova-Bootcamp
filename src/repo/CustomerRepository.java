package repo;
import java.util.*;

import model.Company;
import model.Customer;
import model.Individual;
/**
 * Bu sınıf fake bir repository olup rastgele eklenmiş müşterileri sağlıyor.
 * Singleton yapıda oluşturuldu. Herhangi bir Threading işlemi kendi içinde barındırmadığı için @volatile gibi anahtar
 * kelimeler kullanılmamıştır.
 * */

public class CustomerRepository {
	
	 // Müşteri listesi
    private final ArrayList<Customer> customerList;

    // Yapıcı methodum
    public CustomerRepository() {
    	customerList = new ArrayList<Customer>();
    }

    // Instance
    private static CustomerRepository customerRepo;

    // Nesneyi tekil bir şekilde sağlamak için gerekli methodum.
    public static CustomerRepository getInstance(){
        if (customerRepo == null) {
            customerRepo = new CustomerRepository();
        }
        return customerRepo;
    }

    // Kurumsal müşterilin listesini ImMutable şekilde alabileceğim methodum
    // Liste boş ise fake müşteriler ekler.
    
    public List<Customer> getCustomerList() {
    	
        if (customerList.isEmpty()){
        	
            // Kurumsal Müşteri 
        	
        	customerList.add(
                    new Company(
                            1,
                            "BMW",
                            "Address 1",
                            "Phone 1",
                            "Mail 1",
                            30));
        	
            // Bireysel Müşteri 1
        	customerList.add(
                    new Individual(
                            2,
                            "Cemal tuysuz",
                            "Address 2",
                            "Phone 2",
                            "license123"));

            // Kurumsal Müşteri 3
        	customerList.add(
                    new Company(
                            3,
                            "FORD",
                            "Address 2",
                            "Phone 2",
                            "Mail 2",
                            25));
        	
        	// Bireysel Müşteri 2
        	customerList.add(
                    new Individual(
                            2,
                            "Ali veli",
                            "Address 3",
                            "Phone 4",
                            "license321"));
        }
        return customerList;
    }
}
