package com.example.myprojectjavafx;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class InventoryManager {
    private final Map<String, Product> products;
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
        new Thread(() -> {
            Product product = new Product(productID, nameofproduct, numberofpiece, price);
            products.put(productID, product);
            System.out.println("Added product: " + productID);
            System.out.println(nameofproduct);
        }).start();
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
    public boolean removeProduct(String productID){

        if(products.containsKey(productID)){
            products.remove(productID);
            return true;
        } else {
            return false;
        }
    }
    public String searchProduct(String productID){
        Product product = products.get(productID);
        if(product != null){
            System.out.println("V searchProduct");
           String dataofproduct = "Product ID: " + productID + "\nProduct Name: " + product.nameofproduct + "\nProduct of piece: " + product.numberofpiece + "\nProduct Price: " + product.price;
           return dataofproduct;
        } else {
            return "Product ID " + productID + " not find";
        }
    }
    public void Writetofile(File file){
            BufferedWriter bf = null;
            try {
                bf = new BufferedWriter(new FileWriter(file));
                for (Map.Entry<String, Product> entry : products.entrySet()) {
                    bf.write("Product ID: " + entry.getKey() + " Product name: " + entry.getValue().getNameOfProduct() + " Product of piece: "
                            + entry.getValue().getNumberOfPiece() + " Product price: " + entry.getValue().getPrice()
                    );
                    bf.newLine();
                }
                bf.flush();
            } catch (IOException e) {
                e.printStackTrace();

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
