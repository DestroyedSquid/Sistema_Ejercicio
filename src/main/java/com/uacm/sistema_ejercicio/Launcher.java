package com.uacm.sistema_ejercicio;
//esta clase, junto con Main son solo para que git los cargue a la pagina.
//siempre se debe correr esta clase, nunca el Main
public class Launcher {
    public static void main(String[] args) {
        // Engañamos a la JVM para que cargue el classpath normal primero
        // y luego llame a la clase de JavaFX.
        Main.main(args);
    }
}