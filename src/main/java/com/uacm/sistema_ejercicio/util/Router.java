package com.uacm.sistema_ejercicio.util;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Router {

    // Método estático para saltar entre pantallas con una sola línea de código
    public static void navegar(ActionEvent event, String rutaFxml, String titulo) {
        try {
            // 1. Cargamos el nuevo archivo FXML
            FXMLLoader loader = new FXMLLoader(Router.class.getResource(rutaFxml));
            Parent root = loader.load();

            // 2. Obtenemos la ventana (Stage) actual a partir del botón que se hizo clic
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // 3. Le aplicamos los estilos globales que ya definimos
            Scene escena = new Scene(root);
            escena.getStylesheets().add(Router.class.getResource("/styles/estilos.css").toExternalForm());

            // 4. Cambiamos la escena
            stage.setTitle(titulo);
            stage.setScene(escena);
            stage.show();

        } catch (IOException e) {
            System.err.println("Error crítico de navegación: No se encontró la vista " + rutaFxml);
            e.printStackTrace();
        }
    }
}