module fr.esgi.burger {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;

    //opens fr.esgi.burger to javafx.fxml;
    opens fr.esgi.burger.controller to javafx.fxml;
    exports fr.esgi.burger;
}
