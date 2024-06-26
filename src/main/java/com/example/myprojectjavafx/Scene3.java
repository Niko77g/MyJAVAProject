package com.example.myprojectjavafx;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.event.ActionEvent;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Scene3 {
    private Stage stage;
    private Scene scene;

    @FXML
    private Label nameLabel3;
    @FXML
    private Label myLabel1;
    @FXML
    private TextField myTextField1;
    @FXML
    private Label myLabel2;
    @FXML
    private TextField myTextField2;
    @FXML
    private Label myLabel3;
    @FXML
    private TextField myTextField3;
    @FXML
    private Label myLabel4;
    @FXML
    private TextField myTextFlied4;
    @FXML
    private RadioButton rButton1;
    @FXML
    private RadioButton rButton2;

    String new_nameofproduct;
    int new_numberofpiece;
    double new_price;
    private InventoryManager inventoryManager = InventoryManager.getInstance();

    public void SubmitUpdate(ActionEvent event) throws IOException {
        String productID = (myTextField1.getText());
        try {
            int id = Integer.parseInt(productID);
            new_numberofpiece = Integer.parseInt(myTextField3.getText());
            new_price = Double.parseDouble(myTextFlied4.getText());
            myTextField3.setText("");
            myTextFlied4.setText("");
            myLabel2.setText("");
            new_nameofproduct = (myTextField2.getText());
            if (rButton1.isSelected()) {
                new_nameofproduct = new_nameofproduct.toUpperCase();
            } else if (rButton2.isSelected()) {
                new_nameofproduct = new_nameofproduct.toLowerCase();
            }
            boolean isUpdated = inventoryManager.updateProduct(productID, new_nameofproduct, new_numberofpiece, new_price);
            if (isUpdated) {
                myLabel1.setText("Update was successful");
                inventoryManager.printProducts();
                System.out.println("Success");
                myTextField1.setText("");
                myTextField2.setText("");
                myTextField3.setText("");
                myTextFlied4.setText("");
            } else {
                myLabel1.setText("Update is not successful(No valid ID)");
                inventoryManager.printProducts();
            }
        }catch (NumberFormatException e){
            myLabel2.setText("Please enter the number!");
        }
    }

    public  void SwitchScene1(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Scene2.fxml"));
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
}
