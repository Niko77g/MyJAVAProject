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

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Scene4 {
    private Stage stage;
    private Scene scene;

    @FXML
    private Label myLabel1;
    @FXML
    private TextField myTextField1;

    private InventoryManager inventoryManager = InventoryManager.getInstance();
    public void SubmitRemove(ActionEvent event)throws IOException {
        String productID = (myTextField1.getText());
        try {
            int id = Integer.parseInt(productID);
            myTextField1.setText("");

        boolean isRemove = inventoryManager.removeProduct(productID);
        if(isRemove){
            myLabel1.setText("Remove was successful");
            myTextField1.setText("");
        } else {
            myLabel1.setText("Remove is not successful");
        }
       } catch (NumberFormatException e){
            myLabel1.setText("Please enter number!");
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
    public void SwitchScene2(ActionEvent event)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Scene3.fxml"));
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
