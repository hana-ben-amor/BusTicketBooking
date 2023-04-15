package com.example.busticketbooking.admin;

import com.example.busticketbooking.database.DatabaseHandler;
import com.example.busticketbooking.utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginAdmin {
    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordField;

    private DatabaseHandler databaseHandler;

    @FXML
    public void initialize() {
        databaseHandler = DatabaseHandler.getInstance();
    }

    @FXML
    void login(ActionEvent event) {
        String username = usernameTextField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            Utils.showAlert(Alert.AlertType.ERROR, "Error", "Please enter both username and password.");
            return;
        }

        if (databaseHandler.validateAdminLogin(username, password)) {
            // Successful login
            Utils.showAlert(Alert.AlertType.INFORMATION, "Success", "Logged in successfully as admin.");
            // Redirect to admin interface
        } else {
            // Invalid credentials
            Utils.showAlert(Alert.AlertType.ERROR, "Error", "Invalid username or password.");
        }
    }
}
