package com.uacm.sistema_ejercicio.controlador;

import com.uacm.sistema_ejercicio.util.Router;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

public class RegistroRapidoControlador {

    @FXML private TextField txtNombre;
    @FXML private DatePicker dpFechaNacimiento;
    @FXML private PasswordField txtPassword; // Cambiado para seguridad y compatibilidad
    @FXML private Button btnAceptarRegistro;

    @FXML
    public void initialize() {
        // Podrías poner logica aquí para validar que el usuario tenga al menos 15 años, por ejemplo.
    }

    @FXML
    private void accionAceptarRegistro(ActionEvent event) {
        String nombre = txtNombre.getText();
        String password = txtPassword.getText();

        // Validación básica de ingeniería antes de tocar la base de datos
        if (nombre.isEmpty() || password.isEmpty() || dpFechaNacimiento.getValue() == null) {
            System.out.println("Error: Campos incompletos");
            return;
        }

        System.out.println("Registrando usuario: " + nombre + " (Nacido el: " + dpFechaNacimiento.getValue() + ")");

        // Aquí iría el INSERT a SQLite (Iteración 2)

        // Alerta temporal de éxito
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Registro Exitoso");
        alerta.setHeaderText(null);
        alerta.setContentText("Cuenta creada. Por favor, inicia sesión.");
        alerta.showAndWait();

        /// Cambia "/views/Login.fxml" por "/views/Inicio.fxml"
        Router.navegar(event, "/views/Inicio.fxml", "FitSystem Login");
    }
}
