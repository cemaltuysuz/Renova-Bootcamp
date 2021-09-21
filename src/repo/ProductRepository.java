package repo;
import java.util.*;

import model.Hardware;
import model.Manual;
import model.Product;
import model.Software;
/**
 * Bu sınıf fake bir repository olup rastgele eklenmiş ürünleri sağlıyor.
 * Singleton yapıda oluşturuldu. Herhangi bir Threading işlemi kendi içinde barındırmadığı için @volatile gibi anahtar
 * kelimeler kullanılmamıştır.
 * */

public class ProductRepository {
	
	
	// Ürün listesi
    private final ArrayList<Product> productList;

    // Yapıcı Method
    public ProductRepository() {
        this.productList = new ArrayList<Product>();
    }

    // Instance
    private static ProductRepository productRepo;

    // Nesneyi tekil bir şekilde sağlamak için gerekli methodum.
    public static ProductRepository getInstance(){
        if (productRepo == null) {
            productRepo = new ProductRepository();
        }
        return productRepo;
    }

    public List<Product> getProductList(){
        if (productList.isEmpty()){
            // Ürün 1 (Product tipinde)
            productList.add(
                    new Product(
                            "Aracın tümseklerden ve düz olmayan yollardan daha rahat geçebilmesini sağlayan sistem.",
                            1,
                            "Süspansiyon",
                            100.50)
            );
            // Ürün 2 (Hardware)
            productList.add(
                    new Hardware(
                            "Sürüş deneyimi ve konforu açısından büyük öneme sahip olan lastikler.",
                            2,
                            "Lastik",
                            130.20,
                            2)
            );
            // Ürün 3 (Software)
            productList.add(
                    new Software(
                            "Güvenilir fren sistemleri.",
                            3,
                            "Fren",
                            120.60,
                            "546372537")
            );
            
         // Ürün 4 (Manual)
            productList.add(
                    new Manual(
                            "Konforlu araba koltukları.",
                            4,
                            "Koltuk",
                            120.60,
                            "Apple")
            );
        }
        return productList;
    }

}
