package model;

public class Individual extends Customer {
	
	 private String licNumber;

	    public Individual(int id, String name, String address, String phone, String licNumber) {
	        super(id, name, address, phone);
	        this.licNumber = licNumber;
	    }

	    public Individual(String licNumber) {
	        this.licNumber = licNumber;
	    }

	    public String getLicNumber() {
	        return licNumber;
	    }

	    public void setLicNumber(String licNumber) {
	        this.licNumber = licNumber;
	    }

	    @Override
	    public String toString() {
	        return "Individual{" +
	                "licNumber='" + licNumber + '\'' +
	                ", id=" + id +
	                ", name='" + name + '\'' +
	                ", address='" + address + '\'' +
	                ", phone='" + phone + '\'' +
	                '}';
	    }

}
