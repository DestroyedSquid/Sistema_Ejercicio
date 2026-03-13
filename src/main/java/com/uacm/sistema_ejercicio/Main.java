package com.uacm.sistema_ejercicio;
//esta clase, junto con Launcher son solo para que git los cargue a la pagina.

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primary) {
        // Un layout básico para comprobar que la ventana compila
        Label textoArranque = new Label("FitSystem - Motor JavaFX Iniciado. Listo para Iteración 1.");
        StackPane raiz = new StackPane(textoArranque);

        // El HUD base medirá 800x600 por defecto
        Scene escena = new Scene(raiz, 800, 600);

        primary.setTitle("Sistema de Ejercicio - UACM");
        primary.setScene(escena);
        primary.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}