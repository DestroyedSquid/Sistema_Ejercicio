package com.uacm.sistema_ejercicio.controlador;

import com.uacm.sistema_ejercicio.util.Router;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;

public class ListaEjerciciosControlador {

    @FXML private ComboBox<String> comboNivel;

    @FXML
    public void initialize() {
        comboNivel.getItems().addAll("Básico", "Intermedio", "Avanzado");
        comboNivel.setValue("Básico"); // Valor por defecto
    }

    @FXML
    public void iniciarBrazo(ActionEvent event) { ejecutarRutina(event, "Brazo"); }

    @FXML
    public void iniciarAbdomen(ActionEvent event) { ejecutarRutina(event, "Abdomen"); }

    @FXML
    public void iniciarPierna(ActionEvent event) { ejecutarRutina(event, "Pierna"); }

    private void ejecutarRutina(ActionEvent event, String musculo) {
        String nivel = comboNivel.getValue();

        if (nivel == null) {
            Alert alerta = new Alert(Alert.AlertType.WARNING, "Por favor selecciona un nivel en la parte superior.");
            alerta.showAndWait();
            return;
        }

        ControladorEjercicio controladorDestino = Router.navegarYObtenerControlador(event, "/views/Ejercicios.fxml", "Entrenamiento: " + musculo);

        if (controladorDestino != null) {
            controladorDestino.recibirDatosDeSeleccion(musculo, nivel);
        }
    }
}