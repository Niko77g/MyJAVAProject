package com.example.myprojectjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.event.ActionEvent;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

public class Scene2 {

    private Stage stage;
    private Scene scene;

    @FXML
    private Label myLabel1;
    @FXML
    private TextField myTextField1;
    @FXML
    private Label MyLabel2;
    @FXML
    private TextField myTextField2;
    @FXML
    private Label MyLabel3;
    @FXML
    private TextField myTextField3;
    @FXML
    private  Label MyLabel4;
    private InventoryManager inventoryManager = InventoryManager.getInstance();
    String nameofproduct;
    int numberofpiece;
    double price;

    public void SubmitAdd(ActionEvent event){
        nameofproduct = (myTextField1.getText());
        if (nameofproduct.isEmpty()){
            myLabel1.setText("Product name cannot be empty!");
            return;
        } else {
            myLabel1.setText("Name of the product: ");
        }
        try {
            numberofpiece = Integer.parseInt(myTextField2.getText());
            MyLabel2.setText("Number of piece:");
            price = Double.parseDouble(myTextField3.getText());
            MyLabel3.setText("Set price of product");
            myTextField1.setText("");
            myTextField2.setText("");
            myTextField3.setText("");
            MyLabel4.setText("");
        }
        catch (NumberFormatException e){
            MyLabel2.setText("You must write only number!");
            MyLabel3.setText("You must write only number!");
            return;
        }

        String productID = inventoryManager.addProduct(nameofproduct,numberofpiece,price);
        try {
            FileWriter data = new FileWriter("datainventory.txt",true);
            data.append("\n ID product: "+ productID + "\n Product name: " + nameofproduct + "\n Product piece: "+ numberofpiece +"\n Product price: " + price + "\n ----------------------------------------");
            data.close();
            MyLabel4.setText("Sent successfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /*
        System.out.println(nameofproduct);
        System.out.println(numberofpiece);
        System.out.println(price);

         */
    }

    public  void SwitchScene1(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Scene2.fxml"));
        Parent root = fxmlLoader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void SwitchScene2(ActionEvent event)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Scene3.fxml"));
        Parent root = fxmlLoader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void SwitchScene3(ActionEvent event) throws  IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Scene4.fxml"));
        Parent root = fxmlLoader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void SwitchScene4(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Scene5.fxml"));
        Parent root = fxmlLoader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchSceneMenu(ActionEvent event) throws  IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SceneMenu.fxml"));
        Parent root = fxmlLoader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}