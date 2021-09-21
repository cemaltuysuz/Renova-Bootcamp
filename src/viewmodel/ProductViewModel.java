package viewmodel;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Hardware;
import model.Manual;
import model.Product;
import model.Software;
import repo.ProductRepository;

public class ProductViewModel {
	
	static ProductRepository pRepository = ProductRepository.getInstance();
	
	
	
	public JTable generateProductWindow() {
		
		List<Product> myProductList = pRepository.getProductList(); // Get Product List 
		
		String products[][] = new String[myProductList.size()][8]; // Create new double array for table
		
		/**
		 * Fill the array with product values
		 * */
		
		int index = 0;
		for(Product p :myProductList) {
			products[index][0] = String.valueOf(index);
			products[index][2] = p.getName();
			products[index][3] = String.valueOf(p.getRetailPrice());
			// If this product is hardware, set WarrantyPeriod and tax
			if(p instanceof Hardware) { 
				products[index][1] = "Hardware";
				products[index][4] = String.valueOf(((Hardware)p).getWarrantyPeriod());
				products[index][7] = String.valueOf(((Hardware)p).getTax());
			}
			// If this product is Manual, set Publisher
			else if(p instanceof Manual) {
				products[index][1] = "Manual";
				products[index][5] = String.valueOf(((Manual)p).getPublisher());
			}
			// If this product is Software, set license
			else if(p instanceof Software) {
				products[index][1] = "Software";
				products[index][6] = String.valueOf(((Software)p).getLicense());
			}else {
				products[index][1] = "Product";
			}
			
			index++;
		}
		// Create new array for product field's titles.
		String[]title = {"Code","Type","Name","Retail Price","Warranty","Publisher","License","Tax"};
		
		JTable productTable = new JTable(products,title); // Create JTable
		productTable.setBounds(30,40,200,300);
		
		
		return productTable;
	} 

}
