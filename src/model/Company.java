package model;

public class Company extends Customer {
	
	String contact;
    int discount;

    public Company(int id, String name, String address, String phone, String contact, int discount) {
        super(id, name, address, phone);
        this.contact = contact;
        this.discount = discount;
    }

    public Company(String contact, int discount) {
        this.contact = contact;
        this.discount = discount;
    }

    public String getContact() {
        return contact;
    }

    public int getDiscount() {
        return discount;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}
