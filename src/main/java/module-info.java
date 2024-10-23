module fr.esgi.burger {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires static lombok;

    opens fr.esgi to javafx.fxml;
    exports fr.esgi.burger;
    opens fr.esgi.burger to javafx.fxml;
    exports fr.esgi.burger.controller;
    opens fr.esgi.burger.controller to javafx.fxml;
    exports fr.esgi.burger.service.impl;
    opens fr.esgi.burger.service.impl to javafx.fxml;
    exports fr.esgi.burger.business;
    opens fr.esgi.burger.business to javafx.fxml;
}
