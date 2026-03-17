package com.uacm.sistema_ejercicio.controlador;

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
    @FXML
    public void iniciarEntrenamiento() {
        String musculo = comboMusculo.getValue();
        String nivel = comboNivel.getValue();

        // Aquí es donde en el futuro cambiaremos a la pantalla del Ejercicio.
        // Por ahora, lanzamos un popup para que el profe vea que la lógica funciona.
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Simulación de Sistema");
        alerta.setHeaderText("¡Entrenamiento Generado!");
        alerta.setContentText("Buscando rutina para: " + musculo + " (Nivel: " + nivel + ")");
        alerta.showAndWait();
    }
    //estas pero que si rebotas de pendejo
    
}
