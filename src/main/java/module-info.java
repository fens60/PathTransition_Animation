module com.example.pathtransition_animation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pathtransition_animation to javafx.fxml;
    exports es.ieslosmontecillos.di_t1a1_shanshangfeng;
    opens es.ieslosmontecillos.di_t1a1_shanshangfeng to javafx.fxml;
}