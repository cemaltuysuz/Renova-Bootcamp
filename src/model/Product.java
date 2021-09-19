package model;

public class Product {
	
	private String description;
    private int id;
    private String name;
    private double retailPrice;

    public Product(String description, int id, String name, double retailPrice) {
        this.description = description;
        this.id = id;
        this.name = name;
        this.retailPrice = retailPrice;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "description='" + description + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", retailPrice=" + retailPrice +
                '}';
    }

}
