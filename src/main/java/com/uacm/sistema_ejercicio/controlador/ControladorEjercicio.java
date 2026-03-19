package com.uacm.sistema_ejercicio.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class ControladorEjercicio {

    @FXML private Label lblNombreEjercicio;
    @FXML private Button btnInfo;
    @FXML private ImageView imgAnimacion;

    @FXML private Label lblMeta;
    @FXML private TextField txtRepeticionesReales;
    @FXML private Button btnSiguiente;

    @FXML
    public void initialize() {
        // 1. Configuramos el Tooltip (La idea del elotero, pero bien hecha)
        Tooltip infoTooltip = new Tooltip("Las lagartijas de diamante enfocan el esfuerzo en los tríceps y el pecho interno. Mantén la espalda recta.");
        infoTooltip.setShowDelay(Duration.millis(200)); // Sale casi de inmediato al pasar el mouse
        infoTooltip.setStyle("-fx-font-size: 14px; -fx-background-color: #245773;");
        btnInfo.setTooltip(infoTooltip);

        // 2. Datos simulados (Iteración 1)
        lblNombreEjercicio.setText("Lagartijas Diamante");
        lblMeta.setText("Meta: 15 Repeticiones");

        // 3. Validación de Ingeniería: Solo aceptar números en el TextField
        txtRepeticionesReales.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                txtRepeticionesReales.setText(newValue.replaceAll("[^\\d]", ""));
            }
            // Habilitar el botón solo si escribió algo
            btnSiguiente.setDisable(newValue.isEmpty());
        });

        btnSiguiente.setDisable(true); // Bloqueado por defecto
    }

    @FXML
    public void registrarYContinuar() {
        String repsHechas = txtRepeticionesReales.getText();
        System.out.println("El usuario registró: " + repsHechas + " repeticiones. Guardando en BD...");

        // Aqui ira la lógica para limpiar la pantalla y cargar el GIF del siguiente ejercicio.
        txtRepeticionesReales.clear();
    }
    // Este método será llamado desde la Lista de Ejercicios ANTES de que el usuario vea esta ventana
    public void recibirDatosDeSeleccion(String musculo, String nivel) {
        System.out.println("Datos recibidos por inyección: " + musculo + " - " + nivel);

        // Actualizamos la interfaz temporalmente hasta que conectemos SQLite
        lblNombreEjercicio.setText("Rutina de " + musculo);
        lblMeta.setText("Nivel: " + nivel);
    }
}