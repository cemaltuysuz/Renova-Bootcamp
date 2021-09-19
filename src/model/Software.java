package model;

public class Software extends Product {
	
	private String license;

    public Software(String description, int id, String name, double retailPrice, String license) {
        super(description, id, name, retailPrice);
        this.license = license;
    }

    public String getLicense() {
        return license;
    }

}
