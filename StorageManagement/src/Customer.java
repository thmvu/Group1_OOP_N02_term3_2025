package models;

public class Customer {
    private String id;
    private String name;
    private String phone;

    public Customer(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public String getInfo() {
        return name + " - " + phone;
    }

    // Getters and Setters...
}
