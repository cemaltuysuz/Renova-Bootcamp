package repo;
import java.util.*;

import model.Product;
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
            // Ürün 1
            productList.add(
                    new Product(
                            "Aracın tümseklerden ve düz olmayan yollardan daha rahat geçebilmesini sağlayan sistem.",
                            1,
                            "Süspansiyon",
                            100.50)
            );
            // Ürün 2
            productList.add(
                    new Product(
                            "Sürüş deneyimi ve konforu açısından büyük öneme sahip olan lastikler.",
                            2,
                            "Lastik",
                            130.20)
            );
            // Ürün 3
            productList.add(
                    new Product(
                            "Uzun ömürlü ve sizi yolda bırakmayacak aküler.",
                            3,
                            "Akü",
                            120.60)
            );
        }
        return productList;
    }

}
