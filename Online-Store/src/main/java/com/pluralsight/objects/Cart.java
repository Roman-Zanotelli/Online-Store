package com.pluralsight.objects;

import com.pluralsight.StoreApp;

import java.util.ArrayList;

public class Cart {
    private static ArrayList<Product> cart_inventory = new ArrayList<>();
    public void addToCart(String id, int amount){
         Product product = StoreApp.inventory.getProductById(id);
         for (int i = 0 ; i < amount ; i++){
             cart_inventory.add(product);
         }
    }
    public boolean removeFromCartByName(String name, boolean removeAll){
        boolean res = false;
        for(Product product : cart_inventory){
            if(product.getName().equalsIgnoreCase(name)){
                cart_inventory.remove(product);
                if(!removeAll) return true; //exit early if remove all is false
                res = true;
            }
        }
        return res;
    }
    public void removeFromCartByID(String id, int amount){
        int amount_removed = 0;
        for(int i = 0; i < cart_inventory.toArray().length; i++){
            if(cart_inventory.get(i).getId().equalsIgnoreCase(id)){
                cart_inventory.remove(i);
                if(amount_removed >= amount) return;
                amount_removed++;
            }
        }
    }
    public ArrayList<Product> getCartInventory(){
        return cart_inventory;
    }
    public String preCheckOut(){
        float total_price = 0;

        for (Product item : cart_inventory){
            total_price += item.getPrice();
        }
        return String.format("Total Price Due: $%.2f", total_price);
    }

    public String checkOut(float amountPayed){
        float total_price = 0;
        for (Product item : cart_inventory){
            total_price += item.getPrice();
        }

        if (total_price <= amountPayed){
            flushCart(); //flushes cart and writes receipt
            return String.format("Amount Payed in Full! Total Cost: $%.2f, Payment Received: $%.2f, Change Due: $%.2f", total_price, amountPayed, total_price - amountPayed);
        }

        return String.format("Amount Payed in Full! Total Cost: $%.2f, Payment Received: $%.2f, Amount Due: -$%.2f", total_price, amountPayed, total_price - amountPayed);
    }
    private void flushCart(){
        //todo: add receipt
        cart_inventory.clear(); //clear cart
    }


}
