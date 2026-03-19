package com.uacm.sistema_ejercicio.controlador;

import com.uacm.sistema_ejercicio.util.Router;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login {

    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtPassword;
    @FXML private Label lblMensaje;
    @FXML private Button btnIngresar;

    @FXML
    public void iniciarSesion(ActionEvent event) {
        String user = txtUsuario.getText();
        String password = txtPassword.getText();

        // Validación "Mock". En iteración 2, esto lo validará tu SQLite.
        if ("admin".equals(user) && "1234".equals(password)) {
            lblMensaje.setText("¡Bienvenido!");
            lblMensaje.setStyle("-fx-text-fill: #27ae60;"); // Verde éxito

            // ¡MAGIA DEL ROUTER AQUÍ! Navegamos a la siguiente pantalla:
            Router.navegar(event, "/views/RegistroRapido.fxml", "Selección de Rutina");

        } else {
            lblMensaje.setText("Usuario o clave incorrectos.");
            lblMensaje.setStyle("-fx-text-fill: #e74c3c;"); // Rojo error
        }
    }
}