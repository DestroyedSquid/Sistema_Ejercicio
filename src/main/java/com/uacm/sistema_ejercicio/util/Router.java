package com.uacm.sistema_ejercicio.util;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Router {

    // Metodo estatico para saltar entre pantallas con una sola linea de codigo
    public static void navegar(ActionEvent event, String rutaFxml, String titulo) {
        try {
            // 1. Cargamos el nuevo archivo FXML
            FXMLLoader loader = new FXMLLoader(Router.class.getResource(rutaFxml));
            Parent root = loader.load();

            // 2. Obtenemos la ventana (Stage) actual a partir del boton que se hizo clic
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // 3. Le aplicamos los estilos globales que ya definimos
            Scene escena = new Scene(root);
            escena.getStylesheets().add(Router.class.getResource("/styles/estilos.css").toExternalForm());

            // 4. Cambiamos la escena
            stage.setTitle(titulo);
            stage.setScene(escena);
            stage.show();

        } catch (IOException e) {
            System.err.println("Error critico de navegación: No se encontro la vista " + rutaFxml);
            e.printStackTrace();
        }
    }
    // Router 2.0: Cambia de pantalla y te devuelve el controlador para inyectarle datos
    public static <T> T navegarYObtenerControlador(javafx.event.ActionEvent event, String rutaFxml, String titulo) {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(Router.class.getResource(rutaFxml));
            javafx.scene.Parent root = loader.load();

            javafx.stage.Stage stage = (javafx.stage.Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            javafx.scene.Scene escena = new javafx.scene.Scene(root);
            // Si tu CSS se llama "estilos.css", verifica que el nombre coincida aquí:
            escena.getStylesheets().add(Router.class.getResource("/styles/estilos.css").toExternalForm());

            stage.setTitle(titulo);
            stage.setScene(escena);
            stage.show();

            // ¡La magia! Devolvemos el controlador de la pantalla que acabamos de abrir
            return loader.getController();

        } catch (java.io.IOException e) {
            System.err.println("Error crítico: No se pudo cargar " + rutaFxml);
            e.printStackTrace();
            return null;
        }
    }
}