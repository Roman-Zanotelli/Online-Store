package com.pluralsight.objects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Inventory {
    private ArrayList<Product> inventory = new ArrayList<>();

    public Inventory() {

    }

    //Loads products when called
    public ArrayList<Product> loadProducts() {
        try {
            FileReader fileReader = new FileReader("src/main/resources/products.csv");
            BufferedReader reader = new BufferedReader(fileReader);

            String input;

            while ((input = reader.readLine()) != null) {
                if (input.startsWith("SKU")) {
                    continue;
                }
                String[] items = input.split("\\|");
                String id = items[0];
                String name = items[1];
                float price = Float.parseFloat(items[2]);
                String department = items[3];

                inventory.add(new Product(id, name, price, department));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inventory;
    }

    //Sends the products when called.
    public ArrayList<Product> getProducts() {
        return inventory;
    }

    //Sends products by specific name.a
    public ArrayList<Product> getProductsByName(String name) {
        ArrayList<Product> specificNameList = new ArrayList<>();
        String searchName = name;

        for (Product product : inventory) {
            if (product.getName().equalsIgnoreCase(searchName)) {
                specificNameList.add(new Product(product.getId(), product.getName(), product.getPrice(), product.getDepartment()));
            }
        }
        return specificNameList;
    }

    //Sends products by specific price.
    public ArrayList<Product> getProductsByPrice(float price) {
        ArrayList<Product> specificPriceList = new ArrayList<>();
        float searchPrice = price;

        for (Product product : inventory) {
            if (product.getPrice() == searchPrice) {
                specificPriceList.add(new Product(product.getId(), product.getName(), product.getPrice(), product.getDepartment()));
            }
        }
        return specificPriceList;
    }

    //Sends products by department name.
    public ArrayList<Product> getProductsByDepartment(String department) {
        ArrayList<Product> specificDepartmentList = new ArrayList<>();
        String searchDepartment = department;

        for (Product product : inventory) {
            if (product.getName().equalsIgnoreCase(searchDepartment)) {
                specificDepartmentList.add(new Product(product.getId(), product.getName(), product.getPrice(), product.getDepartment()));
            }
        }
        return specificDepartmentList;
    }

    //Sends products by price range. (MinValue:MaxValue)
    public ArrayList<Product> getProductsByPriceRange(float min, float max) {
        ArrayList<Product> specificPriceList = new ArrayList<>();
        float minValue = min, maxValue = max;
        for (Product product : inventory) {
            if (minValue <= product.getPrice() && product.getPrice() < maxValue) {
                specificPriceList.add(new Product(product.getId(), product.getName(), product.getPrice(), product.getDepartment()));
            }
        }
        return specificPriceList;
    }
    public Product getProductById(String id) {
        Product found = new Product();
        String searchId = id;

        for (Product product : inventory) {
            if (product.getId().equalsIgnoreCase(searchId)) {
                return product;
            }
        }
        return found;
    }

}

