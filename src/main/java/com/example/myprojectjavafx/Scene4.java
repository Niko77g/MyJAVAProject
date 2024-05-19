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
    private TextField myTextFlied1;

    private InventoryManager inventoryManager = InventoryManager.getInstance();
    public void SubmitRemove(ActionEvent event)throws IOException {

    }
    public void SwitchSceneMenu(javafx.event.ActionEvent event) throws  IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SceneMenu.fxml"));
        Parent root = fxmlLoader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
