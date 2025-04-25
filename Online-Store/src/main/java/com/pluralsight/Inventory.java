package com.pluralsight;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    private static ArrayList<Product> products = new ArrayList<>();
    public Inventory() {

    }
    public static ArrayList<Product> getProducts() {
        return products;
    }
}

