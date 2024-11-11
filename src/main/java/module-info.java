module com.andre.projetolpoo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.andre.projetolpoo to javafx.fxml;
    exports com.andre.projetolpoo;
}