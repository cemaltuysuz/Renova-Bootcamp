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
	
	
	
	public JFrame generateProductWindow() {
		
		JFrame productJF = new JFrame("Ürünler"); // Create a new JFrame for products
		productJF.setSize(700, 300); // Size
		productJF.setLocation(300, 150); // Location
		
		List<Product> myProductList = pRepository.getProductList(); // Get Product List 
		
		String products[][] = new String[myProductList.size()][7]; // Create new double array for table
		
		/**
		 * Fill the array with product values
		 * */
		
		int index = 0;
		for(Product p :myProductList) {
			products[index][1] = p.getName();
			products[index][2] = String.valueOf(p.getRetailPrice());
			// If this product is hardware, set WarrantyPeriod and tax
			if(p instanceof Hardware) { 
				products[index][0] = "Hardware";
				products[index][3] = String.valueOf(((Hardware)p).getWarrantyPeriod());
				products[index][6] = String.valueOf(((Hardware)p).getTax());
			}
			// If this product is Manual, set Publisher
			else if(p instanceof Manual) {
				products[index][0] = "Manual";
				products[index][4] = String.valueOf(((Manual)p).getPublisher());
			}
			// If this product is Software, set license
			else if(p instanceof Software) {
				products[index][0] = "Software";
				products[index][5] = String.valueOf(((Software)p).getLicense());
			}else {
				products[index][0] = "Product";
			}
			
			index++;
		}
		 // Create new array for product field's titles.
		String[]title = {"Type","Name","Retail Price","Warranty","Publisher","License","Tax"};
		
		JTable productTable = new JTable(products,title); // Create JTable
		productTable.setBounds(30,40,200,300);
		
		JScrollPane sc = new JScrollPane(productTable); // Scroll pane for show titles
		
		productJF.add(sc); // insert content pane
		
		return productJF;
	} 

}
