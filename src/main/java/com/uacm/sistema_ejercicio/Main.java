package com.uacm.sistema_ejercicio;
//esta clase, junto con Launcher son solo para que git los cargue a la pagina.

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primary) throws Exception {
        // Carga el archivo FXML desde la carpeta resources
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Login.fxml"));
        Parent root = loader.load();

        Scene escena = new Scene(root);

        primary.setTitle("FitSystem - Iteracion 1");
        escena.getStylesheets().add(getClass().getResource("/styles/estilos.css").toExternalForm());
        primary.setScene(escena);
        primary.show();
    }
}