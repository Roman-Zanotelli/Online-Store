package com.pluralsight;

import com.pluralsight.objects.Cart;
import com.pluralsight.objects.Inventory;

public class StoreApp {
    public static Cart cart = new Cart();
    public static Inventory inventory = new Inventory();
    public static void main(String[] args) {
        inventory.loadProducts();
        Menu.run();
    }
}
