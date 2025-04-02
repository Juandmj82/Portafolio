package com.example.servicio;

import com.example.modelo.Tarea;
import com.example.repositorio.TareaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Indica que la clase es un servicio

public class TareaServicio implements ITareaServicio {

    @Autowired //Inyeccion de dependencias
    private TareaRepositorio tareaRepositorio; //Inyeccion para acceder a los metodos de la interfaz

    @Override
    public List<Tarea> listarTareas() {
        return tareaRepositorio.findAll(); //Retorna todas las tareas
    }

    @Override
    public Tarea buscarTareaPorId(Integer idTarea) {
        Tarea tarea = tareaRepositorio.findById(idTarea).orElse(null); //Busca una tarea por su id y si no la encuentra retorna null
        return tarea;
    }

    @Override
    public void guardarTarea(Tarea tarea) {
        tareaRepositorio.save(tarea); //Guarda una tarea

    }

    @Override
    public void eliminarTarea(Tarea tarea) {
        tareaRepositorio.delete(tarea); //Elimina una tarea

    }
}
