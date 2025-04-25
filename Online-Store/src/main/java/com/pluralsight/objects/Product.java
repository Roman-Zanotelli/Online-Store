package com.pluralsight.objects;

public class Product {
    private String id;
    private String name;
    private float price;
    private String department;
    public Product(String id, String name, float price, String department) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.department = department;
    }
    public Product() {
        this.id = "";
        this.name = "";
        this.price = 0.0f;
        this.department = "";
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f %s", id, name, price, department);
    }
}

