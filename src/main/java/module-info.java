module com.example.buttondrug {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.buttondrug to javafx.fxml;
    exports com.example.buttondrug;
}