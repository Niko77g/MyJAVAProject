module com.example.myprojectjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.myprojectjavafx to javafx.fxml;
    exports com.example.myprojectjavafx;
}