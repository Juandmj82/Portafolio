package com.example.controlador;

import com.example.modelo.Tarea;
import com.example.servicio.TareaServicio;
import jakarta.persistence.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component //Indica que la clase es un componente de Spring

public class IndexControlador implements Initializable {//implementamos la interfaz Initializable para inicializar los componentes de la interfaz grafica
    private static  final Logger logger =
            LoggerFactory.getLogger(IndexControlador.class);//Instancia para imprimir mensajes en la consola
    //componente de servicio de spring
    @Autowired
    private TareaServicio tareaServicio;

    //mapeamos los atributos de la interfaz grafica

    @FXML //Indica que el atributo es un componente de la interfaz grafica
    private TableView<Tarea> tareaTabla;

    @FXML
    private TableColumn<Tarea, Integer> idTareaColumna;

    @FXML
    private TableColumn <Tarea, String> nombreTareaColumna;

    @FXML
    private TableColumn <Tarea, String > responsableColumna;

    @FXML
    private TableColumn <Tarea, String> estadoColumna;

    //Lista observable para almacenar las tareas
    private final ObservableList<Tarea> tareaList = FXCollections.observableArrayList();

    //Componentes de la interfaz grafica
    @FXML
    private TextField nombreTareaTexto;
    @FXML
    private TextField responsableTexto;
    @FXML
    private TextField estadoTexto;
    @FXML
    private Integer idTareaInterno;




    //metodo para cargar las tareas en la tabla
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tareaTabla.getSelectionModel().setSelectionMode(SelectionMode.SINGLE); //Seleccionar una sola fila
        configurarColumnas(); //Configurar las columnas de la tabla
        listarTareas(); //Listar las tareas

    }

    //Metodo para configurar las columnas de la tabla
    private void configurarColumnas() {
        idTareaColumna.setCellValueFactory(new PropertyValueFactory<>("idTarea")); //Asignar el valor de la columna idTarea
        nombreTareaColumna.setCellValueFactory(new PropertyValueFactory<>("nombreTarea")); //Asignar el valor de la columna nombreTarea
        responsableColumna.setCellValueFactory(new PropertyValueFactory<>("responsable")); //Asignar el valor de la columna responsable
        estadoColumna.setCellValueFactory(new PropertyValueFactory<>("estado")); //Asignar el valor de la columna estado

    }

    //Metodo para listar las tareas
    private void listarTareas() {
        logger.info("Ejecutando listado de tareas"); //Imprimir mensaje en la consola
        tareaList.clear(); //Limpiar la lista de tareas
        tareaList.addAll(tareaServicio.listarTareas()); //Agregar todas las tareas de la base de datos a la lista
        tareaTabla.setItems(tareaList); //Asignar la lista de tareas a la tabla
    }


    //Metodo para agregar una tarea
    public void agregarTarea(ActionEvent actionEvent) {
        if(nombreTareaTexto.getText().isEmpty()){

            mostrarMensaje("Error validación", "Debe proporcionar una tarea");
            nombreTareaTexto.requestFocus();
            return;
        }else{
            var tarea = new Tarea();
            recolectarDatosFormulario(tarea);
            tarea.setIdTarea(null); //Asignar null al id de la tarea si es nulo
            tareaServicio.guardarTarea(tarea);
            mostrarMensaje("Información", "La tarea ha sido guardada con éxito");
            limpiarFormulario();
            listarTareas();

        }
    }

    //Metodo para cargar una tarea
    public void cargarTareaFormulario(){
        var tarea = tareaTabla.getSelectionModel().getSelectedItem();
        if(tarea != null){
            idTareaInterno = tarea.getIdTarea();
            nombreTareaTexto.setText(tarea.getNombreTarea());
            responsableTexto.setText(tarea.getResponsable());
            estadoTexto.setText(tarea.getEstado());
        }
    }


    //Metodo para recolectar los datos del formulario
    private void recolectarDatosFormulario(Tarea tarea) {
        if(idTareaInterno != null){
            tarea.setIdTarea(idTareaInterno);
        }
        tarea.setNombreTarea(nombreTareaTexto.getText());
        tarea.setResponsable(responsableTexto.getText());
        tarea.setEstado(estadoTexto.getText());
    }

    //Metodo para actualizar una tarea
    public void modificarTarea(){
        if(idTareaInterno == null){
            mostrarMensaje("Información", "Debe seleccionar una tarea");
            return;
        }
        if(nombreTareaTexto.getText().isEmpty()){
            mostrarMensaje("Error validación", "Debe proporcionar una tarea");
            nombreTareaTexto.requestFocus(); //Colocar el foco en el campo nombreTareaTexto
            return;
        }
        var tarea = new Tarea();
        recolectarDatosFormulario(tarea);
        tareaServicio.guardarTarea(tarea);
        mostrarMensaje("Información", "La tarea ha sido actualizada con éxito");
        limpiarFormulario();
        listarTareas();
    }

    //Metodo para eliminar una tarea
    public void eliminarTarea(){
        var tarea = tareaTabla.getSelectionModel().getSelectedItem();
        if(tarea != null){
            logger.info("Registro a elimiar: " + toString());
            tareaServicio.eliminarTarea(tarea);
            mostrarMensaje("Información", "La tarea No " + tarea.getIdTarea() + " ha sido eliminada con éxito");
            limpiarFormulario();
            listarTareas();
        }else{
            mostrarMensaje("Error", "Debe seleccionar una tarea");
        }

    }

    //método para limpiar el formulario
    public void limpiarFormulario() {
        idTareaInterno = null;
        nombreTareaTexto.clear();
        responsableTexto.clear();
        estadoTexto.clear();
    }

    //Metodo para mostrar un mensaje

    private void mostrarMensaje(String titulo, String mensaje){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
