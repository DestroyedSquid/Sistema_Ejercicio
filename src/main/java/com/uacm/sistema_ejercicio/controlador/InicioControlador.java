package com.uacm.sistema_ejercicio.controlador;

import com.uacm.sistema_ejercicio.util.Router;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class InicioControlador {

    @FXML private TextField txtNombre;
    @FXML private PasswordField txtPassword; // Seguro
    @FXML private Button btnIniciarSesion; // Ortografía corregida
    @FXML private Button btnRegistrarme;
    @FXML private Label lblMensaje;

    @FXML
    private void accionIniciarSesion(ActionEvent event) {
        String nombre = txtNombre.getText();
        String password = txtPassword.getText();

        // Validamos usuario temporal para que puedas probar el flujo
        if ("admin".equals(nombre) && "1234".equals(password)) {
            // Entramos a la pantalla de las tarjetas de tu compañero
            Router.navegar(event, "/views/ListaEjercicios.fxml", "FitSystem - Rutinas");
        } else {
            lblMensaje.setText("Usuario o contraseña incorrectos.");
        }
    }

    @FXML
    private void accionRegistrarme(ActionEvent event) {
        // Viajamos a la pantalla de Registro Rápido
        Router.navegar(event, "/views/RegistroRapido.fxml", "Registro FitSystem");
    }
}