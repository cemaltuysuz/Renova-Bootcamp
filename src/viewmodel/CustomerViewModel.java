package viewmodel;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Company;
import model.Customer;
import model.Hardware;
import model.Individual;
import model.Manual;
import model.Product;
import model.Software;
import repo.CustomerRepository;

/**
 * Bu sınıf ile Customer tablosunu oluşturorum.
 * */

public class CustomerViewModel {
	
	// get customer reposiyory
	private CustomerRepository cRepository = CustomerRepository.getInstance();
	
	public JFrame generateCustomerWindow() {
		
		// customer JFrame and settings
		JFrame customerJF = new JFrame("Customers"); // Create a new JFrame for customers
		customerJF.setSize(700, 300); // Size
		customerJF.setLocation(300, 150); // Location
		
		// get customer list <- Customer Repository
		List<Customer> myCustomerList = cRepository.getCustomerList();
		
		// Create multiple array
		String customers[][] = new String[myCustomerList.size()][8]; // Create new double array for table
		
		/**
		 * Fill the array with customer values
		 * */
		
		int index = 0;
		for(Customer c :myCustomerList) {
			customers[index][0] = String.valueOf(index);
			customers[index][2] = c.getName();
			customers[index][3] = c.getPhone();
			customers[index][4] = c.getAddress();
			// If this product is company, set contact and discount
			if(c instanceof Company) { 
				customers[index][1] = "Company";
				customers[index][5] = ((Company)c).getContact();
				customers[index][6] = String.valueOf(((Company)c).getDiscount());
			}
			// If this product is Individual, set licNumber
			else if(c instanceof Individual) {
				customers[index][1] = "Individual";
				customers[index][7] = ((Individual)c).getLicNumber();
			}
			else {
				customers[index][1] = "Customer";
			}
			
			index++;
		}
		
		 // Create new array for customer field's titles.
		String[]title = {"Code","Type","Name","Phone","Adress","Contact","Discount","Lic Num"};
		
		JTable customerTable = new JTable(customers,title); // Create JTable
		customerTable.setBounds(30,40,200,300);
		
		JScrollPane sc = new JScrollPane(customerTable); // Scroll pane for show titles
		
		customerJF.add(sc); // insert content pane
		
		return customerJF;
		
	}

}
