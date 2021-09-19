package model;

public class Hardware extends Product implements Taxable {
	
	private int warrantyPeriod;

    public Hardware(String description, int id, String name, double retailPrice, int warrantyPeriod) {
        super(description, id, name, retailPrice);
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    @Override
    public double getTax() {
        return 0;
    }

}
