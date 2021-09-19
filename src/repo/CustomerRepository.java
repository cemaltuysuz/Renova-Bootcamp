package repo;
import java.util.*;

import model.Company;
import model.Individual;
/**
 * Bu sınıf fake bir repository olup rastgele eklenmiş müşterileri sağlıyor.
 * Singleton yapıda oluşturuldu. Herhangi bir Threading işlemi kendi içinde barındırmadığı için @volatile gibi anahtar
 * kelimeler kullanılmamıştır.
 * */

public class CustomerRepository {
	
	 // Kurumsal müşterilerin listesi
    private final ArrayList<Company> corporateCustomerList;
    // Bireysel Müşterilerin listesi
    private final ArrayList<Individual> individualCustomerList;

    // Yapıcı methodum
    public CustomerRepository() {
        corporateCustomerList = new ArrayList<Company>();
        individualCustomerList = new ArrayList<Individual>();
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
    public List<Company> getCorporateCustomerList() {
        if (corporateCustomerList.isEmpty()){
            // Kurumsal Müşteri 1
            corporateCustomerList.add(
                    new Company(
                            1,
                            "BMW",
                            "Address 1",
                            "Phone 1",
                            "Mail 1",
                            30));
            // Kurumsal Müşteri 2
            corporateCustomerList.add(
                    new Company(
                            2,
                            "Ford",
                            "Address 2",
                            "Phone 2",
                            "Mail 2",
                            25));

            // Kurumsal Müşteri 3
            corporateCustomerList.add(
                    new Company(
                            3,
                            "Fiat",
                            "Address 3",
                            "Phone 3",
                            "Mail 3",
                            35));
        }
        return corporateCustomerList;
    }

    // Bireysel müşterilin listesini ImMutable şekilde alabileceğim methodum
    // Liste boş ise fake müşteriler ekler.
    public List<Individual> getIndividualCustomerList() {
        if (individualCustomerList.isEmpty()){
            // Bireysel müşteri 1
            individualCustomerList.add(
                    new Individual(
                            1,
                            "Cemal TUYSUZ",
                            "Address 1",
                            "Phone 1",
                            "123456789"));
            // Bireysel Müşteri 2
            individualCustomerList.add(
                    new Individual(
                            2,
                            "Ali PAMUK",
                            "Address 2",
                            "Phone 2",
                            "123456789"));

            // Bireysel Müşteri 3
            individualCustomerList.add(
                    new Individual(
                            1,
                            "Veli DEMIR",
                            "Address 3",
                            "Phone 3",
                            "123456789"));
        }
        return individualCustomerList;
    }

}
