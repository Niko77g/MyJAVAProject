package com.example.myprojectjavafx;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.FileChooser;

import javafx.event.ActionEvent;

import javax.swing.*;
import java.io.*;
public class Scene5 {
    private Stage stage;
    private Scene scene;
    @FXML
    private Label myLabel1;
    @FXML
    private Label myLabel2;
    @FXML
    private Label myLabel3;
    @FXML
    private TextField myTextField;
    private InventoryManager inventoryManager = InventoryManager.getInstance();
    public void SubmitSearch(ActionEvent event)throws IOException{
        String productID = (myTextField.getText());
        try {
            int id = Integer.parseInt(productID);
            myTextField.setText("");
        String dataofproduct = inventoryManager.searchProduct(productID);
        myLabel3.setText(dataofproduct);
        myTextField.setText("");
        myLabel2.setText("Product <ID>:");
        }catch (NumberFormatException e){
            myLabel2.setText("You must enter number of ID!");
        }
    }
    public void SubmitDownloadFile(ActionEvent event) throws  IOException{
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Data");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text File", "*.txt"));
        File file = fileChooser.showSaveDialog(stage);
        if (file != null){
            inventoryManager.Writetofile(file);
        }

    }
    public void SwitchSceneMenu(javafx.event.ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SceneMenu.fxml"));
        Parent root = fxmlLoader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
