package Com.sofka.KataList.service;

import Com.sofka.KataList.models.TareaModel;
import Com.sofka.KataList.repository.TareasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * tarea servicio
 *
 * @author Diego felipe muñoz mosquera
 * @version 1.0.0 17-06-2022
 * @since 1.0.0
 */
@Service
public class TareaService {
    @Autowired
    private TareasRepository tareasRepository;

    /**
     * Metodo que retorna la tareas
     * @return lista de subtareas
     */
    public List<TareaModel> listaTareas(){
        return (List<TareaModel>) tareasRepository.findAll();
    }
    /**
     * Metodo para almacenar  tareas
     * @param tareaModel  tarea que envia el controlador
     * @return tarea almacenada
     */
    public TareaModel guardarTarea(TareaModel tareaModel){
        return tareasRepository.save(tareaModel);
    }
    /**
     *
     * @param tareaModel tarea que envia el controlador
     * @param id id de la  tarea
     * @return tarea alcualizada
     */

    public TareaModel actualizarTarea(TareaModel tareaModel, Long id){
        tareaModel.setId(id);
        return tareasRepository.save(tareaModel);
    }
    /**
     * Metodo para eliminar
     * @param id parametro que enviar el controlado
     * @return verdade o falso depende si elimino
     */
    public boolean eliminarTarea(Long id){
        try {
            tareasRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }

}
