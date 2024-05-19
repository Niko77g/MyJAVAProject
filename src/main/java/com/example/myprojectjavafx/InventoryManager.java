package com.example.myprojectjavafx;

import java.util.HashMap;
import java.util.Map;


public class InventoryManager {
    private Map<String, Product> products;
    private static InventoryManager instance;
    private long myIDproduct;

    public InventoryManager() {
        products = new HashMap<>();
    }
    public static InventoryManager getInstance() {
        if (instance == null) {
            instance = new InventoryManager();
        }
        return instance;
    }

    public String addProduct(String nameofproduct, int numberofpiece, double price) {
        String productID = String.format("%04d", myIDproduct++);
        Product product = new Product(productID, nameofproduct, numberofpiece, price);
        products.put(productID, product);
        System.out.println("Added product: " + productID);
        return productID;
    }

    public boolean updateProduct(String productID, String new_nameofproduct, int new_numberofpiece, double new_price) {
        Product product = products.get(productID);
        if (product != null) {
            product.setNameofproduct(new_nameofproduct);
            product.setNumberofpiece(new_numberofpiece);
            product.setPrice(new_price);
            return true;
        } else {
            return false;
        }
    }

    public void printProducts() {
        System.out.println("Printing all products:");
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (Map.Entry<String, Product> entry : products.entrySet()) {
                String id = entry.getKey();
                Product product = entry.getValue();
                System.out.println("Product ID: " + id + ", Name: " + product.getNameOfProduct() +
                        ", Quantity: " + product.getNumberOfPiece() + ", Price: " + product.getPrice());
            }
        }

    }


    class Product {
        private String id;
        private String nameofproduct;
        private int numberofpiece;
        private double price;

        public Product(String id, String nameofproduct, int numberofpiece, double price) {
            this.id = id;
            this.nameofproduct = nameofproduct;
            this.numberofpiece = numberofpiece;
            this.price = price;
        }

        public String getNameOfProduct() {
            return nameofproduct;
        }

        public void setNameofproduct(String new_nameofproduct) {
            this.nameofproduct = new_nameofproduct;
        }

        public int getNumberOfPiece() {
            return numberofpiece;
        }

        public void setNumberofpiece(int new_numberofpiece) {
            this.numberofpiece = new_numberofpiece;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double newPrice) {
            this.price = newPrice;
        }


    }
}
