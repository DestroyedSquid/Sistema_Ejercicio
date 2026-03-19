package com.uacm.sistema_ejercicio.controlador;

import com.uacm.sistema_ejercicio.util.Router;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class SeleccionControlador {

    // Estas variables se vincularán automáticamente con tu FXML
    @FXML private ComboBox<String> comboMusculo;
    @FXML private ComboBox<String> comboNivel;
    @FXML private Button btnIniciar;

    // Este método se ejecuta automáticamente al cargar la pantalla
    @FXML
    public void initialize() {
        // Llenamos los datos "Mock" (Simulados) por ahora.
        // En la iteración 2, esto vendrá de SQLite.
        comboMusculo.getItems().addAll("Brazo", "Pierna", "Abdomen", "Cuerpo Completo");
        comboNivel.getItems().addAll("Básico", "Intermedio", "Avanzado");

        // Bloqueamos el botón hasta que el usuario elija algo
        btnIniciar.setDisable(true);

        // Listeners para habilitar el botón solo si ambas opciones están seleccionadas
        comboMusculo.setOnAction(e -> validarSeleccion());
        comboNivel.setOnAction(e -> validarSeleccion());
    }

    private void validarSeleccion() {
        boolean listo = comboMusculo.getValue() != null && comboNivel.getValue() != null;
        btnIniciar.setDisable(!listo);
    }

    // Acción del botón principal
    // Este evento debe recibir el ActionEvent para saber qué ventana cerrar
    @FXML
    public void iniciarEntrenamiento(ActionEvent event) {
        String musculo = comboMusculo.getValue();
        String nivel = comboNivel.getValue();

        System.out.println("Cargando rutina para: " + musculo + " Nivel: " + nivel);

        // ¡Navegamos a la pantalla del ejercicio!
        Router.navegar(event, "/views/Ejercicios.fxml", "Entrenamiento en Progreso");
    }
}