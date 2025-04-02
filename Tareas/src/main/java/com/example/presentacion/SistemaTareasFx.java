package com.example.presentacion;

import com.example.TareasApplication;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class SistemaTareasFx extends Application {

    private ConfigurableApplicationContext applicationContext; // Contexto de la aplicación

    /*public static void main(String[] args) {
        launch(args);
    }*/
    @Override
    public void init() {
        this.applicationContext =
                new SpringApplicationBuilder(TareasApplication.class).run(); // Inicializar el contexto de
    }

    // Método start para lanzar la aplicación JavaFX creando un nuevo Stage(escenario)
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(TareasApplication.class.getResource("/templates/index.fxml")); // Cargar el archivo FXML, la interface gráfica
        loader.setControllerFactory(applicationContext::getBean); // Obtener el controlador de la aplicación
        Scene escena = new Scene(loader.load()); // Crear una nueva escena, usamos el método load() para cargar el archivo FXML pero debemos añadir excepciones al método
        stage.setScene(escena); // Establecer la escena en el escenario
        stage.show(); // Mostrar el escenario

    }
    // Método stop para cerrar el contexto de la aplicación y salir de la aplicación
    @Override
    public void stop() {
        applicationContext.close(); // Cerrar el contexto de la aplicación
        Platform.exit(); // Salir de la aplicación
    }
}
