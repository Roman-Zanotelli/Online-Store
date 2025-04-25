package com.pluralsight;

import com.pluralsight.objects.Product;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    //main menu
    public static void run(){
        System.out.println("Welcome to the Store! \n");

        while(true) {

            System.out.println("Please choose from the following options \n");

            System.out.println("What would you like to do");
            System.out.println("1: Display Products");
            System.out.println("2: Display Cart");
            System.out.println("3: Leave the store");

            System.out.print("Please enter your selection here: ");

            switch(scanInt()){
                case 1://go to first page(menu)
                    System.out.println("Continue to menu (Please hit Enter): ");
                    scanner.nextLine();
                    displayProducts();//calls display products menu
                    break;
                case 2: // go to second page(Cart)
                    System.out.println("Continue to cart (Please hit Enter): ");
                    scanner.nextLine();
                    displayCart(); // calls display cart menu
                    break;
                case 3: // exit out of store
                    System.exit(0);
                default:
                    System.out.println("Invalid option selected, please try again\n");
            }

        }
    }

    //PRODUCTS MENU!
    private static void displayProducts(){
        System.out.println("All Products: ");
        for (Product product: StoreApp.inventory.getProducts()){
            System.out.println(product);
        }
        System.out.println("1: Filter list of products");
        System.out.println("2: Add chosen product to cart");
        System.out.println("Other: Return to home page");

        System.out.print("Please enter your selection here: ");
        switch(scanInt()){
            case 1://Filter list of products
                System.out.println("Continue to product list (Please hit Enter): ");
                scanner.nextLine();
                search();
                break;
            case 2:
                System.out.println("Add product into cart (Please hit Enter): ");
                scanner.nextLine();
                addProduct();
                break;
            default:
                System.out.println("Return to menu (Please hit Enter): \n");
                scanner.nextLine();
        }

    }
    private static void search(){
        System.out.println("How would you like to ");
        System.out.println("1: Search by Product Name");
        System.out.println("2: Search by Price");
        System.out.println("3: Search by Department");
        System.out.print("Please enter your selection here: ");
        switch(scanInt()){
            case 1:
                System.out.println("Continue to Name search (Please hit Enter) \n");
                scanner.nextLine();
                searchName();
                break;
            case 2:
                System.out.println("Continue to Price filter (Please hit Enter) \n");
                scanner.nextLine();
                searchPrice();
                break;
            case 3:
                System.out.println("Continue to Departmental Search (Please hit Enter) \n");
                scanner.nextLine();
                searchDepartment();
                break;
        }
    }
    private static void searchName(){
        System.out.print("Enter the Product Name: ");
        String name = scanner.nextLine();
        System.out.println("Products Found: ");
        for (Product product : StoreApp.inventory.getProductsByName(name)){
            System.out.println(product);
        }
    }
    private static void searchPrice(){
        System.out.print("Please enter min price: ");
        float min = scanFloat();
        System.out.print("Please enter max price: ");
        float max = scanFloat();
        System.out.println("Products Found: ");
        for (Product product : StoreApp.inventory.getProductsByPriceRange(min, max)){
            System.out.println(product);
        }
        System.out.println("Continue to Name search (Please hit Enter) \n");
        scanner.nextLine();
    }
    private static void searchDepartment(){
        System.out.print("Please enter Department name to filter by: ");
        String department = scanner.nextLine();
        System.out.println("Products Found: ");
        for (Product product : StoreApp.inventory.getProductsByDepartment(department)){
            System.out.println(product);
        }
        System.out.println("Continue to Name search (Please hit Enter) \n");
        scanner.nextLine();
    }
    private static void addProduct(){
        System.out.print("Enter product ID: ");
        String productID = scanner.nextLine();
        System.out.println();
        System.out.print("Enter amount of Product you would like: ");
        int purchaseAmount = scanInt();
        StoreApp.cart.addToCart(productID, purchaseAmount);
        System.out.println("Continue to Name search (Please hit Enter) \n");
        scanner.nextLine();
    }

    //CART MENU!!!!
    private static void displayCart(){
        System.out.println("All products inside cart:");
        for(Product product : StoreApp.cart.getCartInventory()){
            System.out.println(product);
        }
        System.out.println("1: Check out");
        System.out.println("2: Remove Product from Cart");
        System.out.println("Other: Return to home page");
        switch(scanInt()){
            case 1:// check out
                System.out.println("Continue to Check out (Please hit Enter): ");
                scanner.nextLine();
                checkOutMenu();
                break;
            case 2: // remove product from cart, go to page to insert product to remove
                System.out.println(" (Please hit Enter): ");
                scanner.nextLine();
                removeMenu();
                break;
            default:
                System.out.println("Return to menu (Please hit Enter): \n");
                scanner.nextLine();
        }

    }
    private static void checkOutMenu(){
        System.out.println("Check Out Selected!");
        System.out.println(StoreApp.cart.preCheckOut());
        System.out.print("Please Enter Pay Amount: ");
        System.out.println(StoreApp.cart.checkOut(scanFloat()));
        System.out.println("Continue to Name search (Please hit Enter) \n");
        scanner.nextLine();
    }
    private static void removeMenu(){
        System.out.println("Remove Selected!");
        System.out.println("Please Enter ID: ");
        String id = scanner.nextLine().trim();
        System.out.println("Please Enter Amount: ");
        StoreApp.cart.removeFromCartByID(id, scanInt());
        System.out.println("Continue to Name search (Please hit Enter) \n");
        scanner.nextLine();
    }

    //here are convience methods
    private static int scanInt(){
       while(!scanner.hasNextInt()) {
           scanner.nextLine();
           System.out.println("Please ONLY enter an Integer");
           System.out.print("Enter number here: ");
       }
       int choice = scanner.nextInt();
       scanner.nextLine();
       return choice;
    }
    private static float scanFloat(){

        while(!scanner.hasNextFloat()) {
            scanner.nextLine();
            System.out.println("Please only enter a float");
            System.out.print("Enter number here: ");
        }
        float choice = scanner.nextFloat();
        scanner.nextLine();
        return choice;
    }


}
//• The Store Home Screen - The home screen should display a list
//of options that a user can choose from.
//- Display Products
//- Display Cart
//- Exit - closes out of the application
//• Display Products - Displays a list of products that your store
//sells.
//o On this screen the customer should be able to
//- Search or filter the list of products
//- Add a product to their cart
//- Go Back to the home page
//• Display Cart - This displays a list of line items that are in the
//customer's cart. It should also display the total sales amount of
//the cart.
//o The customer should be able to:
//        - Check Out
//- Remove Product from the cart
//- Go Back to the home screen
//o If the customer chooses to remove a product need to prompt
//them for the product to remove
